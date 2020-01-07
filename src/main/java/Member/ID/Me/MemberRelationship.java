package Member.ID.Me;

import org.json.JSONObject;

public class MemberRelationship {

    // Will be true if the authenticated member follows the member identified by ID.
    private boolean following;

    // Will be true if the member identified by ID follows the authenticated member.
    private boolean followedBy;

    // Will be true if the authenticated member has blocked the member identified by ID.
    private boolean blocking;

    // Will be true if the member identified by ID has blocked the authenticated member.
    private boolean blockedBy;

    public MemberRelationship(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        following = object.has("following") && object.getBoolean("following");
        followedBy = object.has("followedBy") && object.getBoolean("followedBy");
        blocking = object.has("blocking") && object.getBoolean("blocking");
        blockedBy = object.has("blockedBy") && object.getBoolean("blockedBy");
    }

    public boolean isFollowing() {
        return following;
    }

    public boolean isFollowedBy() {
        return followedBy;
    }

    public boolean isBlocking() {
        return blocking;
    }

    public boolean isBlockedBy() {
        return blockedBy;
    }
}
