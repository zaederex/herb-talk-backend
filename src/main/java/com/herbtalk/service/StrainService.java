package com.herbtalk.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herbtalk.model.Strain;
import com.herbtalk.model.StrainRating;
import com.herbtalk.model.StrainUse;
import com.herbtalk.model.Symptom;
import com.herbtalk.model.User;
import com.herbtalk.repository.StrainRatingRepository;
import com.herbtalk.repository.StrainRepository;
import com.herbtalk.repository.StrainUseRepository;
import com.herbtalk.repository.UserRepository;

/**
 * 
 * This class implements the interface IStrainService.
 * 
 * @author zoheb.nawaz
 *
 */
@Service
public class StrainService implements IStrainService {

	@Autowired
	private StrainRepository strainrepo;

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private StrainRatingRepository ratingrepo;

	@Autowired
	private StrainUseRepository userepo;

	@Override
	public void addRating(Integer strainId, Integer userId, Integer rating) {

		User user = userrepo.findById(userId).get();
		Strain strain = strainrepo.findById(strainId).get();
		if (userepo.findTuple(strainId, userId).equals(null)) {
			StrainUse use = new StrainUse();
			use.setStrain(strain);
			use.setUser(user);
			userepo.save(use);
		}

		StrainRating strainrating = new StrainRating();
		strainrating.setRating(rating);
		strainrating.setStrain(strain);
		strainrating.setUser(user);
		ratingrepo.save(strainrating);
	}

	@Override
	public Iterable<Strain> getAllStrains() {
		return strainrepo.findAll();
	}

	@Override
	public Optional<Strain> getStrainById(Integer strainId) {
		return strainrepo.findById(strainId);
	}

	@Override
	public Iterable<Strain> queryStrainName(String name) {
		return strainrepo.getStrainsByName(name);
	}

	public Set<Symptom> getEffects(Integer strainId) {
		Optional<Strain> optStrain = strainrepo.findById(strainId);
		return optStrain.isPresent() ? optStrain.get().getSymptoms() : null;
	}
}
