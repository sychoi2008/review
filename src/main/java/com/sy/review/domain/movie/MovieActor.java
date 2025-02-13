package com.sy.review.domain.movie;

import com.sy.review.domain.actor.Actor;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(
        name = "movie_actor",
        uniqueConstraints = {
                @UniqueConstraint(name = "movie_actor_idx_1", columnNames = {"movie_id", "actor_id"})
        }
)
public class MovieActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieActorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id")
    private Actor actor;
}