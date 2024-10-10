package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10845 {
    static class MyQueue {
        private int[] data;
        private int head = 0;
        private int tail = 0;

        public MyQueue() {
            data = new int[10001];
        }

        public void push(int a) {
            data[tail++] = a;
        }

        public int pop() {
            if (head >= tail)
                return -1;
            return data[head++];
        }

        public int size() {
            return tail - head;
        }

        public int empty() {
            return size() > 0 ? 0 : 1;
        }

        public int front() {
            if (head == tail)
                return -1;
            return data[head];
        }

        public int back() {
            if (head == tail)
                return -1;
            return data[tail - 1];
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MyQueue myQueue = new MyQueue();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            switch (s.split(" ")[0]) {
                case "push":
                    myQueue.push(Integer.parseInt(s.split(" ")[1]));
                    break;
                case "pop":
                    sb.append(myQueue.pop() + "\n");
                    break;
                case "size":
                    sb.append(myQueue.size() + "\n");
                    break;
                case "empty":
                    sb.append(myQueue.empty() + "\n");
                    break;
                case "front":
                    sb.append(myQueue.front() + "\n");
                    break;
                case "back":
                    sb.append(myQueue.back() + "\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }

}
