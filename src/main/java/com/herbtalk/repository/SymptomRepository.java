package com.herbtalk.repository;

import org.springframework.data.repository.CrudRepository;

import com.herbtalk.model.Symptom;

/**
 * This interface represents the Spring Data repository for the table "symptom".
 * 
 * @author zoheb.nawaz
 *
 */
public interface SymptomRepository extends CrudRepository<Symptom, Integer> {

}
