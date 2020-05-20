/**
 * 
 */
package io.spring201.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.spring201.dto.ZoneReport;
import io.spring201.entity.PropertyDetails;
import io.spring201.entity.PropertyStatus;
import io.spring201.entity.PropertyTax;
import io.spring201.entity.PropertyType;
import io.spring201.entity.PropertyZone;
import io.spring201.service.TaxService;

/**
 * @author M1046129
 *
 */
@Controller
public class PropertyTaxController {

	private static final Logger LOGGER = Logger.getLogger(PropertyTaxController.class);

	@Autowired
	private TaxService taxService;

	@PostMapping(path = "/propertyTaxFormSubmission")
	public ModelAndView getPropertyTaxFormDetails(@RequestParam("ownerName") String name,
			@RequestParam("yearOfAssessment") int yearOfAssessment, @RequestParam("email") String email,
			@RequestParam("address") String address, @RequestParam("zone") int zone,
			@RequestParam("propertyType") int propertyType, @RequestParam("status") int status,
			@RequestParam("buildYear") int buildYear, @RequestParam("tax") double tax,
			@RequestParam("buildArea") double buildArea) throws SQLException, Exception {

		LOGGER.info("Inside propertyTaxFormSubmission");

		String propertyTypeName = null;
		String zoneName = null;
		ModelAndView mv;

		PropertyDetails propDetails = new PropertyDetails();
		propDetails.setOwnerName(name);
		propDetails.setEmailId(email);
		propDetails.setPropertyBuildArea(buildArea);
		propDetails.setYearOfAssesment(yearOfAssessment);
		propDetails.setPropertyAddress(address);
		propDetails.setPropertyBuildYear(buildYear);
		propDetails.setPropertyType(new PropertyType(propertyType));
		propDetails.setStatus(new PropertyStatus(status));
		propDetails.setZone(new PropertyZone(zone));

		LOGGER.info("PropertyDetails" + propDetails);

		PropertyTax propTax = new PropertyTax();
		propTax.setTaxAmount(tax);
		propTax.setPropertyId(propDetails);
		propTax.setStatusId(new PropertyStatus(status));
		propTax.setZoneId(new PropertyZone(zone));

		LOGGER.info("Property Tax" + propTax);

		LOGGER.info("Inside propertyTaxFormSubmission try block");
		try {
			taxService.getPropertyDetails(propDetails, propTax);
			mv = new ModelAndView("tax-submit");
			mv.addObject("yearOfAssessment", yearOfAssessment);
			mv.addObject("ownerName", name);
			mv.addObject("email", email);
			mv.addObject("address", address);
			if (zone == 1) {
				zoneName = "Zone A";
			} else if (zone == 2) {
				zoneName = "Zone B";
			} else if (zone == 3) {
				zoneName = "Zone C";
			}
			if (propertyType == 1) {
				propertyTypeName = "RCC buildings";
			} else if (propertyType == 2) {
				propertyTypeName = "RCC buildings with cement or red-oxide flooring";
			} else if (propertyType == 3) {
				propertyTypeName = "Tiled/Sheet of all kind";
			}
			mv.addObject("zone", zoneName);
			mv.addObject("buildYear", buildYear);
			mv.addObject("tax", tax);
			mv.addObject("propertyType", propertyTypeName);
			mv.addObject("buildArea", buildArea);
			return mv;
		} catch (Exception ex) {
			LOGGER.error("Inside propertyTaxFormSubmission catch block"
					+ new Exception(" An exception Has Occured").getMessage());

			mv = new ModelAndView("errors");
			mv.addObject("errors", new Exception(" An exception Has Occured").getMessage());
			return mv;
		}
	}

	@GetMapping(path = "/propertyTaxForm")
	public ModelAndView displayPropertyFormTax() {
		LOGGER.info("Inside propertyTaxForm method");
		ModelAndView mv = null;
		try {
			LOGGER.info("Inside propertyTaxForm try method");
			mv = new ModelAndView("property-tax");
			mv.addObject("zones", taxService.getAllZones());
			return mv;
		} catch (Exception ex) {
			LOGGER.error("Inside propertyTaxForm catch method" + ex.getMessage());
			mv = new ModelAndView("errors");
			mv.addObject("errors", ex.getMessage());
			return mv;
		}

	}

	@GetMapping(path = "/ZoneReport")
	@ResponseBody
	public ModelAndView displayZoneReport() {
		LOGGER.info("Inside ZoneReport method");
		ModelAndView mv = null;
		try {
			LOGGER.info("Inside ZoneReport try method");
			mv = new ModelAndView("zone-report");
			mv.addObject("zones", taxService.getAllZones());
			return mv;
		} catch (Exception ex) {
			LOGGER.error("Inside ZoneReport catch method" + ex.getMessage());
			mv.addObject("errors", ex.getMessage());
			return mv;
		}

	}

	@ResponseBody
	@RequestMapping(value = "/computeTax", method = RequestMethod.GET)
	public double getTaxAmount(@RequestParam("yearOfAssessment") int yearOfAssessment, @RequestParam("zone") int zone,
			@RequestParam("buildYear") int buildYear, @RequestParam("propertyType") int propertyType,
			@RequestParam("status") int status, @RequestParam("buildArea") int buildArea)
			throws SQLException, Exception {

		LOGGER.info("Inside computeTax method");

		return taxService.computeTax(zone, status, propertyType, buildArea, yearOfAssessment, buildYear);

	}

	@ResponseBody
	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public List<ZoneReport> getReport() throws SQLException, Exception {

		LOGGER.info("Inside reports method");

		return taxService.getZoneReports();

	}

}
