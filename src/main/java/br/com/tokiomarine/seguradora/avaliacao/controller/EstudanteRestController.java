package br.com.tokiomarine.seguradora.avaliacao.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudanteService;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudanteServiceImpl;

@RestController
@RequestMapping("/estudantes")
public class EstudanteRestController {

	// TODO caso você não conheça THEMELEAF faça a implementação dos métodos em forma de RESTCONTROLLER (seguindo o padrão RESTFUL)

	private final EstudanteService estudandeService;
	
	public EstudanteRestController(final EstudanteServiceImpl estudanteServiceImpl) {
		this.estudandeService = estudanteServiceImpl;
	}
	
	@GetMapping("/{id}")
	public Estudante buscarPorId(@PathVariable("id") Long id) {
		return estudandeService.buscarEstudante(id);
	}
	
	// TODO IMPLEMENTAR CADASTRO DE ESTUDANTES (POST)
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void cadastrar(@Valid @RequestBody Estudante estudante) {
		estudandeService.cadastrarEstudante(estudante);
	}
		
	// TODO IMPLEMENTAR ATUALIZACAO DE ESTUDANTES (PUT)
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void atualizar(
			@PathVariable("id") Long id,
			@Valid @RequestBody Estudante estudante) {
		estudandeService.atualizarEstudante(estudante, id);
	}

	// TODO IMPLEMENTAR A LISTAGEM DE ESTUDANTES (GET)
	@GetMapping
	public Page<Estudante> listar(Pageable pageable) {
		return estudandeService.buscarEstudantes(pageable);
	}

	// TODO IMPLEMENTAR A EXCLUSÃO DE ESTUDANTES (DELETE)
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerPorId(@PathVariable("id") Long id) {
		estudandeService.removerEstudantePorId(id);
	}
}
