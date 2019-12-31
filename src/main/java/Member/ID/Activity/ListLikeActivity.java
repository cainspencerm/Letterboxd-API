package Member.ID.Activity;

import List.ListSummary;
import org.json.JSONObject;

public class ListLikeActivity extends AbstractActivity<ListLikeActivity> {

    // The list associated with the activity.
    private ListSummary list;

    public ListLikeActivity(String json) {
        super(json);

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        list = object.has("list") ? new ListSummary(object.get("list").toString()) : null;
    }

    public ListSummary getList() {
        return list;
    }

    @Override
    public ListLikeActivity getActivity() {
        return this;
    }
}
