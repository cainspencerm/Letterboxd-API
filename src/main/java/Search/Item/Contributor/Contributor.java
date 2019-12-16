package Search.Item.Contributor;

import Link.Link;
import Search.Item.AbstractSearchItem;
import org.json.JSONArray;
import org.json.JSONObject;

public class Contributor extends AbstractSearchItem<Contributor> {

    // The LID of the contributor.
    private String id;

    // The name of the contributor.
    private String name;

    // An array of the types of contributions made, with a count
    // of films for each contribution.
    private ContributorStatistics statistics;

    // A list of relevant URLs for this entity, Letterboxd and
    // external sites.
    private Link[] links;

    public Contributor(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        // Define member variables.
        id = object.has("id") ? object.getString("id") : null;
        name = object.has("name") ? object.getString("name") : null;
        statistics = object.has("statistics") ? new ContributorStatistics(object.get("statistics").toString()) : null;

        // Store 'n' links into an array.
        if (object.has("links")) {
            JSONArray array = object.getJSONArray("links");

            links = new Link[array.length()];
            for (int i = 0; i < array.length(); i++) {
                links[i] = new Link(array.getJSONObject(i).toString());
            }
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ContributorStatistics getStatistics() {
        return statistics;
    }

    public Link[] getLinks() {
        return links;
    }

    @Override
    public Contributor getItem() {
        return this;
    }
}
