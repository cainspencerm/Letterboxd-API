package Search.Item.Contributor;

import org.json.JSONArray;
import org.json.JSONObject;

public class ContributorStatistics {

    // The statistics for each contribution type.
    private ContributionStatistics[] contributions;

    public ContributorStatistics(String json) {
        JSONObject object = new JSONObject(json);

        if (object.has("contributions")) {
            JSONArray array = object.getJSONArray("contributions");

            contributions = new ContributionStatistics[array.length()];
            for (int i = 0; i < array.length(); i++) {
                contributions[i] = new ContributionStatistics(array.getJSONObject(i).toString());
            }
        } else {
            contributions = null;
        }
    }

    public ContributionStatistics[] getContributions() {
        return contributions;
    }
}
