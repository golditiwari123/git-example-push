package com.webapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.Entity.College;
import com.webapp.Repository.CollegeRepository;

@Service
public class CollegeServiceImpl implements CollegeService  {

	@Autowired
	CollegeRepository collegeRepository;
	@Override
	public String createNewCollege(College college) {
		collegeRepository.save(college);
		return "done";
	}
	@Override
	public College getCollege(int id) {
		College college = collegeRepository.findById(id).get();
		return college;
	}
	@Override
	public College updateCollege(College college) {
		College updatecollege = collegeRepository.save(college);
		return updatecollege;
	}
	@Override
	public String deletecollege(int id) {
		collegeRepository.deleteById(id);
				return "deleted";
	}
	@Override
	public List<College> fetchAllColleges() {
		collegeRepository.findAll();
		return null;
	}

}
