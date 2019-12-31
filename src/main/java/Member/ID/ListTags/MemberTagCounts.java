package Member.ID.ListTags;

import org.json.JSONObject;

public class MemberTagCounts {

    // The number of films the member has used this tag on.
    private int films;

    // The number of log entries the member has used this tag on.
    private int logEntries;

    // The number of diary entries the member has used this tag on.
    private int diaryEntries;

    // The number of reviews the member has used this tag on.
    private int reviews;

    // The number of lists the member has used this tag on.
    private int lists;

    public MemberTagCounts(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        films = object.has("films") ? object.getInt("films") : 0;
        logEntries = object.has("logEntries") ? object.getInt("logEntries") : 0;
        diaryEntries = object.has("diaryEntries") ? object.getInt("diaryEntries") : 0;
        reviews = object.has("reviews") ? object.getInt("reviews") : 0;
        lists = object.has("lists") ? object.getInt("lists") : 0;
    }

    public int getFilms() {
        return films;
    }

    public int getLogEntries() {
        return logEntries;
    }

    public int getDiaryEntries() {
        return diaryEntries;
    }

    public int getReviews() {
        return reviews;
    }

    public int getLists() {
        return lists;
    }
}
