package com.training.assignmentone.TestsMappers;

import com.training.assignmentone.dtos.ListingDto;
import com.training.assignmentone.entity.Dealer;
import com.training.assignmentone.entity.EtatListing;
import com.training.assignmentone.entity.Listing;
import com.training.assignmentone.mappers.ListingMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ListingMapperTest {

    @Test
    void given_listing_id_should_map_listingDto_id(){
        //GIVEN
        Listing listing=Listing.builder().idListing("2")
                .vehicule("Toyota")
                .price(1500000.00)
                .createdAt(LocalDateTime.now())
                .state(EtatListing.draft)
                .dealer(new Dealer())
                .build();

        //WHEN
        final ListingDto listingDto= ListingMapper.INSTANCE.listingToListingDto(listing);

        //THEN
        Assertions.assertEquals(listing.getIdListing(),listingDto.getIdListingDto());
        Assertions.assertEquals(listing.getVehicule(),listingDto.getVehiculeDto());
        Assertions.assertEquals(listing.getPrice(),listingDto.getPriceDto());
        Assertions.assertEquals(listing.getCreatedAt(),listingDto.getCreatedAtDto());
        Assertions.assertEquals(listing.getState(),listingDto.getStateDto());
        Assertions.assertEquals(listing.getDealer(),listingDto.getDealerDto());
    }

    @Test
    void given_listingDto_id_should_map_listing_id(){
        //GIVEN
        ListingDto listingDto = ListingDto.builder().idListingDto("2")
                .vehiculeDto("Toyota")
                .priceDto(1500000.00)
                .createdAtDto(LocalDateTime.now())
                .stateDto(EtatListing.draft)
                .dealerDto(new Dealer())
                .build();

        //WHEN
        final Listing listing = ListingMapper.INSTANCE.listingDtoToListing(listingDto);

        //THEN
        Assertions.assertEquals(listingDto.getIdListingDto(),listing.getIdListing());
        Assertions.assertEquals(listingDto.getVehiculeDto(),listing.getVehicule());
        Assertions.assertEquals(listingDto.getPriceDto(),listing.getPrice());
        Assertions.assertEquals(listingDto.getCreatedAtDto(),listing.getCreatedAt());
        Assertions.assertEquals(listingDto.getStateDto(),listing.getState());
        Assertions.assertEquals(listingDto.getDealerDto(),listing.getDealer());
    }
}
