package org.beond.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * web 접근 관련 제어 설정
 *  -> swagger 관련 및 api 쪽만 가능하도록 설정 
 * @author beond
 *
 */
@Configuration
class SecurityConfig extends WebSecurityConfigurerAdapter {

	// 접근 permit all 할 url 목록
    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/api/**"
    };
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	// auth_whitelist 외에는 모두 deny 하도록 구성
        http.authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/**/*").denyAll();
    }
}