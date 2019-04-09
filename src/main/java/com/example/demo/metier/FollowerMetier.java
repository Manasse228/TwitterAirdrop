package com.example.demo.metier;

import java.util.List;

import com.example.demo.entity.FollowerEntity;


public interface FollowerMetier {
	
	public void saveFollower(FollowerEntity followerEntity);
	
	public FollowerEntity getFollowerByID(Long id);
	
	public FollowerEntity getFollowerByName(String name);
	
	public int updateFollower(FollowerEntity followerEntity);
	
	public List<FollowerEntity> getAllFollower(); 
	
	public void deleteFollower(FollowerEntity followerEntity);
}
