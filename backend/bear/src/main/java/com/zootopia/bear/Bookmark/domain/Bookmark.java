package com.zootopia.bear.Bookmark.domain;


import com.zootopia.bear.Beer.domain.Beer;
import com.zootopia.bear.User.domain.User;

import javax.persistence.*;

@Entity
public class Bookmark {
    @EmbeddedId
    private BookmarkId bookmarkId;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @MapsId("beerId")
    @ManyToOne
    @JoinColumn(name = "beer_id")
    private Beer beer;

}
