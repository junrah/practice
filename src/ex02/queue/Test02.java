package ex02.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Test02 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // 데이터 저장 : add(), offer()
        // add() : 예외 발생
        // offer() : false 리턴

        queue.add("A");
        queue.add("B");
        queue.offer("C");
        queue.offer("D");
        System.out.println(queue);

        // 삭제
        // remove() : 예외발생
        // poll() : null
        String s1 = queue.remove();
        String s2 = queue.poll();
        System.out.println("s1 : " + s1);
        System.out.println("s2 : " + s2);
        System.out.println(queue);

        // 슬쩍보기
        // peek() - null
        // element() - 예외발생
        s1 = queue.peek();
        s2 = queue.element();
        System.out.println("s1 : " + s1);
        System.out.println("s2 : " + s2);
        System.out.println(queue);

    }
}
