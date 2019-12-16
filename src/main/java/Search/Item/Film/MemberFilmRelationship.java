package Search.Item.Film;

import Film.ID.Me.FilmRelationship;
import Search.Item.Member.MemberSummary;
import org.json.JSONObject;

public class MemberFilmRelationship {

    // The member.
    private MemberSummary member;

    // The relationship details.
    private FilmRelationship relationship;

    public MemberFilmRelationship(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        member = object.has("member") ? new MemberSummary(object.get("member").toString()) : null;
        relationship = object.has("relationship") ? new FilmRelationship(object.get("relationship").toString()) : null;
    }

    public MemberSummary getMember() {
        return member;
    }

    public FilmRelationship getRelationship() {
        return relationship;
    }
}
