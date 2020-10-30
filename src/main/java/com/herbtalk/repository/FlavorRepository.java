package com.herbtalk.repository;

import org.springframework.data.repository.CrudRepository;

import com.herbtalk.model.Flavor;


/**
 * This interface represents the Spring Data repository for the table "flavor".
 * 
 * @author zoheb.nawaz
 *
 */
public interface FlavorRepository extends CrudRepository<Flavor, Integer> {

}
