package Search.Item;

import org.json.JSONObject;

public abstract class AbstractSearchItem<Generic> {

    public enum Type {
        ContributorSearchItem, FilmSearchItem,
        ListSearchItem, MemberSearchItem,
        ReviewSearchItem, TagSearchItem
    }

    // The type of the search result.
    private Type type;

    // A relevancy value that can be used to order results.
    private float score;

    public AbstractSearchItem() {
        type = null;
        score = 0;
    }

    public AbstractSearchItem(String json) {

        // Convert json to usable object.
        JSONObject object = new JSONObject(json);

        // Define the type of search item.
        if (object.has("type") && object.get("type").toString().equalsIgnoreCase("contributorsearchitem")) {
            type = Type.ContributorSearchItem;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("filmsearchitem")) {
            type = Type.FilmSearchItem;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("listsearchitem")) {
            type = Type.ListSearchItem;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("membersearchitem")) {
            type = Type.MemberSearchItem;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("reviewsearchitem")) {
            type = Type.ReviewSearchItem;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("tagsearchitem")) {
            type = Type.TagSearchItem;
        } else {
            type = null;
        }

        // Define the score of the search item.
        score = object.has("score") ? object.getFloat("score") : 0.0f;
    }

    public Type getType() {
        return type;
    }

    public float getScore() {
        return score;
    }

    public abstract Generic getItem();

}

