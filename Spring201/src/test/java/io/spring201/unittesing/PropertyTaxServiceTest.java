package io.spring201.unittesing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.spring201.dao.PropertyTaxDao;
import io.spring201.dto.ZoneReport;
import io.spring201.entity.PropertyDetails;
import io.spring201.entity.PropertyStatus;
import io.spring201.entity.PropertyTax;
import io.spring201.entity.PropertyZone;
import io.spring201.service.PropertyTaxService;

/**
 * @author M1046129
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PropertyTaxServiceTest {

	@Mock
	PropertyTaxDao dao;

	@InjectMocks
	PropertyTaxService service;

	@Test
	public void getAllZonesTest() throws Exception {
		List<PropertyZone> zoneList = new ArrayList<PropertyZone>();
		zoneList.add(new PropertyZone(1));
		zoneList.add(new PropertyZone(2));
		zoneList.add(new PropertyZone(3));

		when(dao.getZoneNames()).thenReturn(zoneList);

		List<PropertyZone> result = service.getAllZones();

		assertEquals(3, result.size());

		verify(dao, times(1)).getZoneNames();

		assertEquals("Zone A", result.get(0).getZoneName());
	}

	@Test(expected = Exception.class)
	public void getAllZonesExceptionTest() throws Exception {
		when(dao.getZoneNames()).thenThrow(new Exception());
		service.getAllZones();
	}

	@Test
	public void getPropertyDetailUnitTest() throws Exception {

		PropertyDetails propDetails = new PropertyDetails();
		PropertyTax propTax = new PropertyTax();
		when(dao.savePropertyDetails(propDetails)).thenReturn(1);
		when(dao.savePropertyTax(propTax)).thenReturn(1);

		service.getPropertyDetails(propDetails, propTax);

		verify(dao, times(1)).savePropertyDetails(propDetails);
		verify(dao, times(1)).savePropertyTax(propTax);
	}

	@Test
	public void computeTaxUnitTest() throws SQLException, Exception {

		int zoneId = 1;
		int statusId = 1;
		int propertyId = 1;

		when(dao.getUavValue(zoneId, statusId, propertyId)).thenReturn(2.50);

		int buildArea = 1200;
		int buildYear = 2002;
		int yearOfAssessment = 2019;

		double taxAmount = service.computeTax(zoneId, statusId, propertyId, buildArea, yearOfAssessment, buildYear);

		assertEquals(514.6, taxAmount, 0.00);

		verify(dao).getUavValue(zoneId, statusId, propertyId);

	}

	@Test(expected = Exception.class)
	public void computeTaxUnitTestException() throws SQLException, Exception {

		int zoneId = 1;
		int statusId = 1;
		int propertyId = 1;

		when(dao.getUavValue(zoneId, statusId, propertyId)).thenThrow(new Exception());

		int buildArea = 1200;
		int buildYear = 2002;
		int yearOfAssessment = 2019;

		Double taxAmount = service.computeTax(zoneId, statusId, propertyId, buildArea, yearOfAssessment, buildYear);

	}

	@Test
	public void getZoneReportUnitTest() throws Exception {

		List<ZoneReport> zoneReport = new ArrayList<ZoneReport>();
		zoneReport.add(new ZoneReport());
		zoneReport.add(new ZoneReport());
		zoneReport.add(new ZoneReport());
		zoneReport.add(new ZoneReport());
		zoneReport.add(new ZoneReport());
		zoneReport.add(new ZoneReport());

		List<PropertyZone> zoneList = new ArrayList<PropertyZone>();
		zoneList.add(new PropertyZone(1));
		zoneList.add(new PropertyZone(2));
		zoneList.add(new PropertyZone(3));

		when(dao.getZoneNames()).thenReturn(zoneList);

		List<PropertyStatus> type = new ArrayList<PropertyStatus>();
		type.add(new PropertyStatus());
		type.add(new PropertyStatus());

		when(dao.getPropertyStatus()).thenReturn(type);

		int[] statusIdArray = new int[] { 1, 2 };
		int[] zoneIdArray = new int[] { 1, 2, 3 };

		for (int i = 0; i < zoneIdArray.length; i++) {
			for (int j = 0; j < statusIdArray.length; j++) {
				when(dao.getZoneReport(statusIdArray[j], zoneIdArray[i])).thenReturn(500.0);
			}
		}

		List<ZoneReport> reports = service.getZoneReports();

		assertEquals(6, reports.size());

	}

}
