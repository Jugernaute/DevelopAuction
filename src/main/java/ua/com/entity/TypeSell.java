package ua.com.entity;

public enum TypeSell {
    ORDINARY("Простий аукціон"),
    BLITZ("Аукціон з можливістю бліц-покупки");

    private String string;

    TypeSell(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
