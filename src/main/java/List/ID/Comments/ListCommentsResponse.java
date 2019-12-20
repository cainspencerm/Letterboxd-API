package List.ID.Comments;

import org.json.JSONArray;
import org.json.JSONObject;

public class ListCommentsResponse {

    // The list of comments.
    private ListComment[] items;

    public ListCommentsResponse(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("items")) {
            JSONArray array = object.getJSONArray("items");

            items = new ListComment[array.length()];
            for (int i = 0; i < items.length; i++) {
                items[i] = new ListComment(array.get(i).toString());
            }
        } else {
            items = null;
        }
    }

    public ListComment[] getItems() {
        return items;
    }
}
