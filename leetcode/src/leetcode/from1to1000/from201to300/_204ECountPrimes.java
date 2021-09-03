package leetcode.from1to1000.from201to300;

import java.util.ArrayList;

public class _204ECountPrimes {
	
	public static void main(String[] args) {
		int i;
		long start = System.nanoTime();
		i = countPrimes(10);
		long end = System.nanoTime();
		System.out.println(end - start + "  " + i);
		start = System.nanoTime();
		i = countPrimes2(10);
		end = System.nanoTime();
		System.out.println(end - start + "  " + i);
	}
	
	public static int countPrimes(int n) {
		if(n <= 2) return 0;
		int i, j;
		int tmp;
		int[] list = new int[n / 10 > 100 ? n / 10 : 100];
		list[0] = 2;
		int count = 1;
		a:for(i = 3; i < n; i += 2) {
			for(j = 0, tmp = list[j]; tmp * tmp < i; ++ j, tmp = list[j]) {
				if(i % tmp == 0) {
					continue a;
				}
			}
			list[count] = i;
			count ++;
		}
		return count;
	}
	
	public static int countPrimes2(int n) {
		   boolean[] isPrime = new boolean[n];
		   for (int i = 2; i < n; i++) {
		      isPrime[i] = true;
		   }
		   // Loop's ending condition is i * i < n instead of i < sqrt(n)
		   // to avoid repeatedly calling an expensive function sqrt().
		   for (int i = 2; i * i < n; i++) {
		      if (!isPrime[i]) continue;
		      for (int j = i * i; j < n; j += i) {
		         isPrime[j] = false;
		      }
		   }
		   int count = 0;
		   for (int i = 2; i < n; i++) {
		      if (isPrime[i]) count++;
		   }
		   return count;
	}
}
