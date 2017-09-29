package com.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sa_user_verify")
public class SaUserVerify {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "token")
	private String token;

	@Enumerated(EnumType.STRING)
	private SaUserVerifyStatus status;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String value) {
		userId = value;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String value) {
		token = value;
	}

	public SaUserVerifyStatus getStatus() {
		return status;
	}

	public void setStatus(SaUserVerifyStatus value) {
		status = value;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "{SaUserVerify [id=" + id + ", userId=" + userId + ", token=" + token + ", status=" + status + "]}";
	}
	
	public static String toString(List<SaUserVerify> list) {
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (SaUserVerify saUserVerify : list) {
			sb.append(count+++". ");
			sb.append(saUserVerify.toString()+"\n");
		}
		return sb.toString();
		
	}
}
