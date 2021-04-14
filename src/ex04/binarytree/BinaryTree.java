package ex04.binarytree;

public class BinaryTree {
    private Node root;

    class Node {
        int data;
        Node left, right;
        Node(int data){ this.data = data; }
    }

    void traverse(){
        System.out.println("---- 현재 노드 ----");
        inorder(root);
        System.out.println();
    }

    // 트리의 중위순회
    void inorder(Node node){
        if (node == null){
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
    // 트리의 전위순회
    void preorder(Node node){
        if (node == null){
            return;
        }
        System.out.print(node.data + " "); // D
        preorder(node.left); // L
        preorder(node.right); // R
    }
    // 트리의 후위순회
    void postorder(Node node){
        if (node == null){
            return;
        }
        postorder(node.left); // L
        postorder(node.right); // R
        System.out.print(node.data + " "); // D
    }

    // data가 트리에 있으면 true 없으면 false
    // O(log2 N) - > 반씩 나눠서 진행하기 때문
    boolean search(int data){
        Node tmp = root;
        while(tmp != null){
            if(tmp.data < data){
                tmp = tmp.right;
            }
            else if(tmp.data > data){
                tmp = tmp.left;
            }
            else {
                return true;
            }
        }
        return false;
    }

    void insert(int data){
        if(root == null){
            root = new Node(data);
            return;
        }
        Node tmp = root;
        while(tmp != null){
            if(tmp.data < data) {
                if (tmp.right == null) {
                    tmp.right = new Node(data);
                    break;
                } else {
                    tmp = tmp.right;
                }
            }
            else if(tmp.data > data)
                if(tmp.left == null) {
                    tmp.left = new Node(data);
                    break;
                }
                else {
                    tmp = tmp.left;
                }
            else
                throw new IllegalArgumentException("중복된 원소");
        }
    }


    void delete(int data){
        delete(data, root, null);
    }
    void delete(int data, Node node, Node parent){
        if(node == null){
            return;
        }


        if(node.data > data){
            delete(data, node.left, node);
            return;
        }
        else if(node.data < data){
            delete(data, node.right, node);
            return;
        }

        Node targetChild = null;
        // 삭제할 노드 찾았을 때
        if(node.left != null){
            if(node.right != null){
                // 후계자 노드 찾기
                Node heir = node.left;
                while(heir.right != null){
                    heir = heir.right;
                }
                node.data = heir.data;
                delete(heir.data, node.left, node);
            }
            else {
                targetChild = node.left;
            }
        }
        else{
            targetChild = node.right;
        }
        if(parent.data < node.data){
            parent.right = targetChild;
        }
        else {
            parent.left = targetChild;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(100);
        tree.insert(150);
        tree.insert(200);
        tree.insert(175);
        tree.insert(75);
        tree.insert(25);
        tree.insert(1000);

        tree.delete(75);
        tree.traverse();  // 25 75 100 150 175 200 1000 (오름차순)
    }
}
