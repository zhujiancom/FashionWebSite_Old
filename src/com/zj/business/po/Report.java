package com.zj.business.po;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.zj.bigdefine.GlobalParam;
import com.zj.common.annotation.JsonData;
import com.zj.core.po.AbstractEntity;
@Entity
@Table(name="BUS_REPORT" , catalog = GlobalParam.CATALOG_DB)
@SequenceGenerator(name="commSEQ" , catalog=GlobalParam.CATALOG_DB ,allocationSize=1,initialValue=1)
public class Report extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -98381480647776861L;

	private long reportid;
	private String reportCname;
	private String reportEname;
	private String reportimg;
	private String interviewer;
	private Date reportdate;
	private String reportCcontent;
	private String reportEcontent;
	private Designer designer;
	
	private Blob detailContentCH;
	private Blob detailContentEN;
	
	private String previewCH;
	private String previewEN;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator = "commSEQ")
	@Column(name="REPORT_ID", nullable=false)
	@JsonData(type=GlobalParam.JSONTYPE_ID)
	public long getReportid() {
		return reportid;
	}
	public void setReportid(long reportid) {
		this.reportid = reportid;
	}
	
	@Column(name="REPORTCNAME",length=50)
	@JsonData
	public String getReportCname() {
		return reportCname;
	}
	public void setReportCname(String reportCname) {
		this.reportCname = reportCname;
	}
	
	@Column(name="REPORTENAME",length=50)
	@JsonData
	public String getReportEname() {
		return reportEname;
	}
	public void setReportEname(String reportEname) {
		this.reportEname = reportEname;
	}
	
	@Column(name="IMGS",length=2000)
	public String getReportimg() {
		return reportimg;
	}
	public void setReportimg(String reportimg) {
		this.reportimg = reportimg;
	}
	
	@Column(name="INTERVIEWER",length=50)
	@JsonData
	public String getInterviewer() {
		return interviewer;
	}
	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}
	
	@Column(name="REPORTDATE")
	@Temporal(TemporalType.DATE)
	@JsonData
	public Date getReportdate() {
		return reportdate;
	}
	public void setReportdate(Date reportdate) {
		this.reportdate = reportdate;
	}
	
	@Column(name="CCONTENT",length=1000)
	public String getReportCcontent() {
		return reportCcontent;
	}
	public void setReportCcontent(String reportCcontent) {
		this.reportCcontent = reportCcontent;
	}
	
	@Column(name="ECONTENT",length=1000)
	public String getReportEcontent() {
		return reportEcontent;
	}
	public void setReportEcontent(String reportEcontent) {
		this.reportEcontent = reportEcontent;
	}
	@ManyToOne(optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "DESIGNER_ID",referencedColumnName="DESIGNER_ID")
	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public Designer getDesigner() {
		return designer;
	}
	public void setDesigner(Designer designer) {
		this.designer = designer;
	}
	
	@Lob
	@Basic(fetch = FetchType.LAZY) 
	@Column(name="DETAIL_CONTENT_CH", columnDefinition="blob")
	public Blob getDetailContentCH() {
		return detailContentCH;
	}
	public void setDetailContentCH(Blob detailContentCH) {
		this.detailContentCH = detailContentCH;
	}
	@Lob
	@Basic(fetch = FetchType.LAZY) 
	@Column(name="DETAIL_CONTENT_EN", columnDefinition="blob")
	public Blob getDetailContentEN() {
		return detailContentEN;
	}
	public void setDetailContentEN(Blob detailContentEN) {
		this.detailContentEN = detailContentEN;
	}
	@Column(name="PREVIEW_CH",length=500)
	public String getPreviewCH() {
		return previewCH;
	}
	public void setPreviewCH(String previewCH) {
		this.previewCH = previewCH;
	}
	@Column(name="PREVIEW_EN",length=500)
	public String getPreviewEN() {
		return previewEN;
	}
	public void setPreviewEN(String previewEN) {
		this.previewEN = previewEN;
	}
}
