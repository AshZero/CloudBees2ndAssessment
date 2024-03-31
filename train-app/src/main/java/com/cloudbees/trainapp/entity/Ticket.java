package com.cloudbees.trainapp.entity;

public class Ticket {
	private Long userId;
	private String from;
	private String to;
	private User user;
	private double pricePaid;

	public Ticket(Long userId, String from, String to, User user, double pricePaid) {
		super();
		this.userId = userId;
		this.from = from;
		this.to = to;
		this.user = user;
		this.pricePaid = pricePaid;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getPricePaid() {
		return pricePaid;
	}

	public void setPricePaid(double pricePaid) {
		this.pricePaid = pricePaid;
	}

}
