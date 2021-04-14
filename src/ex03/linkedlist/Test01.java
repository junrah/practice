package ex03.linkedlist;

// 단일 연결 리스트
class SinglyLinkedList<E> {
    Node head;

    void add(E element) {
        Node node = new Node();
        node.data = element;

        if (head == null) {
            head = node;
            return;
        }

        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
    }

    // remove(E e) : e 를 삭제
    // 삭제가 완료되었으면 삭제한 원소를 return
    // 그렇지 않으면 (애초에 없는 원소였다면) null 을 return
    E remove(E e){
        Node tmp = head;
        Node prev = null; // 앞 노드
        E target = null;

        while(tmp != null){
            if(tmp.data == e){
                target = tmp.data;
                if(prev == null)  // head를 삭제할 때
                    head = tmp.next;
                else
                    prev.next = tmp.next;

                tmp = tmp.next;
                continue;
            }

            prev = tmp;
            tmp = tmp.next;
        }
        return target;
    }

    // boolean replace(E old, E new) : old 를 new 로 대체
    // 대체 잘 되었으면 true
    // old 가 없었다면 false
    boolean replace(E oldElement, E newElement){
        Node tmp = head;
        boolean result = false;
        while (tmp != null){
            if(tmp.data == oldElement){
                tmp.data = newElement;
                result = true;
            }
            tmp = tmp.next;
        }
        return result;
    }
    // boolean insert(E prev, E new) : prev 뒤에 new 를 추가
    // 10 -> 20 -> 30 에서 insert(20, 25) 하면
    // 10 -> 20 -> 25 -> 30 가 되도록함.
    // 삽입 잘 되었으면 true
    // prev 가 없었다면 false
    boolean insert(E prevElement, E newElement){
        Node tmp = head;
        while(tmp != null){
            if(tmp.data == prevElement){
                Node newNode = new Node();
                newNode.data = newElement;
                newNode.next = tmp.next;
                tmp.next = newNode;
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }
    //     boolean insertAt(int i, E new) : i번째 노드로 new 를 추가
//     10 -> 20 -> 30 에서 insert(0, 25) 하면
//     25 -> 10 -> 20 -> 30 가 되도록함.
//     삽입 잘 되었으면 true
//     i가 잘못된 인덱스라면 false (음수거나, 원소 개수보다 큰 인덱스)
    boolean insertAt(int i, E newElement){
        int idx = 0;
        Node tmp = head;
        Node prev = null;
        while(tmp != null){
            if(idx > i)
                return false;
            if(idx == i){
                Node node = new Node();
                node.data = newElement;
                if(prev == null){ // head ?
                    node.next = tmp;
                    head = node;
                    return true;
                }
                node.next = tmp;
                prev.next = node;
                return true;
            }
            prev = tmp;
            tmp = tmp.next;
            ++idx;
        }
        return false;
    }


    class Node {
        E data;
        Node next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("head:")
                .append(head == null ? null : head.data)
                .append(" [");

        Node tmp = head;
        while(tmp != null){
            sb.append(tmp.data)
                    .append(tmp.next == null ? "": ", ");
            tmp = tmp.next;
        }

        sb.append("]");
        return sb.toString();
        // "head:10 [10 20 30 40]"
    }
}

public class Test01 {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list1;
//        SinglyLinkedList<String> list2;

        list1 = new SinglyLinkedList<>();
        System.out.println(list1);
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(40);
        list1.add(50);
        list1.add(20);
        list1.add(30);
        list1.add(20);
        list1.add(20);
        list1.add(20);
        System.out.println(list1);

        System.out.println(list1.remove(50));
        System.out.println(list1);

        System.out.println(list1.remove(20));
        System.out.println(list1);

        System.out.println(list1.remove(100));
        System.out.println(list1);

        System.out.println(list1.remove(10));
        System.out.println(list1);

        System.out.println(list1.insert((Integer)30, 35));
        System.out.println(list1);

        System.out.println(list1.insert((Integer)35, 40));
        System.out.println(list1);

        list1.add(100);
        System.out.println(list1.insert((Integer)100, 200));
        System.out.println(list1);

        System.out.println(list1.insert((Integer)1000, 200));
        System.out.println(list1);

        System.out.println(list1.insertAt(0, 1000));
        System.out.println(list1);

        System.out.println(list1.insertAt(8, 2000));
        System.out.println(list1);
    }
}
