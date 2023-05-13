package com.training.assignmentone;

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
        Listing listing=Listing.builder().idListing(2).build();

        //WHEN
        final ListingDto listingDto= ListingMapper.INSTANCE.listingToListingDto(listing);

        //THEN
        Assertions.assertEquals(listing.getIdListing(),listingDto.getIdListingDto());

    }

    @Test
    void given_listing_vehicule_should_map_listingDto_vehicule(){
        //GIVEN
        Listing listing=Listing.builder().vehicule("Toyota").build();

        //WHEN
        final ListingDto listingDto= ListingMapper.INSTANCE.listingToListingDto(listing);

        //THEN
        Assertions.assertEquals(listing.getVehicule(),listingDto.getVehiculeDto());
    }

    @Test
    void given_price_vehicule_should_map_listingDto_price(){
        //GIVEN
        Listing listing=Listing.builder().price(1500000.00).build();

        //WHEN
        final ListingDto listingDto= ListingMapper.INSTANCE.listingToListingDto(listing);

        //THEN
        Assertions.assertEquals(listing.getPrice(),listingDto.getPriceDto());
    }
    @Test
    void given_createAt_vehicule_should_map_listingDto_createAt(){
        //GIVEN
        Listing listing=Listing.builder().createdAt(LocalDateTime.now()).build();

        //WHEN
        final ListingDto listingDto= ListingMapper.INSTANCE.listingToListingDto(listing);

        //THEN
        Assertions.assertEquals(listing.getCreatedAt(),listingDto.getCreatedAtDto());
    }
    @Test
    void given_state_vehicule_should_map_listingDto_state(){
        //GIVEN
        Listing listing=Listing.builder().state(EtatListing.draft).build();

        //WHEN
        final ListingDto listingDto= ListingMapper.INSTANCE.listingToListingDto(listing);

        //THEN
        Assertions.assertEquals(listing.getState(),listingDto.getStateDto());
    }
    @Test
    void given_listing_dealer_should_map_listingDto_dealer(){
        //GIVEN
        Listing listing= Listing.builder().dealer(new Dealer()).build();

        //WHEN
        final ListingDto listingDto = ListingMapper.INSTANCE.listingToListingDto(listing);

        //THEN
        Assertions.assertEquals(listing.getDealer(),listingDto.getDealerDto());
    }

    @Test
    void given_listingDto_id_should_map_listing_id(){
        //GIVEN
        ListingDto listingDto = ListingDto.builder().idListingDto(2).build();

        //WHEN
        final Listing listing = ListingMapper.INSTANCE.listingDtoToListing(listingDto);

        //THEN
        Assertions.assertEquals(listingDto.getIdListingDto(),listing.getIdListing());
    }

    @Test
    void given_listingDto_vehicule_should_map_listing_vehicule(){
        //GIVEN
        ListingDto listingDto = ListingDto.builder().vehiculeDto("Toyota").build();

        //WHEN
        final Listing listing = ListingMapper.INSTANCE.listingDtoToListing(listingDto);

        //THEN
        Assertions.assertEquals(listingDto.getVehiculeDto(),listing.getVehicule());
    }

    @Test
    void given_listingDto_price_should_map_listing_price(){
        //GIVEN
        ListingDto listingDto = ListingDto.builder().priceDto(1500000.00).build();

        //WHEN
        final Listing listing = ListingMapper.INSTANCE.listingDtoToListing(listingDto);

        //THEN
        Assertions.assertEquals(listingDto.getPriceDto(),listing.getPrice());
    }

    @Test
    void given_listingDto_createAt_should_map_listing_createAt(){
        //GIVEN
        ListingDto listingDto = ListingDto.builder().createdAtDto(LocalDateTime.now()).build();

        //WHEN
        final Listing listing = ListingMapper.INSTANCE.listingDtoToListing(listingDto);

        //THEN
        Assertions.assertEquals(listingDto.getCreatedAtDto(),listing.getCreatedAt());
    }

    @Test
    void given_listingDto_state_should_map_listing_state(){
        //GIVEN
        ListingDto listingDto = ListingDto.builder().stateDto(EtatListing.draft).build();

        //WHEN
        final Listing listing = ListingMapper.INSTANCE.listingDtoToListing(listingDto);

        //THEN
        Assertions.assertEquals(listingDto.getStateDto(),listing.getState());
    }

    @Test
    void given_listingDto_dealer_should_map_listing_dealer(){
        //GIVEN
        ListingDto listingDto = ListingDto.builder().dealerDto(new Dealer()).build();

        //WHEN
        final Listing listing = ListingMapper.INSTANCE.listingDtoToListing(listingDto);

        //THEN
        Assertions.assertEquals(listingDto.getDealerDto(),listing.getDealer());
    }
}
