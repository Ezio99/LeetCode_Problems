package org.hireme.neetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Valid_Sudoku {
    public static boolean isValidSudoku(char[][] board) {
        HashMap<Character, List<List<Integer>>> numberCoordinates = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char currentValue = board[i][j];
                if(currentValue == '.'){
                    continue;
                }
                if (numberCoordinates.containsKey(currentValue)) {
                    for (List<Integer> k : numberCoordinates.get(currentValue)) {
                        if (k.get(0) == i || k.get(1)==j){
                            return false;
                        }
                        int square_start_x = (k.get(0) / 3) * 3 ;
                        int square_start_y = (k.get(1) / 3) * 3;
                        if(i>= square_start_x && i<= square_start_x+2){
                            if(j>= square_start_y && j<= square_start_y+2){
                                return false;
                            }
                        }
                    }
                } else {
                    numberCoordinates.put(currentValue, new ArrayList<>());
                }
                numberCoordinates.get((currentValue)).add(List.of(i, j));

            }
        }

        return true;
    }

    public static void main(String args[]) {
        char[][] array = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(array));

    }
}
