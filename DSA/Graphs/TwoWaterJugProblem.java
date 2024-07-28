package DSA.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TwoWaterJugProblem {
    class Box {
    int jug1;
    int jug2;
    int steps;
    
    public Box(int jug1, int jug2, int steps) {
        this.jug1 = jug1;
        this.jug2 = jug2;
        this.steps = steps;
    }
}

class Solution
{
    boolean[][] visited;
    
    private int helper(int m, int n, int d, int jug1, int jug2) {
        if (jug1 == d || jug2 == d) {
            return 0;
        } else if (visited[jug1][jug2]) {
            return Integer.MAX_VALUE;
        }
        visited[jug1][jug2] = true;
        int emptyJugOperation = Integer.MAX_VALUE;
        int fillJugOperation = Integer.MAX_VALUE;
        int oneToAnotherOperation = Integer.MAX_VALUE;
        
        if (jug1 > 0) {
            emptyJugOperation = helper(m, n, d, 0, jug2);
            if (emptyJugOperation != Integer.MAX_VALUE) {
                emptyJugOperation++;
            }
        }
        
        if (jug2 > 0) {
            int other = helper(m, n, d, jug1, 0);
            if (other != Integer.MAX_VALUE) {
                other++;
            }
            emptyJugOperation = Math.min(emptyJugOperation, other);
        }
        
        
        if (jug1 == 0) {
            fillJugOperation = helper(m, n, d, m, jug2);
            if (fillJugOperation != Integer.MAX_VALUE) {
                fillJugOperation++;
            }
        }
        
         if (jug2 == 0) {
            int other = helper(m, n, d, jug1, n);
            if (other != Integer.MAX_VALUE) {
                other++;
            }
            fillJugOperation = Math.min(fillJugOperation, other);
        }
        
        if (jug1 > 0) {
            int mxJug2 = Math.min(n, jug2 + jug1);
            if (mxJug2 - jug2 > 0) {
                int extra = mxJug2 - jug2;
                int other = helper(m, n, d, jug1 - extra, mxJug2);
                if (other != Integer.MAX_VALUE) {
                    other++;
                }
                oneToAnotherOperation = Math.min(oneToAnotherOperation, other);
            }
            
        }
        
        if (jug2 > 0) {
            int mxJug1 = Math.min(m, jug1 + jug2);
            if (mxJug1 - jug1 > 0) {
                int extra = mxJug1 - jug1;
                int other = helper(m, n, d, mxJug1, jug2 - extra);
                if (other != Integer.MAX_VALUE) {
                    other++;
                }
                oneToAnotherOperation = Math.min(oneToAnotherOperation, other);
            }
            
        }
        
        int result = Math.min(emptyJugOperation, fillJugOperation);
        result = Math.min(result, oneToAnotherOperation);
        visited[jug1][jug2] = false;
        return result;
    }
    
    private int helperUsingBFS(int m, int n, int d) {
        Queue<Box> Q = new LinkedList<>();
        Q.add(new Box(0, 0, 0));
        
        while (!Q.isEmpty()) {
            Box curr = Q.poll();
            if (curr.jug1 == d || curr.jug2 == d) {
                return curr.steps;
            }
            int jug1 = curr.jug1;
            int jug2 = curr.jug2;
            
            visited[curr.jug1][curr.jug2] = true;
            if (jug1 > 0 && !visited[0][jug2]) {
                visited[0][jug2] = true;
                Q.add(new Box(0, jug2, curr.steps + 1));
            }
            
            if (jug2 > 0 && !visited[jug1][0]) {
                visited[jug1][0] = true;
                Q.add(new Box(jug1, 0, curr.steps + 1));
            }
            
            
            if (jug1 == 0 && !visited[m][jug2]) {
                visited[m][jug2] = true;
                Q.add(new Box(m, jug2, curr.steps + 1));
            }
            
             if (jug2 == 0 && !visited[jug1][n]) {
                 visited[jug1][n] = true;
                Q.add(new Box(jug1, n, curr.steps + 1));
            }
            
            if (jug1 > 0) {
                int mxJug2 = Math.min(n, jug2 + jug1);
                int extra = mxJug2 - jug2;
                if (extra > 0 && !visited[jug1 - extra][mxJug2]) {
                    visited[jug1 - extra][mxJug2] = true;
                    Q.add(new Box(jug1 - extra, mxJug2, curr.steps + 1));
                }
                
            }
            
            if (jug2 > 0) {
                int mxJug1 = Math.min(m, jug1 + jug2);
                int extra = mxJug1 - jug1;
                if (extra > 0 && !visited[mxJug1][jug2 - extra]) {
                    visited[mxJug1][jug2 - extra] = true;
                    Q.add(new Box(mxJug1, jug2 - extra, curr.steps + 1));
                }
            }
        }
        return -1;
    }
    
    public int  minSteps(int m, int n, int d) {
        visited = new boolean[m + 1][n + 1];
        for (int row = 0; row <= m; row++) {
            Arrays.fill(visited[row], false);
        }
        //int result = helper(m, n, d, 0, 0);
        int result = helperUsingBFS(m, n, d);
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }
}
}
