package com.luxfacta.poll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.luxfacta.poll.model.PollOption;

public interface PollOptionRepository extends JpaRepository<PollOption, Long> {
	
	@Modifying
	@Transactional
	@Query("UPDATE PollOption o SET o.votes = o.votes+1 WHERE o.id=:optionid and o.poll.id=:pollid")
	int updatePollView(@Param("pollid") Long pollId, @Param("optionid") Long optionId);

}
