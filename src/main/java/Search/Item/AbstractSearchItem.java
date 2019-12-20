package Search.Item;

import org.json.JSONObject;

public abstract class AbstractSearchItem<Generic> {

    // The type of the search result.
    private AbstractSearchItemType type;

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
            type = AbstractSearchItemType.ContributorSearchItem;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("filmsearchitem")) {
            type = AbstractSearchItemType.FilmSearchItem;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("listsearchitem")) {
            type = AbstractSearchItemType.ListSearchItem;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("membersearchitem")) {
            type = AbstractSearchItemType.MemberSearchItem;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("reviewsearchitem")) {
            type = AbstractSearchItemType.ReviewSearchItem;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("tagsearchitem")) {
            type = AbstractSearchItemType.TagSearchItem;
        } else {
            type = null;
        }

        // Define the score of the search item.
        score = object.has("score") ? object.getFloat("score") : 0.0f;
    }

    public AbstractSearchItemType getType() {
        return type;
    }

    public float getScore() {
        return score;
    }

    public abstract Generic getItem();

}

