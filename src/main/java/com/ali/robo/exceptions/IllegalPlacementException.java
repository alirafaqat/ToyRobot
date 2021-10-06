package com.ali.robo.exceptions;

public class IllegalPlacementException extends RuntimeException {
    public IllegalPlacementException(int x, int y) {
        super("Invalid placement (" + x + ", " + y + ")");
    }
}
