package com.herbtalk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.herbtalk.model.Address;

/**
 * This interface represents the Spring Data repository for the table "address".
 * 
 * @author zoheb.nawaz
 *
 */
public interface AddressRepository extends CrudRepository<Address, Integer> {
    @Query(value = "select * from address where street = :street and city = :city and state = :state limit 1", nativeQuery = true)
    Optional<Address> findAddress(@Param("street") String street, @Param("city") String city,
            @Param("state") String state);
}
