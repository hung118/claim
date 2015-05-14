package com.mitchell.claim.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;

/**
 * LossInfoType entity class.
 * 
 * @author hnguyen
 *
 */
@Entity
@Table(name="LOSS_INFO_TYPE")
@XmlRootElement
public class LossInfoType extends BaseEntityAbstract {
	private static final long serialVersionUID = 1L;

	@GenericGenerator(name = "generator_lit", strategy = "foreign", parameters = @Parameter(name = "property", value = "claim"))
	@Id
	@GeneratedValue(generator = "generator_lit")
	@Column(name = "CLAIM_ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name="CAUSE_OF_LOSS_CODE")
	private String causeOfLossCode;
	
	@Column(name="REPORTED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reportedDate;
	
	@Column(name="LOSS_DESCRIPTION")
	private String lossDescription;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Claim claim;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCauseOfLossCode() {
		return causeOfLossCode;
	}

	public void setCauseOfLossCode(String causeOfLossCode) {
		this.causeOfLossCode = causeOfLossCode;
	}

	public Date getReportedDate() {
		return reportedDate;
	}

	public void setReportedDate(Date reportedDate) {
		this.reportedDate = reportedDate;
	}

	public String getLossDescription() {
		return lossDescription;
	}

	public void setLossDescription(String lossDescription) {
		this.lossDescription = lossDescription;
	}

	@XmlTransient
	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}
}
