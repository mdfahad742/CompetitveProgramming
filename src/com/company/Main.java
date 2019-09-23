package com.company;

import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class Main {

    public static int countValues(int n)
    {
        // unset_bits keeps track of count
        // of un-set bits in binary
        // representation of n
        int unset_bits=0;
        while (n > 0)
        {
            if ((n & 1) == 0)
                unset_bits++;
            n=n>>1;
        }

        // Return 2 ^ unset_bits
        return 1 << unset_bits;
    }

    public static void main(String[] args) {
	// write your code here
        Stack<Integer> rev = new Stack<>();
        rev.add(1);
        rev.add(2);
        rev.add(3);
        Integer x = 1;
        Iterator<Integer> i = rev.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        long t = (long) 1e9 * (long) 1e9;
        System.out.println(t);
        float ans = 7F / 2;
        System.out.println(ans);
        float r = 21 / ans;
        ans = 3.24f;
        if (21 % ans == 0)
            System.out.println("YES");
        System.out.println(r);
        System.out.println();
        System.out.println("HAPPY");
        int n = 4;
        System.out.println(1L<<31);
        for (long j = 1L << 31; j > 0; j = j / 2) {
            //System.out.print(n & j);
            if ((n & j) == 0)
                System.out.print(0);
            else
                System.out.print(1);
        }
        System.out.println();
        String vv = null;
        System.out.println(vv);
    }
}
