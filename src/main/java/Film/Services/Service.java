package Film.Services;

import org.json.JSONObject;

public class Service {

    // The LID of the service.
    private String id;

    // The name of the service.
    private String name;

    // The URL of the thumbnail image for the service.
    private String icon;

    public Service(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        id = object.has("id") ? object.getString("id") : null;
        name = object.has("name") ? object.getString("name") : null;
        icon = object.has("icon") ? object.getString("icon") : null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }
}
