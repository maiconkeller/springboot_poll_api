package com.luxfacta.poll.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel( value = "VoteDto", description = "Vote resource representation" )
public class VoteRequestDto {
	
	@JsonProperty("option_id")
	@ApiModelProperty( value = "Option's id", required = true )
	private Long id;

	public VoteRequestDto() { }

	public VoteRequestDto(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}

