package com.training.assignmentone;

import com.training.assignmentone.dtos.DealerDto;
import com.training.assignmentone.entity.Dealer;
import com.training.assignmentone.mappers.DealerMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DealerMapperTest {

    @Test
    void given_dealer_id_should_map_dealerDto_id(){
        //GIVEN
        Dealer dealer= Dealer.builder().idDealer(11)
                .name("Arthur")
                .limit_p(5)
                .build();

        //WHEN
        final DealerDto dealerDto= DealerMapper.INSTANCE.dealerToDealerDto(dealer);

        //THEN
        Assertions.assertEquals(dealer.getIdDealer(),dealerDto.getIdDealerDto());
        Assertions.assertEquals(dealer.getName(),dealerDto.getNameDto());
        Assertions.assertEquals(dealer.getLimit_p(),dealerDto.getLimit_pDto());

    }
    @Test
    void given_dealerDto_id_should_map_dealer_id(){
        //GIVEN
        DealerDto dealerDto = DealerDto.builder().idDealerDto(11)
                .nameDto("Arthur")
                .limit_pDto(5)
                .build();

        //WHEN
        final Dealer dealer = DealerMapper.INSTANCE.dealerDtoToDealer(dealerDto);

        //THEN
        Assertions.assertEquals(dealerDto.getIdDealerDto(),dealer.getIdDealer());
        Assertions.assertEquals(dealerDto.getNameDto(),dealer.getName());
        Assertions.assertEquals(dealerDto.getLimit_pDto(),dealer.getLimit_p());
    }


}
