package Member.ID.Statistics;

import org.json.JSONObject;

public class MemberStatisticsCounts {

    // The number of films the member has liked.
    private int filmLikes;

    // The number of lists the member has liked.
    private int listLikes;

    // The number of reviews the member has liked.
    private int reviewLikes;

    // The number of films the member has watched. This is a distinct total -- films with
    // multiple log entries are only counted once.
    private int watches;

    // The number of films the member has rated.
    private int ratings;

    // The number of films the member has reviewed.
    private int reviews;

    // The number of entries the member has in their diary.
    private int diaryEntries;

    // The number of entries the member has in their diary for the current year. The current
    // year rolls over at midnight on 31 December in New Zealand Daylight Time (GMT +13).
    private int diaryEntriesThisYear;

    // The number of unique films the member has in their diary for the current year. The
    // current year rolls over at midnight on 31 December in New Zealand Daylight
    // Time (GMT + 13).
    private int filmsInDiaryThisYear;

    // The number of films the member has in their watchlist.
    private int watchlist;

    // The number of lists for the member. Includes unpublished lists if the request is made
    // for the authenticated member.
    private int lists;

    // The number of unpublished lists for the member. Only included if the request is made
    // for the authenticated member.
    private int unpublishedLists;

    // The number of members who follow the member.
    private int followers;

    // The number of members the member is following.
    private int following;

    // The number of tags the member has used for lists.
    private int listTags;

    // The number of tags the member has used for diary entries and reviews.
    private int filmTags;

    public MemberStatisticsCounts(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        filmLikes = object.has("filmLikes") ? object.getInt("filmLikes") : 0;
        listLikes = object.has("listLikes") ? object.getInt("listLikes") : 0;
        reviewLikes = object.has("reviewLikes") ? object.getInt("reviewLikes") : 0;
        watches = object.has("watches") ? object.getInt("watches") : 0;
        ratings = object.has("ratings") ? object.getInt("ratings") : 0;
        reviews = object.has("reviews") ? object.getInt("reviews") : 0;
        diaryEntries = object.has("diaryEntries") ? object.getInt("diaryEntries") : 0;
        diaryEntriesThisYear = object.has("diaryEntriesThisYear") ? object.getInt("diaryEntriesThisYear") : 0;
        filmsInDiaryThisYear = object.has("filmsInDiaryThisYear") ? object.getInt("filmsInDiaryThisYear") : 0;
        watchlist = object.has("watchlist") ? object.getInt("watchlist") : 0;
        lists = object.has("lists") ? object.getInt("lists") : 0;
        unpublishedLists = object.has("unpublishedLists") ? object.getInt("unpublishedLists") : 0;
        followers = object.has("followers") ? object.getInt("followers") : 0;
        following = object.has("following") ? object.getInt("following") : 0;
        listTags = object.has("listTags") ? object.getInt("listTags") : 0;
        filmTags = object.has("filmTags") ? object.getInt("filmTags") : 0;
    }

    public int getFilmLikes() {
        return filmLikes;
    }

    public int getListLikes() {
        return listLikes;
    }

    public int getReviewLikes() {
        return reviewLikes;
    }

    public int getWatches() {
        return watches;
    }

    public int getRatings() {
        return ratings;
    }

    public int getReviews() {
        return reviews;
    }

    public int getDiaryEntries() {
        return diaryEntries;
    }

    public int getDiaryEntriesThisYear() {
        return diaryEntriesThisYear;
    }

    public int getFilmsInDiaryThisYear() {
        return filmsInDiaryThisYear;
    }

    public int getWatchlist() {
        return watchlist;
    }

    public int getLists() {
        return lists;
    }

    public int getUnpublishedLists() {
        return unpublishedLists;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    public int getListTags() {
        return listTags;
    }

    public int getFilmTags() {
        return filmTags;
    }
}
