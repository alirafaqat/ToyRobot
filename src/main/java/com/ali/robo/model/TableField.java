package com.ali.robo.model;

public class TableField {
    private Robot[][] field;
    Robot robo;

    public TableField(int x, int y) {
        field = new Robot[x][y];
    }

    public void place(Robot robot, int x, int y) {

    }

    public boolean isValidMove(int x, int y) {
        return (x < field[0].length) && (y < field.length)
                && (x > -1) && (y > -1);
    }

}
