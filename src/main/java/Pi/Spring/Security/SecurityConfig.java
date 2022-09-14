package Pi.Spring.Security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import Pi.Spring.Filter.CustomAuthenticationFilter;
import Pi.Spring.Filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;

@Configuration @EnableWebSecurity @RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsService userDetaisService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetaisService).passwordEncoder(bCryptPasswordEncoder);
	}

@Override
protected void configure(HttpSecurity http) throws Exception {
	CustomAuthenticationFilter customAuthenticationFilter= new CustomAuthenticationFilter(authenticationManagerBean());
	customAuthenticationFilter.setFilterProcessesUrl("/Condidat/login");
	
	http.csrf().disable();
	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	http.authorizeRequests().antMatchers("/Condidat/login/**", "Stage/Condidat/token/refresh/**").permitAll();
	http.authorizeRequests().antMatchers(HttpMethod.GET,"/Stage/Condidat/**").hasAnyAuthority("Role_User");
	http.authorizeRequests().antMatchers(HttpMethod.POST,"/Stage/Condidat/add/**").permitAll();
	http.authorizeHttpRequests().anyRequest().authenticated();
	http.addFilter(customAuthenticationFilter);
	http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
}
	
@Bean
@Override
public AuthenticationManager authenticationManagerBean() throws Exception{
	return super.authenticationManagerBean();
	
}
	
	

}
