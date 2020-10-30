package com.herbtalk.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.herbtalk.model.StrainLike;

/**
 * This interface represents the Spring Data repository for the table "strain_like".
 * 
 * @author zoheb.nawaz
 *
 */
public interface StrainLikeRepository extends CrudRepository<StrainLike, Integer> {
    @Query(value = "select count(*) from strain_like where strain_id = :strainId", nativeQuery = true)
    public Integer getStrainLikeCount(@Param("strainId") Integer strainId);

    @Query(value = "select * from strain_like where strain_id = :strainId and user_id = :userId", nativeQuery = true)
    public StrainLike isLiked(@Param("strainId") Integer strainId, @Param("userId") Integer userId);

    @Transactional
    @Modifying
    @Query(value = "insert into strain_like (strain_id, user_id) values(:strainId, :userId)", nativeQuery = true)
    public void likeStrain(@Param("strainId") Integer strainId, @Param("userId") Integer userId);

    @Transactional
    @Modifying
    @Query(value = "delete from strain_like where strain_id = :strainId and user_id = :userId", nativeQuery = true)
    public void unlikeStrain(@Param("strainId") Integer strainId, @Param("userId") Integer userId);
}