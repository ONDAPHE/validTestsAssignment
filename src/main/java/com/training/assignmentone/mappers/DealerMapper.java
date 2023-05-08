package com.training.assignmentone.mappers;

import com.training.assignmentone.dtos.DealerDto;
import com.training.assignmentone.entity.Dealer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DealerMapper {
    DealerMapper INSTANCE = Mappers.getMapper(DealerMapper.class);

    @BeanMapping(ignoreByDefault  = true)
    @Mapping(source = "idDealer", target = "idDealerDto")
    @Mapping(source = "name", target = "nameDto")
    @Mapping(source = "limit_p", target = "limit_pDto")
    DealerDto dealerToDealerDto(Dealer dealer);

    @BeanMapping(ignoreByDefault  = true)
    @Mapping(source = "idDealerDto", target = "idDealer")
    @Mapping(source = "nameDto", target = "name")
    @Mapping(source = "limit_pDto", target = "limit_p")
    Dealer dealerDtoToDealer(DealerDto dealerDto);

}
