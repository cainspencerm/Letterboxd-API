package Contributor.ID.Contributions;

import Search.Item.Member.MemberSummary;
import org.json.JSONArray;
import org.json.JSONObject;

public class FilmContributorMemberRelationship {

    // The member.
    private MemberSummary member;

    // The relationship details.
    private FilmContributorRelationship[] relationships;

    public FilmContributorMemberRelationship(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        member = object.has("member") ? new MemberSummary(object.get("member").toString()) : null;

        if (object.has("relationships")) {
            JSONArray array = object.getJSONArray("relationships");

            relationships = new FilmContributorRelationship[array.length()];
            for (int i = 0; i < relationships.length; i++) {
                relationships[i] = new FilmContributorRelationship(array.get(i).toString());
            }
        } else {
            relationships = null;
        }
    }

    public MemberSummary getMember() {
        return member;
    }

    public FilmContributorRelationship[] getRelationships() {
        return relationships;
    }
}
