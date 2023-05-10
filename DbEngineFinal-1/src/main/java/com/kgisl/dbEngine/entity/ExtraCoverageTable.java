package com.kgisl.dbEngine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "extra_coverage_table")
public class ExtraCoverageTable {

	@Id
	@Column(name="NUM_CN_EXT_COVERAGE_ID")
	private int num_cn_ext_coverage_id;
	
	@Column(name="VCH_EXT_COVER_CODE")
	private String vch_ext_cover_code;
	
	@Column(name="VCH_EXT_COVER_NAME")
	private String vch_ext_cover_name;
	
	@Column(name="VCH_FORMULA_TYPE")
	private String vch_formula_type;
	
	public int getNum_cn_ext_coverage_id() {
		return num_cn_ext_coverage_id;
	}
	public void setNum_cn_ext_coverage_id(int num_cn_ext_coverage_id) {
		this.num_cn_ext_coverage_id = num_cn_ext_coverage_id;
	}
	public String getVch_ext_cover_code() {
		return vch_ext_cover_code;
	}
	public void setVch_ext_cover_code(String vch_ext_cover_code) {
		this.vch_ext_cover_code = vch_ext_cover_code;
	}
	public String getVch_ext_cover_name() {
		return vch_ext_cover_name;
	}
	public void setVch_ext_cover_name(String vch_ext_cover_name) {
		this.vch_ext_cover_name = vch_ext_cover_name;
	}
	public String getVch_formula_type() {
		return vch_formula_type;
	}
	public void setVch_formula_type(String vch_formula_type) {
		this.vch_formula_type = vch_formula_type;
	}

	
}
