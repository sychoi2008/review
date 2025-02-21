package com.sy.review.domain.drama;

import com.sy.review.domain.BaseEntity;
import com.sy.review.domain.member.Member;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@ToString(exclude ={"drama", "member"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DramaReview extends BaseEntity {
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

    @Column(nullable = false)
    private Integer count = 0;

    @Builder
    public DramaReview(Long id, String title, String content, Integer rating, Drama drama, Member member) {
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.drama = drama;
        this.member = member;
        this.id = id;
        this.count = 0;
    }

    public DramaReview update(String content, Integer rating) {
        this.content = content;
        this.rating = rating;
        return this;
    }
}
