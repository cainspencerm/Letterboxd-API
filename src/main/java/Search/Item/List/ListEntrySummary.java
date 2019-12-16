package Search.Item.List;

import Search.Item.Film.FilmSummary;
import org.json.JSONObject;

public class ListEntrySummary {

    // If the list is ranked, this is the entry's rank in the list, numbered from 1.
    private int rank;

    // The film for this entry.
    private FilmSummary film;

    public ListEntrySummary(String json) {

        // Convert json to usable object.
        JSONObject object = new JSONObject(json);

        rank = object.has("rank") ? object.getInt("rank") : 0;
        film = object.has("film") ? new FilmSummary(object.get("film").toString()) : null;
    }

    public int getRank() {
        return rank;
    }

    public FilmSummary getFilm() {
        return film;
    }
}
