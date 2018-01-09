package com.luxfacta.poll.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luxfacta.poll.dto.PollNewRequestDto;
import com.luxfacta.poll.dto.PollNewResponseDto;
import com.luxfacta.poll.dto.PollOptionStatsResponseDto;
import com.luxfacta.poll.dto.PollResponseDto;
import com.luxfacta.poll.dto.PollStatsResponseDto;
import com.luxfacta.poll.dto.VoteRequestDto;
import com.luxfacta.poll.model.Poll;
import com.luxfacta.poll.model.PollOption;
import com.luxfacta.poll.service.PollOptionService;
import com.luxfacta.poll.service.PollService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/poll")
public class PollController {
	
	@Autowired
	private PollService pollService;
	
	@Autowired
	private PollOptionService pollOptionService;

	/**
	 * Método responsável por buscar um Poll por id
	 * 
	 * @param java.lang.Long
	 * @return com.luxfacta.poll.dto.PollResponseDto
	 */
	@GetMapping("{id}")
	public ResponseEntity<PollResponseDto> getPoll(@ApiParam(value="Poll's id", required=true) @PathVariable("id") Long id) {
		Poll poll;
		try {
			
			poll = pollService.findById(id, true);
			if (poll == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(pollService.PollToPollResponseDto(poll));
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

	/**
	 * Método responsável por buscar informações estatísticas
	 * 
	 * @param java.lang.Long
	 * @return com.luxfacta.poll.dto.PollStatsResponseDto
	 */
	@GetMapping("{id}/stats")
	public ResponseEntity<PollStatsResponseDto> getStats(@ApiParam(value="Poll's id", required=true) @PathVariable("id") Long id) {
		Poll poll;
		try {
			poll = pollService.findById(id, false);
			if (poll == null) {
				return ResponseEntity.notFound().build();
			}
			
			PollStatsResponseDto dto = new PollStatsResponseDto();
			dto.setViews(poll.getViews());
			dto.setOptions(new ArrayList<PollOptionStatsResponseDto>());
			poll.getOptions().forEach(o -> dto.getOptions().add(new PollOptionStatsResponseDto(o.getId(), o.getVotes())));
			
			return ResponseEntity.ok(dto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
	
	/**
	 * Este método é responsável por adicionar um novo Poll
	 * 
	 * @param com.luxfacta.poll.dto.pollNewRequestDto
	 * @param com.luxfacta.poll.dto.pollNewResponseDto
	 * @return com.luxfacta.poll.dto.pollNewResponseDto
	 */

	@PostMapping
	public ResponseEntity<PollNewResponseDto> savePoll(
			@Valid @RequestBody
			@ApiParam(name="PollDto", value="New Poll object", required=true)
			PollNewRequestDto pollNewRequestDto, 
			BindingResult result) {
		
		if (result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		Poll poll = new Poll();
		poll.setDescription(pollNewRequestDto.getDescription());

		List<PollOption> options = new ArrayList<PollOption>();
		pollNewRequestDto.getOptions().forEach(opt -> options.add(new PollOption(opt, poll)));
		poll.setOptions(options);
		
		pollService.save(poll);
		
		return ResponseEntity.ok(new PollNewResponseDto(poll.getId()));
	}
	
	/**
	 * Método responsável por efetuar um voto
	 * 
	 * @param id
	 * @param voteDto
	 * @return
	 */
	@PostMapping("{id}/vote")
	public ResponseEntity<Object> saveVote(@ApiParam(value="Poll's id", required=true) @PathVariable("id") Long id, @Valid @RequestBody VoteRequestDto voteDto) {
		try {
			pollOptionService.saveVote(id, voteDto.getId());
			return ResponseEntity.ok(null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Poll or Option not found");
		}
	}
	
}
