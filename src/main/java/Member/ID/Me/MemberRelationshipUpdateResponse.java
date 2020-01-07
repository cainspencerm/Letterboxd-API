package Member.ID.Me;

import org.json.JSONArray;
import org.json.JSONObject;

public class MemberRelationshipUpdateResponse {

    // The response object.
    private MemberRelationship data;

    // A list of messages the API client should show to the user.
    private MemberRelationshipUpdateMessage[] messages;

    public MemberRelationshipUpdateResponse(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        data = object.has("data") ? new MemberRelationship(object.get("data").toString()) : null;

        if (object.has("messages")) {
            JSONArray array = object.getJSONArray("messages");

            messages = new MemberRelationshipUpdateMessage[array.length()];
            for (int i = 0; i < messages.length; i++) {
                messages[i] = new MemberRelationshipUpdateMessage(array.get(i).toString());
            }
        } else {
            messages = null;
        }
    }

    public MemberRelationship getData() {
        return data;
    }

    public MemberRelationshipUpdateMessage[] getMessages() {
        return messages;
    }
}
