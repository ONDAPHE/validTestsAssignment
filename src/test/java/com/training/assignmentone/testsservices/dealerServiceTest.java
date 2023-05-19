package com.training.assignmentone.testsservices;

import com.training.assignmentone.dtos.DealerDto;
import com.training.assignmentone.entity.Dealer;
import com.training.assignmentone.exception.DealerNotFoundException;
import com.training.assignmentone.mappers.DealerMapper;
import com.training.assignmentone.repositories.DealerRepository;
import com.training.assignmentone.services.DealerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class dealerServiceTest {

    @Mock
    private DealerRepository dealerRepository;

    @InjectMocks
    private DealerServiceImpl dealerService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createDealerDto_ValidInput_ReturnsDealerDto() {

        String dealerDtoName = "Test Dealer";

        int dealerDtotierLimit = 10;
        DealerDto dealerDto = DealerDto.builder()
                .nameDto(dealerDtoName)
                .limit_pDto(dealerDtotierLimit)
                .build();

        when(dealerRepository.save(any(Dealer.class)))
                .thenReturn(DealerMapper.INSTANCE.dealerDtoToDealer(dealerDto));

        DealerDto createdDealerDto = dealerService.createDealer(dealerDto);

        assertEquals(dealerDto, createdDealerDto);
        verify(dealerRepository, times(1)).save(any(Dealer.class));
    }

    @Test
    public void getDealerDtoById_InvalidId_ThrowsException() {

        String dealerDtoId = "1L";

        when(dealerRepository.findById(dealerDtoId)).thenReturn(Optional.empty());

        assertThrows(DealerNotFoundException.class, () -> dealerService.getDealerById(dealerDtoId));
        verify(dealerRepository, times(1))
                .findById(dealerDtoId);
    }

    @Test
    public void updateDealerDto_ValidInput_ReturnsUpdatedDealerDto() throws DealerNotFoundException {
        String dealerDtoId = "1L";
        String oldDealerDtoName = "Test Dealer";
        int oldTierLimit = 10;

        DealerDto oldDealerDto = DealerDto.builder()
                .nameDto(oldDealerDtoName)
                .limit_pDto(oldTierLimit)
                .build();

        oldDealerDto.setIdDealerDto(dealerDtoId);
        String newDealerDtoName = "New Dealer Name";
        int newTierLimit = 5;

        DealerDto updatedDealerDto = DealerDto.builder()
                .nameDto(newDealerDtoName)
                .limit_pDto(newTierLimit)
                .build();

        updatedDealerDto.setIdDealerDto(dealerDtoId);

        when(dealerRepository.findById(dealerDtoId))
                .thenReturn(Optional.of(DealerMapper.INSTANCE.dealerDtoToDealer(oldDealerDto)));
        when(dealerRepository.save(any(Dealer.class)))
                .thenReturn(DealerMapper.INSTANCE.dealerDtoToDealer(updatedDealerDto));

        DealerDto result = dealerService.updateDealer(updatedDealerDto);

        assertEquals(dealerDtoId, result.getIdDealerDto());
        assertEquals(newDealerDtoName, result.getNameDto());
        verify(dealerRepository, times(0))
                .save(DealerMapper.INSTANCE.dealerDtoToDealer(oldDealerDto));
    }


}
