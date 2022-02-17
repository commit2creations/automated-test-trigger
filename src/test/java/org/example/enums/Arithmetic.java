package org.example.enums;

public enum Arithmetic {
    ADD("button-add"),
    SUBTRACT("button-subtract"),
    MULTIPLY("button-multiply"),
    DIVIDE("button-divide"),
    OPEN_PARENTHESIS("button-open-paren"),
    CLOSED_PARENTHESIS("button-close-paren"),
    BACKSPACE("__classcalc-button-backspace");

    private String function;

     Arithmetic(String function) {
        this.function = function;
    }

    public String getFunction(){
        return function;
    }
}
