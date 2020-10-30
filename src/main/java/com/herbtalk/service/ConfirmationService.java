package com.herbtalk.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herbtalk.model.Confirmation;
import com.herbtalk.model.StrainUse;
import com.herbtalk.repository.ConfirmationRepository;
import com.herbtalk.repository.StrainRepository;
import com.herbtalk.repository.StrainUseRepository;
import com.herbtalk.repository.SymptomRepository;
import com.herbtalk.repository.UserRepository;

/**
 * 
 * This class implements the interface IConfirmationService.
 * 
 * @author zoheb.nawaz
 *
 */
@Service
public class ConfirmationService implements IConfirmationService {

	@Autowired
	private ConfirmationRepository confirmationRepository;

	@Autowired
	private StrainUseRepository useRepository;

	@Override
	public Iterable<Confirmation> getAllConfirmations() {
		return confirmationRepository.findAll();
	}

	@Override
	public Iterable<Confirmation> getConfirmationsForStrain(Integer strainID) {
		Set<Confirmation> allConfirmations = new HashSet<>();
		Iterable<StrainUse> uses = useRepository.getUsesOfStrain(strainID);
		for (StrainUse use : uses) {
			allConfirmations.addAll(use.getConfirmations());
		}
		return allConfirmations;
	}

	@Override
	public void addConfirmation(Integer strainUseId, Integer userId, boolean confirmation, Integer symptomId) {
		confirmationRepository.addConfirmation(symptomId, strainUseId, confirmation);
	}
}