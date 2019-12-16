package Search.Item.Review;

import org.json.JSONObject;

public class ReviewSearchItem extends Search.Item.AbstractSearchItem<ReviewSearchItem> {

    // Details of the review.
    private LogEntry review;

    public ReviewSearchItem(String json) {
        super(json);

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        review = object.has("review") ? new LogEntry(object.get("review").toString()) : null;
    }

    public LogEntry getReview() {
        return review;
    }

    @Override
    public ReviewSearchItem getItem() {
        return this;
    }
}
