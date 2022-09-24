package Pi.Spring.Controller;

import java.io.File;
import java.net.URI;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pi.Spring.Entity.Condidat;
import Pi.Spring.Response.Com;
import Pi.Spring.Service.CondidatService;
import lombok.Data;


@RestController
@RequestMapping("/Condidat")
@CrossOrigin("*")

public class CondidatController {

@Autowired
CondidatService condidatService;
@Autowired
ServletContext context;

	
	@GetMapping("/retrieve/{id}")
	@ResponseBody
	public Condidat retrieveCondidat(@PathVariable("id")Long idCondidat){
		return condidatService.retrieveCondidat(idCondidat);
	}
	
	
	@GetMapping("/retrieve")
	@ResponseBody
	public ResponseEntity<List<Condidat>> retrieveAllCondidats(){
		return ResponseEntity.ok().body(condidatService.retrieveAllCondidats());
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void deletCondidat(@PathVariable("id")Long idCondidat){
		condidatService.deletCondidat(idCondidat);
	}
	
	
	@PostMapping("/add")
	@ResponseBody

	public ResponseEntity<Condidat>addCondidat(@RequestBody Condidat condidat){
		URI uri =URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/Stage/Condidat/add").toUriString());
		return ResponseEntity.created(uri).body(condidatService.addCondidat(condidat));
		
	}
	
	@PostMapping("/RoleToUser")
	@ResponseBody
	public ResponseEntity<?>RoleToUser(@RequestBody RoleToUserForm form){
		condidatService.addRoleToUser(form.getNom(), form.getNomRole());
		return ResponseEntity.ok().build();
		
	}


}
@Data
class RoleToUserForm {
	private String nom;
	private String nomRole;
}
