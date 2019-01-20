package br.com.impacta.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.impacta.model.Produto;
import br.com.impacta.model.enums.CategoriaEnum;
import br.com.impacta.model.enums.SexoEnum;
import br.com.impacta.model.enums.StatusEnum;
import br.com.impacta.repository.ProdutoRepository;




@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repositorio;
	
	@RequestMapping(value="", method=RequestMethod.POST)  
	@ResponseBody
	public Produto inserir(@RequestBody Produto entrada) {
		repositorio.save(entrada);
		return entrada;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)  
	@ResponseBody
	public ResponseEntity<List<Produto>> buscarTodos() {
		
		Produto produto = new Produto();
		produto.setCategoria(CategoriaEnum.BLUSA.getTipoCategoria());
		produto.setCor("Branco");
		produto.setDescricao("Descricao");
		produto.setSexo(SexoEnum.MASCULINO.getTipoSexo());
		produto.setStatus(StatusEnum.DISPONIVEL.getStatus());
		produto.setTamanho("P");
		produto.setTitulo("Novo");
		produto.setUser_id(1L);;
		
		List<Produto> lista = new ArrayList<>();
		lista.add(produto);
		lista.add(produto);
		lista.add(produto);
		
		return new ResponseEntity<List<Produto>>(lista, HttpStatus.OK) ;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)  
	@ResponseBody
	public Produto buscar() {
		Produto produto = new Produto();
		produto.setCategoria(CategoriaEnum.BLUSA.getTipoCategoria());
		produto.setCor("Branco");
		produto.setDescricao("Descricao");
		produto.setSexo(SexoEnum.MASCULINO.getTipoSexo());
		produto.setStatus(StatusEnum.DISPONIVEL.getStatus());
		produto.setTamanho("P");
		produto.setTitulo("Novo");
		produto.setUser_id(1L);
		
		return produto;
	}

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Produto> atualizar(@RequestBody Produto produto, @PathVariable String id) {
		return new ResponseEntity<Produto>(produto, HttpStatus.OK); 
	}

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Produto> deletar(@PathVariable String id) {
		System.out.println("Deletando o id:" + id);
		return new ResponseEntity<Produto>(new Produto(), HttpStatus.OK) ;
	}
}
