package org.gautam.backbase.entities;

import java.io.Serializable;
import java.util.List;

public class GeocodeResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9007413299079914631L;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private Result result;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public static class Result implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1272406953086632451L;
		private String type;
		private String formatted_address;
		private List<AddressComponent> address_component;

		public List<AddressComponent> getAddress_component() {
			return address_component;
		}

		public void setAddress_component(List<AddressComponent> address_component) {
			this.address_component = address_component;
		}

		private Geometry geometry;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getFormatted_address() {
			return formatted_address;
		}

		public void setFormatted_address(String formatted_address) {
			this.formatted_address = formatted_address;
		}

		public Geometry getGeometry() {
			return geometry;
		}

		public void setGeometry(Geometry geometry) {
			this.geometry = geometry;
		}
	}

	public static class AddressComponent implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5109068990321184404L;
		private String long_name;
		private String short_name;
		private String type;

		public String getLong_name() {
			return long_name;
		}

		public void setLong_name(String long_name) {
			this.long_name = long_name;
		}

		public String getShort_name() {
			return short_name;
		}

		public void setShort_name(String short_name) {
			this.short_name = short_name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}

	public static class Geometry implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3128052571631690426L;
		private Location location;
		private String location_type;

		public Location getLocation() {
			return location;
		}

		public void setLocation(Location location) {
			this.location = location;
		}

		public String getLocation_type() {
			return location_type;
		}

		public void setLocation_type(String location_type) {
			this.location_type = location_type;
		}
	}

	public static class Location implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5535737647518687062L;
		private String lat;
		private String lng;

		public String getLat() {
			return lat;
		}

		public void setLat(String lat) {
			this.lat = lat;
		}

		public String getLng() {
			return lng;
		}

		public void setLng(String lng) {
			this.lng = lng;
		}
	}
}
