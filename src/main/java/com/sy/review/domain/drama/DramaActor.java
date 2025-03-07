package com.sy.review.domain.drama;

import com.sy.review.domain.BaseEntity;
import com.sy.review.domain.actor.Actor;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(
        name = "drama_actor",
        uniqueConstraints = {
                @UniqueConstraint(name = "drama_actor_idx_1", columnNames = {"drama_id", "actor_id"})
        }
)
public class DramaActor extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dramaActorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drama_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Drama drama;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Actor actor;
}
