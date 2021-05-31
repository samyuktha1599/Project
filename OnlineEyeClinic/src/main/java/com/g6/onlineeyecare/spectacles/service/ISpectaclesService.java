package com.g6.onlineeyecare.spectacles.service;

import java.util.List;

import com.g6.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.g6.onlineeyecare.exceptions.SpectaclesIdNotFoundException;
import com.g6.onlineeyecare.spectacles.dto.Spectacles;

public interface ISpectaclesService {

	Spectacles addSpectacles(Spectacles spectacles) throws PatientIdFoundNotException;
	
	Spectacles updateSpectacles(Spectacles spectacles)throws SpectaclesIdNotFoundException;
	
	Spectacles removeSpectacles(int spectaclesId)throws SpectaclesIdNotFoundException;
	
	Spectacles viewSpectacles(int spectaclesId)throws SpectaclesIdNotFoundException;
	
	List<Spectacles>viewSpectacles();
	
	
}
