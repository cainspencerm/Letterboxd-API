package Contributor.ID.Contributions;

import Contributor.ID.Contributor.ContributionType;
import Search.Item.Film.FilmSummary;
import org.json.JSONObject;

public class FilmContribution {

    // The type of contribution.
    private ContributionType type;

    // The film.
    private FilmSummary film;

    // The name of the character (only when @type is @Actor);
    private String characterName;

    public FilmContribution(String json) {

        // Convert the json string into a usable object.
        JSONObject object = new JSONObject(json);

        if (object.has("type")) {
            switch (object.get("type").toString()) {
                case "Director":
                    type = ContributionType.Director;
                    break;
                case "CoDirector":
                    type = ContributionType.CoDirector;
                    break;
                case "Actor":
                    type = ContributionType.Actor;
                    break;
                case "Producer":
                    type = ContributionType.Producer;
                    break;
                case "Writer":
                    type = ContributionType.Writer;
                    break;
                case "Editor":
                    type = ContributionType.Editor;
                    break;
                case "Cinematography":
                    type = ContributionType.Cinematography;
                    break;
                case "ArtDirection":
                    type = ContributionType.ArtDirection;
                    break;
                case "VisualEffects":
                    type = ContributionType.VisualEffects;
                    break;
                case "Composer":
                    type = ContributionType.Composer;
                    break;
                case "Sound":
                    type = ContributionType.Sound;
                    break;
                case "Costumes":
                    type = ContributionType.Costumes;
                    break;
                case "MakeUp":
                    type = ContributionType.MakeUp;
                    break;
                case "Studio":
                    type = ContributionType.Studio;
                    break;
                default:
                    type = null;
            }
        } else {
            type = null;
        }

        film = object.has("film") ? new FilmSummary(object.get("film").toString()) : null;
        characterName = object.has("characterName") ? object.getString("characterName") : null;
    }

    public ContributionType getType() {
        return type;
    }

    public FilmSummary getFilm() {
        return film;
    }

    public String getCharacterName() {
        return characterName;
    }
}
