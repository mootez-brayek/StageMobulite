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

import Pi.Spring.Entity.Condidat;
import Pi.Spring.Service.CondidatService;


@RestController
@RequestMapping("/Condidat")
@CrossOrigin("*")
public class CondidatController {
	
	@Autowired
	CondidatService condidatService;

	
	@PostMapping("/add")
	@ResponseBody
	public void addCondidat(@RequestBody Condidat condidat){
		condidatService.addCondidat(condidat);
	}
	
	@GetMapping("/retrieve/{id}")
	@ResponseBody
	public Condidat retrieveCondidat(@PathVariable("id")Long idCondidat){
		return condidatService.retrieveCondidat(idCondidat);
	}
	
	
	@GetMapping("/retrieve")
	@ResponseBody
	public List<Condidat> retrieveAllCondidats(Condidat condidat){
		return condidatService.retrieveAllCondidats(condidat);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void deletCondidat(@PathVariable("id")Long idCondidat){
		condidatService.deletCondidat(idCondidat);
	}
}
