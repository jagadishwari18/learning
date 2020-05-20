/**
 * 
 */
package io.spring201.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.spring201.controller.PropertyTaxController;
import io.spring201.entity.PropertyDetails;
import io.spring201.entity.PropertyStatus;
import io.spring201.entity.PropertyTax;
import io.spring201.entity.PropertyZone;

/**
 * @author M1046129
 *
 */
@Repository
public class PropertyTaxDaoImpl implements PropertyTaxDao {

	private static final Logger LOGGER = Logger.getLogger(PropertyTaxDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<PropertyZone> getZoneNames() throws Exception {

		LOGGER.info("Inside getZoneNames dao method ");

		List<PropertyZone> zoneNames = sessionFactory.getCurrentSession().getNamedQuery("getZoneIdAndName").list();
		return zoneNames;

	}

	public int savePropertyDetails(PropertyDetails propDetails) throws SQLException {

		LOGGER.info("Inside savePropertyDetails dao method ");

		Integer saveStatus = (Integer) sessionFactory.getCurrentSession().save(propDetails);

		if (saveStatus == 0) {

			throw new SQLException();
		}

		return saveStatus;
	}

	public int savePropertyTax(PropertyTax propTax) throws SQLException {

		LOGGER.info("Inside savePropertyTax dao method ");

		Integer saveTaxStatus = (Integer) sessionFactory.getCurrentSession().save(propTax);

		if (saveTaxStatus == 0) {

			throw new SQLException();
		}

		return saveTaxStatus;

	}

	public double getUavValue(int zoneId, int statusId, int propertyId) throws NullPointerException {

		LOGGER.info("Inside getUavValue dao method ");

		Query query = sessionFactory.getCurrentSession().createNativeQuery(
				"select uav from zone_unit_value where status_id =:statusId AND zone_id=:zoneId AND category_id=:propertyId")
				.setInteger("statusId", statusId).setInteger("zoneId", zoneId).setInteger("propertyId", propertyId);

		Double uav = (Double) query.list().get(0);

		LOGGER.info("Inside getUavValue dao method uav Value:" + uav);

		if (uav == null) {

			throw new NullPointerException();
		}

		return uav;
	}

	@SuppressWarnings("deprecation")
	public Double getZoneReport(int status_Id, int zoneId) throws Exception {

		LOGGER.info("Inside getZoneReport dao method ");

		Double amount = (Double) sessionFactory.getCurrentSession().createNativeQuery(
				"select sum(amount) from property_tax where zoneId_zone_Id=:zoneId AND statusId_status_id=:statusId")
				.setInteger("statusId", status_Id).setInteger("zoneId", zoneId).list().get(0);

		LOGGER.info(
				"Inside getZoneReport dao method taxAmount:" + amount + "ZoneId:" + zoneId + " statusId:" + status_Id);

		return amount;

	}

	@SuppressWarnings("unchecked")
	public List<PropertyStatus> getPropertyStatus() throws Exception {

		LOGGER.info("Inside getPropertyStatus dao method ");

		List<PropertyStatus> propertyStatus = sessionFactory.getCurrentSession().createQuery("from PropertyStatus")
				.list();

		return propertyStatus;

	}
}
