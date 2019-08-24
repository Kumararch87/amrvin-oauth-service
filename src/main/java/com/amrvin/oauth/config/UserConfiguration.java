package com.amrvin.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter{

	PasswordEncoder PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder(); 
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password(PasswordEncoder.encode("password01")).roles("USER","ADMIN","DEVELOPER").authorities("CAN_READ","CAN_DELETE","CAN_WRITE")
		.and().withUser("amrvin").password(PasswordEncoder.encode("password02")).roles("USER","DEVELOPER").authorities("CAN_READ","CAN_WRITE");
	}

}
