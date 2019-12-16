package Search.Item.Member;

import org.json.JSONObject;

public class Pronoun {

    // The LID for this pronoun.
    private String id;

    // A label to describe this pronoun.
    private String label;

    // The pronoun to use when the member is the subject.
    private String subjectPronoun;

    // The pronoun to use when the member is the object.
    private String objectPronoun;

    // The adjective to use when describing a specified thing or things
    // belonging to or associated with a member previously mentioned.
    private String possesiveAdjective;

    // The pronoun to use when referring to a specified thing or things
    // belonging to or associated with a member previously mentioned.
    private String possessivePronoun;

    // The pronoun to use to refer back to the member.
    private String reflexive;

    public Pronoun(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        id = object.has("id") ? object.getString("id") : null;
        label = object.has("label") ? object.getString("label") : null;
        subjectPronoun = object.has("subjectPronoun") ? object.getString("subjectPronoun") : null;
        objectPronoun = object.has("objectPronoun") ? object.getString("objectPronoun") : null;
        possesiveAdjective = object.has("possessiveAdjective") ? object.getString("possessiveAdjective") : null;
        possessivePronoun = object.has("possessivePronoun") ? object.getString("possessivePronoun") : null;
        reflexive = object.has("reflexive") ? object.getString("reflexive") : null;

    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getSubjectPronoun() {
        return subjectPronoun;
    }

    public String getObjectPronoun() {
        return objectPronoun;
    }

    public String getPossesiveAdjective() {
        return possesiveAdjective;
    }

    public String getPossessivePronoun() {
        return possessivePronoun;
    }

    public String getReflexive() {
        return reflexive;
    }
}
