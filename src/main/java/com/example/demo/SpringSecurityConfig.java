package com.example.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SpringSecurityConfig {
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() throws Exception{
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(
				User.withUsername("user")
				.password(passwordEncoder().encode("user"))
				.roles("USER").build()
				);
		manager.createUser(
				User.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN","USER").build()
				);
		return manager;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(authorize -> authorize
				//Peliculas
				.requestMatchers(new AntPathRequestMatcher("/index")).permitAll()
				.requestMatchers(new AntPathRequestMatcher("/pelicula/editar/*")).hasAnyRole("ADMIN")
				.requestMatchers(new AntPathRequestMatcher("/pelicula/agregar")).hasAnyRole("ADMIN", "USER")
				.requestMatchers(new AntPathRequestMatcher("/pelicula/eliminar/*")).hasAnyRole("ADMIN")
				.requestMatchers(new AntPathRequestMatcher("/pelicula/peliculas")).hasAnyRole("ADMIN","USER")
				//Reseñas
				.requestMatchers(new AntPathRequestMatcher("/index")).permitAll()
				.requestMatchers(new AntPathRequestMatcher("/resena/editar/*")).hasAnyRole("ADMIN")
				.requestMatchers(new AntPathRequestMatcher("/resena/agregar")).hasAnyRole("ADMIN", "USER")
				.requestMatchers(new AntPathRequestMatcher("/resena/eliminar/*")).hasAnyRole("ADMIN")
				.requestMatchers(new AntPathRequestMatcher("/resena/peliculas")).hasAnyRole("ADMIN","USER")
				.anyRequest().authenticated())
		.formLogin(login -> login.permitAll())
		.logout(logout -> logout.permitAll());
		return http.build();
	}
}
