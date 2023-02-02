package com.gft.helpdesk.services;

import com.gft.helpdesk.entities.Chamado;
import com.gft.helpdesk.entities.Fila;
import com.gft.helpdesk.entities.Operador;
import com.gft.helpdesk.entities.Setor;
import com.gft.helpdesk.enums.NivelEnum;
import com.gft.helpdesk.exceptions.EntityNotFoundException;
import com.gft.helpdesk.repositories.FilaRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilaService {

	private final FilaRepository filaRepository;

	private final OperadorService operadorService;

	private final ChamadoService chamadoService;

	@Lazy
	public FilaService(FilaRepository filaRepository, OperadorService operadorService, ChamadoService chamadoService) {
		this.filaRepository = filaRepository;
		this.operadorService = operadorService;
		this.chamadoService = chamadoService;
	}

	public Fila salvarFila(Fila fila) {
		return filaRepository.save(fila);
	}

	public Fila buscarFilaPorSetorENivel(Setor setor, NivelEnum nivel){
		return filaRepository.findBySetorAndNivel(setor, nivel);
	}

    public void criarFilasDoSetor(Setor setor) {
		salvarFila(criarFila(setor, NivelEnum.NIVEL_1));
		salvarFila(criarFila(setor, NivelEnum.NIVEL_2));
		salvarFila(criarFila(setor, NivelEnum.NIVEL_3));
		salvarFila(criarFila(setor, NivelEnum.NIVEL_4));
    }

	private Fila criarFila(Setor setor, NivelEnum nivel) {
		List<Operador> operadores = operadorService.buscarOperadorPorSetorEPorNivel(setor, nivel);
		return new Fila(setor, nivel, operadores);
	}

	public void colocarOperadorNaSuaFila(Operador operador) {
		Fila fila = filaRepository.findBySetorAndNivel(operador.getSetor(), operador.getNivel());
		fila.getOperadores().add(operador);
		salvarFila(fila);
	}

    public Fila buscarFila(Long id) {
		return filaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Fila não encntrada"));
    }

    public void colocarChamadoNaFila(Chamado chamado) {
		Fila fila = buscarFilaPorSetorENivel(chamado.getSetor(), chamado.getNivel());
		fila.getChamados().add(chamado);
		salvarFila(fila);
    }

	public void chamarProximoDafila(Setor setor, NivelEnum nivel) {
		Fila fila = buscarFilaPorSetorENivel(setor, nivel);
		if(!fila.getChamados().isEmpty()){
			Chamado chamado = fila.getChamados().get(0);
			fila.getChamados().remove(chamado);
			salvarFila(fila);
			chamadoService.abrirChamado(chamado);
		}
	}
}
