package Pi.Spring.Controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Pi.Spring.Entity.Role;
import Pi.Spring.Service.UserService;

@RestController
@RequestMapping("/Role")
@CrossOrigin("*")
public class RoleController {

	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/ajouter")
	@ResponseBody
	public Role ajouterRole(@RequestBody Role role){
		return userService.addRole(role);
		
	}
	
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<Role>addRole(@RequestBody Role role){
		URI uri =URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/Stage/Role/add").toUriString());
		return ResponseEntity.created(uri).body(userService.addRole(role));
		
	}
}
