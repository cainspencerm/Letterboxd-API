package Film.ID.Availability;

import org.json.JSONArray;
import org.json.JSONObject;

public class AvailabilityResponse {

    // The list of stores where the film is available for streaming or purchasing, in order of preference. If the member has not specified their preferred stores for a service, the USA store will be assumed.
    private FilmAvailability[] items;

    public AvailabilityResponse(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("items")) {
            JSONArray array = object.getJSONArray("items");

            items = new FilmAvailability[array.length()];
            for (int i = 0; i < items.length; i++) {
                items[i] = new FilmAvailability(array.get(i).toString());
            }
        } else {
            items = null;
        }
    }

    public FilmAvailability[] getItems() {
        return items;
    }
}
