package com.webapp.Controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.Entity.College;
import com.webapp.Repository.CollegeRepository;
import com.webapp.responce.CustomResponse;

@RestController
@RequestMapping("/api")
public class CollegeController {

	@Autowired
	CollegeRepository collegeRepository;
	
	@PostMapping("/colleges")
	public ResponseEntity<CustomResponse<String>> createNewCollege(@RequestBody College college) {
		College response = collegeRepository.save(college);
		String message;
		String responce = null;
		CustomResponse<String> resp = new CustomResponse<String>( "college data created",responce);
		return ResponseEntity.status(HttpStatus.OK).body(resp);
		
	}
	
	@GetMapping("/colleges")
	public ResponseEntity<List<College>> getAllCollege() {
		List<College> clgList  = new ArrayList<>();
		collegeRepository.findAll().forEach(clgList::add);
		return new ResponseEntity<List<College>>(clgList,HttpStatus.OK);
	}
	
	@GetMapping("/colleges/{clgid}")
	public ResponseEntity<College> getCollegeById(@PathVariable Integer clgid){
		Optional<College> clg = collegeRepository.findById(clgid);
		if(clg.isPresent()) {
			return new ResponseEntity<College>(clg.get(),HttpStatus.FOUND);
		}else {
			return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	@PutMapping("/colleges")
	public String updateCollegeById(@PathVariable int clgid, @RequestBody College college) {
		Optional<College> clg = collegeRepository.findById(clgid);
		if(clg.isPresent()) {
			
		College existClg = clg.get();		
		existClg.setName(college.getName());
		existClg.setEmail(college.getEmail());
		existClg.setPassword(college.getPassword());
		existClg.setAbout(college.getAbout());
		collegeRepository.save(existClg);
		return "College Details against Id "+clgid+ "updated";
		
		}else {
			return "College Details does not exist for clgid "+clgid;
		}
		
	}
	@DeleteMapping("/colleges/{clgid}")
	public String deleteCollegeById(@PathVariable Integer clgid) {
		collegeRepository.deleteById(clgid);
		return "College Deleted Successfully";
	}
}



