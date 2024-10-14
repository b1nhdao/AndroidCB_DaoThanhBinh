package com.example.truyencuoi;

public class Story {
    private String topicName, name, content;

    public Story(String topicName, String name, String content) {
        this.topicName = topicName;
        this.name = name;
        this.content = content;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
