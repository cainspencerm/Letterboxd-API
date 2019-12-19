package Contributor.ID;

import Authentication.Auth;
import Contributor.ID.Contributions.FilmContribution;
import Contributor.ID.Contributions.FilmContributionsRequest;
import Contributor.ID.Contributions.FilmContributionsResponse;
import Link.Link;
import Member.ID.Member;
import Search.Item.Contributor.ContributorStatistics;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.naming.directory.SearchResult;

public class Contributor {

    public enum ContributionType {
        Director, CoDirector, Actor,
        Producer, Writer, Editor,
        Cinematography, ArtDirection,
        VisualEffects, Composer, Sound,
        Costumes, MakeUp, Studio
    }

    // The LID of the contributor.
    private String id;

    // The name of the contributor.
    private String name;

    // An array of the types of contributions made, with a count
    // of films for each contribution.
    private ContributorStatistics statistics;

    // A list of relevant URLs for this entity, Letterboxd and
    // external sites.
    private Link[] links;

    public Contributor(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        // Define member variables.
        id = object.has("id") ? object.getString("id") : null;
        name = object.has("name") ? object.getString("name") : null;
        statistics = object.has("statistics") ? new ContributorStatistics(object.get("statistics").toString()) : null;

        // Store 'n' links into an array.
        if (object.has("links")) {
            JSONArray array = object.getJSONArray("links");

            links = new Link[array.length()];
            for (int i = 0; i < array.length(); i++) {
                links[i] = new Link(array.getJSONObject(i).toString());
            }
        } else {
            links = null;
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ContributorStatistics getStatistics() {
        return statistics;
    }

    public Link[] getLinks() {
        return links;
    }

    public FilmContribution[] getContributions(ContributionType type) {
        FilmContributionsRequest request = new FilmContributionsRequest();
        request.setType(type);

        String json;
        try {
            json = Auth.request("/contributor/" + this.id + "/contributions", request.getParameters(), "GET", null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return new FilmContributionsResponse(json).getItems();
    }

    // TODO Find a way to get a contributor's member id.
//    public Member getAsMember(ContributionType type) {
//
//        String json;
//        try {
//            json = Auth.request("/member/" + this.getId(), null, "GET", null);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//
//        return new Member(json);
//    }

}
