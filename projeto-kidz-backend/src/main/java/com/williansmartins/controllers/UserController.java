package com.williansmartins.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.williansmartins.model.RetornoGenerico;
import com.williansmartins.model.Status;
import com.williansmartins.model.User;
import com.williansmartins.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	RetornoGenerico retorno = new RetornoGenerico();
	
	@ResponseBody
	@RequestMapping(value = {""}, method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> salvar(@RequestBody User user) {
		//TODO: validar email
		User backUser = userService.findUserByEmail(user.getEmail());
		
		if( backUser!=null ){
			retorno.setStatus(Status.ERRO);
			retorno.setMenssagem("Este usuário já esta cadastrado, escolha outro.");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(retorno);
			
		}else{
			user.setActive(1);
			backUser = (User)userService.saveUser(user);
			backUser.setPassword("***");

			retorno.setStatus(Status.SUCESSO);
			retorno.setObjeto(backUser);
			return ResponseEntity.status(HttpStatus.OK).body(retorno);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = {"{id}"}, method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		try {
			//TODO: tratar se este usuario existe
			userService.deleteUser(id);
			retorno.setStatus(Status.SUCESSO);
			return ResponseEntity.status(HttpStatus.OK).body(retorno);
		} catch (Exception e) {
			e.printStackTrace();
			retorno.setStatus(Status.ERRO);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = {""}, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> buscarTodos() {
		try {
			List<User> all = userService.findAll();
			for (User user : all) {
				if(user.getActive() != 1) {
					//all.remove(user);
				}else {
					user.setPassword("***");
				}
			}
			return ResponseEntity.status(HttpStatus.OK).body(all);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = {"{id}"}, method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> buscarUm(@PathVariable("id") Integer id) {
		try {
			Optional<User> all = userService.findById(id);
			
			if (all.isPresent()){
			    User user = all.get();
			    user.setPassword("***");
			    return ResponseEntity.status(HttpStatus.OK).body(user);
			}
			else{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			}
			
 		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@ResponseBody
	@RequestMapping(value = {"{id}"}, method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Object> atualizar(@RequestBody User usuarioNovo, @PathVariable("id") Integer id) {
		try {
			//TODO: tratar campos nullos
			Optional<User> usuarioDoBanco = userService.findById(id);
			
			
			if (usuarioDoBanco.isPresent()){
				
				User usuarioASerAtualizado = usuarioDoBanco.get();
				
				if(!usuarioNovo.getEmail().equals(usuarioASerAtualizado.getEmail())) {
					retorno.setMenssagem("Não é possível trocar o email");
					return ResponseEntity.status(HttpStatus.CONFLICT).body(retorno);
				}

			    usuarioASerAtualizado.setActive(usuarioNovo.getActive());
			    usuarioASerAtualizado.setEmail(usuarioNovo.getEmail());
			    usuarioASerAtualizado.setLastName(usuarioNovo.getLastName());
			    usuarioASerAtualizado.setName(usuarioNovo.getName());
			    usuarioASerAtualizado.setPassword(usuarioNovo.getPassword());
			    
			    userService.saveUser(usuarioASerAtualizado);
			    usuarioASerAtualizado.setPassword("***");
			    
			    return ResponseEntity.status(HttpStatus.OK).body(usuarioASerAtualizado);
			}else{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			}
			
 		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
}
