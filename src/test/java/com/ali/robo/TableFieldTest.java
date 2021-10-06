package com.ali.robo;

import com.ali.robo.model.TableField;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TableFieldTest {
    private static final int X = 5;
    private static final int Y = 5;

    @Test
    public void isValidMoveTest_success() {
        TableField tableField = new TableField(X, Y);

        IntStream.range(0, X).forEach(x -> {
            IntStream.range(0, Y).forEach(y -> {
                System.out.println(x + ", " + y);
                assertTrue(tableField.isValidMove(x, y));
            });
        });
    }

    @Test
    public void isValidMoveTest_failure() {
        TableField tableField = new TableField(X, Y);

        assertFalse(tableField.isValidMove(-1, -1));
        assertFalse(tableField.isValidMove(X, Y));
    }
}
