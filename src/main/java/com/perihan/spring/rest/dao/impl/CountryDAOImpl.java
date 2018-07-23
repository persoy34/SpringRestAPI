package com.perihan.spring.rest.dao.impl;

import java.util.List;


import com.perihan.spring.rest.dao.CountryDAO;
import com.perihan.spring.rest.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 

@Repository
public class CountryDAOImpl implements CountryDAO {

	@Autowired
	private SessionFactory sessionFactory;
 
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
 
	public List<Country> getAllCountries() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Country> countryList = session.createQuery("from Country").list();
		return countryList;
	}
 
	public Country getCountry(String countryCode) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query= session.
		        createQuery("from Country where countryCode=:countryCode");
		query.setParameter("countryCode", countryCode);
		Country country = (Country) query.uniqueResult();
		return country;
	}
 
	public Country addCountry(Country country) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(country);
		return country;
	}
	
 
	public void updateCountry(Country country) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(country);
	}
 
	public void deleteCountry(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Country p = session.load(Country.class, id);
		if (null != p) {
			session.delete(p);
		}
	} 
	
	public Country getCountryById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Country country = session.load(Country.class, id);
		return country;
	}
}
