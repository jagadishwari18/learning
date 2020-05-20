package io.spring201.service;

import java.sql.SQLException;
import java.util.List;

import io.spring201.dto.ZoneReport;
import io.spring201.entity.PropertyDetails;
import io.spring201.entity.PropertyTax;
import io.spring201.entity.PropertyZone;

/**
 * @author M1046129
 *
 */
public interface TaxService {
	List<PropertyZone> getAllZones() throws SQLException, Exception;

	/**
	 * @param propDetails
	 * @param propTax
	 * @return
	 */
	void getPropertyDetails(PropertyDetails propDetails, PropertyTax propTax) throws SQLException, Exception;

	/**
	 * @param zone
	 * @param status
	 * @param propertyType
	 * @param buildArea
	 * @param yearOfAssessment
	 * @param buildYear
	 * @return
	 */
	double computeTax(int zone, int status, int propertyType, double buildArea, int yearOfAssessment, int buildYear)
			throws SQLException, Exception;

	public List<ZoneReport> getZoneReports() throws SQLException, Exception;
}
