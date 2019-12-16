package Search.Item.Review;

import org.json.JSONObject;

public class DiaryDetails {

    private String diaryDate;

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
