package com.ali.robo.model;

import com.ali.robo.exceptions.IllegalMoveException;
import com.ali.robo.exceptions.IllegalPlacementException;

import static com.ali.robo.model.Direction.EAST;
import static com.ali.robo.model.Direction.WEST;
import static com.ali.robo.model.Direction.NORTH;
import static com.ali.robo.model.Direction.SOUTH;

public class Robot {
    private TableField tableField;
    private Direction direction;
    private int x;
    private int y;

    public Robot(TableField tableField) {
        this.tableField = tableField;
        direction = SOUTH;
    }

    public Robot(TableField tableField, int x, int y, Direction direction) {
        this.tableField = tableField;
        if(!tableField.isValidMove(x, y)) {
            throw new IllegalPlacementException(x, y);
        }
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public boolean move() {
        int currentX = x;
        int currentY = y;

        switch(direction) {
            case EAST:
                currentX++;
                break;
            case WEST:
                currentX--;
                break;
            case NORTH:
                currentY++;
                break;
            case SOUTH:
                currentY--;
        }

        if(tableField.isValidMove(currentX, currentY)) {
            x = currentX;
            y = currentY;
        } else {
            throw new IllegalMoveException();
        }

        return true;
    }

    /*
            N
         W     E
            S
     */
    public void turn(boolean right) {
        switch(direction) {
            case EAST:
                direction = right? SOUTH : NORTH;
                break;
            case WEST:
                direction = right? NORTH : SOUTH;
                break;
            case NORTH:
                direction = right? EAST : WEST;
                break;
            case SOUTH:
                direction = right? WEST : EAST;
        }

    }

    public void report() {
        System.out.printf("%s, %s, %s", x, y, direction);
    }
}
