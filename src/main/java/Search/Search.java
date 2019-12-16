package Search;

import Authentication.Auth;
import Search.Item.AbstractSearchItem;
import Search.Item.Contributor.Contributor;
import Search.Item.Film.FilmSearchItem;
import Search.Item.Film.FilmSummary;
import Search.Item.List.ListSearchItem;
import Search.Item.List.ListSummary;
import Search.Item.Member.MemberSearchItem;
import Search.Item.Member.MemberSummary;
import Search.Item.Review.LogEntry;
import Search.Item.Review.ReviewSearchItem;
import Search.Item.Tag.Tag;
import Search.Item.Tag.TagSearchItem;

public class Search {

    public static Contributor getActor(String name) {
        // Create a search request.
        SearchRequest request = new SearchRequest();
        request.setInput(name);
        request.setInclude(SearchRequest.Include.ContributorSearchItem);
        request.setContributionType(SearchRequest.ContributionType.Actor);

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
        Contributor actor = null;
        for (int i = 0; i < response.getItems().length; i++) {
            if (response.getItems()[i] != null &&
                    response.getItems()[i].getType().equals(AbstractSearchItem.Type.ContributorSearchItem))
                actor = (Contributor) response.getItems()[i].getItem();
        }

        if (actor != null)
            return actor;
        else throw new NullPointerException();
    }

    public static FilmSummary getFilm(String film) {
        // Create a search request.
        SearchRequest request = new SearchRequest();
        request.setInput(film);
        request.setInclude(SearchRequest.Include.FilmSearchItem);

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
            if (response.getItems()[i] != null && response.getItems()[i].getType().equals(AbstractSearchItem.Type.FilmSearchItem)) {
                filmSearchItem = (FilmSearchItem) response.getItems()[i].getItem();
                break;
            }
        }

        if (filmSearchItem != null)
            return filmSearchItem.getFilm();
        else throw new NullPointerException();
    }

    public static String getFilmURL(FilmSummary film) {
        return film.getLinks()[0].getUrl();
    }

    public static String getFilmURL(String film) {
        return getFilm(film).getLinks()[0].getUrl();
    }

    public static ListSummary getList(String title) {
        // Create a search request.
        SearchRequest request = new SearchRequest();
        request.setInput(title);
        request.setInclude(SearchRequest.Include.ListSearchItem);

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
            if (response.getItems()[i] != null && response.getItems()[i].getType().equals(AbstractSearchItem.Type.ListSearchItem)) {
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
        request.setInclude(SearchRequest.Include.MemberSearchItem);

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
            if (response.getItems()[i].getType().equals(AbstractSearchItem.Type.MemberSearchItem)) {
                MemberSearchItem item = (MemberSearchItem) response.getItems()[i];
                return item.getMember();
            }
        }

        return null;
    }

    public static LogEntry getReview(String review) {
        SearchRequest request = new SearchRequest();
        request.setInput(review);
        request.setInclude(SearchRequest.Include.ReviewSearchItem);

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
            if (response.getItems()[i].getType().equals(AbstractSearchItem.Type.ReviewSearchItem)) {
                ReviewSearchItem item = (ReviewSearchItem) response.getItems()[i];
                return item.getReview();
            }
        }

        return null;
    }

    public static Tag getTag(String tag) {
        SearchRequest request = new SearchRequest();
        request.setInput(tag);
        request.setInclude(SearchRequest.Include.TagSearchItem);

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

            if (response.getItems()[i].getType().equals(AbstractSearchItem.Type.TagSearchItem)) {
                TagSearchItem item = (TagSearchItem) response.getItems()[i];
                return item.getTag();
            }
        }

        return null;
    }
}
