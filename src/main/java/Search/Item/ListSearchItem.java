package Search.Item;

import List.ListSummary;
import org.json.JSONObject;

public class ListSearchItem extends Search.Item.AbstractSearchItem<ListSearchItem> {

    // The list.
    private ListSummary list;

    public ListSearchItem(String json) {
        super(json);

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        list = object.has("list") ? new ListSummary(object.get("list").toString()) : null;
    }

    @Override
    public ListSearchItem getItem() {
        return this;
    }

    public ListSummary getList() {
        return list;
    }
}
