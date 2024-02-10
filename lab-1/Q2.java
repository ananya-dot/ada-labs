package org.example;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int teams = sc.nextInt();
        int bases = sc.nextInt();

        int[] teamHarry = new int[teams];
        for(int i = 0; i < teams; i ++){
            teamHarry[i] = sc.nextInt();
        }

        int[][] baseVoldy = new int[bases][2];
        for(int i = 0; i < bases; i ++){
            baseVoldy[i][0] = sc.nextInt();
            baseVoldy[i][1] = sc.nextInt();
        }

        Arrays.sort(baseVoldy, Comparator.comparingInt(a -> a[0]));
//        Arrays.sort(teamHarry);
        int[] arr = new int[bases];
        arr[0] = baseVoldy[0][1];
        for(int i = 1; i < bases; i ++){
            arr[i] = arr[i - 1] + baseVoldy[i][1];
        }


        int[] dp = new int[teams];

        for(int team = 0; team < teams; team ++) {
//            int ans = 0;
            int ind = bSearch(baseVoldy, teamHarry[team]);
            if(ind < 0) System.out.print(0 + " ");
            else System.out.print(arr[ind] + " ");
        }
//        System.out.println(Arrays.toString(dp));
//        for(int team_ : dp){
//            if(team_ < 0) System.out.println(0 + " ");
//            System.out.print(arr[team_] + " ");
//        }
    }

    public static int bSearch(int[][] voldy, int target){
        int lo = 0;
        int hi = voldy.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target >= voldy[mid][0]) {
                lo = mid + 1;
            }
            else hi = mid - 1;
        }
        return hi;
    }
}
