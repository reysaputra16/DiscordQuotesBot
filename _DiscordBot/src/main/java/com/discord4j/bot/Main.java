package com.discord4j.bot;

import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;

public class Main {

    /**
     * The main running app for the bot
     */

    public static void main(String[] args) {
        DiscordClientBuilder builder = new DiscordClientBuilder("NzQyMjczMTk1NDEwODQ5Nzk1.XzDtyA._Ewa0JWqGlh1meIajuF1doz_jgQ");
        DiscordClient client = builder.build();
        QuoteList quoteList = new QuoteList();

        Events.createEvent(client);
        Events.getQuote(client, quoteList);

        client.login().block();
    }

}
