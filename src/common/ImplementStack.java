package common;

//Implement a stack with push(), pop() and min() in O(1) time
public class ImplementStack {
    int min = Integer.MAX_VALUE;
    int index = 0;
    int[] arr = new int[10];

    void push(int value){
        if(index == arr.length)
            throw new RuntimeException("stack is full");
        arr[index++] = value;
        if(min > value)
            min = value;
    }
    int pop(){
       if(index < 0)
           throw new RuntimeException("stack is empty");
       return arr[--index];
    }

    int min(){
        return min;
    }

    public static void main(String[] args) {
        ImplementStack is = new ImplementStack();
        is.push(3);
        System.out.println(is.pop());
        is.push(1);
        is.push(2);
        System.out.println(is.min());
        is.pop();
        is.push(4);
        System.out.println(is.index);
    }


}
