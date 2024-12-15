package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.entity.Usuario;
import com.example.demo.serviceImpl.UsuarioServiceImpl;

@Configuration
public class SpringSecurityConfig {

	@Autowired
	private UsuarioServiceImpl usuarioService;

	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		return new InMemoryUserDetailsManager();
	}

	@Bean
	public ApplicationRunner userLoader(InMemoryUserDetailsManager manager) {
		return args -> {
			List<Usuario> usuarios = usuarioService.findAll();

			manager.createUser(
					User.withUsername("admin")
					.password(passwordEncoder().encode("admin"))
					.roles("ADMIN", "USER").build()
				);
			
			for (Usuario usuario : usuarios) {
				manager.createUser(User.withUsername(usuario.getNombre())
						.password(usuario.getPass())
						.roles(usuario.getRol()).build()
						
				);
			}
			
		};
	}


	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize
				// Peliculas
				.requestMatchers(new AntPathRequestMatcher("/index")).permitAll()
				.requestMatchers(new AntPathRequestMatcher("/pelicula/editar/*")).hasAnyRole("ADMIN")
				.requestMatchers(new AntPathRequestMatcher("/pelicula/agregar")).hasAnyRole("ADMIN", "USER")
				.requestMatchers(new AntPathRequestMatcher("/pelicula/eliminar/*")).hasAnyRole("ADMIN")
				.requestMatchers(new AntPathRequestMatcher("/pelicula/peliculas")).hasAnyRole("ADMIN", "USER")
				// Reseñas
				.requestMatchers(new AntPathRequestMatcher("/resena/editar/*")).hasAnyRole("ADMIN")
				.requestMatchers(new AntPathRequestMatcher("/resena/agregar")).hasAnyRole("ADMIN", "USER")
				.requestMatchers(new AntPathRequestMatcher("/resena/eliminar/*")).hasAnyRole("ADMIN")
				.requestMatchers(new AntPathRequestMatcher("/resena/peliculas")).hasAnyRole("ADMIN", "USER")
				// Usuarios
				.requestMatchers(new AntPathRequestMatcher("/usuario/registrar")).hasAnyRole("ADMIN")
				.requestMatchers(new AntPathRequestMatcher("/usuario/agregar")).hasAnyRole("ADMIN")
				.requestMatchers(new AntPathRequestMatcher("/usuario/listar/usuario/")).hasAnyRole("ADMIN")
		
				.anyRequest().authenticated()).formLogin(login -> login.permitAll())
				.logout(logout -> logout.permitAll());
		return http.build();
	}
}
