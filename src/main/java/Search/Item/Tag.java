package Search.Item;

import org.json.JSONObject;

public class Tag {

    // The tag code.
    private String code;

    // The tag text as entered by the tagger.
    private String displayTag;

    public Tag(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        code = object.has("code") ? object.getString("code") : null;
        displayTag = object.has("displayTag") ? object.getString("displayTag") : null;
    }

    public String getCode() {
        return code;
    }

    public String getDisplayTag() {
        return displayTag;
    }
}
