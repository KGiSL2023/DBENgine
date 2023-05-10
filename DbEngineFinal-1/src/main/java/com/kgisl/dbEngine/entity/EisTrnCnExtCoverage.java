package com.kgisl.dbEngine.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EIS_TRN_CN_EXT_COVERAGE")
public class EisTrnCnExtCoverage {

	@Id
	@Column(name="NUM_CN_EXT_COVERAGE_ID")
	private int  num_cn_ext_coverage_id;
	
	@Column(name="NUM_COVER_NOTE_ID")
	private int  num_cover_note_id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="NUM_EXT_COVERAGE_ID")
	private ExtraCoverageTable extracoverage;
	
	public ExtraCoverageTable getExtracoverage() {
		return extracoverage;
	}
	public void setExtracoverage(ExtraCoverageTable extracoverage) {
		this.extracoverage = extracoverage;
	}
	@Column(name="NUM_EXT_SUM_INSURED")
	private float  num_ext_sum_insured;
	
	@Column(name="NUM_RATE")
	private float  num_rate;
	
	@Column(name="NUM_PREMIUM")
	private float  num_premium;
	
	public int getNum_cn_ext_coverage_id() {
		return num_cn_ext_coverage_id;
	}
	public void setNum_cn_ext_coverage_id(int num_cn_ext_coverage_id) {
		this.num_cn_ext_coverage_id = num_cn_ext_coverage_id;
	}
	public int getNum_cover_note_id() {
		return num_cover_note_id;
	}
	public void setNum_cover_note_id(int num_cover_note_id) {
		this.num_cover_note_id = num_cover_note_id;
	}
	public float getNum_ext_sum_insured() {
		return num_ext_sum_insured;
	}
	public void setNum_ext_sum_insured(float num_ext_sum_insured) {
		this.num_ext_sum_insured = num_ext_sum_insured;
	}
	public float getNum_rate() {
		return num_rate;
	}
	public void setNum_rate(float num_rate) {
		this.num_rate = num_rate;
	}
	public float getNum_premium() {
		return num_premium;
	}
	public void setNum_premium(float num_premium) {
		this.num_premium = num_premium;
	}

	
}
