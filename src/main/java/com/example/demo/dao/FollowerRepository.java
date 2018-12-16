package com.example.demo.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.FollowerEntity;


@Service
public interface FollowerRepository extends JpaRepository<FollowerEntity, Integer>{
	
	@Query("select f FROM FollowerEntity f where f.id = ?1 ")
	public FollowerEntity getFollowerByID(Long id);
	
	@Query("select f FROM FollowerEntity f where f.name = ?1 ")
	public FollowerEntity getFollowerByName(String name);
	
	@Transactional
	@Modifying
	@Query("UPDATE FollowerEntity f set  " + 
			"f.screenName             = :#{#FollowerEntity.screenName} , " +
			"f.name                   = :#{#FollowerEntity.name} , " +
			"f.url                    = :#{#FollowerEntity.url} , " +
			"f.profileImageUrl        = :#{#FollowerEntity.profileImageUrl} , " +
			"f.description            = :#{#FollowerEntity.description} , " +
			"f.createdDate            = :#{#FollowerEntity.createdDate} , " +
			"f.language               = :#{#FollowerEntity.language} , " +
			"f.statusesCount          = :#{#FollowerEntity.statusesCount} , " +
			"f.friendsCount           = :#{#FollowerEntity.friendsCount} , " +
			"f.followersCount         = :#{#FollowerEntity.followersCount} , " +
			"f.favoritesCount         = :#{#FollowerEntity.favoritesCount} , " +
			"f.listedCount            = :#{#FollowerEntity.listedCount} , " +
			"f.sidebarBorderColor     = :#{#FollowerEntity.sidebarBorderColor} , " +
			"f.sidebarFillColor       = :#{#FollowerEntity.sidebarFillColor} , " +
			"f.backgroundColor        = :#{#FollowerEntity.backgroundColor} , " +
			"f.backgroundImageUrl     = :#{#FollowerEntity.backgroundImageUrl} , " +
			"f.textColor              = :#{#FollowerEntity.textColor} , " +
			"f.linkColor              = :#{#FollowerEntity.linkColor} , " +
			"f.profileBannerUrl       = :#{#FollowerEntity.profileBannerUrl}  " +
			"where id   = :#{#FollowerEntity.id} ")
	public int updateFollower(@Param("FollowerEntity")  FollowerEntity FollowerEntity);

}

