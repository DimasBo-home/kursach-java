package com.youpassed.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exam {
	private Integer id;
	private String subject;
	private Date date;
	private String location;

	private boolean isRegistered;
	private int mark;
}
