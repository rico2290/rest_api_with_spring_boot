package com.user.restapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.user.restapi.domain.models.User;
import com.user.restapi.domain.service.CRUDUserService;
import com.user.restapi.respository.UserRepository;
import com.user.restapi.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Users")
@CrossOrigin(origins = {"*"})  
@Validated
public class UserController {

	@Autowired
	CRUDUserService crudUserService;
	
	@Autowired
	private UserService userService;

	@ApiOperation(value = "Listar usuários")
	@GetMapping(value = "/users")
	public ResponseEntity<Page<User>> getUsers(@RequestParam(required = false, defaultValue = "0") int pageNumber,
			@RequestParam int pageSize, @RequestParam(defaultValue = "name") String sortBy) {
			List<User> allUsers = crudUserService.getUsers();
			allUsers.stream().forEach(user -> user.setNome(user.getNome().toUpperCase()));
		return new ResponseEntity<Page<User>>(this.userService.getUsers(pageNumber, pageSize, sortBy), HttpStatus.OK);
	}
	
	/*
 	public ResponseEntity<Page<User>> getUsers(@RequestParam(required = false, defaultValue = "0") int pageNumber,
		@RequestParam int pageSize, @RequestParam(defaultValue = "name") String sortBy) {
		@SuppressWarnings("unchecked")
		List<User> allUsers = (List<User>) this.userService.getUsers(pageNumber, pageSize, sortBy);
		allUsers.stream().forEach(user -> user.setName(user.getName().toUpperCase()));
	return new ResponseEntity<Page<User>>((Page<User>) allUsers, HttpStatus.OK);
}
 */
	
	@ApiOperation(value = "Listar usuários com Stream")
	@GetMapping(value = "/usersWithStream")
	
	public ResponseEntity<List<User>> getUsersWithStream() {
	
		 List<User> allUsers = crudUserService.getUsers();
		 allUsers.stream().forEach(user -> user.setNome(user.getNome().toUpperCase()));
		 return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);

		
	}
	
	@ApiOperation(value= "Detalhar usuario [native sql]")
	@GetMapping(value= "/details/user/{userId}")
	public ResponseEntity<Optional<User>> getUserDetails(@PathVariable(value = "userId") long userId) {

		Optional<User> user = Optional.ofNullable(userService.findByIdDetail(userId));
		if (user.isPresent()) {

			return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	


	@ApiOperation(value = "Retornar um  usuário")
	@GetMapping("/user/{userId}")
	public ResponseEntity<Optional<User>> getUser(@PathVariable(value = "userId") long userId) {

		Optional<User> user = Optional.ofNullable(crudUserService.findById(userId));
		if (user.isPresent()) {

			return new ResponseEntity<Optional<User>>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@ApiOperation(value = "Criar um usuário")
	@PostMapping("/user")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		return new ResponseEntity<User>(crudUserService.save(user), HttpStatus.CREATED);

	}

	@ApiOperation(value = "Atualizar um usuário")
	@PutMapping("/user/{userId}")
	public ResponseEntity<User> editUser(@PathVariable(value = "userId") long userId, @Valid @RequestBody User newUser) {
		Optional<User> oldUser = Optional.ofNullable(userService.findById(userId));
	
		if (oldUser.isPresent()) {

			newUser.setId(userId);
			newUser.setCreatedAt(oldUser.get().getCreatedAt());

			return new ResponseEntity<User>(userService.save(newUser), HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);

	}	

	@ApiOperation(value = "Deletar um usuário")
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "userId") long userId) {
		Optional<User> deleteUser = Optional.ofNullable((crudUserService.findById(userId)));
		if (deleteUser.isPresent()) {
			this.userService.removeUser(userId);
			return new ResponseEntity<String>("Usuario removido com sucesso!",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("Não existe usuário com esse ID", HttpStatus.NOT_FOUND);

	}

}
