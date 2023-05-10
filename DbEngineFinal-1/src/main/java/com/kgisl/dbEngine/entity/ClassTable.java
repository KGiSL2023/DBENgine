package com.kgisl.dbEngine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "class_table")
public class ClassTable {

	@Id
	@Column(name="NUM_CLASS_ID")
	private int num_class_id;
	
	@Column(name="VCH_CLASS_CODE")
	private int vch_class_code;
	
	@Column(name="VCH_CLASS_NAME")
	private String vch_class_name;
	
	public int getNum_class_id() {
		return num_class_id;
	}
	public void setNum_class_id(int num_class_id) {
		this.num_class_id = num_class_id;
	}
	public int getVch_class_code() {
		return vch_class_code;
	}
	public void setVch_class_code(int vch_class_code) {
		this.vch_class_code = vch_class_code;
	}
	public String getVch_class_name() {
		return vch_class_name;
	}
	public void setVch_class_name(String vch_class_name) {
		this.vch_class_name = vch_class_name;
	}

	

}
