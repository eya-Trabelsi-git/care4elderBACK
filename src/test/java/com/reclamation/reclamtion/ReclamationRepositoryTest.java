package com.reclamation.reclamtion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.reclamation.reclamtion.repository.ReclamationRepository;

@DataJpaTest
@ActiveProfiles("test")
public class ReclamationRepositoryTest {

    @Autowired
    private ReclamationRepository repository;

    @Test
    void testRepositoryLoads() {
        // You can test a simple query or just check if it's not null
        assert repository != null;
    }
}
