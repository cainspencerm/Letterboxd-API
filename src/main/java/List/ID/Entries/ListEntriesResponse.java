package List.ID.Entries;

import Film.FilmsMetaData;
import org.json.JSONArray;
import org.json.JSONObject;

public class ListEntriesResponse {

    // The list of entries.
    private ListEntry[] items;

    // The filtered and total count of films in the list.
    private FilmsMetaData metadata;

    // The relationships to the films in the list for the members referenced in the request.
    private FilmsMemberRelationship[] relationships;

    public ListEntriesResponse(String json) {

        // Convert json to usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("items")) {
            JSONArray array = object.getJSONArray("items");

            items = new ListEntry[array.length()];
            for (int i = 0; i < items.length; i++) {
                items[i] = new ListEntry(array.get(i).toString());
            }
        }

        metadata = object.has("metadata") ? new FilmsMetaData(object.get("metadata").toString()) : null;

        if (object.has("relationships")) {
            JSONArray array = object.getJSONArray("relationships");

            relationships = new FilmsMemberRelationship[array.length()];
            for (int i = 0; i < relationships.length; i++) {
                relationships[i] = new FilmsMemberRelationship(array.get(i).toString());
            }
        }
    }

    public ListEntry[] getItems() {
        return items;
    }

    public FilmsMetaData getMetadata() {
        return metadata;
    }

    public FilmsMemberRelationship[] getRelationships() {
        return relationships;
    }
}
