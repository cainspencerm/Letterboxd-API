package Film.Genres;

import org.json.JSONArray;
import org.json.JSONObject;

public class GenresResponse {

    // The list of genres.
    private Genre[] items;

    public GenresResponse(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("items")) {
            JSONArray array = object.getJSONArray("items");

            items = new Genre[array.length()];
            for (int i = 0; i < items.length; i++) {
                items[i] = new Genre(array.get(i).toString());
            }
        } else {
            items = null;
        }
    }

    public Genre[] getItems() {
        return items;
    }
}
