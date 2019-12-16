package Search.Item.Tag;

import org.json.JSONObject;

public class Tag {

    // Use @displayTag instead.
    @Deprecated
    private String tag;

    // The tag code.
    private String code;

    // The tag text as entered by the tagger.
    private String displayTag;

    public Tag(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        tag = object.has("tag") ? object.getString("tag") : null;
        code = object.has("code") ? object.getString("code") : null;
        displayTag = object.has("displayTag") ? object.getString("displayTag") : null;
    }

    @Deprecated
    public String getTag() {
        return tag;
    }

    public String getCode() {
        return code;
    }

    public String getDisplayTag() {
        return displayTag;
    }
}
