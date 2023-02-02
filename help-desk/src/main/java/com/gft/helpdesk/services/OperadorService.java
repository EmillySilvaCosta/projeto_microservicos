package com.gft.helpdesk.services;

import com.gft.helpdesk.entities.Chamado;
import com.gft.helpdesk.entities.Operador;
import com.gft.helpdesk.entities.Setor;
import com.gft.helpdesk.enums.NivelEnum;
import com.gft.helpdesk.exceptions.EntityNotFoundException;
import com.gft.helpdesk.repositories.OperadorRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperadorService {

	private final OperadorRepository operadorRepository;
	private final FilaService filaService;
	private final SetorService setorService;

	@Lazy
	public OperadorService(OperadorRepository operadorRepository, FilaService filaService, SetorService setorService) {
		this.operadorRepository = operadorRepository;
		this.filaService = filaService;
		this.setorService = setorService;
	}

	public Operador salvarOperador(Operador operador) {
		operador.setSetor(setorService.buscarSetor(operador.getSetor().getId()));
		operador = operadorRepository.save(operador);
		filaService.colocarOperadorNaSuaFila(operador);
		return operador;
	}

	public Page<Operador> listarOperadores(Pageable pageable) {
		return operadorRepository.findAll(pageable);
	}

	public Operador buscarOperador(Long id) {
		Optional<Operador> optional = operadorRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Operador não encontrado"));

	}

	public Operador atualizarOperador(Operador operador, Long id) {
		Operador operadorOriginal = this.buscarOperador(id);
		operador.setId(operadorOriginal.getId());
		return operadorRepository.save(operador);

	}

	public void excluirOperador(Long id) {
		Operador operadorOriginal = this.buscarOperador(id);
		operadorRepository.delete(operadorOriginal);
	}

	public List<Operador> buscarOperadorPorSetorEPorNivel(Setor setor, NivelEnum nivel) {
		return operadorRepository.findBySetorAndNivel(setor, nivel);
	}

	public List<Operador> buscarOperadoresDisponiveisPorSetorEPorNivel(Setor setor, NivelEnum nivel) {
		return operadorRepository.findByDisponivelAndSetorAndNivel(true, setor, nivel);
	}

	public void mudarDisponibilidadeDoOperador(Operador operador, boolean disponivel) {
		if(operador!=null){
			operador.setDisponivel(disponivel);
			if(disponivel){
				filaService.chamarProximoDafila(operador.getSetor(), operador.getNivel());
			}
			salvarOperador(operador);
		}
	}

	public Operador buscarOperadorDisponivelPraEsseChamadoEAtribuirAoChamado(Chamado chamado) {
		List<Operador> operadores = buscarOperadoresDisponiveisPorSetorEPorNivel(chamado.getSetor(),
				chamado.getNivel());

		if(operadores.isEmpty()){
			return null;
		} else {
			Operador operador = operadores.get(0);
			operador.setDisponivel(false);
			return salvarOperador(operador);
		}

	}
}
