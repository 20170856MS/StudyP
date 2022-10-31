package com.iu.home.List;

import lombok.Data;

@Data
public class ListVO {
	private Long num;
	private String title;
	private String writer;
	private String contents;
	private Long hit;
	private Data regDate;
	private Long ref;
	private Long step;
	private Long depth;
}
