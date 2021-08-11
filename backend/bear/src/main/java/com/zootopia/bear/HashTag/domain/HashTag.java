package com.zootopia.bear.HashTag.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HashTag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hashTagId;

	@Column(unique = true)
	private String hashTagName;

	@OneToMany(mappedBy = "hashTag", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ReviewHashTag> reviewHashTags = new ArrayList<>();

	public HashTag(String hashTagName) {
		this.hashTagName = hashTagName;
	}

	public HashTag(int hashTagId, String hashTagName) {
		this.hashTagId = hashTagId;
		this.hashTagName = hashTagName;
	}
}
