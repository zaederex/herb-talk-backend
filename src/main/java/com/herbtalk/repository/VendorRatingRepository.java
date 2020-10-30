package com.herbtalk.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.herbtalk.model.VendorRating;


/**
 * This interface represents the Spring Data repository for the table "vendor_rating".
 * 
 * @author zoheb.nawaz
 *
 */
public interface VendorRatingRepository extends CrudRepository<VendorRating, Integer> {

    @Query(value = "select * from vendor_rating where user_id = :userId and vendor_id = :vendorId", nativeQuery = true)
    Optional<VendorRating> findRating(@Param("userId") Integer userId, @Param("vendorId") Integer vendorId);

    @Query(value = "select * from vendor_rating where vendor_id = :vendorId", nativeQuery = true)
    Iterable<VendorRating> findRatingsForVendor(@Param("vendorId") Integer vendorId);

    @Modifying
    @Transactional
    @Query(value = "insert into vendor_rating (user_id, vendor_id, rating) values (:userId, :vendorId, :rating)", nativeQuery = true)
    void insertRating(@Param("userId") Integer userId, @Param("vendorId") Integer vendorId,
            @Param("rating") Integer rating);
}