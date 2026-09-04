# CSES Problem: Chessboard and Queens

This repository contains the solution for the **"Chessboard and Queens"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/1624).

## Problem Description

Your task is to place eight queens on an $8 \times 8$ chessboard so that no two queens are attacking each other.

Each square on the board is either free (`.`) or reserved (`*`). You can only place queens on the free squares. However, the reserved squares do not prevent queens from attacking each other.

The goal is to find the **total number of possible ways** to place the eight queens validly.

### Constraints

- The board size is exactly $8 \times 8$.

## Example

**Input:**

```text
........
........
..*.....
........
........
.....**.
...*....
........
```

**Output:**

```text
65
```

## Solution Approach

Since the board size is fixed at $8 \times 8$, we can use **backtracking** to generate all valid queen placements.

To optimize the search, we place queens row by row. Rather than searching the entire grid repeatedly, we maintain 1D boolean arrays to track which columns and diagonals are currently under attack by previously placed queens.

### Logic

1. Read the $8 \times 8$ grid into a 2D character array.
2. Maintain three boolean tracking arrays:
    - `column[]`: Tracks occupied columns.
    - `diagonal[]`: Tracks occupied main diagonals (top-left to bottom-right).
    - `anti_diagonal[]`: Tracks occupied anti-diagonals (top-right to bottom-left).
3. Start the recursion from the last row (`row = 7`) and proceed upwards towards row `0`.
4. For the current row, iterate through each column (`col = 0` to `7`).
5. Skip the square if it contains a `*` (reserved square) or if its column/diagonal/anti-diagonal is already under attack.
6. If the square is safe:
    - Mark the column, diagonal, and anti-diagonal as occupied.
    - Recursively call the solver for the next row (`row - 1`).
    - Backtrack by unmarking the column, diagonal, and anti-diagonal so other configurations can be explored.
7. If the recursion reaches a row index less than $0$, all 8 queens have been placed successfully; return $1$.

## Diagonal Tracking Representation

We map the $8 \times 8$ grid diagonals to 1D boolean arrays of size $15$:

- **Columns (`col`)**: Values range from $0$ to $7$.
- **Main Diagonals (`row - col + 7`)**: Values remain constant along any top-left to bottom-right diagonal. Adding $7$ shifts negative indices into positive values ($0$ to $14$).
- **Anti-Diagonals (`row + col`)**: Values remain constant along any top-right to bottom-left diagonal ($0$ to $14$).

## Complexity

Since we place exactly one queen per row and prune branches as soon as a conflict is detected:

### Time Complexity

$$
O(N!)
$$

where $N = 8$. In the worst unconstrained case, there are at most $8! = 40,320$ permutations to evaluate. Due to reserved square constraints and early diagonal pruning, the search visits far fewer states.

### Space Complexity

$$
O(N)
$$

The space complexity is dominated by the recursion stack (which goes up to depth $8$) and the boolean arrays used for state tracking.

## Code Implementation (Java)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] board = new char[8][];
        for (int i = 0; i < 8; i++) {
            board[i] = br.readLine().trim().toCharArray();
        }

        boolean[] column = new boolean[8];
        boolean[] diagonal = new boolean[15];
        boolean[] anti_diagonal = new boolean[15];

        System.out.println(solve(7, board, column, diagonal, anti_diagonal));
    }

    private static int solve(int row, char[][] board, boolean[] column, boolean[] diagonal, boolean[] anti_diagonal) {
        // base case
        if (row < 0) return 1;

        // recursive work
        int sum = 0;

        for (int col = 0; col < 8; col++) {

            if (board[row][col] == '*' || column[col] || diagonal[row - col + 7] || anti_diagonal[row + col]) {
                continue;
            }

            column[col] = true;
            diagonal[row - col + 7] = true;
            anti_diagonal[row + col] = true;

            sum += solve(row - 1, board, column, diagonal, anti_diagonal);

            column[col] = false;
            diagonal[row - col + 7] = false;
            anti_diagonal[row + col] = false;
        }

        return sum;
    }
}
```

---

# ---------------------------- THANK YOU ----------------------------