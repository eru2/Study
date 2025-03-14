package com.kh.board.model.vo;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Reply {

	private int replyNo;
	private String replyContent;
	private int refBno;
	private int replyWriter;
	private String createDate;
	private Date status;

	private String userId;
}
