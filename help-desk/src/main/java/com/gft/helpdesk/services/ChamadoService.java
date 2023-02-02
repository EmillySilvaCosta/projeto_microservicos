package com.gft.helpdesk.services;

import com.gft.helpdesk.entities.Chamado;
import com.gft.helpdesk.entities.Setor;
import com.gft.helpdesk.enums.NivelEnum;
import com.gft.helpdesk.enums.StatusEnum;
import com.gft.helpdesk.exceptions.EntityNotFoundException;
import com.gft.helpdesk.repositories.ChamadoRepository;
import com.gft.helpdesk.request.EmailRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChamadoService {
	
	private final ChamadoRepository chamadoRepository;
	private final FilaService filaService;
	private final OperadorService operadorService;
	private final SetorService setorService;
	private final ClienteService clienteService;
	private final EmailService emailService;

	public ChamadoService(ChamadoRepository chamadoRepository, FilaService filaService, OperadorService operadorService,
						  SetorService setorService, ClienteService clienteService, EmailService emailService) {
		this.chamadoRepository = chamadoRepository;
		this.filaService = filaService;
		this.operadorService = operadorService;
		this.setorService = setorService;
		this.clienteService = clienteService;
		this.emailService = emailService;
	}
	
	public Chamado salvarChamado(Chamado chamado) {
		chamado.setSetor(setorService.buscarSetor(chamado.getSetor().getId()));
		chamado.setCliente(clienteService.buscarOuSalvarNovoCliente(chamado.getCliente()));
		if(chamado.getId()==null){
			chamado = chamadoRepository.save(chamado);
			String titulo = "Chamado " + chamado.getId() + ": " + chamado.getAssunto();
			chamado.setAssunto(titulo);
		}
		return chamadoRepository.save(chamado);
	}
	
	public Chamado buscarChamado(Long id) {
		Optional<Chamado> optional = chamadoRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Chamado não encontrado"));
	}
	
	public Chamado alterarChamado(Long id, Chamado chamado) {
		chamado.setId(this.buscarChamado(id).getId());
		return this.salvarChamado(chamado);
	}
	
	public Page<Chamado> listarChamados(Pageable paginacao) {
		return chamadoRepository.findAll(paginacao);
	}

	public Chamado abrirChamado(Chamado chamado) {
		chamado =  salvarChamado(chamado);
		chamado.setOperador(operadorService.buscarOperadorDisponivelPraEsseChamadoEAtribuirAoChamado(chamado));
		if(chamado.getOperador()==null){
			chamado.setStatus(StatusEnum.EM_ESPERA);
			filaService.colocarChamadoNaFila(chamado);
		}else {
			chamado.setStatus(StatusEnum.EM_PROGRESSO);
			chamado = salvarChamado(chamado);
			enviarEmailsDeProgressoDoChamado(chamado);
		}
		return salvarChamado(chamado);
	}

	private void enviarEmailsDeProgressoDoChamado(Chamado chamado) {
		String emailOperador = chamado.getOperador().getEmail();
		String emailCliente = chamado.getCliente().getEmail();
		String assunto = chamado.getAssunto();
		String texto = chamado.getTexto();

		emailService.enviarEmail(new EmailRequest(emailOperador, assunto, texto));
		emailService.enviarEmail(new EmailRequest(emailCliente, assunto, texto));
	}

	public Chamado escalarChamado(Long idChamado, int nivel){
		Chamado chamado = buscarChamado(idChamado);
		chamado.setNivel(atribuindoNivel(nivel));
		chamado = reabrirChamado(chamado);
		return salvarChamado(chamado);
	}

	private NivelEnum atribuindoNivel(int nivel) {
		switch (nivel){
			case 1:
				return NivelEnum.NIVEL_1;
			case 2:
				return NivelEnum.NIVEL_2;
			case 3:
				return NivelEnum.NIVEL_3;
			case 4:
				return NivelEnum.NIVEL_4;
			default:
				throw new EntityNotFoundException("Nivel não encontrado");
		}
	}

	public Chamado transferirChamado(Long idChamado, Long idSetor){
		Chamado chamado = buscarChamado(idChamado);
		Setor setor = setorService.buscarSetor(idSetor);
		chamado.setSetor(setor);
		chamado.setNivel(NivelEnum.NIVEL_1);
		chamado = reabrirChamado(chamado);
		return salvarChamado(chamado);
	}

	private Chamado reabrirChamado(Chamado chamado) {
		operadorService.mudarDisponibilidadeDoOperador(chamado.getOperador(), false);
		chamado.setOperador(null);
		chamado = salvarChamado(chamado);
		return abrirChamado(chamado);
	}

	public Chamado finalizarChamado(Long id){
		Chamado chamado = buscarChamado(id);
		chamado.setStatus(StatusEnum.FINALIZADO);
		operadorService.mudarDisponibilidadeDoOperador(chamado.getOperador(), true);
		return salvarChamado(chamado);
	}

	public String verificarEstadoDoChamado(Chamado chamado) {
		return "Chamado de número " + chamado.getId() + " está " + chamado.getStatus();
	}
}
