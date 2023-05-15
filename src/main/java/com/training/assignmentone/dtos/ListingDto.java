package com.training.assignmentone.dtos;

import com.training.assignmentone.entity.Dealer;
import com.training.assignmentone.entity.EtatListing;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListingDto {
    private String idListingDto;
    private String vehiculeDto;
    private Double priceDto;
    private LocalDateTime createdAtDto;
    private EtatListing stateDto;
    private Dealer dealerDto;
}
