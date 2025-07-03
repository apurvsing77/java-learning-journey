package JavaBasicProgram.interview;

public class LargestRectangle {
		public static void main(String[] args) {
				int redius= 5;
				double side;
				double area_circle= 3.141 * redius * redius;
				System.out.println("Area of Circle: "+area_circle);

				side = redius * Math.sqrt(2);

				double area_squre = side * side;

				System.out.println("Area of area of largest possible rectangle : "+area_squre);

		}
}
