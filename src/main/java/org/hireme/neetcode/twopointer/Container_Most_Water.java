package org.hireme.neetcode.twopointer;

public class Container_Most_Water {
    public int maxArea(int[] height) {
        int maxAreaFound = 0, l = 0, r = height.length - 1;

        while (r > l) {
            maxAreaFound = Math.max(maxAreaFound, (r - l) * (Math.min(height[r], height[l])));

            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }

        return maxAreaFound;

    }
}
