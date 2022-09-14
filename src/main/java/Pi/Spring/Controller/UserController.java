package Pi.Spring.Controller;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pi.Spring.Entity.Role;
import Pi.Spring.Entity.User;


import Pi.Spring.Service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/Condidat")
@CrossOrigin
public class UserController {
	

@Autowired
UserService userService;
@Autowired
ServletContext context;

@PostMapping("/add/condidat")
@ResponseBody
	public User ajouterCondidat(@RequestBody User user){
		return userService.addCondidat(user);
	
}

	
	@GetMapping("/retrieve/{id}")
	@ResponseBody
	public User retrieveCondidat(@PathVariable("id")Long idCondidat){
		return userService.retrieveUser(idCondidat);
	}
	
	
	@GetMapping("/retrieve")
	@ResponseBody
	public ResponseEntity<List<User>> retrieveAllCondidats(){
		return ResponseEntity.ok().body(userService.findUsers());
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void deletCondidat(@PathVariable("id")Long idCondidat){
		userService.deletCondidat(idCondidat);
	}
	
	
	@PostMapping("/add/user")
	@ResponseBody

	public ResponseEntity<User>addCondidat(@RequestBody User user){
		URI uri =URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/Stage/Condidat/add/user").toUriString());
		return ResponseEntity.created(uri).body(userService.addCondidat(user));
		
	}
	
	@PostMapping("/add/RoleToUser")
	@ResponseBody
	public ResponseEntity<?>RoleToUser(@RequestBody RoleToUserForm form){
		userService.addRoleToUser(form.getNom(), form.getNomRole());
		return ResponseEntity.ok().build();
		
	}

	@GetMapping("/token/refresh")
	@ResponseBody
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String authorizationHeader = request.getHeader(AUTHORIZATION);
		 if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
			 try {
				 
				 String refresh_token = authorizationHeader.substring("Bearer ".length());
				 Algorithm algorithm=Algorithm.HMAC256("secret".getBytes()); 
				 JWTVerifier verifier = JWT.require(algorithm).build();
				 DecodedJWT decodedJWT = verifier.verify(refresh_token);
				 String nom = decodedJWT.getSubject();
				 User user = userService.findBynom(nom);
				 String access_token= JWT.create()
							.withSubject(user.getNom())
							.withExpiresAt(new Date(System.currentTimeMillis()+10 * 60 * 1000))
							.withIssuer(request.getRequestURL().toString())
							.withClaim("roles", user.getRoles().stream().map(Role::getNomRole).collect(Collectors.toList()))
							.sign(algorithm);
					Map<String, String> tokens = new HashMap<>();
					tokens.put("access_token", access_token);
					tokens.put("refresh_token", refresh_token);
					response.setContentType(APPLICATION_JSON_VALUE);
					new ObjectMapper().writeValue(response.getOutputStream(), tokens);
							
			 }catch (Exception exception ){
				
				 response.setHeader("error", exception.getMessage());
				 response.setStatus(FORBIDDEN.value());
				 // response.sendError(FORBIDDEN.value());
					Map<String, String> error = new HashMap<>();
					error.put("error_message", exception.getMessage());	
					response.setContentType(APPLICATION_JSON_VALUE);
					new ObjectMapper().writeValue(response.getOutputStream(), error);
					
			 }
			
		 }else {
		throw new RuntimeException("refresh token is missing");
		 }
	}
	
	
}
@Data
class RoleToUserForm {
	private String nom;
	private String nomRole;
}
