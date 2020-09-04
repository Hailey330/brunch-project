package com.project.brunch.domain.post;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int userId;
	private String title;
	private String subTitle;

	@Lob
	private String content; // 내용
	@Lob
	private String coverImg; // 메인에 뿌려질 img 1개만 넣은거
	private String postType; // 메거진, 에세이
	private int readCount;
	@CreationTimestamp
	private Timestamp createDate;
}
