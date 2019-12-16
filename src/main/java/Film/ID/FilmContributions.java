package Film.ID;

import Search.Item.Contributor.ContributorSummary;
import org.json.JSONArray;
import org.json.JSONObject;

public class FilmContributions {

    public enum Type {
        Director, CoDirector, Actor,
        Producer, Writer, Editor,
        Cinematography, ArtDirection,
        VisualEffects, Composer, Sound,
        Costumes, MakeUp, Studio
    }

    // The type of contribution.
    private Type type;

    // The list of contributors of the specified type for the film.
    private ContributorSummary[] contributors;

    public FilmContributions(String json) {

        // Convert json string into a usable object.
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

        if (object.has("contributors")) {
            JSONArray array = object.getJSONArray("contributors");

            contributors = new ContributorSummary[array.length()];
            for (int i = 0; i < contributors.length; i++) {
                contributors[i] = new ContributorSummary(array.get(i).toString());
            }
        } else {
            contributors = null;
        }
    }

    public Type getType() {
        return type;
    }

    public ContributorSummary[] getContributors() {
        return contributors;
    }
}
