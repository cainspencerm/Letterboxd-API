package Film.ID;

import Contributor.ContributorSummary;
import org.json.JSONArray;
import org.json.JSONObject;
import Contributor.ID.ContributionType;

public class FilmContributions {

    // The type of contribution.
    private ContributionType type;

    // The list of contributors of the specified type for the film.
    private ContributorSummary[] contributors;

    public FilmContributions(String json) {

        // Convert json string into a usable object.
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

    public ContributionType getType() {
        return type;
    }

    public ContributorSummary[] getContributors() {
        return contributors;
    }
}
