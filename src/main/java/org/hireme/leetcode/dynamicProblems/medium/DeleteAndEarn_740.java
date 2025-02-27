package org.hireme.leetcode.dynamicProblems.medium;

import java.util.*;

public class DeleteAndEarn_740 {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> scoresMap = new HashMap<>();
        List<Integer> numList = new ArrayList<>();


        for (int num : nums) {
            if (!scoresMap.containsKey(num)) {
                numList.add(num);
            }
            scoresMap.merge(num, num, Integer::sum);
        }
        int[] cache = new int[numList.size()];
        Arrays.fill(cache, -1);

        numList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

//        return dfsHelper(0, numList, scoresMap);
//        return topDownHelper(0, numList, scoresMap, cache);
        return bottomUpHelper(nums, numList, scoresMap);
    }

    private int bottomUpHelper(int[] nums, List<Integer> numList, HashMap<Integer, Integer> scoresMap) {
        int[] dp = new int[numList.size() + 1];
        int ctr = numList.size() - 1;
        int num, skip, include;
        while (ctr >= 0) {
            num = numList.get(ctr);
            skip = dp[ctr + 1];
            include = scoresMap.get(num);
            if (ctr + 1 < numList.size() && numList.get(ctr + 1) - numList.get(ctr) != 1) {
                include += dp[ctr + 1];
            }
            else if(ctr+2<dp.length){
                include+=dp[ctr+2];
            }
            dp[ctr] = Math.max(include, skip);
            ctr--;
        }

        return dp[0];

    }

    private int topDownHelper(int i, List<Integer> numList, HashMap<Integer, Integer> scoresMap, int[] cache) {
        if (i >= numList.size()) {
            return 0;
        }
        if (cache[i] != -1) {
            return cache[i];
        }

        int skip = topDownHelper(i + 1, numList, scoresMap, cache);

        int include = 0;
        if (i + 1 < numList.size() && numList.get(i + 1) - numList.get(i) != 1) {
            include = scoresMap.get(numList.get(i)) + topDownHelper(i + 1, numList, scoresMap, cache);
        } else {
            include = scoresMap.get(numList.get(i)) + topDownHelper(i + 2, numList, scoresMap, cache);
        }


        cache[i] = Math.max(skip, include);

        return cache[i];
    }

    private int dfsHelper(int i, List<Integer> numList, HashMap<Integer, Integer> scoresMap) {
        if (i >= numList.size()) {
            return 0;
        }

        int skip = dfsHelper(i + 1, numList, scoresMap);

        int include = 0;
        include = scoresMap.get(numList.get(i)) + dfsHelper(i + 2, numList, scoresMap);

        return Math.max(skip, include);
    }

    public static void main(String[] args) {
        DeleteAndEarn_740 obj = new DeleteAndEarn_740();
        System.out.println(obj.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        System.out.println(obj.deleteAndEarn(new int[]{3, 4, 2, 3, 3, 4}));
    }
}
