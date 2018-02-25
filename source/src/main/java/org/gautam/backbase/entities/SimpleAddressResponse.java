package org.gautam.backbase.entities;

import java.io.Serializable;

public class SimpleAddressResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6589131266284692864L;

	private String subpremise, streetNumber, route, locality, administrativeAreaLevel1, administrativeAreaLevel2,
			country, postalCode, postalCodeSuffix, latitude, longitude, status, message;

	public String getSubpremise() {
		return subpremise;
	}

	public void setSubpremise(String subpremise) {
		this.subpremise = subpremise;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getAdministrativeAreaLevel1() {
		return administrativeAreaLevel1;
	}

	public void setAdministrativeAreaLevel1(String administrativeAreaLevel1) {
		this.administrativeAreaLevel1 = administrativeAreaLevel1;
	}

	public String getAdministrativeAreaLevel2() {
		return administrativeAreaLevel2;
	}

	public void setAdministrativeAreaLevel2(String administrativeAreaLevel2) {
		this.administrativeAreaLevel2 = administrativeAreaLevel2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPostalCodeSuffix() {
		return postalCodeSuffix;
	}

	public void setPostalCodeSuffix(String postalCodeSuffix) {
		this.postalCodeSuffix = postalCodeSuffix;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
