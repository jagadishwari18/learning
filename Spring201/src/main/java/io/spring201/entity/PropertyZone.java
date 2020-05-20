package io.spring201.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author M1046129
 *
 */
@Entity
@Table(name = "property_zone")
@NamedQuery(name = "getZoneIdAndName", query = "from PropertyZone")
public class PropertyZone implements Serializable {

	public PropertyZone(int zoneId) {
		this.zoneId = zoneId;
		this.zoneName = "Zone " + (char) (64 + zoneId);
	}

	public PropertyZone() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "zone_Id")
	private int zoneId;

	@Column(name = "zone_name", nullable = false)
	private String zoneName;

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	public int getZoneId() {
		return zoneId;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	@Override
	public String toString() {
		return "PropertyZone [zoneId=" + zoneId + ", zoneName=" + zoneName + "]";
	}

}
