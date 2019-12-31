package Member.ID.Activity;

import Film.FilmSummary;
import org.json.JSONObject;

public class FilmRatingActivity extends AbstractActivity<FilmRatingActivity> {

    // The film associated with the activity. Includes a @MemberFilmRelationship for the member who added the activity.
    private FilmSummary film;

    // The member's rating for the film. Allowable values are between 0.5 and 5.0, with increments of 0.5.
    private float rating;

    public FilmRatingActivity(String json) {
        super(json);

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        film = object.has("film") ? new FilmSummary(object.get("film").toString()) : null;
        rating = object.has("rating") ? object.getFloat("rating") : 0.0f;
    }

    public FilmSummary getFilm() {
        return film;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public FilmRatingActivity getActivity() {
        return this;
    }
}
