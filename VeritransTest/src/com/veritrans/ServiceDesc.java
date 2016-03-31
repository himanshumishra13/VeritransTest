package com.veritrans;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class ServiceDesc {

	private int id;
	private String name;
	private String image;
	private String description;
	private boolean branding;
	private float rating;
	private boolean setup_fee;
	private String transaction_fee;
	private String how_to_url;
	private String currencies;
	
	public ServiceDesc(){
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isBranding() {
		return branding;
	}
	public void setBranding(boolean branding) {
		this.branding = branding;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public boolean getSetup_fee() {
		return setup_fee;
	}
	public void setSetup_fee(boolean setup_fee) {
		this.setup_fee = setup_fee;
	}
	public String getHow_to_url() {
		return how_to_url;
	}
	public void setHow_to_url(String how_to_url) {
		this.how_to_url = how_to_url;
	}
	public String getTransaction_fee() {
		return transaction_fee;
	}
	public void setTransaction_fee(String transaction_fee) {
		this.transaction_fee = transaction_fee;
	}
	public String getCurrencies() {
		return currencies;
	}
	public void setCurrencies(String currencies) {
		this.currencies = currencies;
	}
	
}
