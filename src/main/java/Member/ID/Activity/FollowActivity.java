package Member.ID.Activity;

import Member.MemberSummary;
import org.json.JSONObject;

public class FollowActivity extends AbstractActivity<FollowActivity> {

    // A summary of the member that was followed.
    private MemberSummary followed;

    public FollowActivity(String json) {
        super(json);

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        followed = object.has("followed") ? new MemberSummary(object.get("followed").toString()) : null;
    }

    public MemberSummary getFollowed() {
        return followed;
    }

    @Override
    public FollowActivity getActivity() {
        return this;
    }
}
