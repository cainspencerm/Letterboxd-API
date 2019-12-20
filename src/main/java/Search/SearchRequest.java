package Search;

import Contributor.ID.ContributionType;

import java.util.HashSet;
import java.util.Iterator;

public class SearchRequest {

    // The number of items to include per page (default is 20, maximum is 100).
    private int perPage;

    // The word, partial word or phrase to search for.
    private String input;

    // The type of search to perform. Defaults to @FullText, which preforms a standard search
    // considering text in all fields. @Autocomplete only searches primary fields.
    private SearchMethod searchMethod;

    // The types of results to search for. Default to all SearchResultTypes.
    private SearchResultType include;

    // The type of contributor to search for. Implies 'include=ContributorSearchItem'.
    private ContributionType contributionType;

    public SearchRequest() {
        perPage = 20;
        input = null;
        searchMethod = SearchMethod.Autocomplete;
        include = null;
        contributionType = null;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public SearchMethod getSearchMethod() {
        return searchMethod;
    }

    public void setSearchMethod(SearchMethod searchMethod) {
        this.searchMethod = searchMethod;
    }

    public SearchResultType getInclude() {
        return include;
    }

    public void setInclude(SearchResultType include) {
        this.include = include;
    }

    public ContributionType getContributionType() {
        return contributionType;
    }

    public void setContributionType(ContributionType contributionType) {
        this.contributionType = contributionType;
    }

    public String[] getParameters() {
        HashSet<String> parameters = new HashSet<>();

        if (perPage != 0)
            parameters.add("perPage=" + perPage);

        if (input != null)
            parameters.add("input=" + input);

        if (searchMethod != null)
            parameters.add("searchMethod=" + searchMethod);

        if (include != null)
            parameters.add("include=" + include);

        if (contributionType != null)
            parameters.add("contributionType=" + contributionType);

        // Fill an array with all applicable parameters.
        Iterator<String> iterator = parameters.iterator();
        String[] result = new String[parameters.size()];
        for (int i = 0; i < parameters.size(); i++) {
            result[i] = iterator.next();
        }

        return result;
    }
}
