package List.ID.Statistics;

import List.ListIdentifier;
import org.json.JSONObject;

public class ListStatistics {

    // The list for which statistics were requested.
    private ListIdentifier list;

    // The number of comments and likes for the list.
    private ListStatisticsCounts counts;

    public ListStatistics(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        list = object.has("list") ? new ListIdentifier(object.get("list").toString()) : null;
        counts = object.has("counts") ? new ListStatisticsCounts(object.get("counts").toString()) : null;
    }

    public ListIdentifier getList() {
        return list;
    }

    public ListStatisticsCounts getCounts() {
        return counts;
    }
}
