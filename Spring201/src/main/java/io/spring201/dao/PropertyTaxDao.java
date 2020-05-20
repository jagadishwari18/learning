/**
 * 
 */
package io.spring201.dao;

import java.sql.SQLException;
import java.util.List;

import io.spring201.entity.PropertyDetails;
import io.spring201.entity.PropertyStatus;
import io.spring201.entity.PropertyTax;
import io.spring201.entity.PropertyZone;
/**
 * @author M1046129
 *
 */
public interface PropertyTaxDao {

	public List<PropertyZone> getZoneNames() throws Exception;

	public int savePropertyDetails(PropertyDetails propDetails) throws SQLException;

	public int savePropertyTax(PropertyTax propTax) throws SQLException;

	/**
	 * @param zoneId
	 * @param statusId
	 * @param propertyId
	 */
	public double getUavValue(int zoneId, int statusId, int propertyId);

	public List<PropertyStatus> getPropertyStatus() throws Exception;

	public Double getZoneReport(int statusId, int zoneId) throws Exception;

}
