package legendary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/accueil", "/styles.css", "/bootstrap.min.css", "/bootstrap.min.js", "/jquery-3.2.1.min.js", "/popper.js", "/img/*", "/img/items/*", "/api/*", "/api/items/*", "/api/personnages/*", "/api/items/delete/*", "/api/items/edit/*", "/api/personnages/delete/*", "/api/personnages/edit/*").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll();

        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("Theophile").password("azerty").roles("USER");
        auth.inMemoryAuthentication()
            .withUser("Benjamin").password("azerty").roles("USER");
        auth.inMemoryAuthentication()
            .withUser("Mickael").password("azerty").roles("USER");
    }

}