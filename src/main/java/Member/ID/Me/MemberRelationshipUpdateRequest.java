package Member.ID.Me;

public class MemberRelationshipUpdateRequest {

    // Set to true if the authenticated member wishes to follow the member identified by ID,
    // or false if they wish to unfollow. A member may not follow their own account, or the
    // account of a member they have blocked or that has blocked them.
    private boolean following;

    // Set to true if the authenticated member wishes to block the member identified by ID,
    // or false if they wish to unblock. A member may not block their own account.
    private boolean blocking;

    public MemberRelationshipUpdateRequest() {
        following = false;
        blocking = false;
    }

    public boolean isFollowing() {
        return following;
    }

    public void setFollowing(boolean following) {
        this.following = following;
    }

    public boolean isBlocking() {
        return blocking;
    }

    public void setBlocking(boolean blocking) {
        this.blocking = blocking;
    }

    public String[] getParameters() {
        return new String[]{"following=" + following, "blocking=" + blocking};
    }
}
