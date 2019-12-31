package Member.ID.Activity;

import LogEntry.LogEntry;
import org.json.JSONObject;

public class ReviewActivity extends AbstractActivity<ReviewActivity> {

    // The log entry associated with this activity.
    private LogEntry review;

    public ReviewActivity(String json) {
        super(json);

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        review = object.has("review") ? new LogEntry(object.get("review").toString()) : null;
    }

    public LogEntry getReview() {
        return review;
    }

    @Override
    public ReviewActivity getActivity() {
        return this;
    }
}
