package Film.ID.Members;

import Search.Item.Film.MemberFilmRelationship;
import org.json.JSONArray;
import org.json.JSONObject;

public class MemberFilmRelationshipsResponse {

    // The list of film relationships for members.
    private MemberFilmRelationship[] items;

    public MemberFilmRelationshipsResponse(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("items")) {
            JSONArray array = object.getJSONArray("items");

            items = new MemberFilmRelationship[array.length()];
            for (int i = 0; i < items.length; i++) {
                items[i] = new MemberFilmRelationship(array.get(i).toString());
            }
        } else {
            items = null;
        }
    }

    public MemberFilmRelationship[] getItems() {
        return items;
    }
}
