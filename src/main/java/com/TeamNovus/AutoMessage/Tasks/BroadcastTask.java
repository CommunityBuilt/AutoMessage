package com.TeamNovus.AutoMessage.Tasks;

import java.util.Random;
import com.TeamNovus.AutoMessage.AutoMessage;
import com.TeamNovus.AutoMessage.Models.MessageList;

public class BroadcastTask implements Runnable {

    private MessageList list;

    public BroadcastTask(MessageList list) {
        this.list = list;
    }

    @Override
    public void run() {
        if (AutoMessage.plugin.getConfig().getBoolean("settings.enabled") && list.isEnabled() && list.hasMessages()) {
            int index = list.isRandom() ? new Random().nextInt(list.getMessages().size()) : list.getCurrentIndex();
            list.broadcast(index);
            list.setCurrentIndex(index + 1);
        }
    }
}
