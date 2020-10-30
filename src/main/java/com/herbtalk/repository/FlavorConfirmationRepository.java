package com.herbtalk.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.herbtalk.model.FlavorConfirmation;


/**
 * This interface represents the Spring Data repository for the table "flavor_confirmation".
 * 
 * @author zoheb.nawaz
 *
 */
public interface FlavorConfirmationRepository extends CrudRepository<FlavorConfirmation, Integer> {

	@Transactional
	@Modifying
	@Query(value = "insert into flavor_confirmation (strain_use_id, flavor_id, confirmation) values (:strainUseId, :flavorId, :confirmation)", nativeQuery = true)
	void addConfirmation(@Param("strainUseId") Integer strainUseId, @Param("flavorId") Integer flavorId,
			@Param("confirmation") Boolean confirmation);
}
