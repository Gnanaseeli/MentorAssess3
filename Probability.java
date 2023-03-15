package mentorAssessment;
import java.util.Arrays;
import java.util.Random;

public class Probability {
    public static int getRandomElement(int[] nums, int[] probability) {
        int[] cumProb = new int[probability.length];
        cumProb[0] = probability[0];
        for (int i = 1; i < probability.length; i++) {
            cumProb[i] = cumProb[i - 1] + probability[i];
        }

        Random rand = new Random();
        int randNum = rand.nextInt(cumProb[cumProb.length - 1]) + 1;
        int index = binarySearch(cumProb, randNum);
        return nums[index];
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] probability = {30, 10, 20, 15, 25};

        int[] count = new int[nums.length];
        for (int i = 0; i < 10000; i++) {
            int randNum = getRandomElement(nums, probability);
            count[randNum - 1]++;
        }

        System.out.println("Element\tProbability");
        for (int i = 0; i < nums.length; i++) {
            double p = (double) count[i] / 10000;
            System.out.printf("%d\t%.2f%%\n", nums[i], p * 100);
        }
    }
}
