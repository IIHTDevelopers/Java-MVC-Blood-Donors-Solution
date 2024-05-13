package com.yaksha.training.blooddonors.repository;

import com.yaksha.training.blooddonors.entity.Donor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DonorRepository extends JpaRepository<Donor, Long> {

    @Query(value = "Select c from Donor c where :keyword is NULL or lower(state) like %:keyword% or lower(city) like %:keyword% or lower(bloodGroup) like %:keyword%")
    Page<Donor> findByStateAndCityAndBloodGroup(@Param("keyword") String keyword, Pageable pageable);
    
    
//    
//    @Query(value="select * from Donor where lower(firstName) like %:keyword% or lower(lastName) like %:keyword%")
//    List<Donor> findByFirstNameAndLastName(@Param("keyword")String keyword);
    
}
