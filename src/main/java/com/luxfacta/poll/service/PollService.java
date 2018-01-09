package com.luxfacta.poll.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxfacta.poll.dto.PollOptionResponseDto;
import com.luxfacta.poll.dto.PollResponseDto;
import com.luxfacta.poll.model.Poll;
import com.luxfacta.poll.repository.PollRepository;

@Service
public class PollService {

	@Autowired
	private PollRepository pollRepository;
	
	/**
	 * Este método é responsável por procurar um Poll por ID
	 * 
	 * @param java.lang.Long
	 * @param java.lang.Long
	 * @return com.luxfacta.poll.model.Poll
	 * @throws Exception 
	 */
	public Poll findById(Long id, boolean incrementViews) throws Exception {
		if (incrementViews) {
			int updated = pollRepository.updatePollView(id);
			if (updated <= 0) { 
				throw new Exception();
			}
		}
		return pollRepository.findOne(id);
	}

	/**
	 * Este método é responsável por salvar uma entidade Poll
	 * 
	 * @param com.luxfacta.poll.model.Poll
	 */
	public void save(Poll poll) {
		pollRepository.save(poll);
	}

	/**
	 * Este método retorna um DTO com base numa entidade de Poll
	 * 
	 * @param com.luxfacta.poll.model.Poll
	 * @return com.luxfacta.poll.dto.PollResponseDto
	 */
	public PollResponseDto PollToPollResponseDto(Poll poll) {
		// criando dto
		PollResponseDto dto = new PollResponseDto();
		
		// setando id		
		dto.setId(poll.getId());
		
		// setando descrição
		dto.setDescription(poll.getDescription());
		
		//criando lista de option dto
		List<PollOptionResponseDto> optDto = new ArrayList<PollOptionResponseDto>();
		
		// populando a lista de option no dto
		poll.getOptions().forEach(opt -> optDto.add(new PollOptionResponseDto(opt.getId(), opt.getDescription())));
		
		// setando option dto
		dto.setOptions(optDto);
		
		// retorno do dto preenchido
		return dto;
	}

}
