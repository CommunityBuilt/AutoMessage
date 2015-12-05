package com.TeamNovus.AutoMessage.Models;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class MessageList {

    private boolean enabled = true;
    private int interval = 45;
    private boolean random = false;
    private List<Message> messages = new LinkedList<Message>();

    private transient int currentIndex = 0;

    public MessageList() {
        messages.add(new Message("First message in the list!"));
        messages.add(new Message("&aSecond message in the list with formatters!"));
        messages.add(new Message("&bThird message in the list with formatters and a \nnew line!"));
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public boolean isRandom() {
        return random;
    }

    public void setRandom(boolean random) {
        this.random = random;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public Message getMessage(Integer index) {
        try {
            return this.messages.get(index.intValue());
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void addMessage(Integer index, Message message) {
        try {
            this.messages.add(index.intValue(), message);
        } catch (IndexOutOfBoundsException e) {
            this.messages.add(message);
        }
    }

    public boolean editMessage(Integer index, Message message) {
        try {
            return this.messages.set(index.intValue(), message) != null;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean removeMessage(Integer index) {
        try {
            return this.messages.remove(index.intValue()) != null;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean hasMessages() {
        return messages.size() > 0;
    }

    public void setCurrentIndex(int index) {
        this.currentIndex = index;

        if (currentIndex >= messages.size() || currentIndex < 0) {
            this.currentIndex = 0;
        }
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void broadcast(int index) {
        Bukkit.broadcastMessage(this.getMessage(index).getMessage());
    }

}
