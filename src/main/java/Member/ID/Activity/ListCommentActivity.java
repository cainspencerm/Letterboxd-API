package Member.ID.Activity;

import List.ID.Comments.ListComment;
import List.ListSummary;
import org.json.JSONObject;

public class ListCommentActivity extends AbstractActivity<ListCommentActivity> {

    // The list associated with the activity.
    private ListSummary list;

    // The comment associated with the activity.
    private ListComment comment;

    public ListCommentActivity(String json) {
        super(json);

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        list = object.has("list") ? new ListSummary(object.get("list").toString()) : null;
        comment = object.has("comment") ? new ListComment(object.get("comment").toString()) : null;
    }

    public ListSummary getList() {
        return list;
    }

    public ListComment getComment() {
        return comment;
    }

    @Override
    public ListCommentActivity getActivity() {
        return this;
    }
}
