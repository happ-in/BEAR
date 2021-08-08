package com.zootopia.bear.Follow.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private Long follow_id;
    public Follow(Long user_id,Long follow_id){
        this.user_id = user_id;
        this.follow_id = follow_id;
    }
}
