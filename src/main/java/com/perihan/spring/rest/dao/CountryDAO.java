package com.perihan.spring.rest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.perihan.spring.rest.model.Country;

@Repository
public interface CountryDAO {
	public List<Country> getAllCountries();
	public Country getCountry(String countryCode);
	public Country addCountry(Country country);
	public void updateCountry(Country country);
	public void deleteCountry(Long id);
	public Country getCountryById(Long id);
}
