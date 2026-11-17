class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (op.equals("+")) {
                // Pop the top two elements to calculate the sum, then push them back and push the new sum
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top); // restore the top element
                stack.push(newTop);
            } else if (op.equals("D")) {
                // Double the previous score
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                // Invalidate / remove the previous score
                stack.pop();
            } else {
                // Record a new score
                stack.push(Integer.parseInt(op));
            }
        }

        // Sum up all scores left in the stack
        int totalSum = 0;
        for (int score : stack) {
            totalSum += score;
        }

        return totalSum;
    }
}