package com.exercise.security.config;

import com.exercise.security.user.Role;
import com.exercise.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
//public class SecurityConfig extends JdbcUserDetailsManager {
public class SecurityConfig {

	private final JwtAuthenticationFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;
//	private final UserRepository userRepository;
//	private JdbcUserDetailsManager userDetailsManager;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf()
			.disable()
				.authorizeHttpRequests()
				.requestMatchers("/api/v1/auth/**")
//				.requestMatchers("/api/v1/auth/**", "/api/v1/app/**")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authenticationProvider(authenticationProvider)
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager addAdminToTheDatabase(PasswordEncoder passwordEncoder) {
//		UserDetails user = User.withUsername("user")
//				.password(passwordEncoder.encode("password"))
//				.roles(String.valueOf(Role.USER))
//				.build();

//		todo: which object to convert to which?
//		every user has to have an app even admin (it needs to be changed, it does not make sense)
		UserDetails admin = User
//				todo: does admin needs a name or app? Does admin needs email (maybe for reporting issues)?
				.withUsername("admin@admin.com")
				.password(passwordEncoder.encode("admin"))
				.roles(String.valueOf(Role.ADMIN))
				.build();

//		userDetailsManager.createUser(admin);
//		Authentication authentication = new UsernamePasswordAuthenticationToken(admin, null);
//		SecurityContextHolder.getContext().setAuthentication(authentication);

//		repository.saveAndFlush(admin);

		return new InMemoryUserDetailsManager(admin);
	}
}
