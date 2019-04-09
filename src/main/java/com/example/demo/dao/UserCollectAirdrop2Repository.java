package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserCollectAirdrop2;

@Service
public interface UserCollectAirdrop2Repository extends JpaRepository<UserCollectAirdrop2, Integer> {
	
	@Query("select f FROM UserCollectAirdrop2 f where f.twitter = ?1 ")
	public UserCollectAirdrop2 getUserCollectByTwitter(String twitter);

	@Query("select f FROM UserCollectAirdrop2 f where f.telegram = ?1 ")
	public UserCollectAirdrop2 getUserCollectByTelegram(String telegram);

	@Query("select f FROM UserCollectAirdrop2 f where f.etherAdresse = ?1 ")
	public UserCollectAirdrop2	 getUserCollectByEtherAdresse(String etherAdresse);

}
