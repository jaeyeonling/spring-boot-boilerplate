package com.jaeyeonling.boilerplate.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
abstract class BaseSupports {

    @Autowired
    private ObjectMapper objectMapper;

    byte[] toBytes(final Object value) throws JsonProcessingException {
        return objectMapper.writeValueAsBytes(value);
    }
}
