package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.AirdropUser;
import com.example.demo.entity.FollowerEntity;


@Service
public interface AirdropUserRepository extends JpaRepository<AirdropUser, Integer> {
	
	@Query("select f FROM AirdropUser f where f.twitter = ?1 ")
	public AirdropUser getUserCollectByTwitter(String twitter);

	@Query("select f FROM AirdropUser f where f.telegram = ?1 ")
	public AirdropUser getUserCollectByTelegram(String telegram);

	@Query("select f FROM AirdropUser f where f.etherAdresse = ?1 ")
	public AirdropUser getUserCollectByEtherAdresse(String etherAdresse);
	
	@Transactional
	@Modifying
	@Query("UPDATE AirdropUser f set  " + 
			"f.balance     = :#{#AirdropUser.balance}  " +
			"where id   = :#{#AirdropUser.id} ")
	public int updateAirdropUser(@Param("AirdropUser")  AirdropUser AirdropUser);

}
