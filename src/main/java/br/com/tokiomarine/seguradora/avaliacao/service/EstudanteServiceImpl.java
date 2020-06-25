package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;

@Service
public class EstudanteServiceImpl implements EstudandeService {

	private final EstudanteRepository repository;
	
	public EstudanteServiceImpl(final EstudanteRepository estudanteRepository) {
		this.repository = estudanteRepository;
	}

	@Override
	public void cadastrarEstudante(@Valid Estudante estudante) {
		repository.save(estudante);
	}

	@Override
	public void atualizarEstudante(@Valid Estudante estudante) {
		if(!repository.existsById(estudante.getId()))
			throw new IllegalArgumentException("Identificador inválido:" + estudante.getId());
		repository.save(estudante);
	}

	@Override
	public List<Estudante> buscarEstudantes() {
		return repository.findAll();
	}

	@Override
	public Estudante buscarEstudante(long id) {
		return repository.findById(id)
							.map((m) -> m)
							.orElseThrow(() -> new IllegalArgumentException("Identificador inválido:" + id));
	}

}
