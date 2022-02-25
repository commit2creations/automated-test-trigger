package org.example.enums;

public enum ModalShould {
    SHOULD(true),
    SHOULD_NOT(false);

    private boolean aBoolean;

    ModalShould(boolean aBoolean){
        this.aBoolean = aBoolean;
    }

    public boolean getModal(){
        return aBoolean;
    }
}
