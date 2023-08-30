package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.BloodBank;

public interface BloodBankRepository extends JpaRepository<BloodBank, String>{
	
	@Query(value="select  b from BloodBank b where b.contact=:contact")
	BloodBank getBankByContactId(@Param("contact") String contact);
	
	@Query(value="select  b from BloodBank b where b.licence=:licence")
	BloodBank getBankByLicenceId(@Param("licence") String licence);
	
	@Query(value="select  b from BloodBank b where b.email=:email")
	BloodBank featchById(@Param("email") String email);

	@Query(value="select  b from BloodBank b where b.status='PENDING'")
	List<BloodBank> GetAllPendingReqBloodBank();
	
	@Query(value="select  b from BloodBank b where b.status='ACCEPTED'")
	List<BloodBank> GetAllAcceptedBloodBank();
	
	@Query(value="select  b from BloodBank b where b.status='ACCEPTED' and city.district.state.id=:stateId")
	List<BloodBank> GetAllAcceptedBloodBankOfState(@Param("stateId") int stateId);
	
	@Query(value="select  b from BloodBank b where b.status='ACCEPTED' and city.district.id=:districtId ")
	List<BloodBank> GetAllAcceptedBloodBankOfDistrict(@Param("districtId") int districtId);
	
	@Query(value="select  b from BloodBank b where b.status='ACCEPTED' and city.id=:cityId")
	List<BloodBank> GetAllAcceptedBloodBankOfCity(@Param("cityId") int cityId);

	

}
