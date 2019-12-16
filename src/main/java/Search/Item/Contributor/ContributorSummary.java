package Search.Item.Contributor;

import org.json.JSONObject;

public class ContributorSummary {

    // The LID of the contributor.
    private String id;

    // The name of the contributor.
    private String name;

    // The character name if available (only if the contributor is
    // an Actor; see the type field in FilmContributions).
    private String characterName;

    public ContributorSummary(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        id = object.has("id") ? object.getString("id") : null;
        name = object.has("name") ? object.getString("name") : null;
        characterName = object.has("characterName") ? object.getString("characterName") : null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCharacterName() {
        return characterName;
    }
}
