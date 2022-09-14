package Pi.Spring.Service;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Pi.Spring.Entity.User;
import Pi.Spring.Entity.Role;
import Pi.Spring.Repositury.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import Pi.Spring.Repositury.RoleRepository;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService,UserDetailsService{
	

	@Autowired
	UserRepository condidatRepo;
	@Autowired
	RoleRepository roleRepo;
	@Autowired
	PasswordEncoder passwordEncoder;
	

	@Override
	public User addCondidat(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return condidatRepo.save(user);
		
	}

	@Override
	public void deletCondidat(Long idCondidat) {
		User user=condidatRepo.findById(idCondidat).orElse(null);
		
		condidatRepo.delete(user);
	}


	@Override
	public User retrieveUser(Long idCondidat) {
		
		return condidatRepo.findById(idCondidat).orElse(null);
	}

	@Override
	public User findBynom(String nom) {
		
		return condidatRepo.findByNom(nom);
	}

	@Override
	public Role addRole(Role role) {
	
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String nom, String nomRole) {
		User user= condidatRepo.findByNom(nom);
		Role role = roleRepo.findByNomRole(nomRole);
		user.getRoles().add(role);
		
	}

	@Override
	public Role findBynomRole(String nomRole) {
	
		return roleRepo.findByNomRole(nomRole);
	}

	@Override
	public List<User> findUsers() {
		// TODO Auto-generated method stub
		return condidatRepo.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String nom) throws UsernameNotFoundException {
		User user= condidatRepo.findByNom(nom);
		if(user==null){
			log.error("User is nor found ");
			throw new UsernameNotFoundException("User is nor found ");
		}else {
			log.info("User is  found : {}",nom);
		}
		Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getNomRole()));
		});
		return new org.springframework.security.core.userdetails.User(user.getNom(),user.getPassword(), authorities);
	}



}
