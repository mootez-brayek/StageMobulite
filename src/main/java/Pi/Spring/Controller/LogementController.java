package Pi.Spring.Controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pi.Spring.Entity.Logement;

import Pi.Spring.Response.Com;
import Pi.Spring.Service.LogementService;

@RestController
@RequestMapping("/Logement")
@CrossOrigin("*")
public class LogementController {
	@Autowired
	LogementService logementService;
	@Autowired
	ServletContext context;
	
	
	@PostMapping("/add")
	@ResponseBody
	public Com addLogement(@RequestParam("file") MultipartFile file,@RequestParam("body") String logement)throws JsonParseException , JsonMappingException , Exception{
		Logement LL = new ObjectMapper().readValue(logement, Logement.class);

		boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit)
        {
        	new File (context.getRealPath("/Images/")).mkdir();
        	System.out.println("mk dir.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        System.out.println(context.getContextPath());
        try
        {
        	System.out.println("Image");
        	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
        	 
        }catch(Exception e) {
        	e.printStackTrace();
        }
		
		
        LL.setImage(newFileName);
		
		return new Com(logementService.addLogement(LL));
		
	}
	 @GetMapping("/Imgarticles/{id}")
	 public byte[] getPhoto(@PathVariable("id") Long idLogement) throws Exception{
		 
		 Logement p   =logementService.retrievePostById(idLogement);
		 return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+p.getImage()));
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
