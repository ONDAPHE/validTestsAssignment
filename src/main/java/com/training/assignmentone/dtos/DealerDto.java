package com.training.assignmentone.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DealerDto {
    private String idDealerDto;
    private String nameDto;
    private int limit_pDto;
}
