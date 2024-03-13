package com.study.gestao_vagas.utilis;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.UUID;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtilis {

    public static String objectToJson(Object obj) {
        final ObjectMapper ObjectMapper = new ObjectMapper();
        try {
            return ObjectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String generateToken (UUID idCompany, String secret){
        Algorithm algorithm = Algorithm.HMAC256(secret);

        var expiresIn = Instant.now().plus(Duration.ofHours(2));

        var token = JWT.create().withIssuer("javagas")
            .withExpiresAt(expiresIn)
            .withSubject(idCompany.toString())
            .withClaim("roles", Arrays.asList("COMPANY"))
            .sign(algorithm);

            return token;
    }

}
