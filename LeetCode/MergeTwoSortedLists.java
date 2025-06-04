//package LeetCode;
//
//public class MergeTwoSortedLists {
//    private ListNode head;
//    private ListNode tail;
//    private int size;
//
//    public MergeTwoSortedLists() {
//        this.size = 0;
//    }
//
//    public static void main(String[] args) {
//        MergeTwoSortedLists first =  new MergeTwoSortedLists();
//        MergeTwoSortedLists second = new MergeTwoSortedLists();
//        first.insertLast(1);
//        first.insertLast(2);
//        first.insertLast(4);
//
//
//        second.insertLast(1);
//        second.insertLast(3);
//        second.insertLast(4);
//        MergeTwoSortedLists ans= MergeTwoSortedLists.check(first,second);
//    }
//
//    public  class ListNode {
//         public ListNode(int val) {
//             this.val = val;
//         }
//         public ListNode(int val, ListNode next) {
//             this.val = val;
//             this.next = next;
//         }
//         public ListNode() {
//         }
//         int val;
//         ListNode next;
//
//     }
//
//    public  void insertFirst(int value){
//        ListNode ln = new ListNode(value);
//        ln.next=head;
//        head = ln;
//        if (tail == null) {
//            tail = head;
//        }
//        size=size+1;
//    }
//    public void  insertLast(int value){
//        if (tail == null) {
//            insertFirst(value);
//            return;
//        }
//        ListNode ln = new ListNode(value);
//        tail.next = ln;
//        tail = ln;
//        size++;
//    }
//
//    public void display() {
//        ListNode temp = head;
//        while (temp != null) {
//            System.out.print(temp.val + " -> ");
//            temp = temp.next;
//        }
//        System.out.println("END");
//    }
//
//    static MergeTwoSortedLists check(MergeTwoSortedLists list1, MergeTwoSortedLists list2){
//         ListNode head = null,ptr=null;
//         if (list1 == null) return list2;
//         if (list2 == null) return list1;
//     while (list1 != null && list2 != null){
//         if (head == null) {
//             if (list1.val < list2.val) {
//                 ptr = head = list1;
//                 list1 = list1.next;
//             }else {
//                 ptr = head = list2;
//                 list2 = list2.next;
//             }
//             continue;
//         }else {
//             if (list1.val < list2.val){
//                 ptr.next = list1;
//                 ptr =list1;
//                 list1 = list1.next;
//             }else {
//                 ptr.next = list2;
//                 ptr = list2;
//                 list2 = list2.next;
//             }
//
//         }
//
//     }
//         if (list1 != null) {
//          ptr.next = list1;
//         }else ptr.next = list2;
//
//return head;
//     }
//}
