package Member.ID.Activity;

import LogEntry.LogEntry;
import org.json.JSONObject;

public class DiaryEntryActivity extends AbstractActivity<DiaryEntryActivity> {

    // The log entry associated with this activity.
    private LogEntry diaryEntry;

    public DiaryEntryActivity(String json) {
        super(json);

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        diaryEntry = object.has("diaryEntry") ? new LogEntry(object.get("diaryEntry").toString()) : null;
    }

    public LogEntry getDiaryEntry() {
        return diaryEntry;
    }

    @Override
    public DiaryEntryActivity getActivity() {
        return this;
    }
}
