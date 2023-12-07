package com.yaksha.training.blooddonors.repository;

import com.yaksha.training.blooddonors.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DonorRepository extends JpaRepository<Donor, Long> {

    @Query(value = "Select c from Donor c where lower(state) like %:keyword% or lower(city) like %:keyword%")
    List<Donor> findByStateAndCity(@Param("keyword") String keyword);
}
