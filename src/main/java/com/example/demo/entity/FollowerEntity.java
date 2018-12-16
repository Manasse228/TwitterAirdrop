package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "followers" )
public class FollowerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "followersID")
	private int followersID;
	
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "createdDate", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name = "statusesCount", nullable = true)
	private int statusesCount;
	
	@Column(name = "friendsCount", nullable = true)
	private int friendsCount;
	
	@Column(name = "followersCount", nullable = true)
	private int followersCount;
	
	@Column(name = "favoritesCount", nullable = true)
	private int favoritesCount;
	
	@Column(name = "listedCount", nullable = true)
	private int listedCount;
	
	@Column(length = 225, name = "language", nullable = true, unique = false)
	private String language;
	
	@Column(length = 225, name = "screenName", nullable = true, unique = false)
	private String screenName;
	
	@Column(length = 225, name = "name", nullable = true, unique = false)
	private String name;
	
	@Column(length = 225, name = "url", nullable = true, unique = false)
	private String url;
	
	@Column(length = 225, name = "profileImageUrl", nullable = true, unique = false)
	private String profileImageUrl;
	
	@Column(length = 225, name = "description", nullable = true, unique = false)
	private String description;
	
	@Column(length = 225, name = "location", nullable = true, unique = false)
	private String location;
	
	@Column(length = 225, name = "sidebarBorderColor", nullable = true, unique = false)
	private String sidebarBorderColor;
	
	@Column(length = 225, name = "sidebarFillColor", nullable = true, unique = false)
	private String sidebarFillColor;
	
	@Column(length = 225, name = "backgroundColor", nullable = true, unique = false)
	private String backgroundColor;
	
	@Column(length = 225, name = "backgroundImageUrl", nullable = true, unique = false)
	private String backgroundImageUrl;
	
	@Column(length = 225, name = "textColor", nullable = true, unique = false)
	private String textColor;
	
	@Column(length = 225, name = "linkColor", nullable = true, unique = false)
	private String linkColor;
	
	@Column(length = 225, name = "profileBannerUrl", nullable = true, unique = false)
	private String profileBannerUrl;

	public FollowerEntity(long id) {
		this.id = id;
	}
	
	public FollowerEntity() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getStatusesCount() {
		return statusesCount;
	}

	public void setStatusesCount(int statusesCount) {
		this.statusesCount = statusesCount;
	}

	public int getFriendsCount() {
		return friendsCount;
	}

	public void setFriendsCount(int friendsCount) {
		this.friendsCount = friendsCount;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public int getFavoritesCount() {
		return favoritesCount;
	}

	public void setFavoritesCount(int favoritesCount) {
		this.favoritesCount = favoritesCount;
	}

	public int getListedCount() {
		return listedCount;
	}

	public void setListedCount(int listedCount) {
		this.listedCount = listedCount;
	}


	public String getSidebarBorderColor() {
		return sidebarBorderColor;
	}

	public void setSidebarBorderColor(String sidebarBorderColor) {
		this.sidebarBorderColor = sidebarBorderColor;
	}

	public String getSidebarFillColor() {
		return sidebarFillColor;
	}

	public void setSidebarFillColor(String sidebarFillColor) {
		this.sidebarFillColor = sidebarFillColor;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}


	public String getBackgroundImageUrl() {
		return backgroundImageUrl;
	}

	public void setBackgroundImageUrl(String backgroundImageUrl) {
		this.backgroundImageUrl = backgroundImageUrl;
	}


	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	public String getLinkColor() {
		return linkColor;
	}

	public void setLinkColor(String linkColor) {
		this.linkColor = linkColor;
	}


	public String getProfileBannerUrl() {
		return profileBannerUrl;
	}

	public void setProfileBannerUrl(String profileBannerUrl) {
		this.profileBannerUrl = profileBannerUrl;
	}

	@Override
	public String toString() {
		return "FollowerEntity [followersID=" + followersID + ", id=" + id + ", createdDate=" + createdDate
				+ ", statusesCount=" + statusesCount + ", friendsCount=" + friendsCount + ", followersCount="
				+ followersCount + ", favoritesCount=" + favoritesCount + ", listedCount=" + listedCount + ", language="
				+ language + ", screenName=" + screenName + ", name=" + name + ", url=" + url + ", profileImageUrl="
				+ profileImageUrl + ", description=" + description + ", location=" + location + ", sidebarBorderColor="
				+ sidebarBorderColor + ", sidebarFillColor=" + sidebarFillColor + ", backgroundColor=" + backgroundColor
				+ ", backgroundImageUrl=" + backgroundImageUrl + ", textColor=" + textColor + ", linkColor=" + linkColor
				+ ", profileBannerUrl=" + profileBannerUrl + "]";
	}



}
