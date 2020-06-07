package com.company;

import java.util.Scanner;

public class _08_TheHeiganDance {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] position = new int[]{7,7}; // int[] row, col

        int playerHP = 18500;
        double heiganHP = 3000000;
        double playerDamage = Double.parseDouble(console.nextLine());
        String lastSpell = "";

        while (true) {
            if (playerHP >= 0) {
                heiganHP -= playerDamage;
            }
            if (lastSpell.equals("Cloud")) {
                playerHP -= 3500;
            }
            if (heiganHP <= 0 || playerHP <= 0) {
                break;
            }
            String[] input = console.nextLine().split(" ");
            String currentSpell = input[0];
            int targetRow = Integer.parseInt(input[1]);
            int targetCol = Integer.parseInt(input[2]);
            if (isInDamageArea(targetRow, targetCol, position[0], position[1])) {
                if (!isInDamageArea(targetRow, targetCol, position[0] - 1, position[1]) && !isWall(position[0] - 1)) {
                    position[0]--;
                    lastSpell = "";
                } else if (!isInDamageArea(targetRow, targetCol, position[0], position[1] + 1) && !isWall(position[1] + 1)) {
                    position[1]++;
                    lastSpell = "";
                } else if (!isInDamageArea(targetRow, targetCol, position[0] + 1, position[1]) && !isWall(position[0] + 1)) {
                    position[0]++;
                    lastSpell = "";
                } else if (!isInDamageArea(targetRow, targetCol, position[0], position[1] - 1) && !isWall(position[1] - 1)) {
                    position[1]--;
                    lastSpell = "";
                } else {
                    if (currentSpell.equals("Cloud")) {
                        playerHP -= 3500;
                        lastSpell = "Cloud";
                    } else if (currentSpell.equals("Eruption")) {
                        playerHP -= 6000;
                        lastSpell = "Eruption";
                    }
                }
            }
        }
        lastSpell = lastSpell.equals("Cloud") ? "Plague Cloud" : "Eruption";
        String heiganState = heiganHP <= 0 ? "Heigan: Defeated!" : String.format("Heigan: %.2f", heiganHP);
        String playerState = playerHP <= 0 ? String.format("Player: Killed by %s", lastSpell) :
                String.format("Player: %d", playerHP);
        String playerEndCoordinates = String.format("Final position: %d, %d", position[0], position[1]);

        System.out.println(heiganState);
        System.out.println(playerState);
        System.out.println(playerEndCoordinates);
    }

    private static boolean isWall(int moveCell) {
        return moveCell < 0 || moveCell >= 15;
    }

    private static boolean isInDamageArea(int targetRow, int targetCol, int moveRow, int moveCol) {
        return ((targetRow - 1 <= moveRow && moveRow <= targetRow + 1)
                && (targetCol - 1 <= moveCol && moveCol <= targetCol + 1));
    }
}