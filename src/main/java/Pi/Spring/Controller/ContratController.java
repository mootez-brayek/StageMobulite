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

import Pi.Spring.Entity.Contrat;
import Pi.Spring.Service.ContratService;


@RestController
@RequestMapping("/Contrat")
@CrossOrigin("*")
public class ContratController {

	
	@Autowired
	ContratService contratService;
	
	
	
	@PostMapping("/add/{idLogement}/{idCondidat}")
	@ResponseBody
	public void addAndAffectContrat(@RequestBody Contrat contrat,@PathVariable("idLogement")Long idLogement,@PathVariable("idCondidat")Long idCondidat){
		contratService.addAndAffectContrat(contrat, idLogement, idCondidat);
	}
	
	@GetMapping("/retrieve/{id}")
	@ResponseBody
	public Contrat findLogement(@PathVariable("id")Long idContrat){
		return contratService.findLogement(idContrat);
	}
	
	
	@GetMapping("/retrieve")
	@ResponseBody
	public List<Contrat> findAllContrats(Contrat contrat){
		return contratService.findAllContrats(contrat);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void deletContrat(@PathVariable("id")Long idContrat){
		contratService.deletContrat(idContrat);
	}
}