package Member.ID.Report;

public class ReportMemberRequest {

    public enum Reason {
        SpamAccount, Other
    }

    // The reason why the member was reported.
    private Reason reason;

    // An optional, explanatory message to accompany the report. Required if the @reason is @Other.
    private String message;

    public ReportMemberRequest() {
        reason = null;
        message = null;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
