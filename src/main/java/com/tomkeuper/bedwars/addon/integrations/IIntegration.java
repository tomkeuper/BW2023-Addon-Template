package com.tomkeuper.bedwars.addon.integrations;

public interface IIntegration {
    boolean isRunning();
    boolean isPresent();
    boolean isEnabled();
    boolean enable();
    void disable();
}
