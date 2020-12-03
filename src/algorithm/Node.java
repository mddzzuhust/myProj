package algorithm;

import java.util.LinkedList;

class Node {
    char content; // 节点包含的内容
    boolean isEnd; // 是否在该节点行成过一个单词
    int count;  // 统计该节点的字符被几个单词共享
    LinkedList<Node> childList; // 子节点的集合

    //初始化
    public Node(char c){
        childList = new LinkedList<Node>();
        isEnd = false;
        content = c;
        count = 0;
    }

    //查找子节点中是否有内容为x的子节点，有则返回该子节点，否则返回空
    public Node subNode(char c){
        if(childList != null){
            for(Node eachChild : childList){
                if(eachChild.content == c){
                    return eachChild;
                }
            }
        }
        return null;
    }
}

