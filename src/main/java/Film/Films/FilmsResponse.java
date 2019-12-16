package Film.Films;

import Search.Item.Film.FilmSummary;
import org.json.JSONArray;
import org.json.JSONObject;

public class FilmsResponse {

    // The list of films.
    private FilmSummary[] items;

    public FilmsResponse(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("items")) {
            JSONArray array = object.getJSONArray("items");

            items = new FilmSummary[array.length()];
            for (int i = 0; i < items.length; i++) {
                items[i] = new FilmSummary(array.get(i).toString());
            }
        } else {
            items = null;
        }
    }

    public FilmSummary[] getItems() {
        return items;
    }
}
