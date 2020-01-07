package Member.ID.Watchlist;

import Contributor.ID.Contributions.IncludeFriends;
import Member.MemberRelationship;

import java.util.HashSet;
import java.util.Iterator;

public class WatchlistRequest {

    public enum WatchlistSort {
        Added, FilmName, OwnerRatingHighToLow, OwnerRatingLowToHigh,
        AuthenticatedMemberRatingHighToLow, AuthenticatedMemberRatingLowToHigh,
        MemberRatingHighToLow, MemberRatingLowToHigh, AverageRatingHighToLow,
        AverageRatingLowToHigh, ReleaseDateLatestFirst, ReleaseDateEarliestFirst,
        FilmDurationShortestFirst, FilmDurationLongestFirst, FilmPopularity,
        RatingHighToLow, RatingLowToHigh, FilmPopularityThisWeek,
        FilmPopularityThisMonth, FilmPopularityThisYear
    }

    public enum WatchlistWhere {
        Released, NotReleased, InWatchlist, NotInWatchlist, WatchedFromWatchlist,
        Watched, NotWatched, FeatureLength, NotFeatureLength
    }

    // The number of items to include per page (default is 20, maximum is 100).
    private int perPage;

    // The order in which the entries should be returned. Defaults to Added, which is the
    // order that the films were added to the watchlist, most recent first.
    //
    // The AuthenticatedMemberRating values are only available to signed-in members.
    //
    // The MemberRating values must be used in conjunction with member and are only available
    // when specifying a single member (i.e. IncludeFriends=None).
    private WatchlistSort sort;

    // Specify up to 100 Letterboxd IDs or TMDB IDs prefixed with tmdb:, or IMDB IDs prefixed
    // with imdb:.
    private String[] filmId;

    // Specify the LID of a genre to limit films to those within films to those within the
    // specified genre.
    private String genre;

    // Specify the starting year of a decade (must end in 0) to limit films to those released
    // during the decade.
    private int decade;

    // Specify the year to limit films to those released during the decade.
    private int year;

    // Specify the ID of a supported service to limit films to those available from that
    // service. The list of available services can be found by using the /films/film-services
    // endpoint.
    private String service;

    // Specify one or more values to limit the list of films accordingly.
    private WatchlistWhere where;

    // Specify the LID of a member to limit the returned films according to the value set in
    // @memberRelationship or to access the @MemberRatingHighToLow and @MemberRatingLowToHigh
    // sort options. The member and memberRelationship parameters can be used to compute
    // comparisons between the watchlist owner and another member.
    private String member;

    // Must be used in conjunction with @member. Defaults to @Watched. Specify the type of
    // relationship to limit the returned films accordingly. Use @Ignore if you only intend
    // to specify the member for use with sort=MemberRatingHighToLow or
    // sort=MemberRatingLowToHigh.
    private MemberRelationship memberRelationship;

    // Must be used in conjunction with @member. Defaults to @None, which only returns films
    // from the member’s account. Use @Only to return films from the member’s friends, and
    // @All to return films from both the member and their friends.
    private IncludeFriends includeFriends;

    // Specify a tag code to limit the returned films to those tagged accordingly.
    private String tagCode;

    // Must be used with @tagCode. Specify the LID of a member to focus the tag filter on
    // the member.
    private String tagger;

    // Must be used in conjunction with tagger. Defaults to None, which filters tags set by
    // the member. Use Only to filter tags set by the member’s friends, and All to filter
    // tags set by both the member and their friends.
    private IncludeFriends includeTaggerFriends;

    public WatchlistRequest() {
        perPage = 0;
        sort = null;
        filmId = null;
        genre = null;
        decade = 0;
        year = 0;
        service = null;
        where = null;
        member = null;
        memberRelationship = null;
        includeFriends = null;
        tagCode = null;
        tagger = null;
        includeTaggerFriends = null;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public WatchlistSort getSort() {
        return sort;
    }

    public void setSort(WatchlistSort sort) {
        this.sort = sort;
    }

    public String[] getFilmId() {
        return filmId;
    }

    public void setFilmId(String[] filmId) {
        this.filmId = filmId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDecade() {
        return decade;
    }

    public void setDecade(int decade) {
        this.decade = decade;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public WatchlistWhere getWhere() {
        return where;
    }

    public void setWhere(WatchlistWhere where) {
        this.where = where;
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

    public String[] getParameters() {
        HashSet<String> set = new HashSet<>();

        if (perPage != 0)
            set.add("perPage=" + perPage);

        if (sort != null)
            set.add("sort=" + sort);

        if (filmId != null)
            for (String s : filmId)
                set.add("filmId=" + s);

        if (genre != null)
            set.add("genre=" + genre);

        if (decade != 0)
            set.add("decade=" + decade);

        if (year != 0)
            set.add("year=" + year);

        if (service != null)
            set.add("service=" + service);

        if (where != null)
            set.add("where=" + where);

        if (member != null)
            set.add("member=" + member);

        if (memberRelationship != null)
            set.add("memberRelationship=" + memberRelationship);

        if (includeFriends != null)
            set.add("includeFriends=" + includeFriends);

        if (tagCode != null)
            set.add("tagCode=" + tagCode);

        if (tagger != null)
            set.add("tagger=" + tagger);

        if (includeTaggerFriends != null)
            set.add("includeTaggerFriends=" + includeTaggerFriends);

        String[] parameters = new String[set.size()];
        Iterator<String> iterator = set.iterator();
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = iterator.next();
        }

        return parameters;
    }
}
