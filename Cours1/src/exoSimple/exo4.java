package exoSimple;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class exo4 {

    static void main() {

        Queue<String> queue = new ArrayDeque<String>();
        queue.add("a");
        queue.add("b");

        IO.println(queue);

        // à comprété
        Stack<String> stack = new Stack<String>();
        stack.push("a");
        stack.push("b");

        IO.println(stack);

        // Par rapport à Queue, Deque affiche depuis la fin
        Deque<String> deque = new ArrayDeque<String>();
        deque.push("a");
        deque.push("b");

        IO.println(deque);

    }
}
