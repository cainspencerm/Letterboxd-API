package Search.Item.List;

import Search.Item.Member.MemberSummary;
import org.json.JSONArray;
import org.json.JSONObject;

public class ListSummary {

    // The LID of the list.
    private String id;

    // The name of the list.
    private String name;

    // The number of films in the list.
    private int filmCount;

    // Will be true if the owner has elected to publish the list for other members to see.
    private boolean published;

    // Will be true if the owner has elected to make this a ranked list.
    private boolean ranked;

    // The list description in LBML. May contain the following HTML tags: <br><strong><em><b><i><a href=""><blockquote>. The text is a preview extract, and may be truncated if it's too long.
    private String descriptionLbml;

    // Will be true if the list description was truncated because it's very long.
    private boolean descriptionTruncated;

    // The member who owns the list.
    private MemberSummary owner;

    // The list this was cloned from, if applicable.
    private ListIdentifier clonedFrom;

    // The first 12 entries in the list. To fetch more than 12 entries, and to fetch entry notes, use the /list/{id}/entries endpoint.
     private ListEntrySummary[] previewEntries;

    // The list description formatted as HTML. The text is a preview extract, and may be truncated if it's too long.
    private String description;

    public ListSummary(String json) {

        // Convert json to usable object.
        JSONObject object = new JSONObject(json);

        id = object.has("id") ? object.getString("id") : null;
        name = object.has("name") ? object.getString("name") : null;
        filmCount = object.has("filmCount") ? object.getInt("filmCount") : 0;
        published = object.has("published") && object.getBoolean("published");
        ranked = object.has("ranked") && object.getBoolean("ranked");
        descriptionLbml = object.has("descriptionLbml") ? object.getString("descriptionLbml") : null;
        descriptionTruncated = object.has("descriptionTruncated") && object.getBoolean("descriptionTruncated");
        owner = object.has("owner") ? new MemberSummary(object.get("owner").toString()) : null;
        clonedFrom = object.has("clonedFrom") ? new ListIdentifier(object.get("clonedFrom").toString()) : null;

        if (object.has("previewEntries")) {
            previewEntries = new ListEntrySummary[object.getJSONArray("previewEntries").length()];
            JSONArray objects = object.getJSONArray("previewEntries");
            for (int i = 0; i < previewEntries.length; i++) {
                previewEntries[i] = new ListEntrySummary(objects.get(i).toString());
            }
        } else {
            previewEntries = null;
        }

        description = object.has("description") ? object.getString("description") : null;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFilmCount() {
        return filmCount;
    }

    public boolean isPublished() {
        return published;
    }

    public boolean isRanked() {
        return ranked;
    }

    public String getDescriptionLbml() {
        return descriptionLbml;
    }

    public boolean isDescriptionTruncated() {
        return descriptionTruncated;
    }

    public MemberSummary getOwner() {
        return owner;
    }

    public ListIdentifier getClonedFrom() {
        return clonedFrom;
    }

    public ListEntrySummary[] getPreviewEntries() {
        return previewEntries;
    }

    public String getDescription() {
        return description;
    }
}
