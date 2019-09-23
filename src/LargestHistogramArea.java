import java.util.Stack;

public class LargestHistogramArea {
    public static int largestRectangleArea(int[] A) {
        Stack<Integer> s = new Stack<>();
        int n = A.length;
        int ans[] = new int[n];

        int area = 0, max = 0;
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && A[s.peek()] >= A[i]) {
                int top = s.pop();
                if (s.isEmpty())
                    area = i * A[top];
                else {
                    area = A[top] * (i - s.peek() - 1);
                }
                //System.out.println(area + " " + max);
                max = Math.max(area, max);
            }
            s.push(i);
        }
        int i = n;
        while (!s.isEmpty()) {
            int top = s.pop();
            if (s.isEmpty())
                area = i * A[top];
            else
                area = A[top] * (i - s.peek() - 1);
            max = Math.max(area, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int A[] = {90, 58, 69, 70, 82, 100, 13, 57, 47, 18};
        System.out.println(largestRectangleArea(A));
    }
}