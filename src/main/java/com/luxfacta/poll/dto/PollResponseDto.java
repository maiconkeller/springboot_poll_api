package com.luxfacta.poll.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel( value = "PollDto", description = "Poll resource representation" )
public class PollResponseDto {
	
	@JsonProperty("poll_id")
	@ApiModelProperty( value = "Poll's id", required = true )
	private Long id;
	
	@JsonProperty("poll_description")
	@ApiModelProperty( value = "Poll's description", required = true )
	private String description;
	
	@ApiModelProperty( value = "Poll's option list", required = true )
	private List<PollOptionResponseDto> options;
	
	public PollResponseDto() { }

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

	public List<PollOptionResponseDto> getOptions() {
		return options;
	}

	public void setOptions(List<PollOptionResponseDto> options) {
		this.options = options;
	}

}
