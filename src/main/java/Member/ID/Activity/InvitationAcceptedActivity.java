package Member.ID.Activity;

import Member.MemberSummary;
import org.json.JSONObject;

public class InvitationAcceptedActivity extends AbstractActivity<InvitationAcceptedActivity> {

    // The invitor of the member associated with the activity.
    private MemberSummary invitor;

    public InvitationAcceptedActivity(String json) {
        super(json);

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        invitor = object.has("invitor") ? new MemberSummary(object.get("invitor").toString()) : null;
    }

    public MemberSummary getInvitor() {
        return invitor;
    }

    @Override
    public InvitationAcceptedActivity getActivity() {
        return this;
    }
}
