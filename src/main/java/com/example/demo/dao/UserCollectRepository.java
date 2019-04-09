package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserCollect;

@Service
public interface UserCollectRepository extends JpaRepository<UserCollect, Integer> {

	@Query("select f FROM UserCollect f where f.twitter = ?1 ")
	public UserCollect getUserCollectByTwitter(String twitter);

	@Query("select f FROM UserCollect f where f.telegram = ?1 ")
	public UserCollect getUserCollectByTelegram(String telegram);

	@Query("select f FROM UserCollect f where f.etherAdresse = ?1 ")
	public UserCollect getUserCollectByEtherAdresse(String etherAdresse);

}
