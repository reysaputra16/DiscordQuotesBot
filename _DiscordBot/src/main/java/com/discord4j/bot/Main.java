package com.discord4j.bot;

import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;

public class Main {

    /**
     * The main running app for the bot
     */

    public static void main(String[] args) {
        /**
         *  Insert the token for the bot below.
         */
        DiscordClientBuilder builder = new DiscordClientBuilder("");
        DiscordClient client = builder.build();
        QuoteList quoteList = new QuoteList();

        Events.createEvent(client);
        Events.getQuote(client, quoteList);

        client.login().block();
    }

}
