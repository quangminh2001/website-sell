package com.devpro.karma.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.devpro.karma.services.implement.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConf extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable().authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/img/**", "/fonts/**", "/scss/**", "/login", "/logout").permitAll()

				// các request kiểu: "/admin/" là phải đăng nhập (authenticated)
				.antMatchers("/admin/**").hasAuthority("ADMIN")
				.and()

				// cấu hình trang đăng nhập
				// /login: một request trong LoginController
				.formLogin().loginPage("/login").loginProcessingUrl("/login_processing_url")
						.successHandler(authenticationSuccessHandler())
//				.defaultSuccessUrl("/", false)
				.failureUrl("/login?login_error=true")
				.usernameParameter("username")
				.passwordParameter("password")
				.and()
				// cấu hình cho phần logout
				.logout().logoutUrl("/logout").logoutSuccessUrl("/").invalidateHttpSession(true)
				.deleteCookies("JSESSIONID");
	}
	
	@Autowired
	private UserDetailServiceImpl userDetailSevice;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailSevice).passwordEncoder(new BCryptPasswordEncoder(4));
	}
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new UrlAuthenticationSuccessHandler();
	}

}
