package com.herbtalk.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.herbtalk.model.Strain;
import com.herbtalk.model.Symptom;
import com.herbtalk.service.IStrainService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000", "https://herb-talk.herokuapp.com" })
@RequestMapping(path = "/api/strain")
public class StrainController {

	@Autowired
	private IStrainService strainService;

	@GetMapping(path = "")
	public @ResponseBody Iterable<Strain> getAllStrains(@RequestParam(value = "name", required = false) String name) {
		if (name != null) {
			return strainService.queryStrainName(name);
		}
		return strainService.getAllStrains();
	}

	@GetMapping(path = "/{strainId}")
	public @ResponseBody Optional<Strain> getStrain(@PathVariable Integer strainId) {
		return strainService.getStrainById(strainId);
	}

	@GetMapping(path = "/get/experience/{strainId}")
	public @ResponseBody Set<Symptom> getExperiences(@PathVariable Integer strainId) {
		return strainService.getEffects(strainId);
	}

	// @PostMapping(path = "/comment/{strainId}")
	// public @ResponseBody String addComment(@PathVariable Integer strainId,
	// @RequestParam Integer userId) {
	// }

	// @PostMapping(path="/rating/{strainId}")

	// return"Strain rated!";
}