package Interviews_prep.JAVA8.FunctionalInterface;

@FunctionalInterface
public interface DefaultMethod {
    int process(int a, int b);
    default  int   show(int a , int b){
      int  result =  process(a,  b);
        System.out.println("Result is :"+result);
        return result;
    }
}
