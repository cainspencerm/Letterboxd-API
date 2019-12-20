package LogEntry;

import Link.Link;
import Film.FilmSummary;
import Member.MemberSummary;
import Search.Item.Tag;
import org.json.JSONArray;
import org.json.JSONObject;

public class LogEntry {

    // The LID of the log entry.
    private String id;

    // A descriptive title for the log entry.
    private String name;

    // The member who created the log entry.
    private MemberSummary owner;

    // The film being logged. Includes a MemberFilmRelationship for the member who created the log entry.
    private FilmSummary film;

    // Details about the log entry, if present.
    private DiaryDetails diaryDetails;

    //Review details for the log entry, if present.
    private Review review;

    // The tags for the log entry.
    private Tag[] tags2;

    // The timestamp of when the log entry was created, in ISO 8601 format with UTC timezone, i.e. YYYY-MM-DDThh:mm:ssZ
    private String whenCreated;

    // The timestamp of when the log entry was last updated, in ISO 8601 format with UTC timezone, i.e. YYYY-MM-DDThh:mm:ssZ
    private String whenUpdated;

    // The member’s rating for the film. Allowable values are between 0.5 and 5.0, with increments of 0.5.
    private float rating;

    // Will be true if the member likes the film (via the ‘heart’ icon).
    private boolean like;

    // Will be true if the log entry can have comments.
    private boolean commentable;

    // A list of relevant URLs for this entity, on Letterboxd and external sites.
    private Link[] links;

    public LogEntry(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        id = object.has("id") ? object.getString("id") : null;
        name = object.has("name") ? object.getString("name") : null;
        owner = object.has("owner") ? new MemberSummary(object.get("owner").toString()) : null;
        film = object.has("film") ? new FilmSummary(object.get("film").toString()) : null;
        diaryDetails = object.has("diaryDetails") ? new DiaryDetails(object.get("diaryDetails").toString()) : null;
        review = object.has("review") ? new Review(object.get("review").toString()) : null;

        if (object.has("tags2")) {
            JSONArray array = object.getJSONArray("tags2");

            tags2 = new Tag[array.length()];
            for (int i = 0; i < array.length(); i++) {
                tags2[i] = new Tag(array.get(i).toString());
            }
        }

        whenCreated = object.has("whenCreated") ? object.getString("whenCreated") : null;
        whenUpdated = object.has("whenUpdated") ? object.getString("whenUpdated") : null;
        rating = object.has("rating") ? object.getFloat("rating") : 0.0f;
        like = object.has("like") && object.getBoolean("like");
        commentable = object.has("id") && object.getBoolean("commentable");

        if (object.has("links")) {
            JSONArray array = object.getJSONArray("links");

            links = new Link[array.length()];
            for (int i = 0; i < array.length(); i++) {
                links[i] = new Link(array.get(i).toString());
            }
        }

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MemberSummary getOwner() {
        return owner;
    }

    public FilmSummary getFilm() {
        return film;
    }

    public DiaryDetails getDiaryDetails() {
        return diaryDetails;
    }

    public Review getReview() {
        return review;
    }

    public Tag[] getTags2() {
        return tags2;
    }

    public String getWhenCreated() {
        return whenCreated;
    }

    public String getWhenUpdated() {
        return whenUpdated;
    }

    public float getRating() {
        return rating;
    }

    public boolean isLike() {
        return like;
    }

    public boolean isCommentable() {
        return commentable;
    }

    public Link[] getLinks() {
        return links;
    }
}
