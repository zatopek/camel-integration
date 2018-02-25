package org.gautam.backbase.translator;

import java.util.List;

import org.gautam.backbase.entities.GeocodeResponse;
import org.gautam.backbase.entities.GeocodeResponse.AddressComponent;
import org.gautam.backbase.entities.SimpleAddressResponse;
import org.springframework.stereotype.Component;

/**
 * A transformer to simplify the complex {@link GeocodeResponse} to {@link SimpleAddressResponse}
 * @author Gautam Velpula
 *
 */
@Component
public class SimplifyGeocodeResponse {
	public static SimpleAddressResponse transform(GeocodeResponse geocodeResponse) {
		SimpleAddressResponse addressResponse = new SimpleAddressResponse();

		addressResponse.setStatus(geocodeResponse.getStatus());
		addressResponse.setMessage(geocodeResponse.getError_message());

		addressResponse.setLatitude(geocodeResponse != null && geocodeResponse.getResult() != null
				&& geocodeResponse.getResult().getGeometry() != null
				&& geocodeResponse.getResult().getGeometry().getLocation() != null
						? geocodeResponse.getResult().getGeometry().getLocation().getLat()
						: "");
		addressResponse.setLongitude(geocodeResponse != null && geocodeResponse.getResult() != null
				&& geocodeResponse.getResult().getGeometry() != null
				&& geocodeResponse.getResult().getGeometry().getLocation() != null
						? geocodeResponse.getResult().getGeometry().getLocation().getLng()
						: "");

		if (geocodeResponse != null && geocodeResponse.getResult() != null
				&& geocodeResponse.getResult().getAddress_component() != null) {
			List<AddressComponent> addressComponents = geocodeResponse.getResult().getAddress_component();

			for (AddressComponent addressComponent : addressComponents) {
				List<String> types = addressComponent.getType();
				for (String type : types) {
					switch (type) {
					case "street_number":
						addressResponse.setStreetNumber(addressComponent.getLong_name());
						break;
					case "route":
						addressResponse.setRoute(addressComponent.getLong_name());
						break;
					case "locality":
						addressResponse.setLocality(addressComponent.getLong_name());
						break;
					case "administrative_area_level_2":
						addressResponse.setAdministrativeAreaLevel2(addressComponent.getLong_name());
						break;
					case "administrative_area_level_1":
						addressResponse.setAdministrativeAreaLevel1(addressComponent.getLong_name());
						break;
					case "country":
						addressResponse.setCountry(addressComponent.getLong_name());
						break;
					case "postal_code":
						addressResponse.setPostalCode(addressComponent.getLong_name());
						break;
					case "postal_code_suffix":
						addressResponse.setPostalCodeSuffix(addressComponent.getLong_name());
						break;
					case "subpremise":
						addressResponse.setSubpremise(addressComponent.getLong_name());
						break;
					default:
						break;
					}
				}
			}
		}

		return addressResponse;
	}
}
