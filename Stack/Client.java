import java.util.*;

class Stack{
    int maxSize;
    int stackArr[];
    int top = -1;

    Stack(int size){
        this.maxSize = size;
        this.stackArr = new int[size];
    }

    void push(int data){
        if(top == maxSize-1){
            System.out.println("Stack Overflow");
            return;
        }else{
            top++;
            stackArr[top] = data;
        }
    }

    boolean empty(){
        if(top == -1)
            return true;
        else    
            return false;
    }

    int pop(){
        if(empty())
            System.out.println("Stack is empty");
        else{
            int val = stackArr[top];
            top--;
            return val;
        }
        return -1;
    }

    int peek(){
        if(empty())
            System.out.println("Stack is empty");
        else{
            return stackArr[top];
        }
        return -1;
    }

    int countNode(){
        /*if(empty())
            System.out.println("Stack is empty");
        else{
            return top;
        }
        return -1;*/

        return top;
    }

    void printStack(){
        if(empty()){
            System.out.println("Stack is empty");
            return;
        }else{
            System.out.print("[ ");
            for(int i = 0; i<=top; i++){
                System.out.print(stackArr[i] + " ");
            }
            System.out.println(" ]");
        }
    }
}

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the stack:");
        int size = sc.nextInt();

        Stack s = new Stack(size);
        char ch;

        do{
            System.out.println("1.Push");
            System.out.println("2.pop");
            System.out.println("3.peek");
            System.out.println("4.empty");
            System.out.println("5.size");
            System.out.println("6.printStack");

            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch(choice){
                case 1:{
                    System.out.println("Enter element in the stack");
                    int data = sc.nextInt();
                    s.push(data);
                }
                break;

                case 2:{
                    int flag = s.pop();
                    if(flag != -1){
                        System.out.println(flag + " popped!");
                    }
                }
                break;

                case 3:{
                    int flag = s.peek();
                    if(flag != 1){
                        System.out.println(flag);
                    }
                }
                break;

                case 4:{
                    boolean flag = s.empty();
                    if(flag)
                        System.out.println("Empty");
                    else    
                        System.out.println("No Empty");
                }
                break;

                case 5:{
                    int sz = s.countNode();
                    System.out.println("Stack size: " + sz+1);
                }   
                break;

                case 6:
                    s.printStack();
                    break;

                default:
                    System.out.println("Wrong choice");
                    break;
            }
            System.out.println("Do you want to continue");
            ch = sc.next().charAt(0);
        }while(ch == 'y' || ch == 'Y');
        sc.close();
    }
}
