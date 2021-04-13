package ex01.stack;

import java.util.Stack;

public class Test02 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // 원소 추가
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack);

        // 원소 삭제
        String d = stack.pop();
        System.out.println("pop된 데이터 : " + d);
        System.out.println(stack);

        d = stack.pop();
        System.out.println("pop된 데이터 : " + d);
        System.out.println(stack);

        // 현재 top 조회
        d = stack.peek();
        System.out.println("peek된 데이터 : " + d);
        System.out.println(stack);
    }
}
