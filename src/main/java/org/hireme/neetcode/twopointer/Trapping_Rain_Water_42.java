package org.hireme.neetcode.twopointer;

public class Trapping_Rain_Water_42 {
    //    For each spot the amount of water it can hold is min(max L,max R from that spot) - height of that spot
    public int trap(int[] height) {
        int mapLength = height.length;
        int[] maxLeftHeight = new int[mapLength];
        int[] minLR = new int[mapLength];

        int currMax = 0;
        for (int i = 0; i < mapLength; i++) {
            maxLeftHeight[i] = currMax;
            if (height[i] > currMax) {
                currMax = height[i];
            }
        }

        currMax = 0;
        for (int i = mapLength - 1; i >= 0; i--) {
            minLR[i] = Math.min(maxLeftHeight[i], currMax);
            if (height[i] > currMax) {
                currMax = height[i];
            }
        }

        int trappedWater = 0, currWater;
        for (int i = 0; i < mapLength; i++) {
            currWater = minLR[i] - height[i];
            if (currWater > 0) {
                trappedWater += currWater;
            }
        }

        return trappedWater;
    }

    public int trap2Pointer(int[] height) {
        int mapLength = height.length;
        int l = 0, r = mapLength - 1;
        int maxL = height[l], maxR = height[r];
        int trappedWater = 0, tmp;
        while (l <= r) {
            if (maxL <= maxR) {
                l++;
                tmp = maxL - height[l];
                if (tmp > 0) {
                    trappedWater += tmp;
                }
                if (height[l] > maxL) {
                    maxL = height[l];
                }
            } else {
                r--;
                tmp = maxR - height[r];
                if (tmp > 0) {
                    trappedWater += tmp;
                }
                if (height[r] > maxR) {
                    maxR = height[r];
                }

            }
        }

        return trappedWater;

    }
}
