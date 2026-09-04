# CSES Problem: Apple Division

This repository contains the solution for the **"Apple Division"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/1623).

## Problem Description

There are `n` apples with known weights. Your task is to divide the apples into two groups such that the difference between the total weights of the two groups is as small as possible.

The goal is to find the **minimum possible difference** between the total weights of the two groups.

### Constraints

- $1 \le n \le 20$
- $1 \le p_i \le 10^9$

## Example

**Input:**

```text
5
3 2 7 4 1
```

**Output:**

```text
1
```

### Explanation

One possible division is:

- Group 1: `2, 3, 4` → Total weight = `9`
- Group 2: `1, 7` → Total weight = `8`

Therefore, the minimum difference is:

$$
|9 - 8| = 1
$$

## Solution Approach

Since $n \le 20$, we can use **bitmasking** to generate every possible subset of apples.

Each subset represents the first group, while all remaining apples automatically form the second group.

There are:

$$
2^n
$$

possible subsets.

For each subset, we calculate its total weight and determine the difference between the two groups.

### Logic

1. Calculate the total weight of all apples.
2. Iterate through every possible subset using a bitmask.
3. Calculate the sum of the apples included in the current subset.
4. The remaining apples automatically form the second group.
5. Calculate the difference between the two groups.
6. Keep track of the minimum difference.

If:

$$
\text{subsetSum}
$$

is the weight of the first group and:

$$
\text{totalSum}
$$

is the total weight of all apples, then the second group's weight is:

$$
\text{totalSum} - \text{subsetSum}
$$

Therefore, the difference between the two groups is:

$$
|\text{subsetSum} - (\text{totalSum} - \text{subsetSum})|
$$

which simplifies to:

$$
|\text{totalSum} - 2 \times \text{subsetSum}|
$$

We calculate this difference for every possible subset and keep track of the minimum value.

## Bitmask Representation

Each bit in a bitmask determines whether an apple belongs to the selected subset.

For example:

```text
mask = 10101
```

Each bit represents an apple:

```text
Apple index:  4 3 2 1 0
Mask:         1 0 1 0 1
```

- Bit `1` → The apple belongs to the first group.
- Bit `0` → The apple belongs to the second group.

By iterating through all masks from:

```text
0
```

to:

```text
2^n - 1
```

we generate every possible division of the apples into two groups.

## Complexity

There are $2^n$ possible subsets, and for each subset, we iterate through at most `n` apples.

### Time Complexity

$$
O(n \times 2^n)
$$

### Space Complexity

$$
O(n)
$$

The array storing the apple weights requires `O(n)` space.

## Code Implementation (Java)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] weights = new long[n];
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            weights[i] = Long.parseLong(st.nextToken());
            totalSum += weights[i];
        }

        long minDiff = Long.MAX_VALUE;
        long subsetSum, difference;

        // checking out all the possibilities using bit-mask
        for (int mask = 0; mask < (1 << n); mask++) {
            subsetSum = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subsetSum += weights[i];
                }
            }

            difference = Math.abs(totalSum - 2 * subsetSum);
            minDiff = Math.min(minDiff, difference);
        }

        System.out.println(minDiff);
    }
}
```

---

# ---------------------------- THANK YOU ----------------------------