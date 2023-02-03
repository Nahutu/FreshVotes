package ht.nahum.freshvotes.domain;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class CommentId implements Serializable {
	
	private static final long serialVersionUID = 7846971547516668977L;
	@ManyToOne
	private User user;
	@ManyToOne
	private Feature feature;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Feature getFeature() {
		return feature;
	}
	public void setFeature(Feature feature) {
		this.feature = feature;
	}
	
	

}
