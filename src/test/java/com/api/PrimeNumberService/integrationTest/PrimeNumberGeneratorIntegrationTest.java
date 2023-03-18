package com.api.PrimeNumberService.integrationTest;

import com.api.PrimeNumberService.model.PrimeNumberGeneratorResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Arrays;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 *  prime number generator integration test
 *  @author divyavenkatesh
 */
@SpringBootTest
@AutoConfigureMockMvc
public class PrimeNumberGeneratorIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetPrimes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/primes/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.initial").value(10))
                .andExpect(jsonPath("$.primes", hasSize(4)))
                .andExpect(jsonPath("$.primes", containsInAnyOrder(2, 3, 5, 7)));
    }
}
