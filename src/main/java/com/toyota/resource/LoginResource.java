package com.toyota.resource;

import com.toyota.domain.CustomSpringUser;
import com.toyota.domain.User;
import com.toyota.dto.LoginDto;
import com.toyota.security.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Component
@Path("/login")
public class LoginResource {

    @Autowired
    private LoginSuccessHandler service;


    @GET
    @Produces("application/json")
    public LoginDto loginControl() {
        LoginDto loginDto = new LoginDto();
        service = new LoginSuccessHandler();
        com.toyota.domain.User user;
        //authentication islemi gerceklestiyse giris yapan kisinin bilgilerini user nesnesine atıyoruz
        //user = (User) service.getAuthentication().getPrincipal();
        //logindto'nun nick namesi giris yapan kisinin bilgilerine aktarılıyor
        Authentication aut;
        aut = service.getAuthentication();
        /*
        loginDto.setUserName(user.getUserNickname());

        if(loginDto.getUserName() != null){ //oturum acılmıssa
            loginDto.setFirtName(user.getUserName());
            loginDto.setEmail(user.getUserEmail());

        }
        if (loginDto.getUserName() != null)//Kullanıcı giriş yaptıysa.
            loginDto.setLoginStatus(true);
        else
            loginDto.setLoginStatus(false);//Kullanıcı giriş yapmadıysa login durumunu false yapıyoruz.*/

        return loginDto;

    }
}