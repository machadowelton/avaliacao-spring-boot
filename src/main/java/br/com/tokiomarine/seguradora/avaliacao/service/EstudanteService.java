package br.com.tokiomarine.seguradora.avaliacao.service;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;

public interface EstudanteService {

	Page<Estudante> buscarEstudantes(Pageable pageable);

	void cadastrarEstudante(@Valid Estudante estudante);

	Estudante buscarEstudante(Long id);

	void atualizarEstudante(@Valid Estudante estudante, Long id);
	
	void removerEstudantePorId(Long id);

}
