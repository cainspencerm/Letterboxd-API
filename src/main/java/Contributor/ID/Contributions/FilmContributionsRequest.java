package Contributor.ID.Contributions;

import Contributor.ID.ContributionType;

import java.util.HashSet;
import java.util.Iterator;

public class FilmContributionsRequest {

    // The number of items to include per page (default is 20, maximum is 100).
    private int perPage;

    // The order in which the films should be returned. Defaults to @FilmPopularity,
    // which is an all-time measurement of the amount of activity the film has
    // received. The @FilmPopularityWithFriends values are only available to
    // signed-in members and consider popularity amongst the signed-in member’s
    // friends. The @AuthenticatedMemberRating values are only available to signed-in
    // members. The @MemberRating values must be used in conjunction with @member and
    // are only available when specifying a single member (i.e. IncludeFriends=None).
    private FilmSort sort;

    // Specify up to 100 Letterboxd IDs or TMDB IDs prefixed with tmdb:, or IMDB
    // IDs prefixed with imdb:. Example: 'filmId=b8wK&filmId=imdb:tt1396484'.
    private String[] filmId;

    // The type of contribution.
    private ContributionType type;

    // Specify the LID of a genre to limit films to those within the specified genre.
    private String genre;

    // Specify the starting year of a decade (must end in 0) to limit films to those
    // released during the decade.
    private int decade;

    // Specify a year to limit films to those released during that year.
    private int year;

    // Specify the ID of a supported service to limit films to those available from
    // that service. The list of available services can be found by using the
    // /films/film-services endpoint.
    private String service;

    // Specify one or more values to limit the list of films accordingly. Example:
    // 'where=Watched&where=Released'.
    private Location where;

    // Specify the LID of a member to limit the returned films according to the
    // value set in @memberRelationship or to access the @MemberRatingHighToLow and
    // @MemberRatingLowToHigh sort options.
    private String member;

    // Must be used in conjunction with member. Defaults to @Watched. Specify the
    // type of relationship to limit the returned films accordingly. Use Ignore if
    // you only intend to specify the member for use with 'sort=MemberRatingHighToLow'
    // or 'sort=MemberRatingLowToHigh'.
    private MemberRelationship memberRelationship;

    // Must be used in conjunction with @member. Defaults to @None, which only
    // returns films from the member's account. Use @Only to return films from
    // the member's friends, and @All to return films from both the member and
    // their friends.
    private IncludeFriends includeFriends;

    // Specify a tag code to limit the returned films to those tagged accordingly.
    private String tagCode;

    // Must be used with @tagCode. Specify the LID of a member to focus the tag
    // filter on the member.
    private String tagger;

    // Must be used in conjunction with @tagger. Defaults to @None, which filters
    // tags set by the member. Use @Only to filter tags set by the member’s friends,
    // and @All to filter tags set by both the member and their friends.
    private IncludeFriends includeTaggerFriends;

    public FilmContributionsRequest() {
        perPage = 0;
        sort = null;
        filmId = null;
        type = null;
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

    public FilmSort getSort() {
        return sort;
    }

    public void setSort(FilmSort sort) {
        this.sort = sort;
    }

    public String[] getFilmId() {
        return filmId;
    }

    public void setFilmId(String[] filmId) {
        this.filmId = filmId;
    }

    public ContributionType getType() {
        return type;
    }

    public void setType(ContributionType type) {
        this.type = type;
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

    public Location getWhere() {
        return where;
    }

    public void setWhere(Location where) {
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
        // Count changes to parameters.
        HashSet<String> parameterSet = new HashSet<>();

        if (perPage != 0)
            parameterSet.add("perPage=" + perPage);

        if (sort != null)
            parameterSet.add("sort=" + sort);

        if (filmId != null)
            for (String s : filmId) {
                parameterSet.add("filmId=" + s);
            }

        if (type != null)
            parameterSet.add("type=" + type);

        if (genre != null)
            parameterSet.add("genre=" + genre);

        if (decade != 0)
            parameterSet.add("decade=" + decade);

        if (year != 0)
            parameterSet.add("year=" + year);

        if (service != null)
            parameterSet.add("service=" + service);

        if (where != null)
            parameterSet.add("where=" + where);

        if (member != null)
            parameterSet.add("member=" + member);

        if (memberRelationship != null)
            parameterSet.add("memberRelationship=" + memberRelationship);

        if (includeFriends != null)
            parameterSet.add("includeFriends=" + includeFriends);

        if (tagCode != null)
            parameterSet.add("tagCode=" + tagCode);

        if (includeTaggerFriends != null)
            parameterSet.add("includeTaggerFriends=" + includeTaggerFriends);

        Iterator<String> iterator = parameterSet.iterator();
        String[] parameters = new String[parameterSet.size()];
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = iterator.next();
        }

        return parameters;

    }


}
