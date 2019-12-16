package Search.Item.Contributor;

import Film.ID.FilmContributions.Type;
import org.json.JSONObject;

public class ContributionStatistics {

    // The type of contribution.
    private Type type;

    // The number of films for this contribution.
    private int filmCount;


    public ContributionStatistics(String json) {

        // Convert json into a usable object.
        JSONObject object = new JSONObject(json);

        // Define the type of contributor.
        if (object.has("type") && object.get("type").toString().equalsIgnoreCase("director")) {
            type = Type.Director;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("codirector")) {
            type = Type.CoDirector;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("actor")) {
            type = Type.Actor;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("producer")) {
            type = Type.Producer;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("writer")) {
            type = Type.Writer;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("editor")) {
            type = Type.Editor;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("cinematography")) {
            type = Type.Cinematography;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("artdirection")) {
            type = Type.ArtDirection;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("visualeffects")) {
            type = Type.VisualEffects;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("composer")) {
            type = Type.Composer;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("sound")) {
            type = Type.Sound;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("costumes")) {
            type = Type.Costumes;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("makeup")) {
            type = Type.MakeUp;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("studio")) {
            type = Type.Studio;
        } else {
            type = null;
        }

        filmCount = object.has("filmCount") ? object.getInt("filmCount") : 0;
    }

    public Type getType() {
        return type;
    }

    public int getFilmCount() {
        return filmCount;
    }

    @Override
    public String toString() {
        return "Type = " + type + "; filmCount = " + filmCount;
    }
}
