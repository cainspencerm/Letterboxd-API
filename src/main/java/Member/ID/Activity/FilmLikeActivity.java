package Member.ID.Activity;

import Film.FilmSummary;
import org.json.JSONObject;

public class FilmLikeActivity extends AbstractActivity<FilmLikeActivity> {

    // The film associated with the activity. Includes a @MemberFilmRelationship for the member who added the activity.
    private FilmSummary film;

    public FilmLikeActivity(String json) {
        super(json);

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        film = object.has("film") ? new FilmSummary(object.get("film").toString()) : null;
    }

    public FilmSummary getFilm() {
        return film;
    }

    @Override
    public FilmLikeActivity getActivity() {
        return this;
    }
}
