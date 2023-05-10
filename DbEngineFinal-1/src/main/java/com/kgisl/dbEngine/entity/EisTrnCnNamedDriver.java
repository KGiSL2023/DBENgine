package com.kgisl.dbEngine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EIS_TRN_CN_NAMED_DRIVER")
public class EisTrnCnNamedDriver { 

	@Id
	@Column(name="NUM_CN_NAMED_DRIVER_ID")
	private int  num_cn_named_drive_id;
	
	@Column(name="NUM_COVER_NOTE_ID")
	private int  num_cover_note_id;
	
	@Column(name="VCH_IC_NO")
	private String  vch_ic_no;
	
	@Column(name="VCH_DRIVER_NAME")
	private String  vch_driver_name;
	
	@Column(name="VCH_DRIVER_AGE")
	private int  vch_driver_age;
	
	@Column(name="NUM_DRIVING_EXPERIENCE")
	private int  num_driving_experience;
	
	public int getNum_cn_named_drive_id() {
		return num_cn_named_drive_id;
	}
	public void setNum_cn_named_drive_id(int num_cn_named_drive_id) {
		this.num_cn_named_drive_id = num_cn_named_drive_id;
	}
	public int getNum_cover_note_id() {
		return num_cover_note_id;
	}
	public void setNum_cover_note_id(int num_cover_note_id) {
		this.num_cover_note_id = num_cover_note_id;
	}
	public String getVch_ic_no() {
		return vch_ic_no;
	}
	public void setVch_ic_no(String vch_ic_no) {
		this.vch_ic_no = vch_ic_no;
	}
	public String getVch_driver_name() {
		return vch_driver_name;
	}
	public void setVch_driver_name(String vch_driver_name) {
		this.vch_driver_name = vch_driver_name;
	}
	public int getVch_driver_age() {
		return vch_driver_age;
	}
	public void setVch_driver_age(int vch_driver_age) {
		this.vch_driver_age = vch_driver_age;
	}
	public int getNum_driving_experience() {
		return num_driving_experience;
	}
	public void setNum_driving_experience(int num_driving_experience) {
		this.num_driving_experience = num_driving_experience;
	}

	

}
