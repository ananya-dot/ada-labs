package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int testCases = sc.nextInt();
        for(int i = 0; i < testCases; i ++) {
            int len = sc.nextInt();
            int n = sc.nextInt();

            int[] nums = new int[len];

            for(int ind = 0; ind < len; ind ++){
                nums[ind] = sc.nextInt();
            }

            boolean ans = true;

            for(int remove = 0; remove < nums.length; remove ++) {
                int tmp = nums[remove];
                nums[remove] = 0;
                ans &= (subseqSum(nums, 0, 0, n, 0, remove));

                nums[remove] = tmp;
//                System.out.println(ans);


            }
            if(ans) System.out.println("YES");
            else System.out.println("NO");

//            System.out.println((subseqSum(nums, 0, 0, n)));




        }


    }


    public static boolean subseqSum(int[] nums, int start, int sum, int n, int cnt, int rem) {

        if(start >= nums.length){
            return (sum % n == 0 && cnt != 0);
        }
        if(start == rem) {
            return subseqSum(nums, start + 1, sum, n, cnt, rem);
        }
        boolean x = subseqSum(nums, start + 1, sum, n, cnt, rem);
        boolean y = subseqSum(nums, start + 1, sum + nums[start], n, cnt + 1, rem);
        return x || y;

    }



    }
