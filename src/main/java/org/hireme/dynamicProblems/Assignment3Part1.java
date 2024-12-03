package org.hireme.dynamicProblems;

import java.util.*;

public class Assignment3Part1 {


    private  static  Map<List<String>, List<String>> directDependency = new HashMap<>();
    /**
     * min_cover([[['A'], ['B', 'C']],[['B'], ['C','D']], [['D'], ['B']], [['A','B','E'], ['F']]])
     * outputs: [[['A'], ['B']], [['B'], ['C']], [['B'], ['D']], [['D'], ['B']], [['A', 'E'], ['F']]]
     *
     * @param fd
     * @return
     */


    public static List<List<List<String>>> min_cover(List<List<List<String>>> fd) {
//        Map<List<String>, List<String>> adj = new HashMap<>();
        //Generating map of dependencies
        for (List<List<String>> current : fd) {
            for (String i : current.get(1)) {
                directDependency.computeIfAbsent(current.get(0), k -> new ArrayList<>()).add(i);
            }
        }

        //Generating closure of each key
        Map<List<String>,Set<String>> closures = new HashMap<>();
        for(List<String> i : directDependency.keySet()){
            closures.put(i,generateClosure(i,null));
        }

        List<List<List<String>>> replaceKeyWith = new ArrayList<>();

        //For simplifying key of fd also have to consider that any subset of the key could be a key to check
        //Removing any fd in which lhs has more than 1 element and any subset of lhs can give rhs (Keep only the smaller one)
        // Or if a subset gives at least part of RHS then removing those parts from the fd
        boolean removeElement = false;
        List<List<String>> removeList = new ArrayList<>();
        for (List<String> key : directDependency.keySet()) {
            if (key.size() > 1) {
                List<List<String>> allSubsets = generateCombinations(key);
                for (List<String> subset : allSubsets) {
                    if (subset.size() != key.size() && closures.get(subset) != null) {
                        directDependency.get(key).removeAll(closures.get(subset));
                        if(directDependency.get(key).isEmpty()){
                            removeElement = true;
                            break;
                        }
                    }
                }
                if (removeElement) {
                    removeList.add(key);
                    closures.remove(key);
                    removeElement = false;
                    continue;
                }
                List<String> transitiveDependenciesOfKey = new ArrayList<>();
                for(List<String> subset : allSubsets){
                    if(subset.size()!=key.size() && directDependency.get(subset)!=null){
                        transitiveDependenciesOfKey.addAll(directDependency.get(subset));
                    }
                }
                List<String> duplicate = new ArrayList<>(key);
                duplicate.removeAll(transitiveDependenciesOfKey);
                List<List<String>> tmp = new ArrayList<>();
                tmp.add(key);
                tmp.add(duplicate);
                replaceKeyWith.add(tmp);
            }
        }

        removeList.forEach(directDependency::remove);

        //Are any of the elements in key derived by others in the key?Remove them
        for (List<List<String>> i : replaceKeyWith){
            List<String> value = directDependency.get(i.get(0));
            if(value!=null){
                directDependency.remove(i.get(0));
                directDependency.put(i.get(1),value);
            }

        }


        //Check for transitive dependencies
        for (List<String> key : directDependency.keySet()) {
            List<List<String>> allSubsets = generateCombinations(directDependency.get(key));
            for(List<String> subset : allSubsets){
                if(!subset.isEmpty() &&subset.size() != directDependency.get(key).size()){
                    Set<String> closureExceptWithKey = generateClosure(subset,key);
                    if(!closureExceptWithKey.isEmpty()){
                        removeAllFromFirstExcept(directDependency.get(key),closureExceptWithKey,subset);
//                        removeAllFromFirstExcept(closures.get(key),closureExceptWithKey,subset);
                    }
                }
            }

        }



        List<List<List<String>>> ans = new ArrayList<>();
        for(List<String> key : directDependency.keySet()){
            for(String value : directDependency.get(key)){
                List<List<String>> innerList = new ArrayList<>();
                innerList.add(key);
                innerList.add(Arrays.asList(value));
                ans.add(innerList);
            }
        }




        return ans;

    }

    // Will generate closure for the element sent to it,
    //Avoid - Dont add transitive dependencies that are generated from this element
    public static Set<String> generateClosure(List<String> inputList,List<String> avoid){
        Set<String> transitiveDependencies = new HashSet<>();
        transitiveDependencies.addAll(inputList);
        if(avoid!=null){
            transitiveDependencies.addAll(avoid);
        }
        generateClosureHelper(inputList,transitiveDependencies);
        return transitiveDependencies;

    }

    //Unique set and list of repeated elements
    public static void generateClosureHelper(List<String> inputList,Set<String> transitiveDependencies){
        List<List<String>> x = inputList.size()==1? List.of(inputList) :generateCombinations(inputList);
        for (List<String> i : x){
            if(directDependency.get(i)!=null){
                List<String> currentValue = new ArrayList<>(directDependency.get(i));
                currentValue.removeAll(transitiveDependencies);
                if(!currentValue.isEmpty()){
                    transitiveDependencies.addAll(currentValue);
                    generateClosureHelper(currentValue,transitiveDependencies);
                }

            }
        }
    }


    public static List<List<String>> generateCombinations(List<String> inputList) {
        List<List<String>> allCombinations = new ArrayList<>();
        generateHelper(inputList, new ArrayList<>(), 0, allCombinations);
        return allCombinations;
    }

