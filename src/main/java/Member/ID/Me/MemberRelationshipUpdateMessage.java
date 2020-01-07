package Member.ID.Me;

import org.json.JSONObject;

public class MemberRelationshipUpdateMessage {

    public enum UpdateMessage {
        Error, Success
    }

    public enum UpdateCode {
        BlockYourself, FollowYourself,
        FollowBlockedMember,
        FollowMemberYouBlocked
    }

    // The type of message.
    private UpdateMessage type;

    // The error message code.
    private UpdateCode code;

    // The error message text in human-readable form.
    private String title;

    public MemberRelationshipUpdateMessage(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("type")) {
            switch (object.get("type").toString()) {
                case "Error":
                    type = UpdateMessage.Error;
                    break;
                case "Success":
                    type = UpdateMessage.Success;
                    break;
                default:
                    type = null;
            }
        } else {
            type = null;
        }

        if (object.has("code")) {
            switch (object.get("code").toString()) {
                case "BlockYourself":
                    code = UpdateCode.BlockYourself;
                    break;
                case "FollowYourself":
                    code = UpdateCode.FollowYourself;
                    break;
                case "FollowBlockedMember":
                    code = UpdateCode.FollowBlockedMember;
                    break;
                case "FollowMemberYouBlocked":
                    code = UpdateCode.FollowMemberYouBlocked;
                    break;
                default:
                    code = null;
            }
        } else {
            code = null;
        }

        title = object.has("title") ? object.getString("title") : null;
    }

    public UpdateMessage getType() {
        return type;
    }

    public UpdateCode getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
}
