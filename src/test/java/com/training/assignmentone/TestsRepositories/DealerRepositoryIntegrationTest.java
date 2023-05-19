package com.training.assignmentone.TestsRepositories;

import com.training.assignmentone.entity.Dealer;
import com.training.assignmentone.repositories.DealerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest
@DirtiesContext
public class DealerRepositoryIntegrationTest {

    @Autowired
    private DealerRepository dealerRepository;

    @AfterEach
    void setupDatabase(){
        this.dealerRepository.deleteAll();
    }

    @Test
    void given_dealertosavethendealer_persistedto_database(){
        //GIVEN
        Dealer dealer = Dealer.builder()
                .name("Arthuro")
                .limit_p(5)
                .build();

        //WHEN
        final Dealer persistedDealer= dealerRepository.save(dealer);
        Optional<Dealer> optionalDealer= dealerRepository.findById(dealer.getIdDealer());

        //THEN
        Assertions.assertEquals(dealer,persistedDealer);
        Assertions.assertTrue(optionalDealer.isPresent());

    }
}
