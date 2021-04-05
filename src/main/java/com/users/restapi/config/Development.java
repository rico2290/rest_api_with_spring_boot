package com.users.restapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@Profile("development")
public @interface Development {

}
