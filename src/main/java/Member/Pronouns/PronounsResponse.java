package Member.Pronouns;

import Member.Pronoun;
import org.json.JSONArray;
import org.json.JSONObject;

public class PronounsResponse {

    // The list of pronouns.
    private Pronoun[] pronouns;

    public PronounsResponse(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("pronouns")) {
            JSONArray array = object.getJSONArray("pronouns");

            pronouns = new Pronoun[array.length()];
            for (int i = 0; i < pronouns.length; i++) {
                pronouns[i] = new Pronoun(array.get(i).toString());
            }
        } else {
            pronouns = null;
        }
    }

    public Pronoun[] getPronouns() {
        return pronouns;
    }
}
