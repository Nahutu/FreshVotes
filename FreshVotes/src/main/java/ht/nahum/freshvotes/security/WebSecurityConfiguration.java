package ht.nahum.freshvotes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
//	@Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//		User user = userDetailsServ.loadUserByUsername(username)
//        UserDetails user = User.withUsername()
//                .password(passwordEncoder().encode("password"))
//                .roles("USER")
//                .build();
//		return new InMemoryUserDetailsManager(user);
//
//	}
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
        	.passwordEncoder(getPasswordEncoder());
    }
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
            	.requestMatchers("/").permitAll()
            	.requestMatchers("/register").permitAll()
            	.requestMatchers("/admin/**").hasRole("ADMIN")
            	.anyRequest().hasRole("USER")
            	.and()
            .formLogin()
            	.loginPage("/login")
            	.defaultSuccessUrl("/dashboard")
            	.permitAll()
            	.and()	
            .logout()
            	.logoutUrl("/logout")
            	.permitAll()
            	.and()
            .httpBasic();
        return http.build();
    }


}
 