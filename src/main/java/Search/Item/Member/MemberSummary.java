package Search.Item.Member;

import Image.Image;
import org.json.JSONObject;

public class MemberSummary {

    public enum MemberStatus {
        Crew, Patron, Pro, Member
    }

    // The LID of the member.
    private String id;

    // The member's Letterboxd username. Usernames must be between 2 and 15
    // characters long and may only contain upper or lowercase letters, numbers
    // or the underscore (_) character.
    private String username;

    // The given name of the member.
    private String givenName;

    // The family name of the member.
    private String familyName;

    // A convenience method that returns the member's given name and family
    // name concatenated with a space, if bother are set, or just their
    // given name or family name, if one is set, or their username, if neither
    // is set. Will never be empty.
    private String displayName;

    // A convenience method that returns the member's given name, if set, or
    // their username. Will never be empty.
    private String shortName;

    // The member's preferred pronoun. Use the /members/pronouns endpoint to
    // request all available pronouns.
    private Pronoun pronoun;

    // The member's avatar image at multiple sizes.
    private Image avatar;

    // The member's account type.
    private MemberStatus memberStatus;

    public MemberSummary(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        id = object.has("id") ? object.getString("id") : null;
        username = object.has("username") ? object.getString("username") : null;
        givenName = object.has("givenName") ? object.getString("givenName") : null;
        familyName = object.has("familyName") ? object.getString("familyName") : null;
        displayName = object.has("displayName") ? object.getString("displayName") : null;
        shortName = object.has("shortName") ? object.getString("shortName") : null;
        pronoun = object.has("pronoun") ? new Pronoun(object.get("pronoun").toString()) : null;

        if (object.has("memberStatus")) {

            switch (object.getString("memberStatus")) {
                case "crew":
                    memberStatus = MemberStatus.Crew;
                    break;
                case "patron":
                    memberStatus = MemberStatus.Patron;
                    break;
                case "pro":
                    memberStatus = MemberStatus.Pro;
                    break;
                case "member":
                    memberStatus = MemberStatus.Member;
                    break;
                default:
                    memberStatus = null;
                    break;
            }

        } else {
            memberStatus = null;
        }

        avatar = object.has("avatar") ? new Image(object.get("avatar").toString()) : null;

    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getShortName() {
        return shortName;
    }

    public Pronoun getPronoun() {
        return pronoun;
    }

    public Image getAvatar() {
        return avatar;
    }

    public MemberStatus getMemberStatus() {
        return memberStatus;
    }
}
