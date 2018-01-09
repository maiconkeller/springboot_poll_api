package com.luxfacta.poll.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="poll")
public class Poll implements Serializable {
	
	private static final long serialVersionUID = 8958346286740381952L;

	@Id 
	@Column(name="poll_id", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="poll_description", nullable=false)
	private String description;
	
	@Column(name="poll_views", nullable=false)
	private Long views;
	
	@Column(name="poll_created_at", nullable=false)
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date createdAt;
	
	@Column(name="poll_updated_at", nullable=false)
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date updatedAt;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
	@JoinColumn(name="poll_id")
	private List<PollOption> options;

	public Poll() { }

	public Poll(String description, List<PollOption> options) {
		this.description = description;
		this.options = options;
	}
	
	@PrePersist
	public void prePersist() {
		Date date = Calendar.getInstance().getTime();
		this.createdAt = date;
		this.updatedAt = date;
	}
	
	@PreUpdate
	public void preUpdate() {
		this.updatedAt = Calendar.getInstance().getTime();
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

	public Long getViews() {
		return views;
	}

	public void setViews(Long views) {
		this.views = views;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<PollOption> getOptions() {
		return options;
	}

	public void setOptions(List<PollOption> options) {
		this.options = options;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((options == null) ? 0 : options.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + ((views == null) ? 0 : views.hashCode());
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
		Poll other = (Poll) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
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
		if (options == null) {
			if (other.options != null)
				return false;
		} else if (!options.equals(other.options))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (views == null) {
			if (other.views != null)
				return false;
		} else if (!views.equals(other.views))
			return false;
		return true;
	}

}
