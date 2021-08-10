package com.zootopia.bear.Bookmark.repository;

import com.zootopia.bear.Bookmark.domain.Bookmark;
import com.zootopia.bear.Bookmark.domain.BookmarkId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, BookmarkId> {
}
