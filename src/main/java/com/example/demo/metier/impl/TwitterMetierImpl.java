package com.example.demo.metier.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FollowerRepository;
import com.example.demo.entity.FollowerEntity;
import com.example.demo.metier.FollowerMetier;

@Service
public class TwitterMetierImpl implements FollowerMetier{
	
	@Autowired
	private FollowerRepository followerRepository;

	@Override
	public void saveFollower(FollowerEntity followerEntity) {
		followerRepository.save(followerEntity);
	}

	@Override
	public FollowerEntity getFollowerByID(Long id) {
		return followerRepository.getFollowerByID(id);
	}

	@Override
	public FollowerEntity getFollowerByName(String name) {
		return followerRepository.getFollowerByName(name);
	}

	@Override
	public int updateFollower(FollowerEntity followerEntity) {
		return followerRepository.updateFollower(followerEntity);
	}

	@Override
	public List<FollowerEntity> getAllFollower() {
		return followerRepository.findAll();
	}

	@Override
	public void deleteFollower(FollowerEntity followerEntity) {
		followerRepository.delete(followerEntity);
	}

}
