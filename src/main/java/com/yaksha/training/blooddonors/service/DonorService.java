package com.yaksha.training.blooddonors.service;

import com.yaksha.training.blooddonors.entity.Donor;
import com.yaksha.training.blooddonors.repository.DonorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorService {

    private final DonorRepository donorRepository;

    public DonorService(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    public List<Donor> getDonors() {
        List<Donor> donors = donorRepository.findAll();
        return donors;
    }

    public Donor saveDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    public Donor getDonor(Long id) {
        return donorRepository.findById(id).get();
    }

    public boolean deleteDonor(Long id) {
        donorRepository.deleteById(id);
        return true;
    }

    public List<Donor> searchDonors(String theSearchName) {
        if (theSearchName != null && theSearchName.trim().length() > 0) {
            return donorRepository.findByStateAndCity(theSearchName);
        } else {
            return donorRepository.findAll();
        }
    }
}
