package Search;

import Contributor.ID.ContributionType;

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
        // TODO Replace with new syntax using HashSet.

        // Count the number of parameters.
        int numParams = 0;
        if (perPage != 0) numParams++;
        if (input != null) numParams++;
        if (searchMethod != null) numParams++;
        if (include != null) numParams++;
        if (contributionType != null) numParams++;

        // Fill an array with all applicable parameters.
        String[] parameters = new String[numParams];
        int i = 0;
        if (perPage != 0) {
            parameters[i] = "perPage=" + perPage;
            i++;
        }

        if (input != null) {
            // Ensure the search is alphanumeric with dashed (-) spaces.
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                if (Character.isAlphabetic(input.charAt(j)) || Character.isDigit(input.charAt(j))) {
                    temp.append(input.charAt(j));
                } else if (input.charAt(j) == ' ') {
                    temp.append('-');
                }
            }

            parameters[i] = "input=" + temp;
            i++;
        }

        if (searchMethod != null) {
            parameters[i] = "searchMethod=" + searchMethod;
            i++;
        }

        if (include != null) {
            parameters[i] = "include=" + include;
            i++;
        }

        if (contributionType != null) {
            parameters[i] = "contributionType=" +contributionType;
        }

        return parameters;
    }
}
