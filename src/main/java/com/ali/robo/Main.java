package com.ali.robo;

import com.ali.robo.exceptions.IllegalMoveException;
import com.ali.robo.exceptions.IllegalPlacementException;
import com.ali.robo.model.Direction;
import com.ali.robo.model.Robot;
import com.ali.robo.model.TableField;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        System.out.println("Toy Robot Program");
        Scanner scanner = new Scanner(System.in);
        TableField table = new TableField(5, 5);
        Robot robo = null;

        while(true) {
            String input = scanner.nextLine();
            if(input.startsWith("PLACE ")) {
                robo = createRobotFromConsoleInput(input.substring(6).trim(), table);
            } else if(input.trim().equals("MOVE")) {
                try {
                    robo.move();
                } catch(IllegalMoveException exp) {
                    // Do nothing for the time being unless idrected.
                }
            } else if(input.trim().equals("LEFT")) {
                if(robo != null) {
                    robo.turn(false);
                } else {
                    System.out.println("No robot found.");
                }
            } else if(input.trim().equals("RIGHT")) {
                if(robo != null) {
                    robo.turn(true);
                } else {
                    System.out.println("No robot found.");
                }
            } else if(input.trim().equals("REPORT")) {
                if(robo != null) {
                    robo.report();
                } else {
                    System.out.println("No robot found.");
                }
            } else {

            }
        }
    }


    private static Robot createRobotFromConsoleInput(String input, TableField tableField) {
        System.out.println(input);

        String[] values = input.split(",");
        if(values.length != 3) {
            return null;
        }

        try {
            int x = Integer.parseInt(values[0].trim());
            int y = Integer.parseInt(values[1].trim());
            Direction direction = Direction.valueOf(values[2].trim());
            return new Robot(tableField, x, y, direction);
        } catch (NumberFormatException exp) {
            System.out.println("Invalid points");
        } catch (IllegalArgumentException exp) {
            System.out.println("Invalid Direction");
        } catch(IllegalPlacementException exp) {
            System.out.println(exp.getMessage());
        } catch (Exception exp) {
            exp.printStackTrace();;
        }

        return null;
    }
}
