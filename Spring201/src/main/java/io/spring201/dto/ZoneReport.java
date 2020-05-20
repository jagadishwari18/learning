/**
 * 
 */
package io.spring201.dto;

/**
 * @author M1046129
 *
 */
public class ZoneReport {

	private int ZoneId;

	private int statusId;

	private Double zoneAmount;

	public int getZoneId() {
		return ZoneId;
	}

	public void setZoneId(int zoneId) {
		ZoneId = zoneId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Double getZoneAmount() {
		return zoneAmount;
	}

	public void setZoneAmount(Double zoneAmount) {
		this.zoneAmount = zoneAmount;
	}

}
