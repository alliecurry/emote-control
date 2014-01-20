package net.spantree.emote.domain;

public enum Question {
    QUESTION_A("Activate"),
    QUESTION_B("Belief"),
    QUESTION_C("Consequences"),
    QUESTION_D("Dispute"),
    QUESTION_E("Effect");

    private final String prompt;

    Question(String prompt) {
        this.prompt = prompt;
    }

    String prompt() {
        return prompt;
    }
}