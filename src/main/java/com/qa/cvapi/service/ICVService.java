package com.qa.cvapi.service;

import com.qa.cvapi.persistence.domain.CV;

public interface ICVService {

	public CV addCV(CV cv);

	public Iterable<CV> getAllCVs();

//	public Optional<CV> getCV(int id);

	public CV updateCV(int id, CV cv);

	public String deleteCV(int id);

}
