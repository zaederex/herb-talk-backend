package com.herbtalk.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.herbtalk.model.Address;
import com.herbtalk.model.Strain;
import com.herbtalk.model.Vendor;
import com.herbtalk.model.VendorRating;
import com.herbtalk.repository.AddressRepository;
import com.herbtalk.repository.VendorRatingRepository;
import com.herbtalk.repository.VendorRepository;
import com.herbtalk.util.EncryptionUtil;

/**
 * 
 * This class defines API end points for different queries related to vendors.
 * 
 * @author zoheb.nawaz
 * 
 */
@Controller
@CrossOrigin(origins = { "http://localhost:3000", "https://herb-talk.herokuapp.com" }, allowCredentials = "true")
@RequestMapping(path = "/api/vendor")
public class VendorController {

	@Autowired
	private VendorRepository repository;

	@Autowired
	private VendorRatingRepository vrRepository;

	@Autowired
	private AddressRepository addressRepo;

	/**
	 * Return all vendors.
	 * 
	 * @return vendors
	 */
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Vendor> getAllVendors() {
		return repository.findAll();
	}

	/**
	 * Return the rating of a vendor.
	 * 
	 * @param vendorId ID of the vendor
	 * @return rating
	 */
	@GetMapping(path = "/{vendorId}/ratings")
	public @ResponseBody Iterable<VendorRating> getVendorRatings(@PathVariable Integer vendorId) {
		return vrRepository.findRatingsForVendor(vendorId);
	}

	/**
	 * Return the vendor details based on the specified ID
	 * 
	 * @param vendorId ID of the vendor
	 * @return vendor details
	 */
	@GetMapping(path = "/{vendorId}")
	public @ResponseBody Optional<Vendor> getVendor(@PathVariable Integer vendorId) {
		return repository.findById(vendorId);
	}

	/**
	 * Add a vendor to the database.
	 * 
	 * @param vendorName name of the vendor
	 * @param password   password
	 * @param contact    contact number of the vendor
	 * @param street     street where the vendor is located
	 * @param city       city where the vendor is located
	 * @param state      state where the vendor is located
	 * @return vendor object
	 */
	@PostMapping(value = "/add")
	public @ResponseBody Vendor addNewVendor(@RequestParam("vendorName") String vendorName,
			@RequestParam("password") String password, @RequestParam("contact") String contact,
			@RequestParam("street") String street, @RequestParam("city") String city,
			@RequestParam("state") String state) {
		Optional<Address> address = addressRepo.findAddress(street, city, state);
		Vendor vendor = new Vendor();
		if (address.isPresent()) {
			vendor.setAddress(address.get());
		} else {
			Address addy = new Address();
			addy.setStreet(street);
			addy.setCity(city);
			addy.setState(state);
			addressRepo.save(addy);
			vendor.setAddress(addy);
		}
		vendor.setContact(contact);
		vendor.setVendorName(vendorName);
		vendor.setPassword(password);
		repository.save(vendor);
		return vendor;
	}

	/**
	 * Add a vendor to the database.
	 * 
	 * @param vendorName name of the vendor
	 * @param password   password
	 * @param contact    contact number of the vendor
	 * @param street     street where the vendor is located
	 * @param city       city where the vendor is located
	 * @param state      state where the vendor is located
	 * @return vendor object
	 */
	@PostMapping(value = "/register")
	public @ResponseBody Vendor register(@RequestParam("vendorName") String vendorName,
			@RequestParam("password") String password, @RequestParam("confPassword") String confirmPassword,
			@RequestParam("contact") String contact, @RequestParam("city") String city,
			@RequestParam("state") String state, @RequestParam("street") String street) {
		Optional<Vendor> vendor = repository.findByVendorName(vendorName);
		if (vendor.isPresent()) {
			return null;
		} else {
			if (!password.equals(confirmPassword)) {
				return null;
			} else {
				return addNewVendor(vendorName, password, contact, street, city, state);
			}
		}
	}

	/**
	 * Validate the vendor credentials and login.
	 * 
	 * @param vendorName username of the vendor
	 * @param password   password of the vendor
	 * @return null if credentials are invalid, else vendor details to authorize
	 *         login
	 */
	@PostMapping(value = "/login")
	public @ResponseBody Vendor login(@RequestParam("vendorName") String vendorName,
			@RequestParam("password") String password) {
		Optional<Vendor> vendor = repository.findByVendorName(vendorName);
		if (vendor.isPresent()) {
			if (EncryptionUtil.encrypt(password, "blowfish").equals(vendor.get().getPassword())) {
				return vendor.get();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Add a rating associated with a vendor
	 * 
	 * @param vendorId ID of the vendor being rated
	 * @param userId   ID of the user providing the rating
	 * @param rating   rating given
	 * @return string representing status of addition to database
	 */
	@PostMapping(value = "/rate")
	public @ResponseBody String rateVendor(@RequestParam("vendorId") Integer vendorId,
			@RequestParam("userId") Integer userId, @RequestParam("rating") Integer rating) {
		Optional<VendorRating> vr = vrRepository.findRating(userId, vendorId);
		if (vr.isPresent()) {
			vr.get().setRating(rating);
			vrRepository.save(vr.get());
		} else {
			vrRepository.insertRating(userId, vendorId, rating);
		}
		return "OK";
	}

	/**
	 * Mark a strain as being sold by the vendor.
	 * 
	 * @param strainId ID of the strain
	 * @param vendorId ID of the vendor
	 * @return OK if strain marked as sold
	 */
	@PostMapping(value = "sell")
	public @ResponseBody String sellStrain(@RequestParam("strainId") Integer strainId,
			@RequestParam("vendorId") Integer vendorId) {
		repository.insertSell(strainId, vendorId);
		return "OK";
	}

	/**
	 * Mark a strain as not being sold by the vendor.
	 * 
	 * @param strainId ID of the strain
	 * @param vendorId ID of the vendor
	 * @return OK if strain marked as not sold
	 */
	@DeleteMapping(value = "sell")
	public @ResponseBody String deleteStrain(@RequestParam("strainId") Integer strainId,
			@RequestParam("vendorId") Integer vendorId) {
		repository.deleteSell(strainId, vendorId);
		return "OK";
	}
}