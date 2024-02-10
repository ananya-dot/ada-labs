



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Q4th {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int pokelength = sc.nextInt();
            int targlength = sc.nextInt();
            List<Integer> pokemons = new ArrayList<>();
            List<Integer> targets = new ArrayList<>();
            for (int m = 0; m < pokelength; m++) {
                pokemons.add(sc.nextInt());
            }
            pokemons.sort(null);
            List<Integer> prefixSums = calculatePrefixSum(pokemons);
            for (int m = 0; m < targlength; m++) {
                targets.add(sc.nextInt());
            }
            HashSet<Integer> sums = new HashSet<>();
//            List<Integer> prefixSums = calculatePrefixSum(pokemons);
            store(sums, pokemons, 0, pokelength - 1, prefixSums);

//            System.out.println(sums);
//            for (int target : targets) {
//                if (partition(pokemons, target, 0, pokelength - 1, prefixSums)) {
//                    System.out.println("Yes");
//                } else {
//                    System.out.println("No");
//                }
//            }
            for (int target : targets) {
                if(sums.contains(target)) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }

    public static void store(HashSet<Integer> sums, List<Integer> arr, int start, int end, List<Integer> prefixSum) {
        if (start > end || start < 0 || end >= arr.size()) return;
        int min = arr.get(start);
        int max = arr.get(end);

        int sum = prefixSum.get(end) - (start > 0 ? prefixSum.get(start - 1) : 0);
//        for(int i = start ; i < end; i ++){
//            int sum = prefixSum.get(end) - (i > 0 ? prefixSum.get(i - 1) : 0);
            sums.add(sum);
//        }


        if (min == max) return;

        int mid = (min + max) / 2;
        int ind = bSearch(arr, mid, start, end);
        if (ind < 0 || ind > arr.size()) return;

        store(sums, arr, start, ind, prefixSum);
        store(sums, arr, ind + 1, end, prefixSum);
    }

    private static List<Integer> calculatePrefixSum(List<Integer> arr) {
        List<Integer> prefixSums = new ArrayList<>();
        int prefixSum = 0;
        for (int num : arr) {
            prefixSum += num;
            prefixSums.add(prefixSum);
        }
        return prefixSums;
    }

    
}

