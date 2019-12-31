package Member.ID.Activity;

import org.json.JSONArray;
import org.json.JSONObject;

public class ActivityResponse {

    // The list of activity items.
    private AbstractActivity[] items;

    public ActivityResponse(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("items")) {
            JSONArray array = object.getJSONArray("items");

            items = new AbstractActivity[array.length()];
            for (int i = 0; i < items.length; i++) {
                JSONObject item = array.getJSONObject(i);

                if (item.has("type") && item.get("type").toString().equalsIgnoreCase("DiaryEntryActivity")) {
                    items[i] = new DiaryEntryActivity(item.toString());
                } else if (item.has("type") && item.get("type").toString().equalsIgnoreCase("FilmLikeActivity")) {
                    items[i] = new FilmLikeActivity(item.toString());
                } else if (item.has("type") && item.get("type").toString().equalsIgnoreCase("FilmRatingActivity")) {
                    items[i] = new FilmRatingActivity(item.toString());
                } else if (item.has("type") && item.get("type").toString().equalsIgnoreCase("FilmWatchActivity")) {
                    items[i] = new FilmWatchActivity(item.toString());
                } else if (item.has("type") && item.get("type").toString().equalsIgnoreCase("FollowActivity")) {
                    items[i] = new FollowActivity(item.toString());
                } else if (item.has("type") && item.get("type").toString().equalsIgnoreCase("InvitationAcceptedActivity")) {
                    items[i] = new InvitationAcceptedActivity(item.toString());
                } else if (item.has("type") && item.get("type").toString().equalsIgnoreCase("ListActivity")) {
                    items[i] = new ListActivity(item.toString());
                } else if (item.has("type") && item.get("type").toString().equalsIgnoreCase("ListCommentActivity")) {
                    items[i] = new ListCommentActivity(item.toString());
                } else if (item.has("type") && item.get("type").toString().equalsIgnoreCase("ListLikeActivity")) {
                    items[i] = new ListLikeActivity(item.toString());
                } else if (item.has("type") && item.get("type").toString().equalsIgnoreCase("RegistrationActivity")) {
                    items[i] = new RegistrationActivity(item.toString());
                } else if (item.has("type") && item.get("type").toString().equalsIgnoreCase("ReviewActivity")) {
                    items[i] = new ReviewActivity(item.toString());
                } else if (item.has("type") && item.get("type").toString().equalsIgnoreCase("ReviewCommentActivity")) {
                    items[i] = new ReviewCommentActivity(item.toString());
                } else if (item.has("type") && item.get("type").toString().equalsIgnoreCase("ReviewLikeActivity")) {
                    items[i] = new ReviewLikeActivity(item.toString());
                } else if (item.has("type") && item.get("type").toString().equalsIgnoreCase("WatchlistActivity")) {
                    items[i] = new WatchlistActivity(item.toString());
                } else {
                    items[i] = null;
                }
            }
        } else {
            items = null;
        }
    }

    public AbstractActivity[] getItems() {
        return items;
    }
}
