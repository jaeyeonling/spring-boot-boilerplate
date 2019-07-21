package com.jaeyeonling.boilerplate.domain.notfound;

import com.jaeyeonling.boilerplate.support.ControllerSupports;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class NotFoundControllerTests extends ControllerSupports {

    @DisplayName("페이지를 찾을 수 없다.")
    @Test
    void notFound() throws Exception {
        get("/asdasdada")
                .andExpect(status().isNotFound());
    }
}
