package com.kgisl.dbEngine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cover_note_status_table")
public class CoverNoteStatusTable {

	@Id
	@Column(name="NUM_COVER_NOTE_STATUS_ID")
	private int num_cover_note_status_id;
	
	@Column(name="VCH_CN_STATUS_CODE")
	private String vch_cn_status_code;
	
	@Column(name="VCH_CN_STATUS_NAME")
	private String vch_cn_status_name;
	
	public int getNum_cover_note_status_id() {
		return num_cover_note_status_id;
	}
	public void setNum_cover_note_status_id(int num_cover_note_status_id) {
		this.num_cover_note_status_id = num_cover_note_status_id;
	}
	public String getVch_cn_status_code() {
		return vch_cn_status_code;
	}
	public void setVch_cn_status_code(String vch_cn_status_code) {
		this.vch_cn_status_code = vch_cn_status_code;
	}
	public String getVch_cn_status_name() {
		return vch_cn_status_name;
	}
	public void setVch_cn_status_name(String vch_cn_status_name) {
		this.vch_cn_status_name = vch_cn_status_name;
	}

	

}
