package com.sy.review.domain.drama;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Drama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dramaId;
}
