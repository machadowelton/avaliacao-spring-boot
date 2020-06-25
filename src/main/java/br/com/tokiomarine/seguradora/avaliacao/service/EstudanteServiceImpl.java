package br.com.tokiomarine.seguradora.avaliacao.service;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.exception.RecursoNaoEncontradoException;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;

@Service
public class EstudanteServiceImpl implements EstudanteService {

	private final EstudanteRepository repository;
	
	public EstudanteServiceImpl(final EstudanteRepository estudanteRepository) {
		this.repository = estudanteRepository;
	}

	@Override
	public void cadastrarEstudante(@Valid Estudante estudante) {
		repository.save(estudante);
	}

	@Override
	public void atualizarEstudante(@Valid Estudante estudante, Long id) {
		if(!repository.existsById(id))
			throw new RecursoNaoEncontradoException("Nenhum estudante encontrado pelo id" + id);
		repository.save(estudante);
	}

	@Override
	public Page<Estudante> buscarEstudantes(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Estudante buscarEstudante(Long id) {
		return repository.findById(id)
							.map((m) -> m)
							.orElseThrow(() -> new RecursoNaoEncontradoException("Nenhum estudante encontrado pelo id: " + id));
	}

	@Override
	public void removerEstudantePorId(Long id) {
		if(repository.existsById(id))
			repository.deleteById(id);
		else
			throw new RecursoNaoEncontradoException("Nenhum estudante encontrado pelo id:" + id);
	}	

}
