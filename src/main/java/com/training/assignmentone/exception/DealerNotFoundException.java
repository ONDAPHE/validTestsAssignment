package com.training.assignmentone.exception;

public class DealerNotFoundException extends RuntimeException{

    public DealerNotFoundException(String dealerId){

        super(String.format("dealer with id %s not found", dealerId));
    }
}
