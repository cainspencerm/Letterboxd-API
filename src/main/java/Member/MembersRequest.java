package Member;

import java.util.HashSet;
import java.util.Iterator;

public class MembersRequest {

    public enum MemberSort {
        Date, Name, MemberPopularity, MemberPopularityThisWeek,
        MemberPopularityThisMonth, MemberPopularityThisYear,
        MemberPopularityWithFriends, MemberPopularityWithFriendsThisWeek,
        MemberPopularityWithFriendsThisMonth, MemberPopularityWithFriendsThisYear
    }

    public enum MemberFollows {
        IsFollowing, IsFollowedBy
    }

    public enum FilmStatus {
        Ignore, Watched, NotWatched, Liked, NotLiked,
        InWatchlist, NotInWatchlist, Favorited
    }

    // The number of items to include per page (default is 20, maximum is 100).
    private int perPage;

    // Defaults to @Date, which has different semantics based on the request:
    //      When @review is specified, members who most recently liked the review appear first.
    //      When @list is specified, members who most recently liked the list appear first.
    //      When @film is specified and filmRelationship=Watched, members who most recently
    //      watched the film appear first.
    //      When @film is specified and filmRelationship=Liked, members who most recently
    //      liked the film appear first.
    //      When @film is specified and filmRelationship=InWatchlist, members who most recently
    //      added the film to their watchlist appear first.
    //      When @member is specified and memberRelationship=IsFollowing, most recently
    //      followed members appear first.
    //      When @member is specified and memberRelationship=IsFollowedBy, most recent followers
    //      appear first.

    // Otherwise, members who most recently joined the site appear first.

    // The @PopularWithFriends values are only available to authenticated members and consider
    // popularity amongst the member’s friends.
    private MemberSort sort;

    // Specify the LID of a member to return members who follow or are followed by that member.
    private String member;

    // Must be used in conjunction with @member. Defaults to @IsFollowing, which returns the
    // list of members followed by the @member. Use @IsFollowedBy to return the list of
    // members that follow the @member.
    private MemberFollows memberRelationship;

    // Specify the LID of a film to return members who have interacted with that film.
    private String film;

    // Must be used in conjunction with @film. Defaults to @Watched, which returns the list
    // of members who have seen the @film. Specify the type of relationship to limit the
    // returned members accordingly. You must specify a @member in order to use the @InWatchlist
    // relationship.
    private MemberRelationship filmRelationship;

    // Specify the LID of a list to return members who like that list.
    private String list;

    // Specify the LID of a review to return members who like that review.
    private String review;

    public MembersRequest() {
        perPage = 0;
        sort = null;
        member = null;
        memberRelationship = null;
        film = null;
        filmRelationship = null;
        list = null;
        review = null;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public MemberSort getSort() {
        return sort;
    }

    public void setSort(MemberSort sort) {
        this.sort = sort;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public MemberFollows getMemberRelationship() {
        return memberRelationship;
    }

    public void setMemberRelationship(MemberFollows memberRelationship) {
        this.memberRelationship = memberRelationship;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public MemberRelationship getFilmRelationship() {
        return filmRelationship;
    }

    public void setFilmRelationship(MemberRelationship filmRelationship) {
        this.filmRelationship = filmRelationship;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String[] getParameters() {
        HashSet<String> set = new HashSet<>();

        if (perPage != 0)
            set.add("perPage=" + perPage);

        if (sort != null)
            set.add("sort=" + sort);

        if (member != null)
            set.add("member=" + member);

        if (memberRelationship != null)
            set.add("memberRelationship=" + memberRelationship);

        if (film != null)
            set.add("film=" + film);

        if (filmRelationship != null)
            set.add("filmRelationship=" + filmRelationship);

        if (list != null)
            set.add("list=" + list);

        if (review != null)
            set.add("review=" + review);

        String[] parameters = new String[set.size()];
        Iterator<String> iterator = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            parameters[i] = iterator.next();
        }

        return parameters;
    }
}
