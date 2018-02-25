package org.gautam.backbase.entities;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

/**
 * A transport object to parse the XML response from geocoding api
 * @author Gautam Velpula
 *
 */

@XmlRootElement
public class GeocodeResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9007413299079914631L;
	@XmlElement
	private String status;
	@XmlElement
	private String error_message;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	@XmlElement
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
		@XmlElement
		private String type;
		@XmlElement
		private String formatted_address;
		@JacksonXmlElementWrapper(useWrapping = false)
		private List<AddressComponent> address_component;

		public List<AddressComponent> getAddress_component() {
			return address_component;
		}

		public void setAddress_component(List<AddressComponent> address_component) {
			this.address_component = address_component;
		}

		@XmlElement
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

	@XmlRootElement
	public static class AddressComponent implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5109068990321184404L;
		@XmlElement
		private String long_name;
		@XmlElement
		private String short_name;
		@JacksonXmlElementWrapper(useWrapping = false)
		private List<String> type;

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

		public List<String> getType() {
			return type;
		}

		public void setType(List<String> type) {
			this.type = type;
		}
	}

	@XmlRootElement
	public static class Geometry implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3128052571631690426L;
		@XmlElement
		private Location location;
		@XmlElement
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

	@XmlRootElement
	public static class Location implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5535737647518687062L;
		@XmlElement
		private String lat;
		@XmlElement
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
