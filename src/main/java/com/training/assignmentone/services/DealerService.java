package com.training.assignmentone.services;

import com.training.assignmentone.dtos.DealerDto;
import com.training.assignmentone.exception.DealerNotFoundException;

import java.util.List;

public interface DealerService {
    DealerDto createDealer(DealerDto dealerDto);
    DealerDto getDealerById(String id) throws DealerNotFoundException;
    List<DealerDto> getAllDealers();
    DealerDto updateDealer(DealerDto dealerDto) throws DealerNotFoundException;
    void deleteDealer(String id) throws DealerNotFoundException;
}
