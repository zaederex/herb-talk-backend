package com.herbtalk.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.herbtalk.model.Strain;

/**
 * This interface represents the Spring Data repository for the table "strain".
 * 
 * @author zoheb.nawaz
 *
 */
public interface StrainRepository extends CrudRepository<Strain, Integer> {
	@Query(value = "select * from strain where name like %:name%", nativeQuery = true)
	Iterable<Strain> getStrainsByName(@Param("name") String name);
}
