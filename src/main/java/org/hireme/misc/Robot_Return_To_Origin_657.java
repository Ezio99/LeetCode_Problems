package org.hireme.misc;

public class Robot_Return_To_Origin_657 {
    public boolean judgeCircle(String moves) {
        // If odd not possible to reach back to original position
        if (moves.length() % 2 != 0) {
            return false;
        }
        int[] pos = new int[]{0, 0};
        for (char ch : moves.toCharArray()) {

            switch (ch) {
                case 'U':
                    pos[1]++;
                    break;
                case 'D':
                    pos[1]--;
                    break;
                case 'L':
                    pos[0]--;
                    break;
                case 'R':
                    pos[0]++;
                    break;

                default:
                    break;
            }
        }

        return pos[0] == 0 && pos[1] == 0;
    }
}
