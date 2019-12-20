package Search;

import Search.Item.AbstractSearchItem;
import Search.Item.ContributorSearchItem;
import Search.Item.FilmSearchItem;
import Search.Item.ListSearchItem;
import Search.Item.MemberSearchItem;
import Search.Item.ReviewSearchItem;
import Search.Item.TagSearchItem;
import org.json.JSONArray;
import org.json.JSONObject;

public class SearchResponse {

    // The list of search results.
    private AbstractSearchItem[] items;

    public SearchResponse(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("items")) {
            JSONArray array = object.getJSONArray("items");

            items = new AbstractSearchItem[array.length()];
            for (int i = 0; i < array.length(); i++) {

                switch (array.getJSONObject(i).get("type").toString()) {

                    case "ContributorSearchItem":
                        items[i] = new ContributorSearchItem(array.get(i).toString());
                        break;
                    case "FilmSearchItem":
                        items[i] = new FilmSearchItem(array.get(i).toString());
                        break;
                    case "ListSearchItem":
                        items[i] = new ListSearchItem(array.get(i).toString());
                        break;
                    case "MemberSearchItem":
                        items[i] = new MemberSearchItem(array.get(i).toString());
                        break;
                    case "ReviewSearchItem":
                        items[i] = new ReviewSearchItem(array.get(i).toString());
                        break;
                    case "TagSearchItem":
                        items[i] = new TagSearchItem(array.get(i).toString());
                        break;
                    default:
                        items[i] = null;
                        break;
                }
            }
        } else {
            items = null;
        }
    }

    public AbstractSearchItem[] getItems() {
        return items;
    }
}
