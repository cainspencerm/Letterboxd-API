package Search.Item;

import org.json.JSONObject;

public class TagSearchItem extends AbstractSearchItem<TagSearchItem> {

    // The tag.
    private Tag tag;

    public TagSearchItem(String json) {
        super(json);

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        tag = object.has("tag") ? new Tag(object.get("tag").toString()) : null;
    }

    @Override
    public TagSearchItem getItem() {
        return this;
    }

    public Tag getTag() {
        return tag;
    }
}
