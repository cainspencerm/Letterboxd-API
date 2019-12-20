package Contributor;

import Contributor.ID.ContributionType;
import org.json.JSONObject;

public class ContributionStatistics {

    // The type of contribution.
    private ContributionType type;

    // The number of films for this contribution.
    private int filmCount;


    public ContributionStatistics(String json) {

        // Convert json into a usable object.
        JSONObject object = new JSONObject(json);

        // Define the type of contributor.
        if (object.has("type") && object.get("type").toString().equalsIgnoreCase("director")) {
            type = ContributionType.Director;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("codirector")) {
            type = ContributionType.CoDirector;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("actor")) {
            type = ContributionType.Actor;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("producer")) {
            type = ContributionType.Producer;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("writer")) {
            type = ContributionType.Writer;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("editor")) {
            type = ContributionType.Editor;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("cinematography")) {
            type = ContributionType.Cinematography;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("artdirection")) {
            type = ContributionType.ArtDirection;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("visualeffects")) {
            type = ContributionType.VisualEffects;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("composer")) {
            type = ContributionType.Composer;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("sound")) {
            type = ContributionType.Sound;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("costumes")) {
            type = ContributionType.Costumes;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("makeup")) {
            type = ContributionType.MakeUp;
        } else if (object.has("type") && object.get("type").toString().equalsIgnoreCase("studio")) {
            type = ContributionType.Studio;
        } else {
            type = null;
        }

        filmCount = object.has("filmCount") ? object.getInt("filmCount") : 0;
    }

    public ContributionType getType() {
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
