package LeetCode;

public class LL {
    private  Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size= 0;
    }

    class Node{
        private int val;
        private  Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node neext) {
            this.val = val;
            this.next = neext;
        }
    }
    public  void insertFirst(int val){
       Node node = new Node(val);
       node.next= head;
       head= node;

    }
    public void insertLast(int val){
        if (tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        node.next = head;
        head = node;
    }
    public  void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
     LL ll = new LL();
        ll.insertLast(10);
        ll.insertLast(12);
        ll.insertLast(36);
        ll.insertLast(54);
        ll.insertLast(21);
        ll.insertLast(85);
        ll.insertLast(44);
        ll.display();
        ll.tail= ll.head;
        System.out.println(checkSycle(ll.head));
    }
    static  boolean checkSycle(Node head){
        Node faster= head;
        Node slower = head;

        while (slower != null && faster != null && faster.next != null){
            slower = slower.next;
            faster = faster.next.next;

         if (faster == slower)
         {
             return  true;
         }
        }
        return false;
    }
}
