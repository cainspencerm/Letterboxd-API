package Member.ID.ListTags;

public class MemberTagsRequest {

    // A case-insensitive prefix match. E.g. "pro" will match "pro", "project", and
    // "Professional". An empty @input will match all tags.
    private String input;

    public MemberTagsRequest() {
        input = null;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String[] getParameters() {
        if (input != null)
            return new String[]{"input=" + input};
        else
            return null;
    }
}
