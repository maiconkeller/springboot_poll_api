package com.luxfacta.poll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxfacta.poll.model.PollOption;
import com.luxfacta.poll.repository.PollOptionRepository;

@Service
public class PollOptionService {

	@Autowired
	private PollOptionRepository pollOptionRepository;
	
	/**
	 * Este método é responsável por procurar um PollOption por ID
	 * 
	 * @param java.lang.Long
	 * @return com.luxfacta.poll.model.PollOption
	 */
	public PollOption findById(Long id) {
		return pollOptionRepository.findOne(id);
	}

	public void saveVote(Long pollId, Long optionId) throws Exception {
		int updated = pollOptionRepository.updatePollView(pollId, optionId);
		if (updated <= 0) { 
			throw new Exception();
		}
	}

}
