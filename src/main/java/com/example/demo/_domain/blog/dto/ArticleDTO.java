package com.example.demo._domain.blog.dto;

import com.example.demo._domain.blog.entity.Article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
// 즉, 주로 계층간에 데이터 전송 목적으로 설계 된다.
public class ArticleDTO {

	private String title;
	private String content;
	
	public Article toEntity() {
		return Article.builder()
				.title(this.title)
				.content(this.content)
				.build();
	}
}
