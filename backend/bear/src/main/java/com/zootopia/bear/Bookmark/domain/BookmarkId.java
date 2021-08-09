package com.zootopia.bear.Bookmark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.io.Serializable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class BookmarkId implements Serializable {

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "beer_id")
    private int beerId;
}
