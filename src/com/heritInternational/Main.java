package com.heritInternational;

import java.util.Scanner;
import java.util.*;

/**
 * CODE DESCRIPTION: Count consecutive ONE's in binary representation of entered decimal value
 * ... Find and print the base-10 integer denoting the maximum number of consecutive 1's in a binary representation.
 * ------------
 * Assignment from HackerRank Challenge:
 * https://www.hackerrank.com/challenges/30-binary-numbers/problem
 *
 *
 * Details:
 * ...INPUT: enter decimal value to be converted to binary (e.g. 234544239)
 * ...OUTPUT:
 * ......binary representation: [1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1]
 * ......The max. count of consecutive one's in binary representation: 6
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter decimal value to be converted to binary");
        int n = scanner.nextInt();
        ArrayList<Integer> remainderArray = new ArrayList<Integer>();

        while(n>0){
            int remainder=n%2;
            n=n/2;
            remainderArray.add(remainder);

        }
        Collections.reverse(remainderArray);
        System.out.println("binary representation: " + remainderArray);

        int counter=0;
        int[] localMax= new int[remainderArray.size()+1];
        for(int l=0;l<remainderArray.size();l++){
            if (remainderArray.get(l)==1) {
                counter++;
                localMax[l]=counter;
            }
            else {
                counter=0;
            }
        }
        int globalMax = localMax[0];
        for(int m=0;m<localMax.length;m++){
            if(localMax[m]>globalMax)
                globalMax=localMax[m];
        }



        System.out.println("The max. count of consecutive one's in binary representation: "+ globalMax);

        scanner.close();

    }
}
