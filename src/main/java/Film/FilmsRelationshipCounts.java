package Film;

import org.json.JSONObject;

public class FilmsRelationshipCounts {

    // The number of films the member has indicated they've seen (via the 'eye' icon) or has a log entry for.
    private int watches;

    // The number of films the member has indicated they liked.
    private int likes;

    public FilmsRelationshipCounts(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        watches = object.has("watches") ? object.getInt("watches") : 0;
        likes = object.has("likes") ? object.getInt("likes") : 0;
    }

    public int getWatches() {
        return watches;
    }

    public int getLikes() {
        return likes;
    }
}
