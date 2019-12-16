package Link;

import org.json.JSONObject;

public class Link {
    public enum Type {
        LETTERBOXD, TMDB,
        IMDB, GWI, JUSTWATCH
    }

    // Denotes which site the link is for.
    private Type type;

    // The object ID for the linked entity on the destination site.
    private String id;

    // The fully qualified URL on the destination site.
    private String url;

    public Link(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        // Define member variables.
        if (object.has("type") && object.get("type").toString().equalsIgnoreCase("letterboxd")) {
            type = Type.LETTERBOXD;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("tmdb")) {
            type = Type.TMDB;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("imdb")) {
            type = Type.IMDB;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("gwi")) {
            type = Type.GWI;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("justwatch")) {
            type = Type.JUSTWATCH;
        } else {
            type = null;
        }

        id = object.has("id") ? object.getString("id") : null;
        url = object.has("url") ? object.getString("url") : null;
    }

    public Type getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
