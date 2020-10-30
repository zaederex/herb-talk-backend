package com.herbtalk.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.herbtalk.model.StrainRating;

/**
 * This interface represents the Spring Data repository for the table "strain_rating".
 * 
 * @author zoheb.nawaz
 *
 */
public interface StrainRatingRepository extends CrudRepository<StrainRating, Integer> {
    @Query(value = "select avg(rating) from strain_rating where strain_id = :strainId", nativeQuery = true)
    Double getAvgStrainRating(@Param("strainId") Integer strainId);

    @Query(value = "select * from strain_rating where strain_use_id = :strainUseId", nativeQuery = true)
    Integer getRatingOfUse(@Param("strainUseId") Integer strainUseId);

    @Transactional
    @Modifying
    @Query(value = "insert into strain_rating (strain_id, strain_use_id, user_id, rating) values (:strainId, :strainUseId, :userId, :rating)", nativeQuery = true)
    void addStrainRating(@Param("strainId") Integer strainId, @Param("userId") Integer userId,
            @Param("strainUseId") Integer strainUseId, @Param("rating") Integer rating);
}