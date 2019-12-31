package LogEntry;

import org.json.JSONObject;

public class ReviewIdentifier {

    // The LID of the log entry.
    private String id;

    public ReviewIdentifier(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        id = object.has("id") ? object.getString("id") : null;
    }

    public String getId() {
        return id;
    }
}
