package com.kgisl.dbEngine.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EIS_TRN_COVER_NOTE")
public class EisTrnCoverNote {

	@Id
	@Column(name = "NUM_COVER_NOTE_ID")
	private int num_cover_note_id;

	@Column(name = "VCH_COVER_NOTE_NO", unique = true)
	private String vch_cover_note_no;

	@Column(name = "DTT_ISSUE_DATE")
	private String dtt_issue_date;

	@Column(name = "DTT_INCEPTION_DATE")
	private String dtt_inception_date;

	@Column(name = "DTT_EXPIRY_DATE")
	private String dtt_expiry_date;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NUM_CLASS_ID")
	private ClassTable clas;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NUM_SUB_CLASS_COVER_ID")
	private CoverageTable coverage;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NUM_CLIENT_ID")
	private ClientTable client;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NUM_AGENT_ID")
	private AgentTable agent;

	@Column(name = "VCH_VEHICLE_NO")
	private String vch_vehicle_no;

	@Column(name = "NUM_SUM_INSURED")
	private int num_sum_insured;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NUM_COVER_NOTE_STATUS_ID")
	private CoverNoteStatusTable status;
	
	@OneToMany(fetch= FetchType.LAZY)
	@JoinColumn(name="NUM_COVER_NOTE_ID")
    private Set<EisTrnCnExtCoverage> extra_coverage;
	
	@OneToMany(fetch= FetchType.LAZY)
	@JoinColumn(name="NUM_COVER_NOTE_ID")
    private Set<EisTrnCnNamedDriver> named_driver;

	public Set<EisTrnCnNamedDriver> getNamed_driver() {
		return named_driver;
	}

	public void setNamed_driver(Set<EisTrnCnNamedDriver> named_driver) {
		this.named_driver = named_driver;
	}

	public Set<EisTrnCnExtCoverage> getExtra_coverage() {
		return extra_coverage;
	}

	public void setExtra_coverage(Set<EisTrnCnExtCoverage> extra_coverage) {
		this.extra_coverage = extra_coverage;
	}

	public int getNum_cover_note_id() {
		return num_cover_note_id;
	}

	public void setNum_cover_note_id(int num_cover_note_id) {
		this.num_cover_note_id = num_cover_note_id;
	}

	public String getVch_cover_note_no() {
		return vch_cover_note_no;
	}

	public void setVch_cover_note_no(String vch_cover_note_no) {
		this.vch_cover_note_no = vch_cover_note_no;
	}

	public String getDtt_issue_date() {
		return dtt_issue_date;
	}

	public void setDtt_issue_date(String dtt_issue_date) {
		this.dtt_issue_date = dtt_issue_date;
	}

	public String getDtt_inception_date() {
		return dtt_inception_date;
	}

	public void setDtt_inception_date(String dtt_inception_date) {
		this.dtt_inception_date = dtt_inception_date;
	}

	public String getDtt_expiry_date() {
		return dtt_expiry_date;
	}

	public void setDtt_expiry_date(String dtt_expiry_date) {
		this.dtt_expiry_date = dtt_expiry_date;
	}

	public String getVch_vehicle_no() {
		return vch_vehicle_no;
	}

	public void setVch_vehicle_no(String vch_vehicle_no) {
		this.vch_vehicle_no = vch_vehicle_no;
	}

	public int getNum_sum_insured() {
		return num_sum_insured;
	}

	public void setNum_sum_insured(int num_sum_insured) {
		this.num_sum_insured = num_sum_insured;
	}

	public ClassTable getClas() {
		return clas;
	}

	public void setClas(ClassTable clas) {
		this.clas = clas;
	}

	public CoverageTable getCoverage() {
		return coverage;
	}

	public void setCoverage(CoverageTable coverage) {
		this.coverage = coverage;
	}

	public ClientTable getClient() {
		return client;
	}

	public void setClient(ClientTable client) {
		this.client = client;
	}

	public AgentTable getAgent() {
		return agent;
	}

	public void setAgent(AgentTable agent) {
		this.agent = agent;
	}

	public CoverNoteStatusTable getStatus() {
		return status;
	}

	public void setStatus(CoverNoteStatusTable status) {
		this.status = status;
	}

}
