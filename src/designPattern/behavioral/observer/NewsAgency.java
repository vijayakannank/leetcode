package designPattern.behavioral.observer;

import designPattern.behavioral.command.Light;

import java.util.ArrayList;
import java.util.List;

//NewsAgency is an observable,
public class NewsAgency {

    private List<Channel> channels = new ArrayList<>();

    void setChannels(Channel ch){
        this.channels.add(ch);
    }

    void removeChannels(Channel ch){
        this.channels.remove(ch);
    }

    void notify(String news){
        for(Channel ch: channels){
            ch.update(news);
        }
    }

}
