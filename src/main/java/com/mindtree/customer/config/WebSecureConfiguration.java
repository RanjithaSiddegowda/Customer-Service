package com.mindtree.customer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


/**
 * The Class WebSecureConfiguration.
 */
@Configuration
@EnableWebSecurity
public class WebSecureConfiguration extends WebSecurityConfigurerAdapter {
	
	/** The password. */
	@Autowired
	PasswordEncoder password = new BCryptPasswordEncoder();
	
	/** The user name. */
	@Value("${spring.security.user.name}")
	private String userName;
	
	/** The user password. */
	@Value("${spring.security.user.password}")
	private String userPassword;
	
	/** The role. */
	@Value("${spring.security.user.role}")
	private String role;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#userDetailsService()
	 */
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		// For User token
		UserDetails user = User.builder().username(userName).password(password.encode(userPassword)).roles(role).build();
		// For Admin token
		/*UserDetails userAdmin = User.builder().username("admin").password(password.encode("secret")).roles("ADMIN")
				.build(); */
		//return new InMemoryUserDetailsManager(user, userAdmin);
		return new InMemoryUserDetailsManager(user);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#authenticationManagerBean()
	 */
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
}
