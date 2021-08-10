package com.zootopia.bear.Bookmark.repository;

import com.zootopia.bear.Bookmark.domain.Bookmark;
import com.zootopia.bear.Bookmark.domain.BookmarkId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name="bookmark")
public interface BookmarkRepository extends JpaRepository<Bookmark, BookmarkId> {
}
