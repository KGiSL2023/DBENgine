package com.kgisl.dbEngine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client_table")
public class ClientTable {

	@Id
	@Column(name="NUM_CLIENT_ID")
	private int num_client_id;
	
	@Column(name="VCH_IC_NO")
	private String vch_ic_no;
	
	@Column(name="VCH_CLIENT_NAME")
	private String vch_client_name;
	
	public int getNum_client_id() {
		return num_client_id;
	}
	public void setNum_client_id(int num_client_id) {
		this.num_client_id = num_client_id;
	}
	public String getVch_ic_no() {
		return vch_ic_no;
	}
	public void setVch_ic_no(String vch_ic_no) {
		this.vch_ic_no = vch_ic_no;
	}
	public String getVch_client_name() {
		return vch_client_name;
	}
	public void setVch_client_name(String vch_client_name) {
		this.vch_client_name = vch_client_name;
	}

	
}
