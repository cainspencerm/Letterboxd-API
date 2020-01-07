package Member.ID.Statistics;

import org.json.JSONArray;
import org.json.JSONObject;

public class MemberStatistics {

    // The member for which statistics were requested.
    private MemberIdentifier member;

    // The number of watches, ratings, likes, etc. for the member.
    private MemberStatisticsCounts counts;

    // A summary of the number of ratings the member has made for each increment between 0.5
    // and 5.0. Returns only the integer increments between 1.0 and 5.0 if the member never
    // (or rarely) awards half-star ratings.
    private RatingsHistogramBar[] ratingsHistogram;

    // A list of years the member has year-in-review pages for. Only supported for
    // paying members.
    private int[] yearsInReview;

    public MemberStatistics(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        member = object.has("member") ? new MemberIdentifier(object.get("member").toString()) : null;
        counts = object.has("counts") ? new MemberStatisticsCounts(object.get("counts").toString()) : null;

        if (object.has("ratingsHistogram")) {
            JSONArray array = object.getJSONArray("ratingsHistogram");

            ratingsHistogram = new RatingsHistogramBar[array.length()];
            for (int i = 0; i < ratingsHistogram.length; i++) {
                ratingsHistogram[i] = new RatingsHistogramBar(array.get(i).toString());
            }
        } else {
            ratingsHistogram = null;
        }

        if (object.has("yearsInReview")) {
            JSONArray array = object.getJSONArray("yearsInReview");

            yearsInReview = new int[array.length()];
            for (int i = 0; i < yearsInReview.length; i++) {
                yearsInReview[i] = array.getInt(i);
            }
        } else {
            yearsInReview = null;
        }
    }

    public MemberIdentifier getMember() {
        return member;
    }

    public MemberStatisticsCounts getCounts() {
        return counts;
    }

    public RatingsHistogramBar[] getRatingsHistogram() {
        return ratingsHistogram;
    }

    public int[] getYearsInReview() {
        return yearsInReview;
    }
}
