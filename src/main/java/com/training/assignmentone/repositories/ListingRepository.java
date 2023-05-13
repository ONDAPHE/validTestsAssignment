package com.training.assignmentone.repositories;

import com.training.assignmentone.entity.EtatListing;
import com.training.assignmentone.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ListingRepository extends JpaRepository<Listing, String> {
    List<Listing> findBydealerId(String dealerId);

    List<Listing> findByDealerIdAndState(String dealerId, EtatListing status);

    Listing findFirstByDealerIdAndStateOrderByCreatedAtAsc(String dealerId, EtatListing status);

    int countByDealerIdAndState(String dealerId, EtatListing status);

    Optional<Listing>findByIdListing(String id);
}
