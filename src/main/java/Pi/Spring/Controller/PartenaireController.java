package Pi.Spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Pi.Spring.Entity.Contrat;
import Pi.Spring.Entity.partenaires;
import Pi.Spring.Service.IPartenaireService;


@RestController
@RequestMapping("/partenaire")
@CrossOrigin("*")
public class PartenaireController {
	@Autowired
	private IPartenaireService partenaireService;
	
	// http://localhost:8089/partenaire/GetAllPartenaires/
	@GetMapping("/GetAllPartenaires")
	@ResponseBody
public List<partenaires> GetAllPartenaires() {
		return partenaireService.GetAllPartenaires();
	}

// http://localhost:8089/partenaire/GetAllPartenaires/
@GetMapping("/GetAllByActivity/{activity}")
@ResponseBody
public List<partenaires> GetAllByActivity(@PathVariable(value="activity") String activity) {

	return partenaireService.GetAllByActivity(activity);
}

@PostMapping("/addPartenaire")
@ResponseBody
public void AddPartenaire(@RequestBody partenaires partenaires){
	partenaireService.AddPartenaire(partenaires);
}

}
