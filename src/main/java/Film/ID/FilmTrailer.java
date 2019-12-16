package Film.ID;

import org.json.JSONObject;

public class FilmTrailer {

    // The YouTube ID of the trailer.
    private String id;

    // The YouTube URL for the trailer.
    private String url;

    public FilmTrailer(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        id = object.has("id") ? object.getString("id") : null;
        url = object.has("url") ? object.getString("url") : null;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
