package com.sy.review.domain.drama;

import com.sy.review.domain.member.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "drama_review_like",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"drama_review_id", "member_id"})})
public class DramaReviewLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drama_review_id")
    private DramaReview dramaReview;

    @Builder
    public DramaReviewLike(Member member, DramaReview dramaReview) {
        this.member = member;
        this.dramaReview = dramaReview;
    }
}