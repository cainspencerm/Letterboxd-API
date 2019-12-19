package Member.ID;

import Image.Image;
import Link.Link;
import Member.Pronoun;
import Search.Item.Film.FilmSummary;
import Search.Item.Review.LogEntry;
import org.json.JSONArray;
import org.json.JSONObject;

public class Member {

    public enum MemberStatus {
        Crew, Patron, Pro, Member
    }

    // The LID of the member.
    private String id;

    // The member's Letterboxd username.
    private String username;

    // The given name of the member.
    private String givenName;

    // The family name of the member.
    private String familyName;

    // A convenience method that returns the member's given name and
    // family name concatenated with a space, if both are set, or just
    // their given name or family name, if one is set, or their username,
    // if neither is set. Will never be empty.
    private String displayName;

    // A convenience method that returns the member’s given name, if set,
    // or their username. Will never be empty.
    private String shortName;

    // The member’s preferred pronoun. Use the /members/pronouns endpoint
    // to request all available pronouns.
    private Pronoun pronoun;

    // The member’s Twitter username, if they have authenticated their account.
    private String twitterUsername;

    // The member’s bio in LBML. May contain the following HTML tags: <br>
    // <strong> <em> <b> <i> <a href=""> <blockquote>.
    private String bioLbml;

    // The member's location.
    private String location;

    // The member's website URL. URLs are not validated, so sanitizing may
    // be required.
    private String website;

    // The member's avatar image at multiple sizes.
    private Image avatar;

    // The member's backdrop image at multiple sizes, sorced from the first
    // film in the member's list of favorite films, if available. Only returned
    // for Patron members.
    private Image backdrop;

    // The vertical focal point of the member’s backdrop image, if available.
    // Expressed as a proportion of the image’s height, using values between
    // 0.0 and 1.0. Use when cropping the image into a shorter space, such as
    // in the page for a film on the Letterboxd site.
    private float backdropFocalPoint;

    // The member's account type.
    private MemberStatus memberStatus;

    // A summary of the member’s favorite films, up to a maximum of four.
    private FilmSummary[] favoriteFilms;

    // The reviews the member has pinned on their profile page, up to a maximum
    // of two. Only returned for paying members.
    private LogEntry[] pinnedReviews;

    // A link to the member's profile pag on the Letterboxd website.
    private Link[] links;

    // Defaults to false for new accounts. Indicates whether the member has
    // elected to hide their watchlist from other members.
    private boolean privateWatchlist;

    // The member's bio formatted as HTML.
    private String bio;

    public Member(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        id = object.has("id") ? object.getString("id") : null;
        username = object.has("username") ? object.getString("username") : null;
        givenName = object.has("givenName") ? object.getString("givenName") : null;
        familyName = object.has("familyName") ? object.getString("familyName") : null;
        displayName = object.has("displayName") ? object.getString("displayName") : null;
        shortName = object.has("shortName") ? object.getString("shortName") : null;
        pronoun = object.has("pronoun") ? new Pronoun(object.get("pronoun").toString()) : null;
        twitterUsername = object.has("twitterUsername") ? object.getString("twitterUsername") : null;
        bioLbml = object.has("bioLbml") ? object.getString("bioLbml") : null;
        website = object.has("website") ? object.getString("website") : null;
        avatar = object.has("avatar") ? new Image(object.get("avatar").toString()) : null;
        backdrop = object.has("backdrop") ? new Image(object.get("backdrop").toString()) : null;
        backdropFocalPoint = object.has("backdropFocalPoint") ? object.getFloat("backdropFocalPoint") : 0.0f;

        if (object.has("memberStatus")) {
            switch (object.get("memberStatus").toString()) {
                case "Crew":
                    memberStatus = MemberStatus.Crew;
                    break;
                case "Patron":
                    memberStatus = MemberStatus.Patron;
                    break;
                case "Pro":
                    memberStatus = MemberStatus.Pro;
                    break;
                case "Member":
                    memberStatus = MemberStatus.Member;
                    break;
                default:
                    memberStatus = null;
            }
        } else {
            memberStatus = null;
        }

        if (object.has("favoriteFilms")) {
            JSONArray array = object.getJSONArray("favoriteFilms");

            favoriteFilms = new FilmSummary[array.length()];
            for (int i = 0; i < favoriteFilms.length; i++) {
                favoriteFilms[i] = new FilmSummary(array.get(i).toString());
            }
        } else {
            favoriteFilms = null;
        }

        if (object.has("pinnedReviews")) {
            JSONArray array = object.getJSONArray("pinnedReviews");

            pinnedReviews = new LogEntry[array.length()];
            for (int i = 0; i < pinnedReviews.length; i++) {
                pinnedReviews[i] = new LogEntry(array.get(i).toString());
            }
        } else {
            pinnedReviews = null;
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

        privateWatchlist = object.has("privateWatchlist") && object.getBoolean("privateWatchlist");
        bio = object.has("bio") ? object.getString("bio") : null;
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

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public String getBioLbml() {
        return bioLbml;
    }

    public String getLocation() {
        return location;
    }

    public String getWebsite() {
        return website;
    }

    public Image getAvatar() {
        return avatar;
    }

    public Image getBackdrop() {
        return backdrop;
    }

    public float getBackdropFocalPoint() {
        return backdropFocalPoint;
    }

    public MemberStatus getMemberStatus() {
        return memberStatus;
    }

    public FilmSummary[] getFavoriteFilms() {
        return favoriteFilms;
    }

    public LogEntry[] getPinnedReviews() {
        return pinnedReviews;
    }

    public Link[] getLinks() {
        return links;
    }

    public boolean isPrivateWatchlist() {
        return privateWatchlist;
    }

    public String getBio() {
        return bio;
    }
}
