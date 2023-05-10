package com.kgisl.dbEngine.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EIS_TRN_COVERNOTE_EXT")
public class EisTrnCoverNoteExt { 

	@Id
	@Column(name = "NUM_COVER_NOTE_EXT_ID")
	private int  num_cover_note_ext_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NUM_COVER_NOTE_ID")
	private EisTrnCoverNote parent;
	
	@Column(name = "CHR_GST_IND")
	private char  chr_gst_ind;
	
	@Column(name = "NUM_GST_PERCENT")
	private String  num_gst_percent ;
	
	@Column(name = "NUM_SERVICE_TAX")
	private String  num_service_tax;
	
	@Column(name = "NUM_COMMISSION_AMT")
	private String  num_commission_amt;
	
	@Column(name = "NUM_REBATE_AMT")
	private String  num_rebate_amt;
	
	@Column(name = "CHR_RISK_IND")
	private char  chr_risk_ind;
	
	public EisTrnCoverNote getParent() {
		return parent;
	}
	public void setParent(EisTrnCoverNote parent) {
		this.parent = parent;
	}
	@Column(name = "VCH_TAX_CODE")
	private String  vch_tax_code;
	
	@Column(name = "VCH_INVOICE_NO")
	private String  vch_invoice_no;
	
	@Column(name = "NUM_GROSS_PREMIUM")
	private String  num_gross_premium;
	
	@Column(name = "NUM_NET_PREMIUM")
	private String  num_net_premium;
	
	public int getNum_cover_note_ext_id() {
		return num_cover_note_ext_id;
	}
	public void setNum_cover_note_ext_id(int num_cover_note_ext_id) {
		this.num_cover_note_ext_id = num_cover_note_ext_id;
	}
	
	
	public char getChr_gst_ind() {
		return chr_gst_ind;
	}
	public void setChr_gst_ind(char chr_gst_ind) {
		this.chr_gst_ind = chr_gst_ind;
	}
	
	public char getChr_risk_ind() {
		return chr_risk_ind;
	}
	public void setChr_risk_ind(char chr_risk_ind) {
		this.chr_risk_ind = chr_risk_ind;
	}
	public String getVch_tax_code() {
		return vch_tax_code;
	}
	public void setVch_tax_code(String vch_tax_code) {
		this.vch_tax_code = vch_tax_code;
	}
	public String getVch_invoice_no() {
		return vch_invoice_no;
	}
	public void setVch_invoice_no(String vch_invoice_no) {
		this.vch_invoice_no = vch_invoice_no;
	}
	public String getNum_gst_percent() {
		return num_gst_percent;
	}
	public void setNum_gst_percent(String num_gst_percent) {
		this.num_gst_percent = num_gst_percent;
	}
	public String getNum_service_tax() {
		return num_service_tax;
	}
	public void setNum_service_tax(String num_service_tax) {
		this.num_service_tax = num_service_tax;
	}
	public String getNum_commission_amt() {
		return num_commission_amt;
	}
	public void setNum_commission_amt(String num_commission_amt) {
		this.num_commission_amt = num_commission_amt;
	}
	public String getNum_rebate_amt() {
		return num_rebate_amt;
	}
	public void setNum_rebate_amt(String num_rebate_amt) {
		this.num_rebate_amt = num_rebate_amt;
	}
	public String getNum_gross_premium() {
		return num_gross_premium;
	}
	public void setNum_gross_premium(String num_gross_premium) {
		this.num_gross_premium = num_gross_premium;
	}
	public String getNum_net_premium() {
		return num_net_premium;
	}
	public void setNum_net_premium(String num_net_premium) {
		this.num_net_premium = num_net_premium;
	}
	

	
}
