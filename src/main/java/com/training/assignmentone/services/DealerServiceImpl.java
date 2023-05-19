package com.training.assignmentone.services;

import com.training.assignmentone.mappers.DealerMapper;
import com.training.assignmentone.dtos.DealerDto;
import com.training.assignmentone.entity.Dealer;
import com.training.assignmentone.exception.DealerNotFoundException;
import com.training.assignmentone.repositories.DealerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DealerServiceImpl implements DealerService{

    private DealerRepository dealerRepository;

    @Override
    public DealerDto createDealer(DealerDto dealerDto) {
        log.info("Enregistrement d un dealer");
        Dealer saveDealer = dealerRepository.save(DealerMapper.INSTANCE.dealerDtoToDealer(dealerDto));
        return DealerMapper.INSTANCE.dealerToDealerDto(saveDealer);
    }

    @Override
    public DealerDto getDealerById(String id) throws DealerNotFoundException {
        return DealerMapper.INSTANCE.dealerToDealerDto(dealerRepository.findById(id)
                .orElseThrow(()-> new DealerNotFoundException(id)));
    }

    @Override
    public List<DealerDto> getAllDealers() {
        return dealerRepository.findAll().stream()
                .map(DealerMapper.INSTANCE::dealerToDealerDto)
                .collect(Collectors.toList());
    }

    @Override
    public DealerDto updateDealer(DealerDto dealerDto) throws DealerNotFoundException {
        return DealerMapper.INSTANCE.dealerToDealerDto(dealerRepository.save(DealerMapper.INSTANCE.dealerDtoToDealer(dealerDto)));
    }

    @Override
    public void deleteDealer(String id) throws DealerNotFoundException {
        dealerRepository.deleteById(id);

    }
}
