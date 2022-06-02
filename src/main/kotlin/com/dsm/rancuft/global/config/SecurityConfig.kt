package com.dsm.rancuft.global.config

import com.dsm.rancuft.global.jwt.JwtFilter
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.filter.OncePerRequestFilter

@EnableWebSecurity
class SecurityConfig(private val jwtFilter: JwtFilter): WebSecurityConfigurerAdapter(){
    override fun configure(http: HttpSecurity) {
        http
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .formLogin().disable()
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
            .authorizeRequests()
            .antMatchers("/user").permitAll()
            .antMatchers(HttpMethod.GET, "/gift").permitAll()
            .anyRequest().authenticated()
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
}