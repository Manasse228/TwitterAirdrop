package com.example.demo.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.FollowerEntity;
import com.example.demo.metier.FollowerMetier;

@CrossOrigin(origins = "*")
@RestController

public class FollowerRestService {

	@Autowired
	private FollowerMetier followerMetier;

	@Autowired
	private Twitter twitter;

	@RequestMapping(value = "/purge/{userName}", method = RequestMethod.GET)
	public void purge(@PathVariable String userName) {

		ArrayList<Long> listId = getIdList(userName);
		ArrayList<FollowerEntity> followersList = (ArrayList<FollowerEntity>) followerMetier.getAllFollower();

		int cpt = 0;
		for (FollowerEntity followerEntity : followersList) {

			for (Long id : listId) {
				if (followerEntity.getId() == id) {
					cpt++;
					break;
				}
			}

			if (cpt == 0) {
				followerMetier.deleteFollower(followerEntity);
			}
			cpt = 0;
		}

	}

	@RequestMapping(value = "/getFollowers/{userName}", method = RequestMethod.GET)
	public void getFollowers(@PathVariable String userName) {

		ArrayList<Long> listId = getIdList(userName);
		TwitterProfile twitterProfile;
		int j = 0;

		for (Long idF : listId) {
			System.out.println("idF " + idF);
			if (followerMetier.getFollowerByID(idF) == null) {

				FollowerEntity follow = new FollowerEntity(idF);
				twitterProfile = twitter.userOperations().getUserProfile(idF);

				follow.setCreatedDate(twitterProfile.getCreatedDate());
				follow.setDescription(twitterProfile.getDescription());
				follow.setFavoritesCount(twitterProfile.getFavoritesCount());
				follow.setFollowersCount(twitterProfile.getFollowersCount());
				follow.setFriendsCount(twitterProfile.getFriendsCount());
				follow.setLanguage(twitterProfile.getLanguage());
				follow.setListedCount(twitterProfile.getListedCount());
				follow.setLocation(twitterProfile.getLocation());
				follow.setName(twitterProfile.getName());
				follow.setScreenName(twitterProfile.getScreenName());
				follow.setStatusesCount(twitterProfile.getStatusesCount());
				follow.setUrl(twitterProfile.getUrl());

				followerMetier.saveFollower(follow);

				try {
					j++;
					if (j >= 800) {
						Thread.sleep(1200000);
						System.out.println("am on pause ************************************ ");
						j = 0;
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	}

	public ArrayList<Long> getIdList(String userName) {

		long cursor = -1;
		CursoredList<Long> listId;
		ArrayList<Long> idList = new ArrayList<>();

		do {
			listId = twitter.friendOperations().getFollowerIdsInCursor(userName, cursor);
			for (Long ids : listId) {
				idList.add(ids);
			}

		} while ((cursor = listId.getNextCursor()) != 0);

		return idList;
	}

}
