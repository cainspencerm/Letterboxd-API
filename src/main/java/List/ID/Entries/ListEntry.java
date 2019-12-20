package List.ID.Entries;

import Film.FilmSummary;
import org.json.JSONObject;

public class ListEntry {

    // If the list is ranked, this is the entry's rank in the list, numbered from 1.
    private int rank;

    // The notes for the list entry in LBML. May contain the following HTML tags: <br> <strong>
    // <em> <b> <i> <a href=""> <blockquote>.
    private String notesLbml;

    // Will be true if the member has indicated that the notes field contains plot spoilers
    // for the film.
    private boolean containsSpoilers;

    // The film for this entry. Includes a MemberFilmRelationship for the member who created
    // the list.
    private FilmSummary film;

    // The notes for the list entry formatted as HTML.
    private String notes;

    public ListEntry(String json) {

        // Convert json to usable object.
        JSONObject object = new JSONObject(json);

        rank = object.has("rank") ? object.getInt("rank") : 0;
        notesLbml = object.has("notesLbml") ? object.getString("notesLbml") : null;
        containsSpoilers = object.has("containsSpoilers") && object.getBoolean("containsSpoilers");
        film = object.has("film") ? new FilmSummary(object.get("film").toString()) : null;
        notes = object.has("notes") ? object.getString("notes") : null;
    }

    public int getRank() {
        return rank;
    }

    public String getNotesLbml() {
        return notesLbml;
    }

    public boolean isContainsSpoilers() {
        return containsSpoilers;
    }

    public FilmSummary getFilm() {
        return film;
    }

    public String getNotes() {
        return notes;
    }
}
