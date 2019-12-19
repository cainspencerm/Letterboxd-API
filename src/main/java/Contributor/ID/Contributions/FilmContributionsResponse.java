package Contributor.ID.Contributions;


import org.json.JSONArray;
import org.json.JSONObject;

public class FilmContributionsResponse {

    // The list of contributions.
    private FilmContribution[] items;

    // Metadata about the contributor's contributions.
    private FilmContributorMetadata[] metadata;

    // The relationships to the contributor for the members referenced in the request.
    private FilmContributorMemberRelationship[] relationships;

    public FilmContributionsResponse(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("items")) {
            JSONArray array = object.getJSONArray("items");

            items = new FilmContribution[array.length()];
            for (int i = 0; i < items.length; i++) {
                items[i] = new FilmContribution(array.get(i).toString());
            }
        } else {
            items = null;
        }

        if (object.has("metadata")) {
            JSONArray array = object.getJSONArray("metadata");

            metadata = new FilmContributorMetadata[array.length()];
            for (int i = 0; i < metadata.length; i++) {
                metadata[i] = new FilmContributorMetadata(array.get(i).toString());
            }
        } else {
            metadata = null;
        }

        if (object.has("relationships")) {
            JSONArray array = object.getJSONArray("relationships");

            relationships = new FilmContributorMemberRelationship[array.length()];
            for (int i = 0; i < relationships.length; i++) {
                relationships[i] = new FilmContributorMemberRelationship(array.get(i).toString());
            }
        } else {
            relationships = null;
        }
    }

    public FilmContribution[] getItems() {
        return items;
    }

    public FilmContributorMetadata[] getMetadata() {
        return metadata;
    }

    public FilmContributorMemberRelationship[] getRelationships() {
        return relationships;
    }
}
