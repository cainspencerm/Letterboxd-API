package Search;

class SearchRequest {

    public enum SearchMethod {
        FullText, Autocomplete
    }

    public enum Include {
        ContributorSearchItem, FilmSearchItem,
        ListSearchItem, MemberSearchItem,
        ReviewSearchItem, TagSearchItem
    }

    public enum ContributionType {
        Director, CoDirector, Actor,
        Producer, Writer, Editor,
        Cinematography, ArtDirection,
        VisualEffects, Composer, Sound,
        Costumes, MakeUp, Studio
    }

    // private String cursor;
    private int perPage;
    private String input;
    private SearchMethod searchMethod;
    private Include include;
    private ContributionType contributionType;

    public SearchRequest() {
        perPage = 0;
        input = null;
        searchMethod = null;
        include = null;
        contributionType = null;
    }

    public SearchRequest(int perPage,
                         String input,
                         SearchMethod searchMethod,
                         Include include,
                         ContributionType contributionType) {
        this.perPage = perPage;
        this.input = input;
        this.searchMethod = searchMethod;
        this.include = include;
        this.contributionType = contributionType;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {

        if (perPage <= 100 && perPage > 0) {
            this.perPage = perPage;
        } else if (perPage < 0) {
            this.perPage = 20;
        } else if (perPage > 100) {
            this.perPage = 100;
        }

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

    public Include getInclude() {
        return include;
    }

    public void setInclude(Include include) {
        this.include = include;
    }

    public ContributionType getContributionType() {
        return contributionType;
    }

    public void setContributionType(ContributionType contributionType) {
        this.contributionType = contributionType;
    }

    public String[] getParameters() {

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
