package com.kgisl.dbEngine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="coverage_table")
public class CoverageTable {

	@Id
	@Column(name="NUM_SUB_CLASS_COVER_ID")
	private int num_sub_class_cover_id;
	
	@Column(name="VCH_COVER_CODE")
	private String vch_cover_code;
	
	@Column(name="VCH_COVER_NAME")
	private String vch_cover_name;
	
	public int getNum_sub_class_cover_id() {
		return num_sub_class_cover_id;
	}
	public void setNum_sub_class_cover_id(int num_sub_class_cover_id) {
		this.num_sub_class_cover_id = num_sub_class_cover_id;
	}
	public String getVch_cover_code() {
		return vch_cover_code;
	}
	public void setVch_cover_code(String vch_cover_code) {
		this.vch_cover_code = vch_cover_code;
	}
	public String getVch_cover_name() {
		return vch_cover_name;
	}
	public void setVch_cover_name(String vch_cover_name) {
		this.vch_cover_name = vch_cover_name;
	}

	

}
