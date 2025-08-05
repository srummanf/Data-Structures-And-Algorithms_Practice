
/**
 * Monotonic Stackk
 * https://leetcode.com/problems/online-stock-span/description/
 */

import java.util.ArrayList;
import java.util.Stack;

import java.util.*;


public class StockSpanner {

    Stack<ArrayList<Integer>> stack = new Stack<>();


    public int span(int price) {
        int span = 1; // currently span of price is 1 which is itself
        while (!stack.isEmpty() && stack.peek().get(0) <= price) {
            span += stack.pop().get(1);
        }
        ArrayList<Integer> pair = new ArrayList<>();
        pair.add(price);
        pair.add(span);
        stack.push(pair);
        return span;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
        for (int price : prices) {
            System.out.println(stockSpanner.span(price));
        }
    }
}
