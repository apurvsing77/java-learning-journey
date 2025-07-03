package JavaBasicProgram.interview;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
		public static void main(String[] args) {
				List<Integer> ls = new ArrayList<>();
				int num = 6;
				for (int i = 1; i <=num ; i++) {
						if (i <=3){
								ls.add(i);
						}else {
								ls.add(checkFector(i));
						}
				}
				System.out.println(ls);
		}
		static  int checkFector(int n){
           if (checkPrime(n))
							 return n;

					 int minFactor = Integer.MAX_VALUE;
				for (int i = 2; i <=n ; i++) {
						if (n % i == 0)
								minFactor = Math.min(minFactor,i);
				}
				return minFactor;
		}

		static boolean  checkPrime(int n ){
				int reng = (int)Math.sqrt(n);
				for (int i = 2; i <=reng ; i++) {
						if (n % i == 0)
								return false;
				}
				return true;
		}
}
