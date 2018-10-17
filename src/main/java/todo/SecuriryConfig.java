package todo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecuriryConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
		.withUser("onulo").password(passwordEncoder().encode("onulo1")).roles("USER");
	}
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	          .authorizeRequests()
	          	.antMatchers("/todo/**").authenticated()
	          	.antMatchers("/login").permitAll()
	          .and()
	          	.formLogin().loginPage("/login").defaultSuccessUrl("/todo")
	          .and()
	          	.csrf().disable();
	    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}
