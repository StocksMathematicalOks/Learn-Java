import java.util.ArrayList;
import java.util.Arrays;
interface AttrStat {
    public void Push(int data);
    public void Pop();
    public void View();
    public void Peek();
}
class StaticStack implements AttrStat {
    public int Length;
    public int index = 0;
    public int[] PoppedData;
    public int[] DataHold;
    public int rootLength;
    StaticStack(int capacity){
        DataHold = new int[capacity];
        Length = capacity;
        PoppedData = new int[Length];
    };
    public void Push(int data){ // private
        try{
            DataHold[index] = data;
            index++;
            rootLength = index;
        }
        catch(Exception error){
            throw new RuntimeException("Stack Overflow", error);
        }
    }
    public void Pop(){ // private
        try{
            System.arraycopy(DataHold, 0, PoppedData, 0, index-1);
            DataHold = PoppedData;
            index--;
            rootLength = index;
        }
        catch(Exception error){
            throw new RuntimeException("Stack Underflow", error);
        }
    }
    public void View(){ // private
        System.out.println(Arrays.toString(DataHold));
    }
    public void Peek(){ // private
        System.out.println(DataHold[Length-1]);
    }
}
class DynamicStack implements AttrStat {
    public int index = -1;
    public int Length = 0;
    ArrayList<Integer> DataHold = new ArrayList<Integer>();
    DynamicStack(){};
    public void Push(int data){ // private
        try {
            DataHold.add(data);
            index++;
            Length++;
        }
        catch(Exception error){
            throw new RuntimeException(error);
        }
    }
    public void Pop() { // private
        try {
            DataHold.remove(Length - 1);
            index--;
            Length--;
        }
        catch(Exception error) {
            throw new RuntimeException("Stack Underflow", error);
        }
    }
    public void View(){ // private
        System.out.println(DataHold);
    }
    public void Peek(){ // private
        System.out.println(DataHold.get(Length-1));
    }
}
class LinearQueue {
    public int Length = 0;
    ArrayList<Integer> DataHold = new ArrayList<Integer>();
    LinearQueue(){};
    public void Enqueue(int data){
        try {
            DataHold.add(data);
            Length++;
        }
        catch(Exception error){
            throw new RuntimeException(error);
        }
    }
    public void Dequeue(){
        DataHold.remove(0);
    }
    public void View() {
        System.out.println(DataHold);
    }
}
class LinkedList {
    private class Node {
        int data;
        Node next;
        Node(int val) {
            this.data = val;
            this.next = next;
        }
        public Node getNext(){
            return next;
        }
        public void setNext(){
            this.next = next;
        }
    }
    public Node head;
    public Node tail;
    public int length;
    private Node store = head;
    LinkedList(){
        this.head = null;
        this.length = 0;
        this.tail = null;
    }
    public void add(int val){
        while( head.getNext() != null ){
            head = head.getNext();
        }
        head.next = new Node(val);
    };
    public void remove(int val){
        while( head.getNext() != null ) {
            if (head.data == val) {
                break;
            }
            head = head.getNext();
        }
    }
    public Node next() {
        return head.next;
    }
    public void view(){
        while( head.getNext() != null ){
            System.out.println(head);
            head = head.getNext();
        }
    };
    public int length(){
        return this.length;
    };
    public Node head(){
        return this.head;
    };
    public Node tail(){
        return this.tail;
    };
}
