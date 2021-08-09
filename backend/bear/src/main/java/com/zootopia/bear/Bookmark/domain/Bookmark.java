package com.zootopia.bear.Bookmark.domain;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Bookmark {
    @EmbeddedId
    private BookmarkId bookmarkId;

}
