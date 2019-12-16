package Search.Item.List;

import org.json.JSONObject;

public class ListIdentifier {

    // The LID of the list.
    private String id;

    public ListIdentifier(String json) {

        // Convert json to usable object.
        JSONObject object = new JSONObject(json);

        id = object.has("id") ? object.getString("id") : null;
    }

    public String getId() {
        return id;
    }
}
