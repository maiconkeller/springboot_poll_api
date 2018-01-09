package com.luxfacta.poll.dto;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel( value = "PollDto", description = "Poll resource representation" )
public class PollNewRequestDto {
	
	@JsonProperty("poll_description")
	@ApiModelProperty( value = "Poll's description", required = true )
	@NotEmpty(message="Description is required")
	private String description;
	
	@ApiModelProperty( value = "Poll's options", required = true )
	@NotNull(message="Options is required")
	private Set<String> options;

	public PollNewRequestDto() { }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<String> getOptions() {
		return options;
	}

	public void setOptions(Set<String> options) {
		this.options = options;
	}
}
