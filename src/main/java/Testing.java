
import Search.Item.Contributor.Contributor;
import Search.Item.List.ListSummary;
import Search.Item.Member.MemberSummary;
import Search.Item.Review.LogEntry;
import Search.Item.Tag.Tag;
import Search.Search;
import Search.Item.Film.FilmSummary;

import javax.security.auth.login.LoginException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;



public class Testing {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, LoginException {

        //---------------------- Search usage examples. ----------------------//

        System.out.println("\n---------------------- Search usage examples. ---------------------\n");

        // Print the film.
        FilmSummary film = Search.getFilm("Interstellar");

        System.out.println(film.getName());

        for (int i = 0; i < film.getDirectors().length; i++) {
            if (i == 0)
                System.out.print(film.getDirectors()[i].getName());
            else
                System.out.print(", " + film.getDirectors()[i].getName());
        }
        System.out.println();

        System.out.println(film.getId());

        for (int i = 0; i < film.getLinks().length; i++) {
            if (film.getLinks()[i].getUrl().contains("letterboxd")) {
                System.out.println(film.getLinks()[i].getUrl());
                break;
            }
        }
        System.out.println();

        // Print the actor.
        Contributor actor = Search.getActor("Matthew McConaughey");
        System.out.println(actor.getName());

        int[] filmCount = new int[actor.getStatistics().getContributions().length];
        String[] contribution = new String[actor.getStatistics().getContributions().length];
        for (int i = 0; i < filmCount.length; i++) {
            filmCount[i] = actor.getStatistics().getContributions()[i].getFilmCount();
            contribution[i] = actor.getStatistics().getContributions()[i].getType().toString();
        }

        System.out.println("Appearances: ");

        for (int i = 0; i < filmCount.length; i++) {
            System.out.println(contribution[i] + " of " + filmCount[i] + " films.");
        }

        System.out.println(actor.getId());
        System.out.println(actor.getLinks()[0].getUrl());
        System.out.println();

        // Print the list.
        ListSummary list = Search.getList("INTERSTELLAR");
        System.out.println(list.getName());

        String descriptionBefore = list.getDescription().substring(3), descriptionAfter = "Description: ";
        for (int i = 0, j = 13; i < descriptionBefore.length() - 4; i++, j++) {
            if (j > 70 && Character.isWhitespace(descriptionBefore.charAt(i))) {
                descriptionAfter += "\n";
                j = 0;
            } else {
                descriptionAfter += descriptionBefore.charAt(i);
            }
        }
        System.out.println(descriptionAfter);

        System.out.println("Films: ");
        for (int i = 0; i < list.getPreviewEntries().length; i++) {
            System.out.println((i + 1) + ") " + list.getPreviewEntries()[i].getFilm().getName());
        }
        System.out.println();

        // Print the member.
        MemberSummary member = Search.getMember("cainspence1");
        System.out.println("Member name: " + member.getUsername());
        System.out.println("Real name: " + member.getGivenName() + " " + member.getFamilyName());
        System.out.println("Avatar: " + member.getAvatar().getImageSizes()[0].getUrl());
        System.out.println();

        // Print the review.
        LogEntry review = Search.getReview("interstellar 2014 christopher nolan");
        System.out.println(review.getFilm().getName());
        System.out.println(review.getReview().getText());
        System.out.println(review.getReview().getWhenReviewed());
        System.out.println();

        // Print the tag.
        Tag tag = Search.getTag("christopher nolan");
        System.out.println(tag.getDisplayTag());
        System.out.println(tag.getCode());
        System.out.println();
    }
}