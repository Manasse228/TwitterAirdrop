package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserCollectSuite;

@Service
public interface UserCollectSuiteRepository extends JpaRepository<UserCollectSuite, Integer>{
	
	@Query("select f FROM UserCollectSuite f where f.twitter = ?1 ")
	public UserCollectSuite getUserCollectByTwitter(String twitter);

	@Query("select f FROM UserCollectSuite f where f.telegram = ?1 ")
	public UserCollectSuite getUserCollectByTelegram(String telegram);

	@Query("select f FROM UserCollectSuite f where f.etherAdresse = ?1 ")
	public UserCollectSuite getUserCollectByEtherAdresse(String etherAdresse);

}
