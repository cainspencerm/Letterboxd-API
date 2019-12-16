package Search.Item.Member;

import org.json.JSONObject;

public class MemberSearchItem extends Search.Item.AbstractSearchItem<MemberSearchItem> {

    // The member returned by the search.
    private MemberSummary member;

    public MemberSearchItem(String json) {
        super(json);

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        member = object.has("member") ? new MemberSummary(object.get("member").toString()) : null;
    }

    public MemberSummary getMember() {
        return member;
    }

    @Override
    public MemberSearchItem getItem() {
        return this;
    }
}
