package Member.ID.ListTags;

import org.json.JSONArray;
import org.json.JSONObject;

public class MemberTagsResponse {

    // The list of tag items, ordered by frequency of use.
    private MemberTag[] items;

    public MemberTagsResponse(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("items")) {
            JSONArray array = object.getJSONArray("items");

            items = new MemberTag[array.length()];
            for (int i = 0; i < items.length; i++) {
                items[i] = new MemberTag(array.get(i).toString());
            }
        } else {
            items = null;
        }
    }
}
