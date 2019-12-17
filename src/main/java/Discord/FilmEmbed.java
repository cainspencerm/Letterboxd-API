package Discord;

import Film.ID.Film;
import Film.ID.FilmContributions;

import java.awt.Color;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class FilmEmbed extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {

        String command = "", message = "";

        if (!event.getAuthor().isBot() && event.getMessage().getContentRaw().length() > 7) {
            command = event.getMessage().getContentRaw().substring(0, 5);
            message = event.getMessage().getContentRaw().substring(6);
        }

        if (command.equalsIgnoreCase("-film")) {

            try {
                Film film = Film.getFilm(message);

                int directorCount = 0;
                for (int i = 0; i < film.getContributions().length; i++) {
                    if (film.getContributions()[i].getType().equals(FilmContributions.Type.Director))
                        directorCount++;
                }

                FilmContributions[] directorContributions = new FilmContributions[directorCount];
                for (int i = 0, j = 0; i < film.getContributions().length && j < directorCount; i++) {
                    if (film.getContributions()[i].getType().equals(FilmContributions.Type.Director)) {
                        directorContributions[j] = film.getContributions()[i];
                        j++;
                    }
                }

                String directors = "";
                for (int i = 0; i < directorCount; i++) {
                    for (int j = 0; j < directorContributions[i].getContributors().length; j++) {
                        directors += directorContributions[i].getContributors()[j].getName();

                        if (i != directorCount - 1 && j != directorContributions[i].getContributors().length)
                            directors += ", ";
                    }
                }

                EmbedBuilder embed = new EmbedBuilder();
                embed.setTitle(film.getName(), film.getLinks()[0].getUrl());
                embed.setThumbnail("https://a.ltrbxd.com/logos/letterboxd-logo-alt-v-neg-rgb-1000px.png");
                embed.setColor(new Color(21, 24, 29, 1));

                String description = "";
                if (film.getTagline() != null)
                    description += "**" + film.getTagline().toUpperCase() + "**\n\n";

                if (film.getDescription() != null) {
                    description += film.getDescription();
                    embed.setDescription(description);
                }

                if (film.getPoster() != null)
                    embed.setImage(film.getPoster().getImageSize(2).getUrl());

                if (film.getReleaseYear() != 0)
                    embed.addField(new MessageEmbed.Field("Year", "" + film.getReleaseYear(), true));

                if (!directors.equals(""))
                    embed.addField(new MessageEmbed.Field("Director(s)", directors, true));

                MessageEmbed messageEmbed = embed.build();
                event.getChannel().sendMessage(messageEmbed).queue();

            } catch (Exception e) {
                event.getChannel()
                        .sendMessage("@" + event.getAuthor().getAsTag() + ", I couldn't find that message... Did you spell it wrong?")
                        .queue();

                e.printStackTrace();
            }




        } else {
            System.err.println(message);
        }
    }
}
