package com.example.demo.service;


import java.util.ArrayList;

import org.atteo.evo.inflector.TwoFormInflector;
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

@CrossOrigin(origins="*")
@RestController

public class FollowerRestService {
	
	@Autowired
	private FollowerMetier followerMetier;
	
	@Autowired
	private Twitter twitter;
	
	
	@RequestMapping(value="/getFollowers/{userName}",method=RequestMethod.GET)
	public void getFollowers(@PathVariable String userName) {
	
        long cursor = -1;
        ArrayList<Long> idList = new ArrayList<>();
        ArrayList<TwitterProfile> twitterProfileList = new ArrayList<>();
        CursoredList<Long> listId;
        System.out.println("Listing followers's ids.");
        int i =0 ,j = 0;
        do {
        	listId =  twitter.friendOperations().getFollowerIdsInCursor(userName, cursor);
        	for (Long ids : listId) {
        		i++;
                //System.out.println(ids);
                idList.add(ids);
			}
            
        } while ((cursor = listId.getNextCursor()) != 0);
        
        System.out.println("taile totale i "+ i);
        TwitterProfile twitterProfile;
        for (Long idF : idList) {
        	 System.out.println("idF "+ idF);
        	if( followerMetier.getFollowerByID(idF) == null) {
        		FollowerEntity follow = new FollowerEntity(idF);
        		twitterProfile  = twitter.userOperations().getUserProfile(idF);
        		
        	
        		follow.setBackgroundColor(twitterProfile.getBackgroundColor());
        		follow.setBackgroundImageUrl(twitterProfile.getBackgroundImageUrl());
        		follow.setCreatedDate(twitterProfile.getCreatedDate());
        		follow.setDescription(twitterProfile.getDescription());
        		follow.setFavoritesCount(twitterProfile.getFavoritesCount());
        		follow.setFollowersCount(twitterProfile.getFollowersCount());
        		follow.setFriendsCount(twitterProfile.getFriendsCount());
        		follow.setLanguage(twitterProfile.getLanguage());
        		follow.setLinkColor(twitterProfile.getLinkColor());
        		follow.setListedCount(twitterProfile.getListedCount());
        		follow.setLocation(twitterProfile.getLocation());
        		follow.setName(twitterProfile.getName());
        		follow.setProfileBannerUrl(twitterProfile.getProfileBannerUrl());
        		follow.setProfileImageUrl(twitterProfile.getProfileImageUrl());
        		follow.setScreenName(twitterProfile.getScreenName());
        		follow.setSidebarBorderColor(twitterProfile.getSidebarBorderColor());
        		follow.setSidebarFillColor(twitterProfile.getSidebarFillColor());
        		follow.setStatusesCount(twitterProfile.getStatusesCount());
        		follow.setTextColor(twitterProfile.getTextColor());
        		follow.setUrl(twitterProfile.getUrl());
        		
        		followerMetier.saveFollower(follow);
        		
        		try {
        			j++;
        			if(j>= 800) {
        				Thread.sleep(1200000);
        				System.out.println("am on pause ************************************ ");
        				j=0;
        			}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
        	}
        }
        
    
	}

}
