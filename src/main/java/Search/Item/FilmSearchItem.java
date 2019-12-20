package Search.Item;

import Film.FilmSummary;
import org.json.JSONObject;

public class FilmSearchItem extends Search.Item.AbstractSearchItem<FilmSearchItem> {

    // The film returned by the search.
    private FilmSummary film;

    public FilmSearchItem(String json) {
        super(json);

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        film = object.has("film") ? new FilmSummary(object.get("film").toString()) : null;
    }

    public FilmSummary getFilm() {
        return film;
    }

    @Override
    public FilmSearchItem getItem() {
        return this;
    }
}
