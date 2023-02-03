package ht.nahum.freshvotes.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Comment {
	
	@Column(length = 5000)
	private String text;
	
	@EmbeddedId
	private CommentId pk;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public CommentId getPk() {
		return pk;
	}
	
	public void setPk(CommentId pk) {
		this.pk = pk;
	}
	
}
