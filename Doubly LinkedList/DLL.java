class Node{

    Node prev = null;
    int data;
    Node next = null;

    Node(int data){
        this.data = data;
    }
}

class DoublyLinkedListDemo{
    Node head = null;

    void addFirst(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void addLast(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
        }else{
            Node temp = head;

            while(temp.next != null){
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    int countNode(){
        if(head == null){
            return 0;
        }else{
            Node temp = head;
            int count = 0;

            while(temp != null){
                temp = temp.next;
                count++;
            }
            return count;
        }
    }

    void addAtPos(int pos, int data){

        if(pos <= 0 || pos >= countNode()+2){
            System.out.println("Invalid Input");
            return;
        }
        
        if(pos == 1){
            addFirst(data);
        }else if(pos == countNode()+1){
            addLast(data);
        }else{

            Node newNode = new Node(data);
            Node temp = head;

            while(pos-2 != 0){
                temp = temp.next;
                pos--;
            }
    
            newNode.prev = temp;
            newNode.next = temp.next;
            temp.next = newNode;
            newNode.next.prev = newNode;
        }

    }

    void delFirst(){
        if(head == null){
            System.out.println("DLL is empty");
        }else if(countNode() == 1){
            head = null;
        }else{
            head = head.next;
            head.prev = null;
        }
    }

    void delLast(){
        if(head == null){
            System.out.println("DLL is empty");
        }else if(countNode() == 1){
            head = null;
        }else{
            Node temp = head;

            while(temp.next != null){
                temp = temp.next;
            }
            temp.prev.next = null;
            temp.prev = null;   // this operation is optional in java (GC)
        }
    }

    void delAtPos(int pos){
        if(pos <= 0 || pos > countNode()+1){
            System.out.println("Invalid Input");
        }
        
        if(pos == 1){
            delFirst();
        }else if(pos == countNode()){
            delLast();
        }else{
            Node temp = head;

            while(pos-2 != 0){
                temp = temp.next;
                pos--;
            }

            temp.next = temp.next.next;
            temp.next.prev = temp;

        }
    }

    void printDLL(){

        if(head == null){
            System.out.println("DLL is empty");
        }else{
            Node temp = head;

            while(temp.next != null){
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println(temp.data);
        }
    }
}

public class DLL {
    public static void main(String[] args) {

        DoublyLinkedListDemo dll = new DoublyLinkedListDemo();

        dll.addFirst(10);
        dll.addFirst(20);
        dll.addFirst(30);
        dll.addFirst(40);

        dll.addLast(50);
        dll.addLast(60);

        dll.addAtPos(3, 80);
        dll.addAtPos(dll.countNode()+1, 1);
        dll.delFirst();
        dll.addAtPos(1, 100);

        dll.delLast();
        dll.delAtPos(1);
        dll.delAtPos(dll.countNode());
        dll.delAtPos(3);

        dll.printDLL();

        System.out.println(dll.countNode());
    }
}
