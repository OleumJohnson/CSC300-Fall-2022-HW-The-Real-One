package net.codejava;
import java.util.Stack;

public class StackMin {
	
	private int[] arr;
    private int top;
    //StackMin sorter;
    //private StackMin sorter = new StackMin(6);
    private int min;
    private int height;
 
    StackMin(int size)
    {
        arr = new int[size];
        top = -1;
        min = 100000;
        height = size;
    }
 
    public void Push(int num)
    { 
    	if (isFull())
        {
    		System.out.println("Cannot push more, stack is full");
            System.exit(-1);
        }
    	
    	//this breaks if I just say top + 2 so gottem I guess
        arr[top++ + 1] = num;
        
        if(num < min) {
        	min = num;
        }
    }
 
    public int Pop()
    {   
        return arr[top--];
    }
    
    public int Peek()
    {
        if (isEmpty() == false) {
            return arr[top];
        }
        else {
            System.exit(-1);
        }
 
        return -1;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == height - 1;     // or return size() == capacity;
    }
    
    public void Min() {
    	System.out.println("Current min is " + min);
    }
    
    
    public static void main(String[] args) {
    	StackMin stack = new StackMin(6);
    	
        stack.Push(25);
        stack.Push(12);
        stack.Push(7);
        stack.Push(63);
        stack.Push(41);
        stack.Push(18);
        stack.Pop();
        stack.Min();
    }
}
    
