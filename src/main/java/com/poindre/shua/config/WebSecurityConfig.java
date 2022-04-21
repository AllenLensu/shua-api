package com.poindre.shua.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poindre.shua.handler.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    ObjectMapper objectMapper;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
//        放行域
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Arrays.asList("http://127.0.0.1:18000", "http://localhost:18000", "http://172.29.242.82:18000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));

        configuration.addExposedHeader("access-control-allow-headers");
        configuration.addExposedHeader("access-control-allow-methods");
        configuration.addExposedHeader("access-control-allow-origin");
        configuration.addExposedHeader("access-control-max-age");
        configuration.addExposedHeader("X-Frame-Options");
        configuration.addExposedHeader("X-CSRF-TOKEN");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/verify/loginSuccess").authenticated()
                .antMatchers("/verify/loginFailure").authenticated()
                .anyRequest().permitAll()  //其他的请求可以访问

                .and()
                .formLogin()
                .successForwardUrl("/verify/loginSuccess")
                .failureForwardUrl("/verify/loginFailure")

                .and()
                .logout()
                .logoutSuccessHandler((request, response, authentication) -> request.getRequestDispatcher("/verify/logoutSuccess") .forward(request,response))
                .and()
                .exceptionHandling()
                .authenticationEntryPoint((HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) -> {
                    var responseJson = objectMapper.writeValueAsString(ErrorResponse.of(false, "请先登录！"));
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    response.setCharacterEncoding(StandardCharsets.UTF_8.name());
                    response.getWriter().println(responseJson);
                })
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
    }
}
