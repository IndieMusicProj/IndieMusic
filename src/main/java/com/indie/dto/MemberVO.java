package com.indie.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
	private int mb_num;
	private String mb_id;
	private String mb_pwd;
	private String mb_name;
	private String mb_email;
	private String mb_zipNum;
	private String mb_address;
	private String mb_mobile;
	private Timestamp mb_indate;

}
