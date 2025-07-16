package JavaBasicProgram.interview;


interface  InnerContract{
	void display();
}
class OuterClass {
		public InnerContract m1(){
				 class InnerClass implements InnerContract{
					@Override
					 public void display(){
								System.out.println("Inside InnerClass");
						}
				}

				return new InnerClass();
		}

		public void m2(){
				System.out.println("Inside OuterClass");
		}
}

public class MethodInnerClass {
		public static void main(String[] args) {
				OuterClass outer = new OuterClass();
			  InnerContract inner = outer.m1();
			  inner.display();


		}
}
