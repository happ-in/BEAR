package com.zootopia.bear.User.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "USER")
public class User {
    @Id
    @Column(name = "user_id")
    private long userId;
    @Column(name = "custom_id")
    private String customId;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "sex")
    private String sex;
    @Column(name = "user_image")
    private String userImage;
    @Column(name = "share_count")
    private long shareCount;

}
