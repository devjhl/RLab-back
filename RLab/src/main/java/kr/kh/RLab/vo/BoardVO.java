package kr.kh.RLab.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardVO {
	private int bo_num;
	private int bo_st_num;
	private String bo_title;
	private String bo_content;
	private String bo_me_id;
	private int bo_views;
	private Date bo_reg_date;
	private Date bo_upd_date;
	private String st_name;
	private String me_name;
	
}
