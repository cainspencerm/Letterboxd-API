package List.ID;

import Member.MemberSummary;
import List.ListEntrySummary;
import LogEntry.Sharable;
import Search.Item.Tag;
import List.ListIdentifier;
import Link.Link;
import org.json.JSONArray;
import org.json.JSONObject;

public class List {

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

    // Will be true if the owner has added notes to any entries.
    private boolean hasEntriesWithNotes;

    // The list description in LBML. May contain the following HTML tags: <br><strong><em>
    // <b><i><a href=""><blockquote>.
    private String descriptionLbml;

    // The tags for the list.
    private Tag[] tags2;

    // The third-party service or services to which this list can be shared. Only included
    // if the authenticated member is the list's owner.
    private Sharable canShareOn;

    // The third-party service or services to which this list has been shared. Only included
    // if the authenticated member is the list’s owner.
    private Sharable sharedOn;

    // ISO 8601 format with UTC timezone, i.e. YYYY-MM-DDThh:mm:ssZ.
    private String whenCreated;

    // ISO 8601 format with UTC timezone, i.e. YYYY-MM-DDThh:mm:ssZ.
    private String whenPublished;

    // The member who owns the list.
    private MemberSummary owner;

    // The list this was cloned from, if applicable.
    private ListIdentifier clonedFrom;

    // The first 12 entries in the list. To fetch more than 12 entries, and to fetch the
    // entry notes, use the /list/{id}/entries endpoint.
    private ListEntrySummary[] previewEntries;

    // A list of relevant URLs for this entity, on Letterboxd and external sites.
    private Link[] links;

    // The list description formatted as HTML.
    private String description;

    public List(String json) {

        // Convert json to usable object.
        JSONObject object = new JSONObject(json);

        id = object.has("id") ? object.getString("id") : null;
        name = object.has("name") ? object.getString("name") : null;
        filmCount = object.has("filmCount") ? object.getInt("filmCount") : 0;
        published = object.has("published") && object.getBoolean("published");
        ranked = object.has("ranked") && object.getBoolean("ranked");
        hasEntriesWithNotes = object.has("hasEntriesWithNotes") && object.getBoolean("hasEntriesWithNotes");
        descriptionLbml = object.has("descriptionLbml") ? object.getString("descriptionLbml") : null;

        if (object.has("tags2")) {
            JSONArray array = object.getJSONArray("tags2");

            tags2 = new Tag[array.length()];
            for (int i = 0; i < tags2.length; i++) {
                tags2[i] = new Tag(array.get(i).toString());
            }
        } else {
            tags2 = null;
        }

        if (object.has("canShareOn")) {
            switch (object.get("canShareOn").toString()) {
                case "Facebook":
                    canShareOn = Sharable.Facebook;
                    break;
                default:
                    canShareOn = null;
            }
        } else {
            canShareOn = null;
        }

        if (object.has("sharedOn")) {
            switch (object.get("sharedOn").toString()) {
                case "Facebook":
                    sharedOn = Sharable.Facebook;
                    break;
                default:
                    sharedOn = null;
            }
        } else {
            sharedOn = null;
        }

        whenCreated = object.has("whenCreated") ? object.getString("whenCreated") : null;
        whenPublished = object.has("whenPublished") ? object.getString("whenPublished") : null;
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

        if (object.has("links")) {
            JSONArray array = object.getJSONArray("links");

            links = new Link[array.length()];
            for (int i = 0; i < links.length; i++) {
                links[i] = new Link(array.get(i).toString());
            }
        } else {
            links = null;
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

    public boolean isHasEntriesWithNotes() {
        return hasEntriesWithNotes;
    }

    public String getDescriptionLbml() {
        return descriptionLbml;
    }

    public Tag[] getTags2() {
        return tags2;
    }

    public Sharable getCanShareOn() {
        return canShareOn;
    }

    public Sharable getSharedOn() {
        return sharedOn;
    }

    public String getWhenCreated() {
        return whenCreated;
    }

    public String getWhenPublished() {
        return whenPublished;
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

    public Link[] getLinks() {
        return links;
    }

    public String getDescription() {
        return description;
    }
}
