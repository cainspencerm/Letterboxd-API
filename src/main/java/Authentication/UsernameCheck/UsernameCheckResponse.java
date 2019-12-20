package Authentication.UsernameCheck;

import org.json.JSONObject;

public class UsernameCheckResponse {

    // Will be @Available if the username is available to register, or @NotAvailable if used
    // by another member (or attached to a deactivated account, or otherwise reserved). May
    // return an appropriate error value if the username doesn't meet Letterboxd's
    // requirements: Usernames must be between 2 and 15 characters long and may only
    // contain upper or lowercase letters, numbers or the underscore (_) character.
    private UsernameAvailability result;

    public UsernameCheckResponse(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("result")) {
            switch (object.get("result").toString()) {
                case "Available":
                    result = UsernameAvailability.Available;
                    break;
                case "NotAvailable":
                    result = UsernameAvailability.NotAvailable;
                    break;
                case "TooShort":
                    result = UsernameAvailability.TooShort;
                    break;
                case "TooLong":
                    result = UsernameAvailability.TooLong;
                    break;
                case "Invalid":
                    result = UsernameAvailability.Invalid;
                    break;
                default:
                    result = null;
            }
        } else {
            result = null;
        }
    }

    public UsernameAvailability getResult() {
        return result;
    }
}
