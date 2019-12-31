package Member.ID.Activity;

import Film.FilmSummary;
import org.json.JSONObject;

public class WatchlistActivity extends AbstractActivity<WatchlistActivity> {

    // The film associated with the activity. Includes a @MemberFilmRelationship for the member who added the activity.
    private FilmSummary film;

    public WatchlistActivity(String json) {
        super(json);

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        film = object.has("film") ? new FilmSummary(object.get("film").toString()) : null;
    }

    public FilmSummary getFilm() {
        return film;
    }

    @Override
    public WatchlistActivity getActivity() {
        return this;
    }
}
