package Pi.Spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Pi.Spring.Entity.Logement;
import Pi.Spring.Service.LogementService;

@RestController
@RequestMapping("/Logement")
@CrossOrigin("*")
public class LogementController {
	@Autowired
	LogementService logementService;
	
	
	@PostMapping("/add")
	@ResponseBody
	public void addLogement(@RequestBody Logement logement){
		logementService.addLogement(logement);
		
	}
	
	@GetMapping("/retrieve/{id}")
	@ResponseBody
	public Logement findLogement(@PathVariable("id")Long idLogement){
		return logementService.findLogement(idLogement);
	}
	
	@GetMapping("/retrieve")
	@ResponseBody
	public List<Logement> findAllLogement(){
		return logementService.findAllLogement();
	}

	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void deletLogement(@PathVariable("id")Long IdLogement){
		logementService.deletLogement(IdLogement);
	}
}
