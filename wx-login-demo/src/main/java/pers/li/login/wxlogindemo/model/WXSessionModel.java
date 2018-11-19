package pers.li.login.wxlogindemo.model;

import lombok.Data;

@Data
public class WXSessionModel {

	private String session_key;
	private String openid;
	private Integer expires_in;

	
}
