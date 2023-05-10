package com.kgisl.dbEngine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agent_table")
public class AgentTable {

	@Id
	@Column(name="NUM_AGENT_ID")
	private int num_agent_id;
	
	@Column(name="VCH_AGENT_CODE")
	private String vch_agent_code;
	
	@Column(name="VCH_AGENT_NAME")
	private String vch_agent_name;
	
	public int getNum_agent_id() {
		return num_agent_id;
	}
	public void setNum_agent_id(int num_agent_id) {
		this.num_agent_id = num_agent_id;
	}
	public String getVch_agent_code() {
		return vch_agent_code;
	}
	public void setVch_agent_code(String vch_agent_code) {
		this.vch_agent_code = vch_agent_code;
	}
	public String getVch_agent_name() {
		return vch_agent_name;
	}
	public void setVch_agent_name(String vch_agent_name) {
		this.vch_agent_name = vch_agent_name;
	}

	
}
