package Member.ID.Activity;

import Member.ID.Member;

import java.util.HashSet;
import java.util.Iterator;

public class ActivityRequest {

    public enum ActivityType {
        ReviewActivity, ReviewCommentActivity, ReviewLikeActivity, ListActivity,
        ListCommentActivity, ListLikeActivity, DiaryEntryActivity, FilmRatingActivity,
        FilmWatchActivity, FilmLikeActivity, WatchlistActivity, FollowActivity,
        RegistrationActivity, InvitationAcceptedActivity
    }

    public enum ActivityFlag {
        OwnActivity, NotOwnActivity, IncomingActivity,
        NotIncomingActivity, NetworkActivity
    }

    // The number of items to include per page (default is 20, maximum is 100).
    private int perPage;

    // Only supported for paying members.
    //
    // Use include to specify the subset of activity to be returned. If neither include
    // nor exclude is set, the activity types included depend on the where parameter:
    // If where=OwnActivity is specified, all activity except FilmLikeActivity,
    // FilmWatchActivity and InvitationAcceptedActivity is included.
    //
    // Otherwise all activity except FilmLikeActivity, FilmWatchActivity, FilmRatingActivity,
    // FollowActivity, RegistrationActivity and InvitationAcceptedActivity is included.
    //
    // These defaults mimic those shown on the website.
    private ActivityType include;

    // Use @where to reduce the subset of activity to be returned. If @where is not set,
    // all default activity types relating to the member are returned. If multiple values
    // are supplied, only activity matching all terms will be returned, e.g.
    // where=OwnActivity&where=NotIncomingActivity will return all activity by the member
    // except their comments on their own lists and reviews. @NetworkActivity is activity
    // performed either by the member or their followers. Use
    // where=NetworkActivity&where=NotOwnActivity to only see activity from followers. If
    // you don’t specify any of @NetworkActivity, @OwnActivity or @NotIncomingActivity, you
    // will receive activity related to the member’s content from members outside their
    // network (e.g. comments and likes on the member’s lists and reviews).
    private ActivityFlag where;

    public ActivityRequest() {
        perPage = 0;
        include = null;
        where = null;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public ActivityType getInclude() {
        return include;
    }

    public void setInclude(ActivityType include) {
        this.include = include;
    }

    public ActivityFlag getWhere() {
        return where;
    }

    public void setWhere(ActivityFlag where) {
        this.where = where;
    }

    public String[] getParameters() {
        HashSet<String> set = new HashSet<>();

        if (perPage != 0)
            set.add("perPage=" + perPage);

        if (include != null)
            set.add("include=" + include);

        if (where != null)
            set.add("where=" + where);

        String[] parameters = new String[set.size()];
        Iterator<String> iterator = set.iterator();
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = iterator.next();
        }

        return parameters;
    }
}
