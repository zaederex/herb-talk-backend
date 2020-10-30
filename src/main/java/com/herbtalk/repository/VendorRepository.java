package com.herbtalk.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.herbtalk.model.Vendor;


/**
 * This interface represents the Spring Data repository for the table "vendor".
 * 
 * @author zoheb.nawaz
 *
 */
public interface VendorRepository extends CrudRepository<Vendor, Integer> {

    @Query(value = "select * from vendor where vendor_name = :vendorName limit 1", nativeQuery = true)
    Optional<Vendor> findByVendorName(@Param("vendorName") String vendorName);

    @Transactional
    @Modifying
    @Query(value = "insert into strain_sold (strain_id, vendor_id) values (:strainId, :vendorId)", nativeQuery = true)
    void insertSell(@Param("strainId") Integer strainId, @Param("vendorId") Integer vendorId);

    @Transactional
    @Modifying
    @Query(value = "delete from strain_sold where strain_id = :strainId and vendor_id = :vendorId", nativeQuery = true)
    void deleteSell(@Param("strainId") Integer strainId, @Param("vendorId") Integer vendorId);
}
