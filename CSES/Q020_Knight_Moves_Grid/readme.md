# CSES Problem: Knight Moves Grid

This repository contains the solution for the **"Knight Moves Grid"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/3217).

## Problem Description

There is a knight on an $n \times n$ chessboard. For each square, print the minimum number of moves the knight needs to reach the top-left corner.

### Constraints

- $4 \le n \le 1000$

## Example

**Input:**

```text
8
```

**Output:**

```text
0 3 2 3 2 3 4 5
3 4 1 2 3 4 3 4
2 1 4 3 2 3 4 5
3 2 3 2 3 4 3 4
2 3 2 3 4 3 4 5
3 4 3 4 3 4 5 4
4 3 4 3 4 5 4 5
5 4 5 4 5 4 5 6
```

## Solution Approach

Finding the minimum number of moves from every cell to the top-left corner $(0, 0)$ is equivalent to finding the shortest path from $(0, 0)$ to all other cells, since knight moves are symmetric and undirected.

Because every knight move has an unweighted cost of $1$, this can be solved using a standard **Breadth-First Search (BFS)** starting from $(0, 0)$.

### Logic

1. Initialize an $n \times n$ distance matrix `mat` filled with `-1` to represent unvisited cells.
2. Set the starting distance `mat[0][0] = 0`.
3. Use an array-based queue to run BFS from $(0, 0)$:
   - To optimize memory allocation and speed, pack the 2D coordinates `(r, c)` into a single 32-bit integer: `(r << 16) | c`.
   - Extract row and column using `r = curr >> 16` and `c = curr & 0xFFFF`.
4. For each cell popped from the queue, explore all 8 valid knight move offsets:
   - `(-2, -1), (-2, 1), (-1, 2), (1, 2), (2, 1), (2, -1), (1, -2), (-1, -2)`
5. If the next cell `(nr, nc)` lies within bounds ($0 \le nr < n$ and $0 \le nc < n$) and has not been visited (`mat[nr][nc] == -1`):
   - Update `mat[nr][nc] = mat[r][c] + 1`.
   - Push the packed coordinate `(nr << 16) | nc` into the queue.
6. Print the resulting distance matrix row by row.

## Complexity

### Time Complexity

$$O(n^2)$$

The grid contains $n^2$ cells. Each cell is visited and enqueued at most once, and for each cell, we check a constant 8 possible knight moves.

### Space Complexity

$$O(n^2)$$

The distance matrix `mat` of size $n \times n$ and the static BFS queue array of size $n^2$ require $O(n^2)$ space.

## Code Implementation (Java)

```java
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final int[] DRow = {-2, -2, -1, 1, 2, 2, 1, -1};
    private static final int[] DCol = {-1, 1, 2, 2, 1, -1, -2, -2};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        int[][] mat = new int[n][n];

        for (int[] row : mat) {
            Arrays.fill(row, -1);
        }

        int[] queue = new int[n * n];
        int head = -1;
        int tail = 0;

        queue[++head] = 0;
        mat[0][0] = 0;

        while (tail <= head) {
            int curr = queue[tail++];
            int r = curr >> 16;
            int c = curr & 0xFFFF;

            for (int x = 0; x < 8; x++) {
                int nr = r + DRow[x];
                int nc = c + DCol[x];

                if (0 <= nr && nr < n && 0 <= nc && nc < n && mat[nr][nc] == -1) {
                    mat[nr][nc] = mat[r][c] + 1;
                    queue[++head] = (nr << 16) | nc;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(mat[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
    }
}
```

---

# ---------------------------- THANK YOU ----------------------------