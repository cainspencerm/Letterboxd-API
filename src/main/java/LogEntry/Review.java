package LogEntry;

import org.json.JSONObject;

public class Review {

    // The review text in LBML. May contain the following HTML tags: <br> <strong> <em> <b> <i> <a href=""> <blockquote>.
    private String lbml;

    // Will be true if the member has indicated that the review field contains plot spoilers for the film.
    private boolean containsSpoilers;

    // Will be true if the review has been removed by a moderator.
    private boolean moderated;

    // The third-party service or services to which this review can be shared. Only included if the authenticated member is the review’s owner.
    private Sharable canShareOn;

    // The third-party service or services to which this review has been shared. Only included if the authenticated member is the review’s owner.
    private Sharable sharedOn;

    // The timestamp when this log entry’s review was first published, in ISO 8601 format with UTC timezone, i.e. YYYY-MM-DDThh:mm:ssZ
    private String whenReviewed;

    // The review text formatted as HTML.
    private String text;

    public Review(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        lbml = object.has("lbml") ? object.getString("lbml") : null;
        containsSpoilers = object.has("containsSpoilers") && object.getBoolean("containsSpoilers");
        moderated = object.has("moderated") && object.getBoolean("containsSpoilers");

        String sharable = object.has("canShareOn") ? object.getString("canShareOn") : null;
        canShareOn = sharable != null && sharable.equalsIgnoreCase("Facebook") ? Sharable.Facebook : null;

        sharable = object.has("sharedOn") ? object.getString("sharedOn") : null;
        sharedOn = sharable != null && sharable.equalsIgnoreCase("Facebook") ? Sharable.Facebook : null;

        whenReviewed = object.has("whenReviewed") ? object.getString("whenReviewed") : null;
        text = object.has("text") ? object.getString("text") : null;

    }

    public String getLbml() {
        return lbml;
    }

    public boolean isContainsSpoilers() {
        return containsSpoilers;
    }

    public boolean isModerated() {
        return moderated;
    }

    public Sharable getCanShareOn() {
        return canShareOn;
    }

    public Sharable getSharedOn() {
        return sharedOn;
    }

    public String getWhenReviewed() {
        return whenReviewed;
    }

    public String getText() {
        return text;
    }
}
