package Film;

import Image.Image;
import Link.Link;
import Contributor.ContributorSummary;
import Member.MemberFilmRelationship;
import org.json.JSONObject;

public class FilmSummary {

    // The LID of the film.
    private String id;

    // The title of the film.
    private String name;

    // The original title of the film, if it was first released with a
    // non-English title.
    private String originalName;

    // The other names by which the film is known (including alternative
    // titles and/or foreign translations.
    private String[] alternativeNames;

    // The year in which the film was first released.
    private int releaseYear;

    // The list of directors for the film.
    private ContributorSummary[] directors;

    // The film's poster image (2:3 ratio in multiple sizes).
    private Image poster;

    // The LID of the collection containing this film.
    private String filmCollectionId;

    // A list of relevant URLs for this entity, on Letterboxd and
    // external sites.
    private Link[] links;

    // Relationships to the film for the authenticated member (if any)
    // and other members where relevant.
    private MemberFilmRelationship[] relationships;

    public FilmSummary(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        // Define member variables.
        id = object.has("id") ? object.getString("id") : null;
        name = object.has("name") ? object.getString("name") : null;
        originalName = object.isNull("originalName") ? null : object.getString("originalName");
        releaseYear = object.has("releaseYear") ? object.getInt("releaseYear") : 0;
        poster = object.has("poster") ? new Image(object.getJSONObject("poster").toString()) : null;
        filmCollectionId = object.isNull("filmCollectionId")? null : object.getString("filmCollectionId");

        directors = object.has("directors") ? new ContributorSummary[object.getJSONArray("directors").length()] : null;
        for (int i = 0; directors != null && i < directors.length; i++) {
            directors[i] = new ContributorSummary(object.getJSONArray("directors").getJSONObject(i).toString());
        }

        links = object.has("links") ? new Link[object.getJSONArray("links").length()] : null;
        for (int i = 0; links != null && i < links.length; i++) {
            links[i] = new Link(object.getJSONArray("links").getJSONObject(i).toString());
        }

        relationships = object.has("relationships") ? new MemberFilmRelationship[object.getJSONArray("relationships").length()] : null;
        for (int i = 0; relationships != null && i < relationships.length; i++) {
            relationships[i] = new MemberFilmRelationship(object.getJSONArray("relationships").get(i).toString());
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String[] getAlternativeNames() {
        return alternativeNames;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public ContributorSummary[] getDirectors() {
        return directors;
    }

    public Image getPoster() {
        return poster;
    }

    public String getFilmCollectionId() {
        return filmCollectionId;
    }

    public Link[] getLinks() {
        return links;
    }

    public MemberFilmRelationship[] getRelationships() {
        return relationships;
    }
}
