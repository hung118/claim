package com.mitchell.claim.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;

/**
 * Vehicle entity class.
 * @author hnguyen
 */
@Entity
@Table(name="VEHICLE_INFO")
@XmlRootElement
public class VehicleInfo extends BaseEntityAbstract {
	private static final long serialVersionUID = 1L;

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "claim"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CLAIM_ID", unique = true, nullable = false)
    private Long id;

    @Column(name="MODEL_YEAR")
    private Integer modelYear;

    @Column(name="MAKE_DESCRIPTION")
    private String makeDescription;

    @Column(name="MODEL_DESCRIPTION")
    private String modelDescription;

    @Column(name="ENGINE_DESCRIPTION")
    private String engineDescription;

    @Column(name="EXTERIOR_COLOR")
    private String exteriorColor;

    @Column(name="VIN")
    private String vin;

    @Column(name="LIC_PLATE")
    private String licPlate;

    @Column(name="LIC_PLATE_STATE")
    private String licPlateState;

    @Column(name="LIC_PLATE_EXPIRATION")
    private Date licPlateExpiration;

    @Column(name="DAMAGE_DESCRIPTION")
    private String damageDescription;

    @Column(name="MILEAGE")
    private Long mileage;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Claim claim;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getModelYear() {
        return modelYear;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }

    public String getMakeDescription() {
        return makeDescription;
    }

    public void setMakeDescription(String makeDescription) {
        this.makeDescription = makeDescription;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
    }

    public String getEngineDescription() {
        return engineDescription;
    }

    public void setEngineDescription(String engineDescription) {
        this.engineDescription = engineDescription;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLicPlate() {
        return licPlate;
    }

    public void setLicPlate(String licPlate) {
        this.licPlate = licPlate;
    }

    public String getLicPlateState() {
        return licPlateState;
    }

    public void setLicPlateState(String licPlateState) {
        this.licPlateState = licPlateState;
    }

    public Date getLicPlateExpiration() {
        return licPlateExpiration;
    }

    public void setLicPlateExpiration(Date licPlateExpiration) {
        this.licPlateExpiration = licPlateExpiration;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    @XmlTransient
    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }
}
