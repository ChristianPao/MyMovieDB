package com.pao.moviedb;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanToWatchService {
	@Autowired
	PlanToWatchRepository planToWatchRepository;

	public void addToPlan(PlanToWatch ptw) {
		planToWatchRepository.save(ptw);
	}
	
	public PlanToWatch findById(PlanToWatchKey id) {
		return planToWatchRepository.findById(id).orElse(null);
	}
}
