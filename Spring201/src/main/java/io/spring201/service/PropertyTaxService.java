package io.spring201.service;

import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.spring201.controller.PropertyTaxController;
import io.spring201.dao.PropertyTaxDao;
import io.spring201.dto.ZoneReport;
import io.spring201.entity.PropertyDetails;
import io.spring201.entity.PropertyStatus;
import io.spring201.entity.PropertyTax;
import io.spring201.entity.PropertyZone;

/**
 * @author M1046129
 *
 */
@Service
@Transactional
public class PropertyTaxService implements TaxService {

	private static final Logger LOGGER = Logger.getLogger(PropertyTaxController.class);

	@Autowired
	private PropertyTaxDao dao;

	public List<PropertyZone> getAllZones() throws Exception {

		LOGGER.info("Inside getAllZones service method");

		List<PropertyZone> zones = this.dao.getZoneNames();

		if (zones == null) {

			throw new Exception();
		}
		return zones;

	}

	public double computeTax(int zoneId, int statusId, int propertyId, double buildArea, int yearOfAssessment,
			int buildYear) throws SQLException, Exception {

		LOGGER.info("Inside computeTax service method");

		double uav = 0;
		double total_5 = 0;
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.CEILING);

		double depreciation = (yearOfAssessment - buildYear) >= 60 ? 60 : (yearOfAssessment - buildYear);

		LOGGER.info("Inside getPropertyDetails service method try block");
		uav = dao.getUavValue(zoneId, statusId, propertyId);
		LOGGER.info("Inside getPropertyDetails service method try block   uav value" + uav);
		double total_1 = (buildArea * uav * 10) / 12;
		double total_2 = total_1 - ((total_1 * depreciation) / 100);
		double total_3 = total_2 * 0.2;
		double total_4 = total_3 * 0.24;
		total_5 = total_3 + total_4;
		LOGGER.info("total_1" + total_1 + "\"total_2\"+ " + total_2 + " \"total_3\"+ " + total_3 + " \"total_4\"+ "
				+ total_4 + " \"total_\5" + total_5);

		return Double.parseDouble(df.format(total_5));

	}

	public List<ZoneReport> getZoneReports() throws SQLException, Exception {

		LOGGER.info("Inside getZoneReports service method");

		List<ZoneReport> report = new ArrayList<ZoneReport>();

		for (PropertyZone zones : dao.getZoneNames()) {

			for (PropertyStatus status : dao.getPropertyStatus()) {

				ZoneReport zoneReport = new ZoneReport();
				zoneReport.setStatusId(status.getPropertyStatusId());
				zoneReport.setZoneId(zones.getZoneId());
				zoneReport.setZoneAmount(dao.getZoneReport(zoneReport.getStatusId(), zoneReport.getZoneId()));

				report.add(zoneReport);
			}

		}

		return report;

	}

	public void getPropertyDetails(PropertyDetails propDetails, PropertyTax propTax) throws SQLException, Exception {

		LOGGER.info("Inside getPropertyDetails service method");
		int i = dao.savePropertyDetails(propDetails);
		int j = dao.savePropertyTax(propTax);

	}

}
