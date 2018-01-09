package com.luxfacta.poll.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel( value = "PollDto", description = "Poll resource representation" )
public class PollNewResponseDto {
	
	@JsonProperty("poll_id")
	@ApiModelProperty( value = "Poll's id", required = true )
	private Long id;

	public PollNewResponseDto() { }

	public PollNewResponseDto(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
