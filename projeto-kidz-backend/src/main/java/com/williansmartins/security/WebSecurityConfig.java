package com.williansmartins.security;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.williansmartins.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;
    
    @Autowired
    private UserService userService;
    
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
			.antMatchers("/home", "/aberto").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/user/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.cors()
			.and()
			
			// filtra requisições de login
			.addFilterBefore(new JWTLoginFilter("/login", authenticationManager(), userService),
	                UsernamePasswordAuthenticationFilter.class)
			
			//filtro para autorizacao
			.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);
			
			// filtra outras requisições para verificar a presença do JWT no header
			//.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.
	        jdbcAuthentication()
	        .usersByUsernameQuery(usersQuery)
	        .authoritiesByUsernameQuery(rolesQuery)
	        .dataSource(dataSource)
	        .passwordEncoder(bCryptPasswordEncoder);
	}
	
//	@Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        final CorsConfiguration configuration = new CorsConfiguration();
//        List<String> listaHost = new ArrayList<String>();
//        listaHost.add("http://localhost:3000");
//        
//        List<String> listaMetodos = new ArrayList<String>();
//        listaMetodos.add("HEAD");
//        listaMetodos.add("GET");
//        listaMetodos.add("POST");
//        listaMetodos.add("PUT");
//        listaMetodos.add("DELETE");
//        listaMetodos.add("PATCH");
//        
//        List<String> listaHeaders = new ArrayList<String>();
//        listaHeaders.add("Authorization");
//        listaHeaders.add("Cache-Control");
//        listaHeaders.add("Content-Type");
//        
//		configuration.setAllowedOrigins(listaHost);
//        configuration.setAllowedMethods(listaMetodos);
//        // setAllowCredentials(true) is important, otherwise:
//        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
//        configuration.setAllowCredentials(true);
//        // setAllowedHeaders is important! Without it, OPTIONS preflight request
//        // will fail with 403 Invalid CORS request
//        configuration.setAllowedHeaders(listaHeaders);
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
}
