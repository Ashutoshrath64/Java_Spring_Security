package com.Ashutosh.Spring_Security_Demo.AOP;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {
    //Using after so that i can catch the exception after thrown
    @AfterThrowing(
            pointcut = "execution(* com.Ashutosh.Spring_Security_Demo.controller.*.*(..))",
            throwing = "ex"
    )
    public void handleException(Exception ex){
        if(
                ex instanceof BadCredentialsException ||
                        ex instanceof AuthenticationServiceException ||
                        ex instanceof UsernameNotFoundException ||
                        ex instanceof AccountExpiredException
        ){
            System.out.println("Issue with authentication >>>>>> "+ex.getMessage());
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).
//                    body("Authentication error "+ex.getMessage());

        }

    }
}
