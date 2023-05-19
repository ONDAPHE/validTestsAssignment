package com.training.assignmentone.controller;


import com.training.assignmentone.dtos.DealerDto;
import com.training.assignmentone.services.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/dealers")
public class DealerController {

    @Autowired
    private DealerService dealerService;


    @GetMapping("/{id}")
    public ResponseEntity<DealerDto> getDealerById(@PathVariable String id) {
        DealerDto dealerDto = dealerService.getDealerById(id);
        if (Objects.nonNull(dealerDto)) {
            return new ResponseEntity<>(dealerDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("")
    public ResponseEntity<DealerDto> createDealer(@RequestBody DealerDto dealerDto) {
        DealerDto createdDealerDto = dealerService.createDealer(dealerDto);
        return new ResponseEntity<>(createdDealerDto, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<DealerDto>> getAllDealers() {
        List<DealerDto> dealerDtos = dealerService.getAllDealers();
        return new ResponseEntity<>(dealerDtos, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<DealerDto> updateDealer(@RequestBody DealerDto dealerDto) {
        DealerDto updatedDealerDto = dealerService.updateDealer(dealerDto);
        if (Objects.nonNull(updatedDealerDto)) {
            return new ResponseEntity<>(updatedDealerDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DealerDto> deleteDealer(@PathVariable String id) {
        dealerService.deleteDealer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