    private static void generateHelper(List<String> inputList, List<String> currentCombination,
                                       int currentIndex, List<List<String>> allCombinations) {
        if (currentIndex == inputList.size()) {
            // Base case: Add the current combination to the result
            allCombinations.add(new ArrayList<>(currentCombination));
            return;
        }

        // Include the current element in the combination
        currentCombination.add(inputList.get(currentIndex));
        generateHelper(inputList, currentCombination, currentIndex + 1, allCombinations);

        // Exclude the current element from the combination
        currentCombination.remove(currentCombination.size() - 1);
        generateHelper(inputList, currentCombination, currentIndex + 1, allCombinations);
    }

    //Check if x has all elements of y
//    private static boolean doesFirstContainAllOfSecond(List<String> x, List<String> y) {
//        for (String i : y) {
//            if (!x.contains(i)) {
//                return false;
//            }
//        }
//        return true;
//    }

    private static void removeAllFromFirstExcept(Collection<String> first,Collection<String> second,List<String> except){
        List<String> secondExcept = new ArrayList<>(second);
        secondExcept.removeAll(except);
        first.removeAll(secondExcept);
    }

    public static void main(String[] args) {
        List<List<List<String>>> list = new ArrayList<>();

        // Create the first inner list
        List<List<String>> firstInnerList = new ArrayList<>();
        List<String> firstSubList = new ArrayList<>();
        firstSubList.add("A");
        firstInnerList.add(firstSubList);
        List<String> secondSubList = new ArrayList<>();
        secondSubList.add("B");
        secondSubList.add("C");
        firstInnerList.add(secondSubList);
        list.add(firstInnerList);

        // Create the second inner list
        List<List<String>> secondInnerList = new ArrayList<>();
        List<String> thirdSubList = new ArrayList<>();
        thirdSubList.add("B");
        secondInnerList.add(thirdSubList);
        List<String> fourthSubList = new ArrayList<>();
        fourthSubList.add("C");
        fourthSubList.add("D");
        secondInnerList.add(fourthSubList);
        list.add(secondInnerList);

        // Create the fourth inner list
        List<List<String>> fourthInnerList = new ArrayList<>();
        List<String> seventhSubList = new ArrayList<>();
        seventhSubList.add("A");
        seventhSubList.add("B");
        seventhSubList.add("E");
        fourthInnerList.add(seventhSubList);
        List<String> eighthSubList = new ArrayList<>();
        eighthSubList.add("F");
        fourthInnerList.add(eighthSubList);
        list.add(fourthInnerList);

        // Create the third inner list
        List<List<String>> thirdInnerList = new ArrayList<>();
        List<String> fifthSubList = new ArrayList<>();
        fifthSubList.add("D");
        thirdInnerList.add(fifthSubList);
        List<String> sixthSubList = new ArrayList<>();
        sixthSubList.add("B");
        thirdInnerList.add(sixthSubList);
        list.add(thirdInnerList);
//
//
//
//        // Create the fifth inner list
//        List<List<String>> fifthInnerList = new ArrayList<>();
//        List<String> ninthSubList = new ArrayList<>();
//        ninthSubList.add("A");
//        ninthSubList.add("B");
//        fifthInnerList.add(ninthSubList);
//        List<String> tenthSubList = new ArrayList<>();
//        tenthSubList.add("D");
//        fifthInnerList.add(tenthSubList);
//        list.add(fifthInnerList);

//        List<List<List<String>>> fds = new ArrayList<>();
//
//// {A, B} → {C, D, E}
//        List<List<String>> fd1 = new ArrayList<>();
//        fd1.add(new ArrayList<>(Arrays.asList("A", "B")));
//        fd1.add(new ArrayList<>(Arrays.asList("C", "D", "E")));
//        fds.add(fd1);
//
//// {A, C} → {B, D, E}
//        List<List<String>> fd2 = new ArrayList<>();
//        fd2.add(new ArrayList<>(Arrays.asList("A", "C")));
//        fd2.add(new ArrayList<>(Arrays.asList("B", "D", "E")));
//        fds.add(fd2);
//
//// {B} → {C}
//        List<List<String>> fd3 = new ArrayList<>();
//        fd3.add(new ArrayList<>(Collections.singletonList("B")));
//        fd3.add(new ArrayList<>(Collections.singletonList("C")));
//        fds.add(fd3);
//
//// {C} → {B}
//        List<List<String>> fd4 = new ArrayList<>();
//        fd4.add(new ArrayList<>(Collections.singletonList("C")));
//        fd4.add(new ArrayList<>(Collections.singletonList("B")));
//        fds.add(fd4);
//
//// {C} → {D}
//        List<List<String>> fd5 = new ArrayList<>();
//        fd5.add(new ArrayList<>(Collections.singletonList("C")));
//        fd5.add(new ArrayList<>(Collections.singletonList("D")));
//        fds.add(fd5);
//
//// {B} → {E}
//        List<List<String>> fd6 = new ArrayList<>();
//        fd6.add(new ArrayList<>(Collections.singletonList("B")));
//        fd6.add(new ArrayList<>(Collections.singletonList("E")));
//        fds.add(fd6);
//
//// {C} → {E}
//        List<List<String>> fd7 = new ArrayList<>();
//        fd7.add(new ArrayList<>(Collections.singletonList("C")));
//        fd7.add(new ArrayList<>(Collections.singletonList("E")));
//        fds.add(fd7);


        System.out.println(min_cover(list));
    }
}
