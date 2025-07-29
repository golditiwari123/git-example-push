package com.webapp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webapp.Entity.College;

@Service
public interface CollegeService {

	String createNewCollege(College college);
	College getCollege(int id);
	College updateCollege(College college);
	String deletecollege(int id);
	List<College> fetchAllColleges();
}
