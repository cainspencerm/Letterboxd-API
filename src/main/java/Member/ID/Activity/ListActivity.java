package Member.ID.Activity;

import List.ListSummary;
import org.json.JSONObject;

public class ListActivity extends AbstractActivity<ListActivity> {

    // The list associated with the activity.
    private ListSummary list;

    // The list that was cloned, if applicable.
    private ListSummary clonedFrom;

    public ListActivity(String json) {
        super(json);

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        list = object.has("list") ? new ListSummary(object.get("list").toString()) : null;
        clonedFrom = object.has("clonedFrom") ? new ListSummary(object.get("clonedFrom").toString()) : null;
    }

    public ListSummary getList() {
        return list;
    }

    public ListSummary getClonedFrom() {
        return clonedFrom;
    }

    @Override
    public ListActivity getActivity() {
        return this;
    }
}
