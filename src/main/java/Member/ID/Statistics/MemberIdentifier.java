package Member.ID.Statistics;

import org.json.JSONObject;

public class MemberIdentifier {

    // The LID of the member.
    private String id;

    public MemberIdentifier(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        id = object.has("id") ? object.getString("id") : null;
    }

    public String getId() {
        return id;
    }
}
