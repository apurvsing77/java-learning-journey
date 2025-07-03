package JavaBasicProgram.interview;

public class RepeatedlyAddInteger {
		public static void main(String[] args) {

				System.out.println(addDigit(101));
		}

		public static  int addDigit(int num){
				if (num < 0)
						return  -1;
				if (num  == 0)
			    	return 0;
				return 1+(num - 1) % 9;
		}
}
