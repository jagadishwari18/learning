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
@Table(name = "property_tax")
public class PropertyTax implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taxId;

	@ManyToOne
	private PropertyDetails propertyId;

	@ManyToOne
	private PropertyZone zoneId;

	@ManyToOne
	private PropertyStatus statusId;

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public PropertyStatus getStatusId() {
		return statusId;
	}

	public void setStatusId(PropertyStatus statusId) {
		this.statusId = statusId;
	}

	@Column(name = "amount", nullable = false)
	private double taxAmount;

	public PropertyDetails getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(PropertyDetails propertyId) {
		this.propertyId = propertyId;
	}

	public PropertyZone getZoneId() {
		return zoneId;
	}

	public void setZoneId(PropertyZone zoneId) {
		this.zoneId = zoneId;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

}
