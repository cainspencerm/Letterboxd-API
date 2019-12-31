package Member.ID.Activity;

import LogEntry.LogEntry;
import org.json.JSONObject;

public class ReviewLikeActivity extends AbstractActivity<ReviewLikeActivity> {

    // The review associated with the activity.
    private LogEntry review;

    public ReviewLikeActivity(String json) {
        super(json);

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        review = object.has("review") ? new LogEntry(object.get("review").toString()) : null;
    }

    public LogEntry getReview() {
        return review;
    }

    @Override
    public ReviewLikeActivity getActivity() {
        return this;
    }
}
