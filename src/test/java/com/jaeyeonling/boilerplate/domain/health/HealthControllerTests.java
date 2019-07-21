package com.jaeyeonling.boilerplate.domain.health;

import com.jaeyeonling.boilerplate.support.ControllerSupports;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class HealthControllerTests extends ControllerSupports {

    @DisplayName("상태를 확인한다.")
    @Test
    void health() throws Exception {
        get("/health")
                .andExpect(status().isOk());
    }
}
