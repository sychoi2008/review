package com.sy.review.domain.drama;

import com.sy.review.domain.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DramaReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private Integer rating;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drama_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Drama drama;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Member member;

    @Builder
    public DramaReview(String title, String content, Integer rating, Drama drama, Member member) {
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.drama = drama;
        this.member = member;
    }
}
