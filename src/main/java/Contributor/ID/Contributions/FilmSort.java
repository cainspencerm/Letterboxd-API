package Contributor.ID.Contributions;

public enum FilmSort {
    FilmName, ReleaseDateLatestFirst, ReleaseDateEarliestFirst,
    AuthenticatedMemberRatingHighToLow, AuthenticatedMemberRatingLowToHigh,
    MemberRatingHighToLow, MemberRatingLowToHigh, AverageRatingHighToLow,
    AverageRatingLowToHigh, @Deprecated RatingHighToLow, @ Deprecated RatingLowToHigh,
    FilmDurationShortestFirst, FilmDurationLongestFirst, FilmPopularity,
    FilmPopularityThisWeek, FilmPopularityThisMonth, FilmPopularityThisYear
}
