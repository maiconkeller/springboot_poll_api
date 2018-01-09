package com.luxfacta.poll.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel( value = "PollOptionStatsDto", description = "PollOption statistics resource representation" )
public class PollOptionStatsResponseDto {

	@JsonProperty("option_id")
	@ApiModelProperty(name = "option_id", value = "Option's id", required = true )
	private Long id;
	
	@JsonProperty("qty")
	@ApiModelProperty(name = "qty", value = "Option's votes", required = true )
	private Long votes;
	
	public PollOptionStatsResponseDto() { }

	public PollOptionStatsResponseDto(Long id, Long votes) {
		this.id = id;
		this.votes = votes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVotes() {
		return votes;
	}

	public void setVotes(Long votes) {
		this.votes = votes;
	}
	
}
