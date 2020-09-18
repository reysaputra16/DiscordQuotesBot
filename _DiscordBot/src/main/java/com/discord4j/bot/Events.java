package com.discord4j.bot;

import discord4j.core.DiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;

public class Events {

    public static void createEvent(DiscordClient client) {
        client.getEventDispatcher().on(ReadyEvent.class)
                .subscribe(event -> {
                    User self = event.getSelf();
                    System.out.println(String.format("Logged in as %s#%s", self.getUsername(), self.getDiscriminator()));
                });
    }

    public static void getQuote(DiscordClient client, QuoteList quoteList) {
        client.getEventDispatcher().on(MessageCreateEvent.class)
                .map(MessageCreateEvent::getMessage)
                .filterWhen(message -> message.getAuthor().map(user -> !user.isBot()))
                .filter(message -> message.getContent().orElse("").equalsIgnoreCase("!quotes"))
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage(quoteList.getRandomQuote()))
                .subscribe();
    }
}
