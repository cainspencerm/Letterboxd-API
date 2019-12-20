package Link;

import org.json.JSONObject;

public class Link {

    // Denotes which site the link is for.
    private LinkType type;

    // The object ID for the linked entity on the destination site.
    private String id;

    // The fully qualified URL on the destination site.
    private String url;

    public Link(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        // Define member variables.
        if (object.has("type") && object.get("type").toString().equalsIgnoreCase("letterboxd")) {
            type = LinkType.LETTERBOXD;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("tmdb")) {
            type = LinkType.TMDB;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("imdb")) {
            type = LinkType.IMDB;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("gwi")) {
            type = LinkType.GWI;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("justwatch")) {
            type = LinkType.JUSTWATCH;
        } else {
            type = null;
        }

        id = object.has("id") ? object.getString("id") : null;
        url = object.has("url") ? object.getString("url") : null;
    }

    public LinkType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
