package com.perihan.spring.rest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.perihan.spring.rest.dao.CountryDAO;
import com.perihan.spring.rest.model.Country;
 
@Service("countryService")
public class CountryService {
 
	@Autowired
	CountryDAO countryDao;
 
	@Transactional
	public List<Country> getAllCountries() {
		return countryDao.getAllCountries();
	}
 
	@Transactional
	public Country getCountry(String countryCode) {
		return countryDao.getCountry(countryCode);
	}
 
	@Transactional
	public void addCountry(Country country) {
		countryDao.addCountry(country);
	}
 
	@Transactional
	public void updateCountry(Country country) {
		countryDao.updateCountry(country);
 
	}
 
	@Transactional
	public void deleteCountry(Long id) {
		countryDao.deleteCountry(id);
	}
	
	@Transactional
	public Country getCountryById(Long id) {
		return countryDao.getCountryById(id);
	}
}
 