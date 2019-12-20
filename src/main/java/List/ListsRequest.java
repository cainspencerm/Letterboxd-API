package List;

import Contributor.ID.Contributions.IncludeFriends;
import Contributor.ID.Contributions.Location;

import java.util.HashSet;
import java.util.Iterator;

public class ListsRequest {

    // The number of items to include per page (default is 20, maximum is 100).
    private int perPage;

    // Defaults to @Date, which returns lists that were most recently created/updated first. The
    // @ListPopularityWithFriends values are only available to signed-in members and consider popularity
    // amongst the signed-in member's friends.
    private ListSort sort;

    // Specify the LID of a film to return lists that include that film.
    private String film;

    // Specify the LID of a list to return lists that were cloned from that list.
    private String clonedFrom;

    // Specify a tag code to limit the returned lists to those tagged accordingly.
    private String tagCode;

    // Must be used with @tagCode. Specify the LID of a member to focus the tag filter on the member.
    private String tagger;

    // Must be used in conjunction with @tagger. Defaults to @None, which filters tags set by the member.
    // Use @Only to filter tags set by the member's friends, and @All to filter tags set by both the
    // member and their friends.
    private IncludeFriends includeTaggerFriends;

    // Specify the LID of a member to return lists that are owned or liked by the member (or their
    // friends, when used with @includeFriends.
    private String member;

    // Must be used in conjunction with @member. Defaults to @Owner, which returns lists owned by the
    // specified member. Use @Liked to return lists liked by the member.
    private MemberRelationship memberRelationship;

    // Must be used in conjunction with @member. Defaults to @None, which only returns lists from the
    // member's account. Use @Only to return lists from the member's friends, and @All to return lists
    // from both the member and their friends.
    private IncludeFriends includeFriends;

    // Specify @Clean to return lists that do not contain profane language. Specify @Published to return
    // the member's lists that have been made public. Note that unpublished lists for members other than
    // the authenticated member are never returned. Specify @NotPublished to return the authenticated
    // member's lists that have not been made public.
    private Location where;

    // Specify @NoDuplicateMembers to limit the list to only the first list for each member.
    // @NoDuplicateMembers is only available when using these sort orders: @Date, @WhenPublishedLatestFirst,
    // and @WhenCreatedLatestFirst.
    private Filter filter;

    public ListsRequest() {
        perPage = 0;
        sort = null;
        film = null;
        clonedFrom = null;
        tagCode = null;
        tagger = null;
        includeTaggerFriends = null;
        member = null;
        memberRelationship = null;
        includeFriends = null;
        where = null;
        filter = null;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public ListSort getSort() {
        return sort;
    }

    public void setSort(ListSort sort) {
        this.sort = sort;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getClonedFrom() {
        return clonedFrom;
    }

    public void setClonedFrom(String clonedFrom) {
        this.clonedFrom = clonedFrom;
    }

    public String getTagCode() {
        return tagCode;
    }

    public void setTagCode(String tagCode) {
        this.tagCode = tagCode;
    }

    public String getTagger() {
        return tagger;
    }

    public void setTagger(String tagger) {
        this.tagger = tagger;
    }

    public IncludeFriends getIncludeTaggerFriends() {
        return includeTaggerFriends;
    }

    public void setIncludeTaggerFriends(IncludeFriends includeTaggerFriends) {
        this.includeTaggerFriends = includeTaggerFriends;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public MemberRelationship getMemberRelationship() {
        return memberRelationship;
    }

    public void setMemberRelationship(MemberRelationship memberRelationship) {
        this.memberRelationship = memberRelationship;
    }

    public IncludeFriends getIncludeFriends() {
        return includeFriends;
    }

    public void setIncludeFriends(IncludeFriends includeFriends) {
        this.includeFriends = includeFriends;
    }

    public Location getWhere() {
        return where;
    }

    public void setWhere(Location where) {
        this.where = where;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public String[] getParameters() {
        // TODO getParameters()
        HashSet<String> parameters = new HashSet<>();

        if (perPage != 0)
            parameters.add("perPage=" + perPage);

        if (sort != null)
            parameters.add("sort=" + sort);

        if (film != null)
            parameters.add("film=" + film);

        if (clonedFrom != null)
            parameters.add("clonedFrom=" + clonedFrom);

        if (tagCode != null)
            parameters.add("tagCode=" + tagCode);

        if (tagger != null)
            parameters.add("tagger=" + tagger);

        if (includeTaggerFriends != null)
            parameters.add("includeTaggerFriends=" + includeTaggerFriends);

        if (member != null)
            parameters.add("member=" + member);

        if (memberRelationship != null)
            parameters.add("memberRelationship=" + memberRelationship);

        if (includeFriends != null)
            parameters.add("includeFriends=" + includeFriends);

        if (where != null)
            parameters.add("where=" + where);

        if (filter != null)
            parameters.add("filter=" + filter);

        Iterator<String> iterator = parameters.iterator();
        String[] result = new String[parameters.size()];
        for (int i = 0; i < parameters.size(); i++) {
            result[i] = iterator.next();
        }

        return result;
    }
}
