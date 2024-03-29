import java.util.*;

public class UniqueTriplets {

    protected List<List<Integer>> getTriplets(int[] number, int target){
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(number);
        findTriplets(number, 0, target, new ArrayList<>(), output);
        return output;
    }

    // Getting Triplets that sums the target num
    protected void findTriplets(int[] numbers, int begin, int target, List<Integer> currentList, List<List<Integer>> output){

        if(currentList.size() == 3){
            if(target == 0){
                output.add(new ArrayList<>(currentList));
            }
        }
        for(int i = begin; i < numbers.length; i++){
            if(i > begin && numbers[i] == numbers[i - 1]){
                continue;
            };

            currentList.add(numbers[i]);
            findTriplets(numbers, i + 1, target - numbers[i], currentList, output);
            currentList.removeLast();
        }
    }

    // To get Unique triplet
    protected static boolean isUnique(List<Integer> triplet){
        Set<Integer> set = new HashSet<>();
        for(int num: triplet){
            if(!set.add(num)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] arg){
        UniqueTriplets uniqueTriplets = new UniqueTriplets();
        int[] numbers = {-2, 3, -1, 2, 0, -4, -3, -8, 5, 3};
        int target = 4;
        List<List<Integer>> triplets = uniqueTriplets.getTriplets(numbers, target);
        System.out.println(STR."Triplets that sum up to \{target} :");
        Set<List<Integer>> uniqueNumber = new HashSet<>(triplets);
        for(List<Integer> number: uniqueNumber){
            if(isUnique(number)){
                System.out.println(number);
            }
        }
    }
}
