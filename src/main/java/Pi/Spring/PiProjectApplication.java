package Pi.Spring;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import Pi.Spring.Entity.User;
import Pi.Spring.Entity.Role;
import Pi.Spring.Service.UserService;

@SpringBootApplication
public class PiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiProjectApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
		
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args ->{
			//userService.addRole(new Role(null, "Role_Super_Admin"));
			userService.addRole(new Role(null, "Role_User"));
			userService.addRole(new Role(null, "Role_Admin"));
			
			//userService.addCondidat(new User(null,"brayek","mootez","mootezbrayek98", new ArrayList<>()));
			

			//userService.addRoleToUser("brayek","Role_Super_Admin");
			
			
			
			
		};
		
	}
}
