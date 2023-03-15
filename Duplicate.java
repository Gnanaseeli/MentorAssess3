package mentorAssessment;
import java.util.HashSet;
import java.util.Set;

public class Duplicate {
    public static int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1; // no duplicates found
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,10}; 
        int duplicate = findDuplicate(nums);
        if (duplicate != -1) {
            System.out.println("Duplicate value found: " + duplicate);
        } else {
            System.out.println("No duplicates found in the array.");
        }
    }
}
