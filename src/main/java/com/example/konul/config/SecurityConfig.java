package com.example.konul.config;
import com.example.konul.service.Impl.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import util.SecurityUtil;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Autowired
    private UserSecurityService userSecurityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final String[] PUBLIC_MATCHERS = {
            "/css/**",
            "/js/**",
            "/image/**",
            "/",
            "/new-user",
            "/login",
            "/store",
            "product-detail",
//            "/admin"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(PUBLIC_MATCHERS).permitAll()
                        .requestMatchers("/product/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .formLogin((form) -> form
                        .loginPage("/login").permitAll()
                        .failureUrl("/login?error")
                )
                .logout((logout) -> logout
                                .permitAll()
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/?logout")
                        .deleteCookies("remember-me")
//                        .permitAll()
                )
                .rememberMe((rememberMe) -> rememberMe
                        .key("aSecretKey")
                )
                .httpBasic(withDefaults());   // ??

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userSecurityService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

//    @Autowired    // I added that later
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
}

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig {
//
//    @Autowired
//    private UserSecurityService userSecurityService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    private static final String[] PUBLIC_MATCHERS = {
//            "/css/**",
//            "/js/**",
//            "/image/**",
//            "/",
//            "/new-user",
//            "/login",
//            "/store",
//            "product-detail"
//    };
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(PUBLIC_MATCHERS).permitAll()
//                        .requestMatchers("/product/**").hasRole("ADMIN")
//                        .anyRequest().authenticated()
//                )
//                .formLogin(formLogin -> formLogin
//                        .loginPage("/login")
//                        .failureUrl("/login?error")
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        .logoutSuccessUrl("/?logout")
//                        .deleteCookies("remember-me")
//                        .permitAll()
//                )
//                .rememberMe(rememberMe -> rememberMe
//                        .key("aSecretKey")
//                );
//
//        return http.build();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userSecurityService);
//        authProvider.setPasswordEncoder(passwordEncoder);
//        return authProvider;
//    }
//
////    @Autowired    // I added that later
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.authenticationProvider(authenticationProvider());
////    }
//}
