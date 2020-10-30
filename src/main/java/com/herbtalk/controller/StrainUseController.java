package com.herbtalk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.herbtalk.model.StrainUse;
import com.herbtalk.service.IStrainUseService;

/**
 * 
 * This class defines API end points for different queries related to
 * experiences posted by the different users.
 * 
 * @author zoheb.nawaz
 * 
 */
@CrossOrigin(origins = { "http://localhost:3000", "https://herb-talk.herokuapp.com" })
@RequestMapping(path = "/api/use")
@RestController
public class StrainUseController {

	@Autowired
	private IStrainUseService strainUseService;

	/**
	 * Return all experiences associated with the specified strain.
	 * 
	 * @param strainId ID of the strain
	 * @return all experience for the given strain
	 */
	@GetMapping(path = "/strain/{strainId}")
	public @ResponseBody Iterable<StrainUse> getStrainUses(@PathVariable("strainId") Integer strainId) {
		return strainUseService.getStrainUses(strainId);
	}

	/**
	 * Add an experience.
	 * 
	 * @param description string representing the user experience
	 * @param strainId    ID of the strain
	 * @param userId      ID of the user
	 * @return object the experience added
	 */
	@PostMapping(path = "/strain/{strainId}")
	public @ResponseBody StrainUse postStrainUse(@RequestBody String description,
			@PathVariable("strainId") Integer strainId, @RequestParam Integer userId) {
		return strainUseService.addUse(description, strainId, userId);
	}
}