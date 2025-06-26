package com.reclamation.reclamtion;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") // tells Spring to use application-test.yml
class ReclamtionApplicationTests {

    @Test
    void contextLoads() {
        // This should pass now that the context is correctly loading
    }
}
