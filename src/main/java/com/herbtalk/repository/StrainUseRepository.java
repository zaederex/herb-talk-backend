package com.herbtalk.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.herbtalk.model.StrainUse;

/**
 * This interface represents the Spring Data repository for the table
 * "strain_use".
 * 
 * @author zoheb.nawaz
 *
 */
public interface StrainUseRepository extends CrudRepository<StrainUse, Integer> {

	@Query(value = "Select * from Strain_Use s where s.strain_id = ?1 and s.user_id = ?2", nativeQuery = true)
	StrainUse findTuple(Integer strainId, Integer userId);

	@Query(value = "select * from strain_use where strain_id = :strainId", nativeQuery = true)
	Iterable<StrainUse> getUsesOfStrain(@Param("strainId") Integer strainid);

	@Transactional
	@Modifying
	@Query(value = "insert into strain_use (strain_id, user_id, description) values(1, 2, 'Wow')", nativeQuery = true)
	void addUse();
}
