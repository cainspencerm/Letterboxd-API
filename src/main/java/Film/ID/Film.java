package Film.ID;

import Authentication.Auth;
import Film.Genres.Genre;
import Image.Image;
import Link.Link;
import Film.FilmSummary;
import org.json.JSONArray;
import org.json.JSONObject;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Film {

    // The LID of the film.
    private String id;

    // The title of the film.
    private String name;

    // The original title of the film, if it was first released with a non-English title.
    private String originalName;

    // The other names by which the film is known (including alternative titles and/or foreign translations).
    private String[] alternativeNames;

    // The year in which the film was first released.
    private int releaseYear;

    // The tagline for the film.
    private String tagline;

    // A synopsis of the film.
    private String description;

    // The film's duration (in minutes).
    private int runTime;

    // The film's poster image (2:3 ratio in multiple sizes).
    private Image poster;

    // The film's backdrop image (16:9 ratio in multiple sizes).
    private Image backdrop;

    // The backdrop's vertical focal point, expressed as a proportion of the image's height, using values between 0.0 and 1.0. Use when cropping the image into a short space, such as in the page for a film on the Letterboxd site.
    private float backdropFocalPoint;

    // The film's trailer.
    private FilmTrailer trailer;

    // The film's genres.
    private Genre[] genres;

    // The film's contributors (director, cast, and crew) grouped by discipline.
    private FilmContributions[] contributions;

    // The LID of the collection containing this film.
    private String filmCollectionId;

    // A list of relevant URLs for this entity, on Letterboxd and external sites.
    private Link[] links;

    public Film(String json) {

        // Convert json string into a usable object.
        JSONObject object = new JSONObject(json);

        id = object.has("id") ? object.getString("id") : null;
        name = object.has("name") ? object.getString("name") : null;
        originalName = object.has("originalName") ? object.getString("originalName") : null;

        if (object.has("alternativeNames")) {
            JSONArray array = object.getJSONArray("alternativeNames");

            alternativeNames = new String[array.length()];
            for (int i = 0; i < alternativeNames.length; i++) {
                alternativeNames[i] = array.getString(i);
            }
        } else {
            alternativeNames = null;
        }

        releaseYear = object.has("releaseYear") ? object.getInt("releaseYear") : 0;
        tagline = object.has("tagline") ? object.getString("tagline") : null;
        description = object.has("description") ? object.getString("description") : null;
        runTime = object.has("runTime") ? object.getInt("runTime") : 0;
        poster = object.has("poster") ? new Image(object.get("poster").toString()) : null;
        backdrop = object.has("backdrop") ? new Image(object.get("backdrop").toString()) : null;
        backdropFocalPoint = object.has("backdropFocalPoint") ? object.getFloat("backdropFocalPoint") : 0.0f;
        trailer = object.has("trailer") ? new FilmTrailer(object.get("trailer").toString()) : null;

        if (object.has("genres")) {
            JSONArray array = object.getJSONArray("genres");

            genres = new Genre[array.length()];
            for (int i = 0; i < genres.length; i++) {
                genres[i] = new Genre(array.get(i).toString());
            }
        } else {
            genres = null;
        }

        if (object.has("contributions")) {
            JSONArray array = object.getJSONArray("contributions");

            contributions = new FilmContributions[array.length()];
            for (int i = 0; i < contributions.length; i++) {
                contributions[i] = new FilmContributions(array.get(i).toString());
            }
        } else {
            contributions = null;
        }

        filmCollectionId = object.has("filmCollectionId") ? object.getString("filmCollectionId") : null;

        if (object.has("links")) {
            JSONArray array = object.getJSONArray("links");

            links = new Link[array.length()];
            for (int i = 0; i < links.length; i++) {
                links[i] = new Link(array.get(i).toString());
            }
        } else {
            links = null;
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String[] getAlternativeNames() {
        return alternativeNames;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getTagline() {
        return tagline;
    }

    public String getDescription() {
        return description;
    }

    public int getRunTime() {
        return runTime;
    }

    public Image getPoster() {
        return poster;
    }

    public Image getBackdrop() {
        return backdrop;
    }

    public float getBackdropFocalPoint() {
        return backdropFocalPoint;
    }

    public FilmTrailer getTrailer() {
        return trailer;
    }

    public Genre[] getGenres() {
        return genres;
    }

    public FilmContributions[] getContributions() {
        return contributions;
    }

    public String getFilmCollectionId() {
        return filmCollectionId;
    }

    public Link[] getLinks() {
        return links;
    }

    public static Film getFilm(String film) throws NoSuchAlgorithmException, InvalidKeyException {
        FilmSummary filmSummary = Search.Search.getFilm(film);
        return new Film(Auth.request("/film/" + filmSummary.getId(), null, "GET", null));
    }
}
