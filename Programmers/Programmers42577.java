package Programmers;

public class Programmers42577 {
    class TriNode {
        TriNode[] childNodes = new TriNode[10];
        boolean isEnd = false;
    }

    public boolean solution(String[] phone_book) {
        TriNode root = new TriNode();
        for (String p : phone_book) {
            TriNode current = root;
            for (char c : p.toCharArray()) {
                if (current.childNodes[c - '0'] == null)
                    current.childNodes[c - '0'] = new TriNode();
                current = current.childNodes[c - '0'];
                if (current.isEnd)
                    return false;
            }
            current.isEnd = true;
            for (TriNode t : current.childNodes)
                if (t != null)
                    return false;
        }
        return true;
    }
}
