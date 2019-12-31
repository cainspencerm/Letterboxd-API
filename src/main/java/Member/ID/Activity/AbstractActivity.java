package Member.ID.Activity;

import Member.MemberSummary;
import org.json.JSONObject;

public abstract class AbstractActivity<Generic> {

    public enum Activity {
        DiaryEntryActivity, FilmLikeActivity, FilmRatingActivity, FilmWatchActivity,
        FollowActivity, InvitationAcceptedActivity, ListActivity, ListCommentActivity,
        ListLikeActivity, RegistrationActivity, ReviewActivity, ReviewCommentActivity,
        ReviewLikeActivity, WatchlistActivity
    }

    // The type of activity.
    private Activity type;

    // The member associated with the activity.
    private MemberSummary member;

    // The timestamp of the activity, in ISO 8601 format with UTC timezone,
    // i.e. YYYY-MM-DDThh:mm:ssZ.
    private String whenCreated;

    public AbstractActivity(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("type")) {
            switch (object.get("type").toString()) {
                case "DiaryEntryActivity":
                    type = Activity.DiaryEntryActivity;
                    break;
                case "FilmLikeActivity":
                    type = Activity.FilmLikeActivity;
                    break;
                case "FilmRatingActivity":
                    type = Activity.FilmRatingActivity;
                    break;
                case "FilmWatchActivity":
                    type = Activity.FilmWatchActivity;
                    break;
                case "FollowActivity":
                    type = Activity.FollowActivity;
                    break;
                case "InvitationAcceptedActivity":
                    type = Activity.InvitationAcceptedActivity;
                    break;
                case "ListActivity":
                    type = Activity.ListActivity;
                    break;
                case "ListCommentActivity":
                    type = Activity.ListCommentActivity;
                    break;
                case "ListLikeActivity":
                    type = Activity.ListLikeActivity;
                    break;
                case "RegistrationActivity":
                    type = Activity.RegistrationActivity;
                    break;
                case "ReviewActivity":
                    type = Activity.ReviewActivity;
                    break;
                case "ReviewCommentActivity":
                    type = Activity.ReviewCommentActivity;
                    break;
                case "ReviewLikeActivity":
                    type = Activity.ReviewLikeActivity;
                    break;
                case "WatchlistActivity":
                    type = Activity.WatchlistActivity;
                    break;
                default:
                    type = null;
            }
        } else {
            type = null;
        }

        member = object.has("member") ? new MemberSummary(object.get("member").toString()) : null;
        whenCreated = object.has("whenCreated") ? object.getString("whenCreated") : null;

    }

    public Activity getType() {
        return type;
    }

    public MemberSummary getMember() {
        return member;
    }

    public String getWhenCreated() {
        return whenCreated;
    }

    public abstract Generic getActivity();
}
