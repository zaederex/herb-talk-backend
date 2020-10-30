package com.herbtalk.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herbtalk.model.FlavorConfirmation;
import com.herbtalk.model.StrainUse;
import com.herbtalk.repository.FlavorConfirmationRepository;
import com.herbtalk.repository.StrainUseRepository;

/**
 * 
 * This class implements the interface IFlavorConfirmationService.
 * 
 * @author zoheb.nawaz
 *
 */
@Service
public class FlavorConfirmationService implements IFlavorConfirmationService {

	@Autowired
	private FlavorConfirmationRepository fcrepository;

	@Autowired
	private StrainUseRepository useRepository;

	@Override
	public Iterable<FlavorConfirmation> getFlavorConfirmationsForAStrain(Integer strainID) {

		Set<FlavorConfirmation> allConfirmations = new HashSet<>();
		Iterable<StrainUse> uses = useRepository.getUsesOfStrain(strainID);
		for (StrainUse use : uses) {
			allConfirmations.addAll(use.getFlavorConfirmations());
		}
		return allConfirmations;
	}

	@Override
	public Iterable<FlavorConfirmation> getAllConfirmations() {
		return fcrepository.findAll();
	}

	@Override
	public void addConfirmation(Integer strainUseId, Integer flavorId, boolean confirmation) {
		fcrepository.addConfirmation(strainUseId, flavorId, confirmation);
	}
}