package com.sy.review.domain.drama;

import com.sy.review.domain.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DramaReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drama_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Drama drama;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Member member;
}
