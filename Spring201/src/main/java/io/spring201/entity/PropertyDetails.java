/**
 * 
 */
package io.spring201.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author M1046129
 *
 */
@Entity
@Table(name = "property_details")
public class PropertyDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_prop_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int UserPropertyId;

	@Column(name = "owner_name", nullable = false)
	private String ownerName;

	@Column(name = "emailId", nullable = false)
	private String emailId;

	@Column(name = "prop_addr", nullable = false)
	private String propertyAddress;

	@Column(name = "build_year", nullable = false)
	private int propertyBuildYear;

	@Column(name = "build_area", nullable = false)
	private double propertyBuildArea;

	@Column(name = "year_assessment", nullable = false)
	private int yearOfAssesment;

	@ManyToOne
	private PropertyType propertyType;

	@ManyToOne
	private PropertyZone zone;

	@ManyToOne
	private PropertyStatus status;

	public int getUserPropertyId() {
		return UserPropertyId;
	}

	public void setUserPropertyId(int userPropertyId) {
		UserPropertyId = userPropertyId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public int getPropertyBuildYear() {
		return propertyBuildYear;
	}

	public void setPropertyBuildYear(int propertyBuildYear) {
		this.propertyBuildYear = propertyBuildYear;
	}

	public double getPropertyBuildArea() {
		return propertyBuildArea;
	}

	public void setPropertyBuildArea(double propertyBuildArea) {
		this.propertyBuildArea = propertyBuildArea;
	}

	public int getYearOfAssesment() {
		return yearOfAssesment;
	}

	public void setYearOfAssesment(int yearOfAssesment) {
		this.yearOfAssesment = yearOfAssesment;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public PropertyZone getZone() {
		return zone;
	}

	public void setZone(PropertyZone zone) {
		this.zone = zone;
	}

	public PropertyStatus getStatus() {
		return status;
	}

	public void setStatus(PropertyStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PropertyDetails [PropertyId=" + UserPropertyId + ", ownerName=" + ownerName + ", emailId=" + emailId
				+ ", propertyAddress=" + propertyAddress + ", propertyBuildYear=" + propertyBuildYear
				+ ", propertyBuildArea=" + propertyBuildArea + ", yearOfAssesment=" + yearOfAssesment
				+ ", propertyType=" + propertyType + ", zone=" + zone + ", status=" + status + "]";
	}

}
