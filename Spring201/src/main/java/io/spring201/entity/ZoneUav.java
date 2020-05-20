package io.spring201.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author M1046129
 *
 */
@Entity
@Table(name = "zone_unit_value")
public class ZoneUav implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int Id;

	@OneToOne
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private PropertyType category;

	@OneToOne
	@JoinColumn(name = "status_id", referencedColumnName = "status_id")
	private PropertyStatus status;

	@OneToOne
	@JoinColumn(name = "zone_id", referencedColumnName = "zone_Id")
	private PropertyZone zone;

	@Column(name = "uav")
	private double zoneValue;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public PropertyType getCategory() {
		return category;
	}

	public void setCategory(PropertyType category) {
		this.category = category;
	}

	public PropertyStatus getStatus() {
		return status;
	}

	public void setStatus(PropertyStatus status) {
		this.status = status;
	}

	public PropertyZone getZone() {
		return zone;
	}

	public void setZone(PropertyZone zone) {
		this.zone = zone;
	}

	public double getZoneValue() {
		return zoneValue;
	}

	public void setZoneValue(double zoneValue) {
		this.zoneValue = zoneValue;
	}

}
