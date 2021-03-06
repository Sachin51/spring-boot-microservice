package com.example.demo.model;

import java.util.List;

public class UserRatings {

	private String userId;
	private List<Rating> userRating;
	
	public UserRatings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRatings(String userId, List<Rating> userRating) {
		super();
		this.userId = userId;
		this.userRating = userRating;
	}

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "UserRatings [userRating=" + userRating + "]";
	}
}
