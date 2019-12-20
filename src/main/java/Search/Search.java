package Search;

import Authentication.Auth;
import Contributor.ID.Contributor;
import Contributor.ID.ContributionType;
import Search.Item.AbstractSearchItemType;
import Search.Item.ContributorSearchItem;
import Search.Item.FilmSearchItem;
import Film.FilmSummary;
import Search.Item.ListSearchItem;
import List.ListSummary;
import Search.Item.MemberSearchItem;
import Member.MemberSummary;
import LogEntry.LogEntry;
import Search.Item.ReviewSearchItem;
import Search.Item.Tag;
import Search.Item.TagSearchItem;

public class Search {

    public static Contributor getActor(String name) {
        // Create a search request.
        SearchRequest request = new SearchRequest();
        request.setInput(name);
        request.setInclude(SearchResultType.ContributorSearchItem);
        request.setContributionType(ContributionType.Actor);

        // Request json data.
        String json = null;
        try {
            json = Auth.request("/search", request.getParameters(), "GET", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Store json data.
        SearchResponse response = new SearchResponse(json);

        // Find first actor.
        ContributorSearchItem actor = null;
        for (int i = 0; i < response.getItems().length; i++) {
            if (response.getItems()[i] != null &&
                    response.getItems()[i].getType().equals(AbstractSearchItemType.ContributorSearchItem))
                actor = (ContributorSearchItem) response.getItems()[i].getItem();
        }

        if (actor != null)
            return actor.getContributor();
        else throw new NullPointerException();
    }

    public static FilmSummary getFilm(String film) {
        // Create a search request.
        SearchRequest request = new SearchRequest();
        request.setInput(film);
        request.setInclude(SearchResultType.FilmSearchItem);

        // Request JSON data.
        String json = null;
        try {
            json = Auth.request("/search", request.getParameters(), "GET", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Store JSON data.
        SearchResponse response = new SearchResponse(json);

        // Store the first search item (closest to search input).
        FilmSearchItem filmSearchItem = null;
        for (int i = 0; i < response.getItems().length; i++) {
            if (response.getItems()[i] != null && response.getItems()[i].getType().equals(AbstractSearchItemType.FilmSearchItem)) {
                filmSearchItem = (FilmSearchItem) response.getItems()[i].getItem();
                break;
            }
        }

        if (filmSearchItem != null)
            return filmSearchItem.getFilm();
        else throw new NullPointerException();
    }

    public static ListSummary getList(String title) {
        // Create a search request.
        SearchRequest request = new SearchRequest();
        request.setInput(title);
        request.setInclude(SearchResultType.ListSearchItem);

        // Request JSON data.
        String json = null;
        try {
            json = Auth.request("/search", request.getParameters(), "GET", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Store JSON data.
        SearchResponse response = new SearchResponse(json);

        // Store the first search item (closest to search input).
        ListSearchItem list = null;
        for (int i = 0; i < response.getItems().length; i++) {
            if (response.getItems()[i] != null && response.getItems()[i].getType().equals(AbstractSearchItemType.ListSearchItem)) {
                list = (ListSearchItem) response.getItems()[i].getItem();
                break;
            }

            // List not found.
            if (i == response.getItems().length - 1) {
                return null;
            }
        }

        assert list != null;
        return list.getList();
    }

    public static MemberSummary getMember(String member) {
        // Create a search request.
        SearchRequest request = new SearchRequest();
        request.setInput(member);
        request.setInclude(SearchResultType.MemberSearchItem);

        // Request JSON data.
        String json = null;
        try {
            json = Auth.request("/search", request.getParameters(), "GET", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Store JSON data.
        SearchResponse response = new SearchResponse(json);

        // Find first member.
        for (int i = 0; i < response.getItems().length; i++) {
            if (response.getItems()[i].getType().equals(AbstractSearchItemType.MemberSearchItem)) {
                MemberSearchItem item = (MemberSearchItem) response.getItems()[i];
                return item.getMember();
            }
        }

        return null;
    }

    public static LogEntry getReview(String review) {
        SearchRequest request = new SearchRequest();
        request.setInput(review);
        request.setInclude(SearchResultType.ReviewSearchItem);

        // Request JSON data.
        String json = null;
        try {
            json = Auth.request("/search", request.getParameters(), "GET", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Store JSON data.
        SearchResponse response = new SearchResponse(json);

        // Find first review.
        for (int i = 0; i < response.getItems().length; i++) {
            if (response.getItems()[i].getType().equals(AbstractSearchItemType.ReviewSearchItem)) {
                ReviewSearchItem item = (ReviewSearchItem) response.getItems()[i];
                return item.getReview();
            }
        }

        return null;
    }

    public static Tag getTag(String tag) {
        SearchRequest request = new SearchRequest();
        request.setInput(tag);
        request.setInclude(SearchResultType.TagSearchItem);

        // Request JSON data.
        String json = null;
        try {
            json = Auth.request("/search", request.getParameters(), "GET", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Store JSON data.
        SearchResponse response = new SearchResponse(json);

        // Find first tag.
        for (int i = 0; i < response.getItems().length; i++) {

            if (response.getItems()[i].getType() == null) {
                continue;
            }

            if (response.getItems()[i].getType().equals(AbstractSearchItemType.TagSearchItem)) {
                TagSearchItem item = (TagSearchItem) response.getItems()[i];
                return item.getTag();
            }
        }

        return null;
    }
}
