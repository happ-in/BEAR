package com.zootopia.bear.User.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private long user_id;
    private String custom_id;
    private String nickname;
    private String sex;
    private String image;
    private long share_count;

}
