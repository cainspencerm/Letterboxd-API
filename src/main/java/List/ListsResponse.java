package List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ListsResponse {

    // The list of lists.
    private ListSummary[] items;

    public ListsResponse(String json) {

        // Convert json to usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("items")) {
            JSONArray array = object.getJSONArray("items");

            items = new ListSummary[array.length()];
            for (int i = 0; i < items.length; i++) {
                items[i] = new ListSummary(array.get(i).toString());
            }
        } else {
            items = null;
        }
    }

    public ListSummary[] getItems() {
        return items;
    }
}
