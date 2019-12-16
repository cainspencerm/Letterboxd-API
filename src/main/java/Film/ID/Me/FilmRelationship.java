package Film.ID.Me;

import org.json.JSONArray;
import org.json.JSONObject;

public class FilmRelationship {

    // Will be true if the member has indicated they've seen the film (via the
    // 'eye' icon) or has a log entry for the film.
    private boolean watched;

    // If watched=true, whenWatched will contain the time when the member
    // marked the film as watched. ISO 8601 format with UTC timezone, i.e.
    // YYYY-MM-DDThh:mm:ssZ
    private String whenWatched;

    // Will be true if the member likes the film (via the 'heart' icon).
    private boolean liked;

    // If liked=true, whenLiked will contain the time when the member marked
    // the film as liked. ISO 8601 format with UTC timezone, i.e.
    // YYYY-MM-DDThh:mm:ssZ
    private String whenLiked;

    // Will be true if the member listed the film as one of their four
    // favorites.
    private boolean favorited;

    // Will be true if the film is in the member's watchlist.
    private boolean inWatchlist;

    // If inWatchlist=true, whenAddedToWatchlist will contain the time when the
    // member added the film to their watchlist. ISO 8601 format with UTC
    // timezone, i.e YYYY-MM-DDThh:mm:ssZ
    private String whenAddedToWatchlist;

    // If the member used to have the film in their watchlist, and subsequently
    // watched the film, whenCompletedInWatchlist will contain the time when
    // the member marked the film as watched.
    private String whenCompletedInWatchlist;

    // The member's rating for the film.
    private float rating; // API Docs say "number" not "float"

    // A list of LIDs for reviews the member has written for the film in the
    // order they were added, with the most recent reviews first.
    private String[] reviews;

    // A list of LIDs for log entries the member has added for the film in
    // diary order, with most recent entries first.
    private String[] diaryEntries;

    public FilmRelationship(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        watched = object.has("watched") && object.getBoolean("watched");
        whenWatched = object.has("whenWatched") ? object.getString("whenWatched") : null;
        liked = object.has("liked") && object.getBoolean("liked");
        whenLiked = object.has("whenLiked") ? object.getString("whenLiked") : null;
        favorited = object.has("favorited") && object.getBoolean("favorited");
        inWatchlist = object.has("inWatchlist") && object.getBoolean("inWatchlist");
        whenAddedToWatchlist = object.has("whenAddedToWatchlist") ? object.getString("whenAddedToWatchlist") : null;
        whenCompletedInWatchlist = object.has("whenCompletedInWatchlist") ? object.getString("whenCompletedInWatchlist") : null;
        rating = object.has("rating") ? object.getFloat("rating") : 0;

        if (object.has("reviews")) {
            JSONArray array = object.getJSONArray("reviews");

            reviews = new String[array.length()];
            for (int i = 0; i < reviews.length; i++) {
                reviews[i] = array.getString(i);
            }
        }

        if (object.has("diaryEntries")) {
            JSONArray array = object.getJSONArray("diaryEntries");

            diaryEntries = new String[array.length()];
            for (int i = 0; i < diaryEntries.length; i++) {
                diaryEntries[i] = array.getString(i);
            }
        }
    }

    public boolean isWatched() {
        return watched;
    }

    public String getWhenWatched() {
        return whenWatched;
    }

    public boolean isLiked() {
        return liked;
    }

    public String getWhenLiked() {
        return whenLiked;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public boolean isInWatchlist() {
        return inWatchlist;
    }

    public String getWhenAddedToWatchlist() {
        return whenAddedToWatchlist;
    }

    public String getWhenCompletedInWatchlist() {
        return whenCompletedInWatchlist;
    }

    public float getRating() {
        return rating;
    }

    public String[] getReviews() {
        return reviews;
    }

    public String[] getDiaryEntries() {
        return diaryEntries;
    }
}
