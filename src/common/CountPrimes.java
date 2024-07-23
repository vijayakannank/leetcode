package common;

import java.util.Arrays;

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(100));

    }

    static int countPrimes(int n) {
        if(n<=1)return 0;
        boolean[] sieve=new boolean[n];
        Arrays.fill(sieve, true);
        for(int i=2;i*i<n;i++)
        {
            if(sieve[i])
            {
                for(int j=i*i;j<n;j+=i)
                {
                    sieve[j]=false;
                }
            }
        }
        int ctr=0;
        for(int i=2;i<n;i++)
        {
            if(sieve[i])
                ctr++;
        }

        return ctr;
    }
}
