package LogEntry;

import org.json.JSONObject;

public class DiaryDetails {

    // The date the film was watched, if specified, in ISO 8601 format, i.e. YYYY-MM-DD.
    private String diaryDate;

    // Will be true if the member has indicated (or it can be otherwise determined) that the
    // member has seen the film prior to this date.
    private boolean rewatch;

    public DiaryDetails(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        diaryDate = object.has("diaryDate") ? object.getString("diaryDate") : null;
        rewatch = object.has("rewatch") && object.getBoolean("rewatch");
    }

    public String getDiaryDate() {
        return diaryDate;
    }

    public boolean isRewatch() {
        return rewatch;
    }
}
