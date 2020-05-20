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
@Table(name = "property_type")
public class PropertyType implements Serializable {

	public PropertyType(int propertyId) {
		super();
		this.propertyId = propertyId;
		if (propertyId == 1) {
			this.propertyDescription = "RCC buildings";
		} else if (propertyId == 2) {
			this.propertyDescription = "RCC buildings with cement or red-oxide flooring";
		} else if (propertyId == 3) {
			this.propertyDescription = "Tiled/Sheet of all kind";
		}
	}

	public PropertyType() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "category_id")
	private int propertyId;

	@Column(name = "prop_desc", nullable = false)
	private String propertyDescription;

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyDescription() {
		return propertyDescription;
	}

	public void setPropertyDescription(String propertyDescription) {
		this.propertyDescription = propertyDescription;
	}

	@Override
	public String toString() {
		return "PropertyType [propertyId=" + propertyId + ", propertyDescription=" + propertyDescription + "]";
	}

}
