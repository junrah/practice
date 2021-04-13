package ex01.stack;

import java.util.Arrays;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        // 배열을 Stack 구조로 사용하기
        final int MAX = 5;
        String[] arr = new String[MAX];
        int top = -1;
        String menu = "1. push (저장) \n"
                + "2. pop (삭제) \n"
                + "3. peek (현재 top 보기) \n"
                + "4. 종료";
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println(Arrays.toString(arr));
            System.out.println(menu);
            int select = sc.nextInt();
            if(select == 1){
                System.out.print("새 문자열 : ");
                arr[++top] = sc.next();
            }
            else if(select == 2){
                arr[top--] = null;
                System.out.println("pop 완료!");
            }
            else if(select == 3){
                System.out.println("현재 처리될 값은 " + arr[top]);
            }
            else if(select == 4){
                break;
            }
        }
    }
}
