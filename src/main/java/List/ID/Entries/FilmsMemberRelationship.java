package List.ID.Entries;

import Film.FilmsRelationship;
import Member.MemberSummary;
import org.json.JSONObject;

public class FilmsMemberRelationship {

    // The member.
    private MemberSummary member;

    // The relationship details.
    private FilmsRelationship relationship;

    public FilmsMemberRelationship(String json) {

        // Convert json to usable object.
        JSONObject object = new JSONObject(json);

        member = object.has("member") ? new MemberSummary(object.get("member").toString()) : null;
        relationship = object.has("relationship") ? new FilmsRelationship(object.get("relationship").toString()) : null;
    }

    public MemberSummary getMember() {
        return member;
    }

    public FilmsRelationship getRelationship() {
        return relationship;
    }
}
