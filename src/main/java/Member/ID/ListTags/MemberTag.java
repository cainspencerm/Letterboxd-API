package Member.ID.ListTags;

import org.json.JSONObject;

public class MemberTag {

    // The tag code.
    private String code;

    // The tag text as entered by the tagger.
    private String displayTag;

    // Counts of the member's uses of this tag.
    private MemberTagCounts counts;

    public MemberTag(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        code = object.has("code") ? object.getString("code") : null;
        displayTag = object.has("displayTag") ? object.getString("displayTag") : null;
        counts = object.has("counts") ? new MemberTagCounts(object.get("counts").toString()) : null;
    }

    public String getCode() {
        return code;
    }

    public String getDisplayTag() {
        return displayTag;
    }

    public MemberTagCounts getCounts() {
        return counts;
    }
}
