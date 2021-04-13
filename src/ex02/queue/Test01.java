package ex02.queue;

import java.util.Arrays;

/*
    < Queue >
    - 대기 줄
    - 선입선출 (FIFO)

    < Queue 용어 >
    1. enqueue : 큐에 데이터를 저장
    2. dequeue : 큐에 데이터를 삭제
    3. head, front : 현재 큐의 가장 앞에 위치한 노드
        dequeue 할 때 증가.
        단, 최초 노드를 추가할 때 0 대입

    4. tail, rear  : 현재 큐의 가장 마지막에 위치한 노드
        enqueue 할 때 증가.
        단, 마지막 노드를 제거할 때 -1 대입
 */
class MyQueue {
    public static final int MAX = 10;
    private String[] arr = new String[MAX];
    private int head = -1, tail = -1;
    public void enqueue(String data){
        arr[++tail] = data;
        if(head == -1){ // 최초 노드 추가?
            head = tail;
        }
    }
    public String dequeue(){
        String data = arr[head];
        arr[head] = null;
        if(tail == head){ // 마지막 노드를 삭제?
            tail = head = -1;
        }
        else {
            ++head;
        }
        return data;
    }
    public String peek(){
        if (head == -1){
            return null;
        }
        return arr[head];
    }
    public void print(){
        System.out.println(Arrays.toString(arr));
    }
}
public class Test01 {
    public static void main(String[] args) {
        MyQueue my = new MyQueue();
        my.enqueue("A");
        my.enqueue("B");
        my.enqueue("C");
        my.print();

        my.dequeue();
        my.dequeue();
        my.print();
    }
}
