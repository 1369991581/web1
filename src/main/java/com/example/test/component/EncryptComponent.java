package com.example.test.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class EncryptComponent {
    @Autowired
    private ObjectMapper objectMapper;
    @Value("${my.secretkey}")
    private String secretkey;
    @Value("${my.salt}")
    private String salt;
    @Autowired
    private TextEncryptor encryptor;

    @Bean
    public TextEncryptor getTextEncryptor(){
        return Encryptors.text(secretkey, salt);
    }

    public String encryptToken(MyToken token){
        try{
            String json = objectMapper.writeValueAsString(token);
            return encryptor.encrypt(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "服务器端错误");
        }
    }


    public MyToken decryptToken(String auth){
        try{
            String json = encryptor.decrypt(auth);
            return objectMapper.readValue(json,MyToken.class);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "没有权限");
        }
    }

}
