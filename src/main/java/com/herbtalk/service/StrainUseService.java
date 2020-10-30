package com.herbtalk.service;

import java.util.HashSet;

import java.util.Optional;

import com.herbtalk.model.Comment;
import com.herbtalk.model.Strain;
import com.herbtalk.model.StrainUse;
import com.herbtalk.model.User;
import com.herbtalk.repository.StrainRepository;
import com.herbtalk.repository.StrainUseRepository;
import com.herbtalk.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * This class implements the interface IStrainUseService.
 * 
 * @author zoheb.nawaz
 *
 */
@Service
public class StrainUseService implements IStrainUseService {

	@Autowired
	StrainUseRepository strainUseRepo;

	@Autowired
	UserRepository userRepository;

	@Autowired
	StrainRepository strainRepository;

	@Override
	public Iterable<StrainUse> getStrainUses(Integer strainId) {
		return strainUseRepo.getUsesOfStrain(strainId);
	}

	@Override
	public StrainUse addUse(String description, Integer strainId, Integer userId) {
		StrainUse strainUse = new StrainUse();
		strainUse.setDescription(description);
		Optional<User> user = userRepository.findById(userId);
		Optional<Strain> strain = strainRepository.findById(strainId);
		if (user.isPresent() && strain.isPresent()) {
			strainUse.setUser(user.get());
			strainUse.setStrain(strain.get());
			strainUse.setComments(new HashSet<Comment>());
			strainUseRepo.save(strainUse);
			return strainUse;
		}
		return null;
	}
}