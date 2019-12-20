package List.ID.Statistics;

import org.json.JSONObject;

public class ListStatisticsCounts {

    // The number of comments for the list.
    private int comments;

    // The number of members who like the list.
    private int likes;

    public ListStatisticsCounts(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        comments = object.has("comments") ? object.getInt("comments") : 0;
        likes = object.has("likes") ? object.getInt("likes") : 0;
    }

    public int getComments() {
        return comments;
    }

    public int getLikes() {
        return likes;
    }
}
