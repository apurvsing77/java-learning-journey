package Interviews_prep.JAVA8.FunctionalInterface;

public class StaticTest {
    public static void main(String[] args) {
        StaticMethod st = () -> System.out.println("Abstruct method ");
        st.staticDisplay();
        StaticMethod.show();
    }


}
