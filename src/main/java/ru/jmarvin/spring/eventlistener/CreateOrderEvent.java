package ru.jmarvin.spring.eventlistener;

public class CreateOrderEvent {

    private final boolean awesome;

    public CreateOrderEvent(boolean awesome) {
        this.awesome = awesome;
    }

    public boolean isAwesome() {
        return awesome;
    }
}
