package com.mitchell.claim.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;

/**
 * Claim entity class.
 * @author hnguyen
 */

@Entity
@Table(name="CLAIM")
@Inheritance(strategy=InheritanceType.JOINED)
@XmlRootElement
public class Claim extends BaseEntityAbstract {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MC_SEQ")
    @SequenceGenerator(name="MC_SEQ", sequenceName="MC_SEQ", allocationSize=1)
    private Long id;

    @Column(name="CLAIM_NUMBER")
    private String claimNumber;

    @Column(name="CLAIMANT_FIRST_NAME")
    private String claimantFirstName;

    @Column(name="CLAIMANT_LAST_NAME")
    private String claimantLastName;

    @Column(name="STATUS_CODE")
    private String statusCode;

    @Column(name="LOSS_DATE")
    private Date lossDate;

    @Column(name="ASSIGNED_ADJUSTERID")
    private String assignedAdjusterId;

    @OneToOne(mappedBy="claim", cascade=CascadeType.ALL)
    private LossInfoType lossInfoType;
 
    @OneToOne(mappedBy="claim", cascade=CascadeType.ALL)
    private VehicleInfo vehicleInfo;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getClaimantFirstName() {
        return claimantFirstName;
    }

    public void setClaimantFirstName(String claimantFirstName) {
        this.claimantFirstName = claimantFirstName;
    }

    public String getClaimantLastName() {
        return claimantLastName;
    }

    public void setClaimantLastName(String claimantLastName) {
        this.claimantLastName = claimantLastName;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Date getLossDate() {
        return lossDate;
    }

    public void setLossDate(Date lossDate) {
        this.lossDate = lossDate;
    }

    public String getAssignedAdjusterId() {
        return assignedAdjusterId;
    }

    public void setAssignedAdjusterId(String assignedAdjusterId) {
        this.assignedAdjusterId = assignedAdjusterId;
    }

    public LossInfoType getLossInfoType() {
        return lossInfoType;
    }

    public void setLossInfoType(LossInfoType lossInfoType) {
        this.lossInfoType = lossInfoType;
    }

    public VehicleInfo getVehicleInfo() {
        return vehicleInfo;
    }

    public void setVehicleInfo(VehicleInfo vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }
}
