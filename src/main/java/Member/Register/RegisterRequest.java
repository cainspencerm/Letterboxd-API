package Member.Register;

import Authentication.Auth;
import Authentication.UsernameCheck.UsernameAvailability;
import Authentication.UsernameCheck.UsernameCheckResponse;

public class RegisterRequest {

    // The username for the new account. Use the /auth/username-check endpoint to check
    // availability.
    private String username;

    // The password for the new account.
    private String password;

    // The email address for the new account.
    private String emailAddress;

    // Set to true if the person creating the account has agreed to being at least 16 years
    // of age, and to accepting Letterboxd's Terms of Use
    // (https://letterboxd.com/terms-of-use/).
    private boolean acceptTermsOfUse;

    public RegisterRequest() {
        username = null;
        password = null;
        emailAddress = null;
        acceptTermsOfUse = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isAcceptTermsOfUse() {
        return acceptTermsOfUse;
    }

    public void setAcceptTermsOfUse(boolean acceptTermsOfUse) {
        this.acceptTermsOfUse = acceptTermsOfUse;
    }

    public boolean checkUsername(String username) {
        String json;
        try {
            json = Auth.request("/auth/username-check", new String[]{"username=" + username}, "GET", null);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        UsernameCheckResponse response = new UsernameCheckResponse(json);

        if (response.getResult().equals(UsernameAvailability.Available)) {
            this.username = username;
            return true;
        } else if (response.getResult().equals(UsernameAvailability.Invalid)) {
            System.err.println("Username is invalid.");
            return false;
        } else if (response.getResult().equals(UsernameAvailability.NotAvailable)) {
            System.err.println("Username is not available.");
            return false;
        } else if (response.getResult().equals(UsernameAvailability.TooLong)) {
            System.err.println("Username is too long.");
            return false;
        } else if (response.getResult().equals(UsernameAvailability.TooShort)) {
            System.err.println("Username is too short.");
            return false;
        } else {
            return false;
        }
    }
}
