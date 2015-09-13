package com.poqagames.Combatants;
public class StatNotFoundException extends Exception {

    public StatNotFoundException(String message) {
        super(message);
    }

    public StatNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

}