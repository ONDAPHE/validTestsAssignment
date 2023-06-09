package com.training.assignmentone.exception;

public class ListingNotFoundException extends RuntimeException{
    public ListingNotFoundException(String listingId) {
        super(String.format("Listing with id %s not found", listingId));
    }
}
