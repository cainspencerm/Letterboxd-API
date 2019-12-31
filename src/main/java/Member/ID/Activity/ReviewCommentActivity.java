package Member.ID.Activity;

import LogEntry.LogEntry;
import LogEntry.ReviewComment;
import org.json.JSONObject;

public class ReviewCommentActivity extends AbstractActivity<ReviewCommentActivity> {

    // The review associated with the activity.
    private LogEntry review;

    // The comment associated with the activity.
    private ReviewComment comment;

    public ReviewCommentActivity(String json) {
        super(json);

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        review = object.has("review") ? new LogEntry(object.get("review").toString()) : null;
        comment = object.has("comment") ? new ReviewComment(object.get("comment").toString()) : null;
    }

    public LogEntry getReview() {
        return review;
    }

    public ReviewComment getComment() {
        return comment;
    }

    @Override
    public ReviewCommentActivity getActivity() {
        return this;
    }
}
