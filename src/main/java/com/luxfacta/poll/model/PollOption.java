package com.luxfacta.poll.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="poll_option")
public class PollOption implements Serializable {

	private static final long serialVersionUID = -162669021207430316L;

	@Id 
	@Column(name="option_id", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="option_description", nullable=false)
	private String description;
	
	@Column(name="option_votes", nullable=false)
	private Long votes;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(nullable=false, name="poll_id")
	private Poll poll;
	
	public PollOption() { }
	
	public PollOption(String description, Poll poll) {
		this.description = description;
		this.poll = poll;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getVotes() {
		return votes;
	}

	public void setVotes(Long votes) {
		this.votes = votes;
	}

	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((poll == null) ? 0 : poll.hashCode());
		result = prime * result + ((votes == null) ? 0 : votes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PollOption other = (PollOption) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (poll == null) {
			if (other.poll != null)
				return false;
		} else if (!poll.equals(other.poll))
			return false;
		if (votes == null) {
			if (other.votes != null)
				return false;
		} else if (!votes.equals(other.votes))
			return false;
		return true;
	}
	
}
