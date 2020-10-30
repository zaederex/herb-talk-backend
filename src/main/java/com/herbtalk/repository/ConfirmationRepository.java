package com.herbtalk.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.herbtalk.model.Confirmation;


/**
 * This interface represents the Spring Data repository for the table "confirmation".
 * 
 * @author zoheb.nawaz
 *
 */
public interface ConfirmationRepository extends CrudRepository<Confirmation, Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into confirmation (strain_use_id, symptom_id, confirmation) values (:strainUseId, :symptomId, :confirmation)", nativeQuery = true)
    void addConfirmation(@Param("symptomId") Integer symptomId, @Param("strainUseId") Integer strainUseId,
            @Param("confirmation") Boolean confirmation);
}