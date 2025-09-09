package DataStractureJava.LinkedList;

public class LinkdList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(12);
        list.add(14);
        list.add(16);
        list.add(10);
        list.addAtFirst(9);

        list.display();
//        list.delete(14);
        list.addAtMid(16,20);
        list.display();
    }
}
