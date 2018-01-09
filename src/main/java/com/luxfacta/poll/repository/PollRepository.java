package com.luxfacta.poll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.luxfacta.poll.model.Poll;

public interface PollRepository extends JpaRepository<Poll, Long> {
	
	@Modifying
	@Transactional
	@Query("UPDATE Poll p SET p.views = p.views+1 WHERE p.id=:id")
	int updatePollView(@Param("id") Long id);

}
