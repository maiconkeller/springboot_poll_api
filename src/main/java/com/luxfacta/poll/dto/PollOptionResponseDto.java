package com.luxfacta.poll.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel( value = "PollOptionDto", description = "Poll Option resource representation" )
public class PollOptionResponseDto {

	@JsonProperty("option_id")
	@ApiModelProperty( value = "PollOption's id", required = true ) 
	private Long id;
	
	@JsonProperty("option_description")
	@ApiModelProperty( value = "PollOption's description", required = true )
	private String description;
	
	public PollOptionResponseDto() { }

	public PollOptionResponseDto(Long id, String description) {
		this.id = id;
		this.description = description;
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
	
	
}
