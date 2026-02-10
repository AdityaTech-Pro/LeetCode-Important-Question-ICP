//Brute force approach : use Hashmap  to get maxFreq and loop/function for same steps in optimal approach

//optimal Approach : first , Sort the array to find the maximum frequency using one for loop and two if case . 
//step2 : Calculate Required Swaps for this  (total no.of element ) -  (Every element that is not the majority element ). 
//step3 :   from Greedy Doubling approach : To get more majority elements, you must clone the current array; each clone doubles your current count of that element 
// step 4 :  for Minimize Operations,  Each doubling step adds 1 clone operation to the cost, while the total swap operations remain constant at n-maxFreq. 
//last for total operation add no.of swap and no.of clone and use FastReader and PrintWriter to handle large inputs within the strict 1-second time limit on Codeforces.

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }

            Arrays.sort(a);

            int mf = 1, curFreq = 1;
            for (int i = 1; i < n; i++) {
                if (a[i] == a[i - 1]) {
                    curFreq++;
                } else {
                    mf = Math.max(mf, curFreq);
                    curFreq = 1;
                }
            }
            mf = Math.max(mf, curFreq);

            int swaps = n - mf;

            int clones = 0;
            int cur = mf;
            while (cur < n) {
                cur <<= 1; // faster than cur *= 2
                clones++;
            }

            out.append(swaps + clones).append('\n');
        }

        System.out.print(out.toString());
    }

   
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = read();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = read();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}
