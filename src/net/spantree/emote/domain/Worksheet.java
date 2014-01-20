package net.spantree.emote.domain;

import java.util.Date;
import java.util.Map;

public class Worksheet {
    private long id;
    private Emotion emotion;
    private Map<Question, String> questionResponses;
    private Date dateCreated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }

    public Map<Question, String> getQuestionResponses() {
        return questionResponses;
    }

    public void setQuestionResponses(Map<Question, String> questionResponses) {
        this.questionResponses = questionResponses;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
