package List.ID.Comments;

import java.util.HashSet;
import java.util.Iterator;

public class CommentsRequest {

    // The number of items to include per page (default is 20, maximum is 100).
    private int perPage;

    // Defaults to @Date. The @Updates sort order returns newest content first. Use this to get
    // the most recently posted or edited comments, and pass includeDeletions=true to remain
    // consistent in the case where a comment has been deleted.
    private CommentSort sort;

    // Use this to discover any comments that were deleted.
    private boolean includeDeletions;

    public CommentsRequest() {
        perPage = 0;
        sort = null;
        includeDeletions = false;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public CommentSort getSort() {
        return sort;
    }

    public void setSort(CommentSort sort) {
        this.sort = sort;
    }

    public boolean isIncludeDeletions() {
        return includeDeletions;
    }

    public void setIncludeDeletions(boolean includeDeletions) {
        this.includeDeletions = includeDeletions;
    }

    public String[] getParameters() {
        HashSet<String> parameters = new HashSet<>();

        if (perPage != 0)
            parameters.add("perPage=" + perPage);

        if (sort != null)
            parameters.add("sort=" + sort);

        if (includeDeletions)
            parameters.add("includeDeletions=true");

        Iterator<String> iterator = parameters.iterator();
        String[] result = new String[parameters.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = iterator.next();
        }

        return result;
    }
}
