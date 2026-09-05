# CSES Problem: Raab Game I

This repository contains the solution for the **"Raab Game I"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/3399).

## Problem Description

Consider a two-player game where each player has $n$ cards numbered $1, 2, \dots, n$. On each turn, both players place one of their cards on the table. The player who placed the higher card gets one point. If the cards are equal, neither player gets a point. The game continues until all cards have been played.

You are given the number of cards $n$ and the final scores of the two players, $a$ and $b$. Your task is to determine whether such an outcome is possible and, if so, construct an example of how the game could have been played.

### Constraints

- $1 \le t \le 1000$
- $1 \le n \le 100$
- $0 \le a, b \le n$

## Example

**Input:**

```text
5
4 1 2
2 0 1
3 0 0
2 1 1
4 4 1
```

**Output:**

```text
YES
1 4 3 2
2 1 3 4
NO
YES
1 2 3
1 2 3
YES
1 2
2 1
NO
```

## Solution Approach

We need to match two permutations of numbers from $1$ to $n$ such that:
- Player 1 wins exactly $a$ rounds.
- Player 2 wins exactly $b$ rounds.
- The remaining $n - (a + b)$ rounds result in a tie (matching identical cards).

### Validity Conditions

1. **Total Rounds Constraint**: The sum of wins cannot exceed the total number of rounds:
   $$a + b \le n$$

2. **Mutual Exclusion / Zero-Win Rule**: It is impossible for one player to win $> 0$ rounds while the other player wins $0$ rounds when $a + b > 0$. If one player wins using higher cards, the remaining smaller cards must be taken by the other player or result in ties. Thus:
   $$(a = 0) \oplus (b = 0)$$
   is invalid unless $a = 0$ and $b = 0$ simultaneously.

### Construction Strategy

When a valid configuration exists:
1. Fix Player 2's moves in simple identity order:
   $$[1, 2, 3, \dots, n]$$
2. For Player 1:
    - For the first $a$ positions ($1 \le j \le a$): play card $j + b$. Since $j + b > j$, Player 1 wins these $a$ rounds.
    - For the next $b$ positions ($a < j \le a + b$): play card $j - a$. Since $j - a < j$, Player 2 wins these $b$ rounds.
    - For all remaining positions ($j > a + b$): play card $j$ against Player 2's card $j$, resulting in ties.

This directly partitions the set $\{1, 2, \dots, a + b\}$ between both players with exact score counts and leaves the remaining cards $\{a + b + 1, \dots, n\}$ to tie.

## Complexity

### Time Complexity

$$O(t \times n)$$

For each testcase, we construct permutations of size $n$, resulting in linear time per query.

### Space Complexity

$$O(1)$$

Auxiliary space is $O(1)$ beyond standard I/O buffers since numbers are printed directly.

## Code Implementation (Java)

```java
import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a + b > n || (a == 0) ^ (b == 0)) {
                bw.write("NO\n");
                continue;
            }

            bw.write("YES\n");

            // A cards
            for (int j = 1; j <= n; j++) {
                if (j <= a) bw.write((j + b) + " ");
                else if (j <= (a + b)) bw.write((j - a) + " ");
                else bw.write(j + " ");
            }

            bw.newLine();

            // B cards
            for (int j = 1; j <= n; j++) {
                bw.write(j + " ");
            }

            bw.newLine();
        }

        bw.flush();
    }
}
```

---

# ---------------------------- THANK YOU ----------------------------