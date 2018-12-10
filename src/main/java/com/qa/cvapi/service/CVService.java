package com.qa.cvapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.cvapi.constants.Constants;
import com.qa.cvapi.persistence.domain.CV;
import com.qa.cvapi.persistence.repository.CVRepository;

@Service
public class CVService implements ICVService {

	@Autowired
	private CVRepository cvRepo;

	// Create CV
	public CV addCV(CV cv) {
		return cvRepo.save(cv);
	}

	// Read all CVs
	public Iterable<CV> getAllCVs() {
		return cvRepo.findAll();
	}

	// Update CV
	public CV updateCV(int id, CV cv) {
		Optional<CV> cvInDB = cvRepo.findById(id);
		deleteCV(cvInDB.get().getId());
		addCV(cv);
		return cv;
	}

	// Delete CV
	public String deleteCV(int id) {
		cvRepo.deleteById(id);
		return Constants.CV_DELETED;
	}

	// Get individual CV
	public Optional<CV> getCV(int id) {
		return cvRepo.findById(id);

	}

}
