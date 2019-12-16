package Film.Services;

import org.json.JSONArray;
import org.json.JSONObject;

public class ServicesResponse {

    // The list of film services.
    private Service[] items;

    public ServicesResponse(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("items")) {
            JSONArray array = object.getJSONArray("items");

            items = new Service[array.length()];
            for (int i = 0; i < items.length; i++) {
                items[i] = new Service(array.get(i).toString());
            }
        } else {
            items = null;
        }
    }

    public Service[] getItems() {
        return items;
    }
}
