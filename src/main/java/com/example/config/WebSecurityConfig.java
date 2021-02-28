package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration   // adnotacja mówiąca, że ta klasa jest klasą konfiguracyjną Springa
@EnableWebSecurity //mówimy Springowi, że ta klasa jest konfigurująca pod Spring Security
// dodatkowo roszerzamy klasę o WebSecurityConfigureAdapter
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // konfigurujemy użytkowników za pomocą menadżera
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("test").password(encoder.encode("test"))
                .roles("USER")
                .and()
                .withUser("admin").password(encoder.encode("admin")).roles("ADMIN");
    }


    // konfiguracja m.in. endpointów
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()   //odnosimy się do konfiguracji wszystkich poniższych elementów
                .antMatchers("/", "/index", "personList") // mamy dostęp na ROLE_USER tylko do tych wymienionych endpointów
                .hasAuthority("ROLE_USER") //definiujemy role do powyższych dostępów
                .antMatchers("/technology", "/tasks", "/index", "/") //mamy dostęp tylko do /technology i /tasks
                .hasAuthority("ROLE_ADMIN")
                .and()      // dopisujemy, aby kontynuować konfigurację kolejenego bloku
                .csrf().disable()   //wyłączamy zabezpieczenie CSRF w celu użycia np postman'a
                .headers().frameOptions().disable()
                .and()
                .formLogin()            // wskazujemy, że teraz będziemy konfigurować formularz logowania (autoryzacji)
                .loginPage("/login")    // wskazujemy endpointa, w którym będzie się odbywac logowanie
                .usernameParameter("username") //nadajemy nazwę, jaka będzie jako name w inpucie loginu w formularzu
                .passwordParameter("password")  //nadajemy nazwę, jaka będzie jako name w inpucie hasła w formularzu
                .loginProcessingUrl("/login")  //co się stanie po tym, jak wciśniemy przycisk zaloguj... czyli POST i ?
                .failureForwardUrl("/login?error") //co się stanie w momencie błędnego wpisania loginu i hasła
                .defaultSuccessUrl("/index")        //....w momencie prawidłowego
                .and()
        // rozpoczynamy kofigurację wylogowania
                .logout()
                .logoutSuccessUrl("/login") //wskazujemy, na który endpoint nas przekieruje, kiedy się wylogujemy
                ;

    }
}
