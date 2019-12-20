package List.ID.Me;

import org.json.JSONObject;

public class ListRelationship {

    // Will be true if the member likes the list (via the 'heart' icon). A member may not like
    // their own list.
    private boolean liked;

    // Will be true if the member is subscribed to comment notifications for the list.
    private boolean subscribed;

    // Defaults to Subscribed for the list’s owner, and NotSubscribed for other members. The
    // subscription value may change when a member (other than the owner) posts a comment,
    // as follows: the member will become automatically Subscribed unless they have previously
    // Unsubscribed from the comment thread via the web interface or API, or unless they have
    // disabled comment notifications in their profile settings.
    // NotSubscribed and Unsubscribed are maintained as separate states so the UI can, if
    // needed, indicate to the member how their subscription state will be affected if/when
    // they post a comment.
    private SubscriptionState subscriptionState;

    // The authenticated member’s state with respect to adding comments for this list.
    // CanComment means the authenticated member is authorized to add a comment. All other
    // values mean the authenticated member is not authorized to add a comment.
    // Banned means the Letterboxd community managers have restricted the member’s ability
    // to comment on the site.
    // Blocked means the owner has blocked the member from adding comments.
    // NotCommentable means that it is invalid to try to add comments to this content.
    private CommentThreadState commentThreadState;

    public ListRelationship(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        liked = object.has("liked") && object.getBoolean("liked");
        subscribed = object.has("subscribed") && object.getBoolean("subscribed");

        if (object.has("subscriptionState")) {
            switch (object.get("subscriptionState").toString()) {
                case "Subscribed":
                    subscriptionState = SubscriptionState.Subscribed;
                    break;
                case "NotSubscribed":
                    subscriptionState = SubscriptionState.NotSubscribed;
                    break;
                case "Unsubscribed":
                    subscriptionState = SubscriptionState.Unsubscribed;
                    break;
                default:
                    subscriptionState = null;
            }
        } else {
            subscriptionState = null;
        }

        if (object.has("commentThreadState")) {
            switch (object.get("commentThreadState").toString()) {
                case "CanComment":
                    commentThreadState = CommentThreadState.CanComment;
                    break;
                case "Banned":
                    commentThreadState = CommentThreadState.Banned;
                    break;
                case "Blocked":
                    commentThreadState = CommentThreadState.Blocked;
                    break;
                case "NotCommentable":
                    commentThreadState = CommentThreadState.NotCommentable;
                    break;
                default:
                    commentThreadState = null;
            }
        } else {
            commentThreadState = null;
        }
    }

    public boolean isLiked() {
        return liked;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public SubscriptionState getSubscriptionState() {
        return subscriptionState;
    }

    public CommentThreadState getCommentThreadState() {
        return commentThreadState;
    }
}
