package Search.Item.Contributor;

import Contributor.ID.Contributor;
import Search.Item.AbstractSearchItem;
import org.json.JSONObject;

public class ContributorSearchItem extends AbstractSearchItem<ContributorSearchItem> {

    // Details of the contributor.
    private Contributor contributor;

    public ContributorSearchItem(String json) {
        super(json);

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        contributor = object.has("contributor") ? new Contributor(object.get("contributor").toString()) : null;
    }

    public Contributor getContributor() {
        return contributor;
    }

    @Override
    public ContributorSearchItem getItem() {
        return this;
    }
}
