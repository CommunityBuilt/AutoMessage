package com.TeamNovus.AutoMessage.Models;

import org.bukkit.ChatColor;

public class Message {

    private String raw;
    private String message;

    public Message(String raw) {
        this.setMessage(raw);
    }

    public String getMessage() {
        return message;
    }

    public Message setMessage(String raw) {
        this.raw = raw;
        this.message = ChatColor.translateAlternateColorCodes("&".charAt(0), raw);
        return this;
    }
}
