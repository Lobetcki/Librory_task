package com.skypro.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
//Создаем метод в классе конфигурации -
//который возвращает бин SecurityFilterChain -
//основной бин для конфигурации Spring Security
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // Отключение защиты от подделки межсайтовых запросов (CSRF)
        // это необходимо чтобы нормально использовать REST API,
        // не запрашивая CSRF коды
        httpSecurity.csrf().disable()
                // Настройка правил авторизации
                .authorizeRequests()
                // Разрешение доступа к URL-адресу "/web" для всех пользователей
                .antMatchers("/web").permitAll()
                // Запрет доступа к любым другим URL-адресам, если пользователь не прошел аутентификацию
                .anyRequest().authenticated()
                // Настройка аутентификации через базовую HTTP-аутентификацию
                .and().httpBasic();

        return httpSecurity.build();
    }

//    @Configuration
//    @EnableWebSecurity
//    public class MultiHttpSecurityConfig {
        @Bean
        public UserDetailsService userDetailsService() throws Exception {
            // ensure the passwords are encoded properly
            User.UserBuilder users = User.withDefaultPasswordEncoder();
            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
            manager.createUser(users.username("user").password("password").roles("USER").build());
            manager.createUser(users.username("admin").password("password").roles("USER","ADMIN").build());
            return manager;
        }
//
//        @Bean
//        @Order(1)
//        public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
//            http
//                    .securityMatcher("/api/**")
//                    .authorizeHttpRequests(authorize -> authorize
//                            .anyRequest().hasRole("ADMIN")
//                    )
//                    .httpBasic(withDefaults());
//            return http.build();
//        }
//
//        @Bean
//        public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {
//            http
//                    .authorizeHttpRequests(authorize -> authorize
//                            .anyRequest().authenticated()
//                    )
//                    .formLogin(withDefaults());
//            return http.build();
//        }
//    }

}
