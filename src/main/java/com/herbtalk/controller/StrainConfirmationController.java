package com.herbtalk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.herbtalk.model.Confirmation;
import com.herbtalk.model.FlavorConfirmation;
import com.herbtalk.service.IConfirmationService;
import com.herbtalk.service.IFlavorConfirmationService;

/**
 * 
 * This class defines API end points for different queries related to strain
 * confirmations posted by the different users.
 * 
 * @author zoheb.nawaz
 * 
 */
@RestController
@CrossOrigin(origins = { "http://localhost:3000", "https://herb-talk.herokuapp.com" })
@RequestMapping(path = "/api/confirmation")
public class StrainConfirmationController {

	@Autowired
	private IConfirmationService confirmationService;

	@Autowired
	private IFlavorConfirmationService flavorConfirmService;

	/**
	 * Return all entries part of the confirmation table.
	 * 
	 * @return all symptom confirmations stored in the database
	 */
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Confirmation> getAllConfirmations() {
		return confirmationService.getAllConfirmations();
	}

	/**
	 * Return all symptom confirmations associated with the specified strain.
	 * 
	 * @param strainId ID of the strain
	 * @return all comments associated with the given strain ID
	 */
	@GetMapping(path = "/{strainId}")
	public @ResponseBody Iterable<Confirmation> getConfirmationsByStrainId(@PathVariable Integer strainId) {
		return confirmationService.getConfirmationsForStrain(strainId);
	}

	/**
	 * Return all flavor confirmations.
	 * 
	 * @return all flavor confirmations
	 */
	@GetMapping(path = "/flavors/all")
	public @ResponseBody Iterable<FlavorConfirmation> getAllFlavorConfirmations() {
		return flavorConfirmService.getAllConfirmations();
	}

	/**
	 * Return all flavor confirmations for a given strain.
	 * 
	 * @param strainId ID of the strain
	 * @return all flavor confirmations associated with the strain
	 */
	@GetMapping(path = "/flavors/{strainId}")
	public @ResponseBody Iterable<FlavorConfirmation> getAllFlavorConfirmations(@PathVariable Integer strainId) {
		return flavorConfirmService.getFlavorConfirmationsForAStrain(strainId);
	}

	/**
	 * Add a symptom confirmation for a strain.
	 * 
	 * @param strainId     ID of the strain
	 * @param strainUseId  ID of the strain use (experience)
	 * @param userId       ID of the user
	 * @param confirmation true if user confirms, else false
	 * @param symptomId    ID of the symptom
	 * @return status of successful addition to the database
	 */
	@PostMapping(path = "/{strainId}")
	public @ResponseBody String addConfirmation(@PathVariable("strainId") Integer strainId,
			@RequestParam("strainUseId") Integer strainUseId, @RequestParam("userId") Integer userId,
			@RequestParam("conf") boolean confirmation, @RequestParam("symptomId") Integer symptomId) {
		confirmationService.addConfirmation(strainUseId, userId, confirmation, symptomId);
		return "Confirmation added!";
	}

	/**
	 * Add a flavor confirmation for a strain.
	 * 
	 * @param strainId     ID of the strain
	 * @param strainUseId  ID of the strain user
	 * @param userId       ID of the user
	 * @param confirmation true for a positive confirmation, else false
	 * @param flavorId     ID of the flavor
	 * @return status of successful addition to the database
	 */
	@PostMapping(path = "/flavor/{strainId}")
	public @ResponseBody String addFlavorConfirmation(@PathVariable("strainId") Integer strainId,
			@RequestParam("strainUseId") Integer strainUseId, @RequestParam("userId") Integer userId,
			@RequestParam("conf") boolean confirmation, @RequestParam("flavorId") Integer flavorId) {
		flavorConfirmService.addConfirmation(strainUseId, flavorId, confirmation);
		return "Flavor Confirmation added!";
	}
}