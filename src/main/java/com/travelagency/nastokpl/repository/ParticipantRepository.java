package com.travelagency.nastokpl.repository;

import com.travelagency.nastokpl.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
@ResponseBody
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
}
