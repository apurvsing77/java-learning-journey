package Interviews_prep.DesignPattern.CreationalPattern.SingletonPattern.SingletonByCloning;

class SingletonCloneable implements Cloneable {
    private static final SingletonCloneable instance = new SingletonCloneable();

    private SingletonCloneable() {
        System.out.println("Singleton constructor called");
    }

    public static SingletonCloneable getInstance() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
       // return super.clone(); // Default clone implementation
        throw  new CloneNotSupportedException("Cannot  clone a singleton Instance");
    }
}
