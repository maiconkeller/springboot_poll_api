package com.luxfacta.poll.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel( value = "PollStatsDto", description = "Poll statistics resource representation" )
public class PollStatsResponseDto {
	
	@JsonProperty("views")
	@ApiModelProperty( value = "Poll's views", required = true )
	private Long views;
	
	@JsonProperty("votes")
	@ApiModelProperty(name="votes", value = "Poll's views", required = true )
	private List<PollOptionStatsResponseDto> options;
	
	public PollStatsResponseDto() { }

	public PollStatsResponseDto(Long views, List<PollOptionStatsResponseDto> options) {
		this.views = views;
		this.options = options;
	}

	public Long getViews() {
		return views;
	}

	public void setViews(Long views) {
		this.views = views;
	}

	public List<PollOptionStatsResponseDto> getOptions() {
		return options;
	}

	public void setOptions(List<PollOptionStatsResponseDto> options) {
		this.options = options;
	}
	
	

}
