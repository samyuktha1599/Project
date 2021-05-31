package com.g6.onlineeyecare.spectacles.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.g6.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.g6.onlineeyecare.exceptions.SpectaclesIdNotFoundException;
import com.g6.onlineeyecare.patient.dao.IPatientRepository;
import com.g6.onlineeyecare.spectacles.dao.ISpectaclesRepository;
import com.g6.onlineeyecare.spectacles.dto.Spectacles;

@Service
public class SpectaclesServiceImpl implements ISpectaclesService{

	@Autowired
	ISpectaclesRepository repository;
	@Autowired
	IPatientRepository patientRepository;
	
	@Override
	@Transactional
	public Spectacles addSpectacles(Spectacles spectacles) throws PatientIdFoundNotException {
		if(patientRepository.findById(spectacles.getPatient().getUserId()).isPresent()) {
			repository.save(spectacles);
		}
		else {
			throw new PatientIdFoundNotException("Patient Id not found");
		}
			
		
		return spectacles;
	}

	@Override
	@Transactional
	public Spectacles updateSpectacles(Spectacles spectacles) throws SpectaclesIdNotFoundException {
		Optional<Spectacles>optional=null;
		
			optional=repository.findById(spectacles.getSpectaclesId());
			if(optional.isPresent()) {
			repository.save(spectacles);
			}
			else {
				throw new SpectaclesIdNotFoundException("Spectacles Id not found for updation");
			}
		return optional.get();
	}

	@Override
	@Transactional
	public Spectacles removeSpectacles(int spectaclesId) throws SpectaclesIdNotFoundException {
		Optional<Spectacles>optional=null;
		
			optional=repository.findById(spectaclesId);
			if(optional.isPresent()) {
			repository.deleteById(spectaclesId);
			}
			else {
				throw new SpectaclesIdNotFoundException("Spectacles Id not found for deletion");
			}
		return optional.get();
	}

	@Override
	public Spectacles viewSpectacles(int spectaclesId) throws SpectaclesIdNotFoundException {
		Optional<Spectacles>optional=null;
		
			optional=repository.findById(spectaclesId);
			if(optional.isPresent()) {
				repository.findById(spectaclesId);
			}
			else {
				throw new SpectaclesIdNotFoundException("Spectacles Id not found to view spectacles");
			}
		return optional.get();
	}

	@Override
	public List<Spectacles> viewSpectacles() {
		List<Spectacles> spectacleList = null;
		try {
			spectacleList = repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return spectacleList;
	}

}
