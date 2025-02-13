package com.sy.review.domain.actor;

import com.sy.review.domain.drama.DramaActor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Long, Actor> {
}
