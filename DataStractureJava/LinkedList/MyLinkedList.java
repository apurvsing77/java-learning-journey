package DataStractureJava.LinkedList;

public class MyLinkedList {
    Node head;

    public void add(int data) {
        Node currentNode = head;
        Node newNode = new Node(data, null);
        if (head == null){
            head = newNode;

        } else {
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.next = null;
        }
    }

    public void addAtMid(int position,int data){
        Node currentNode =head;
        Node newNode = new Node(data,null);
        while(currentNode.next.data != position){
            currentNode = currentNode.next;

        }
        newNode.next = currentNode.next;
        currentNode.next =newNode;
    }


    public void addAtFirst(int data){
        Node newNode = new Node(data, head);
        newNode.next = head;
        head = newNode;
    }
    public void delete(int key){
        if (head == null){
            return;
        }
        if (head.data == key)
            head = head.next;

        Node current = head;
        while (current.next != null && current.next.data != key){
            current = current.next;
        }
        current.next = current.next.next;
    }
    public  void display(){
        Node curentNode = head;
        while (curentNode != null){
            System.out.print(curentNode.data+" -> ");
            curentNode = curentNode.next;
        }
        System.out.println("NULL");
    }
}
