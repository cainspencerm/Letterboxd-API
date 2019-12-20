package List.ID.Comments;

import List.ListIdentifier;
import Member.MemberSummary;
import org.json.JSONObject;

public class ListComment {

    // The LID of the comment.
    private String id;

    // The member who posted the comment.
    private MemberSummary member;

    // ISO 8601 format with UTC timezone, i.e. YYYY-MM-DDThh:mm:ssZ.
    private String whenCreated;

    // ISO 8601 format with UTC timezone, i.e. YYYY-MM-DDThh:mm:ssZ.
    private String whenUpdated;

    // The message portion of the comment in LBML. May contain the following HTML tags: <br>
    // <strong> <em> <b> <i> <a href=""> <blockquote>.
    private String commentLbml;

    // If Letterboxd moderators have removed the comment from the site, @removedByAdmin will
    // be true and @comment will not be included.
    private boolean removedByAdmin;

    // If the comment owner has removed the comment from the site, @deleted will be true and
    // @comment will not be included.
    private boolean deleted;

    // If the authenticated member has blocked the commenter, @blocked will be true and
    // @comment will not be included.
    private boolean blocked;

    // If the list owner has blocked the commenter, @blockedByOwner will be true and comment
    // will not be included.
    private boolean blockedByOwner;

    // If the authenticated member posted this comment, and the comment is still editable, this
    // value shows the number of seconds remaining until the editing window closes.
    private int editableWindowExpiresIn;

    // The list on which the comment was posted.
    private ListIdentifier list;

    // The message portion of the comment formatted in HTML.
    private String comment;

    public ListComment(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        id = object.has("id") ? object.getString("id") : null;
        member = object.has("member") ? new MemberSummary(object.get("member").toString()) : null;
        whenCreated = object.has("whenCreated") ? object.getString("whenCreated") : null;
        whenUpdated = object.has("whenUpdated") ? object.getString("whenUpdated") : null;
        commentLbml = object.has("commentLbml") ? object.getString("commentLbml") : null;
        removedByAdmin = object.has("removedByAdmin") && object.getBoolean("removedByAdmin");
        deleted = object.has("deleted") && object.getBoolean("deleted");
        blocked = object.has("blocked") && object.getBoolean("blocked");
        blockedByOwner = object.has("blockedByOwner") && object.getBoolean("blockedByOwner");
        editableWindowExpiresIn = object.has("editableWindowExpiresIn") ? object.getInt("editableWindowExpiresIn") : 0;
        list = object.has("list") ? new ListIdentifier(object.get("list").toString()) : null;
        comment = object.has("comment") ? object.getString("comment") : null;
    }

    public String getId() {
        return id;
    }

    public MemberSummary getMember() {
        return member;
    }

    public String getWhenCreated() {
        return whenCreated;
    }

    public String getWhenUpdated() {
        return whenUpdated;
    }

    public String getCommentLbml() {
        return commentLbml;
    }

    public boolean isRemovedByAdmin() {
        return removedByAdmin;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public boolean isBlockedByOwner() {
        return blockedByOwner;
    }

    public int getEditableWindowExpiresIn() {
        return editableWindowExpiresIn;
    }

    public ListIdentifier getList() {
        return list;
    }

    public String getComment() {
        return comment;
    }
}
