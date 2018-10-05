package id.triqul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception{
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		authenticationMgr.
		inMemoryAuthentication()
			.withUser("adha")
			.password(encoder.encode("123"))
			.authorities("ROLE_USER")
			.and()
			.withUser("admin").password(encoder.encode("123"))
			.authorities("ROLE_USER","ROLE_ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/home").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
			.and().formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/home")
			.failureUrl("/login?error")
			.usernameParameter("username").passwordParameter("password")
			.and().logout().logoutSuccessUrl("/login?logout");
	}
}
