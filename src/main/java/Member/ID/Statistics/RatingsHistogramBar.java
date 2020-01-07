package Member.ID.Statistics;

import org.json.JSONObject;

public class RatingsHistogramBar {

    // The rating increment between 0.5 and 5.0.
    private float rating;

    // The height of this rating increment's entry in a unit-height histogram, normalized
    // between 0.0 and 1.0. The increment(s) with the highest number of ratings will always
    // return 1.0 (unless there are no ratings for the film).
    private float normalizedWeight;

    // The number of ratings made at this increment.
    private int count;

    public RatingsHistogramBar(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        rating = object.has("rating") ? object.getFloat("rating") : 0.0f;
        normalizedWeight = object.has("normalizedWeight") ? object.getFloat("normalizedWeight") : 0.0f;
        count = object.has("count") ? object.getInt("count") : 0;
    }

    public float getRating() {
        return rating;
    }

    public float getNormalizedWeight() {
        return normalizedWeight;
    }

    public int getCount() {
        return count;
    }
}
