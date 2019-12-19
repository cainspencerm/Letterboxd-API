package Contributor.ID.Contributions;

import org.json.JSONObject;

public class FilmsRelationship {

    // The number of watches and likes for the films.
    private FilmsRelationshipCounts counts;

    public FilmsRelationship(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        counts = object.has("counts") ? new FilmsRelationshipCounts(object.get("counts").toString()) : null;
    }

    public FilmsRelationshipCounts getCounts() {
        return counts;
    }
}
