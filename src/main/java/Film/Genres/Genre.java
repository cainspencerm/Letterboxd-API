package Film.Genres;

import org.json.JSONObject;

public class Genre {

    // The LID of the genre.
    private String id;

    // The name of the genre.
    private String name;

    public Genre(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        id = object.has("id") ? object.getString("id") : null;
        name = object.has("name") ? object.getString("id") : null;
    }

    public String getId() { return id; }

    public String getName() {
        return name;
    }

//    public static Film.Genres.Genre[] getGenres() throws NoSuchAlgorithmException, InvalidKeyException {
//        // Request JSON file from API.
//        String json = Auth.request("/films/genres", null, "GET", null);
//
//        // Create JSON object from json String.
//        JSONObject object = new JSONObject(json);
//        JSONArray array = object.getJSONArray("items");
//
//        // Create an array of genres to store json data.
//        Film.Genres.Genre[] genres = new Film.Genres.Genre[array.length()];
//
//        // Initialize and store data in genre array.
//        for (int i = 0; i < genres.length; i++) {
//            genres[i] = new Film.Genres.Genre(
//                    array.getJSONObject(i).get("id").toString(),
//                    array.getJSONObject(i).get("name").toString()
//            );
//        }
//
//        return genres;
//    }

}
