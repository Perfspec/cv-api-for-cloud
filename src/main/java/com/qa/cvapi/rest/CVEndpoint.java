package com.qa.cvapi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cvapi.constants.Constants;
import com.qa.cvapi.persistence.domain.CV;
import com.qa.cvapi.service.CVService;

@EnableEurekaClient
@RestController
@RequestMapping(path = "/cv")
public class CVEndpoint {

	@Autowired
	private CVService cvService;

	@PostMapping(path = "addCV")
	public CV addCV(@RequestBody CV cv) {
		cvService.addCV(cv);
		return cv;
	}

	@GetMapping(path = "/getAll")
	public @ResponseBody Iterable<CV> getAllUsers() {
		return cvService.getAllCVs();
	}

//	@GetMapping(path = "/getCV/{id}")
//	public Optional<CV> getCV(@PathVariable int id) {
//		return cvService.getCV(id);
//	}

	@DeleteMapping(path = "/deleteCV/{id}")
	public String deleteUser(@PathVariable int id) {
		cvService.deleteCV(id);
		return Constants.CV_DELETED;
	}

	@PutMapping(path = "/updateCV/{id}")
	public String updateUser(@PathVariable int id, @RequestBody CV cv) {
		cvService.updateCV(id, cv);
		return Constants.CV_UPDATED;
	}

}
