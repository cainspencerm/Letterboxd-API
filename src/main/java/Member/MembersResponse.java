package Member;

import org.json.JSONArray;
import org.json.JSONObject;

public class MembersResponse {

    // The list of members.
    private MemberSummary[] items;

    // TODO Add cursor usage.

    public MembersResponse(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("items")) {
            JSONArray array = object.getJSONArray("items");

            items = new MemberSummary[array.length()];
            for (int i = 0; i < items.length; i++) {
                items[i] = new MemberSummary(array.get(i).toString());
            }
        } else {
            items = null;
        }
    }

    public MemberSummary[] getItems() {
        return items;
    }
}
