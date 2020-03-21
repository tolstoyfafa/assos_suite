package com.motus.assosuite.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.motus.assosuite.config.MongoConfigTests;
import com.motus.assosuite.models.Adherent;

@SpringBootTest
@Import(MongoConfigTests.class)
public class AdherentRepositoryImplTest {
	
    @Autowired 
    private AdherentRepository repository;

    @BeforeEach
    public void setUp() {
        // initialize your repository with some test data
        repository.save(new Adherent());
    }
    
    @Test
    public void test() {
    	assertEquals(1, 1);
    }

}
