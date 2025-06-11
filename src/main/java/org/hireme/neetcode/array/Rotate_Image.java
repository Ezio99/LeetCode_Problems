package org.hireme.neetcode.array;

//Can also be done by doing reverse of each row and then transpose
public class Rotate_Image {
    public void rotate(int[][] matrix) {
        if (matrix.length == 1) {
            return;
        }

        int ctr = 0, layerNumber = 0, n = matrix.length;
        int[] topLeft;
        int[] topRight;
        int[] bottomLeft;
        int[] bottomRight;
        int tmp;
        while (ctr < (n * n) - 1) {
            topLeft = new int[]{layerNumber, layerNumber};
            topRight = new int[]{layerNumber, n - 1 - layerNumber};
            bottomLeft = new int[]{n - 1 - layerNumber, layerNumber};
            bottomRight = new int[]{n - 1 - layerNumber, n - 1 - layerNumber};
            while (topLeft[1] < n - 1 - layerNumber) {
                tmp = matrix[topRight[0]][topRight[1]];
                matrix[topRight[0]][topRight[1]] = matrix[topLeft[0]][topLeft[1]];
                matrix[topLeft[0]][topLeft[1]] = matrix[bottomLeft[0]][bottomLeft[1]];
                matrix[bottomLeft[0]][bottomLeft[1]] = matrix[bottomRight[0]][bottomRight[1]];
                matrix[bottomRight[0]][bottomRight[1]] = tmp;
                topLeft[1] += 1;
                topRight[0] += 1;
                bottomRight[1] -= 1;
                bottomLeft[0] -= 1;
                ctr += 4;
            }

            layerNumber++;
        }

    }
}
