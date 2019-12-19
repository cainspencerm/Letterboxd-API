package Contributor.ID.Contributions;

import org.json.JSONObject;

public class FilmsMetaData {

    // The total number of films.
    private int totalFilmCount;

    // The number of films that match the filter for this request.
    private int filteredFilmCount;

    public FilmsMetaData(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        totalFilmCount = object.has("totalFilmCount") ? object.getInt("totalFilmCount") : 0;
        filteredFilmCount = object.has("filmteredFilmCount") ? object.getInt("filteredFilmCount") : 0;
    }

    public int getTotalFilmCount() {
        return totalFilmCount;
    }

    public int getFilteredFilmCount() {
        return filteredFilmCount;
    }
}
