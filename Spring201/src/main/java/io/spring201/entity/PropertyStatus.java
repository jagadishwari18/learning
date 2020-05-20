package io.spring201.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author M1046129
 *
 */
@Entity
@Table(name = "property_status")
public class PropertyStatus implements Serializable {

	public PropertyStatus() {
		super();

	}

	public PropertyStatus(int propertyStatusId) {
		super();
		this.propertyStatusId = propertyStatusId;
		if (propertyStatusId == 1) {
			this.propertyStatus = "Owner";
		} else if (propertyStatusId == 1) {
			this.propertyStatus = "Tenated";
		}

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "status_id")
	private int propertyStatusId;

	@Column(name = "prop_status", nullable = false)
	private String propertyStatus;

	public int getPropertyStatusId() {
		return propertyStatusId;
	}

	public void setPropertyStatusId(int propertyStatusId) {
		this.propertyStatusId = propertyStatusId;
	}

	public String getPropertyStatus() {
		return propertyStatus;
	}

	public void setPropertyStatus(String propertyStatus) {
		this.propertyStatus = propertyStatus;
	}

	@Override
	public String toString() {
		return "PropertyStatus [propertyStatusId=" + propertyStatusId + ", propertyStatus=" + propertyStatus + "]";
	}
}
