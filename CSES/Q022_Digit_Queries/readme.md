# CSES Problem: Digit Queries

This repository contains the solution for the **"Digit Queries"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/2431).

## Problem Description

Consider an infinite string that consists of all positive integers in increasing order:

```text
12345678910111213141516171819202122232425...
```

Your task is to process $q$ queries of the form: what is the digit at position $k$ (1-indexed) in the string?

### Constraints

- $1 \le q \le 1000$
- $1 \le k \le 10^{18}$

## Example

**Input:**

```text
3
7
19
12
```

**Output:**

```text
7
4
1
```

### Explanation

- Position `7` in the string is `7`.
- Position `19` corresponds to the second digit of `14` (`1` is at 18, `4` is at 19) → `4`.
- Position `12` corresponds to the first digit of `11` (`1` is at 12, `1` is at 13) → `1`.

## Solution Approach

Since $k$ can be as large as $10^{18}$, constructing the string explicitly is impossible. Instead, we can group numbers by their digit lengths and locate the exact block, the exact number, and the specific digit mathematically.

### Digit Block Breakdown

- **1-digit numbers ($1$ to $9$)**: $9$ numbers $\times 1$ digit = $9$ digits total (positions $1$ to $9$).
- **2-digit numbers ($10$ to $99$)**: $90$ numbers $\times 2$ digits = $180$ digits total (positions $10$ to $189$).
- **3-digit numbers ($100$ to $999$)**: $900$ numbers $\times 3$ digits = $2700$ digits total (positions $190$ to $2889$).
- **$d$-digit numbers ($10^{d-1}$ to $10^d - 1$)**: $9 \times 10^{d-1}$ numbers $\times d$ digits.

### Logic

1. **Base Case**: If $k < 10$, the answer is simply $k$ itself.
2. **Find the Digit Block ($d$)**:
    - Start with `dig = 2`, base power `mul = 10`, `start = 10`, and `end = 189`.
    - While `end < k`, advance to the next digit length (`dig++`, `mul *= 10`), updating the starting and ending 1-indexed positions of the current block.
3. **Find the Exact Number**:
    - Compute the 0-indexed offset within the current block:
      $$\text{orgIdx} = k - \text{start}$$
    - The target number is:
      $$\text{number} = \text{mul} + \left\lfloor \frac{\text{orgIdx}}{\text{dig}} \right\rfloor$$
4. **Extract the Specific Digit**:
    - The 0-indexed position of the digit from the left within `number` is $\text{orgIdx} \bmod \text{dig}$.
    - Equivalently, the number of digits to strip from the right is:
      $$\text{digIdx} = \text{dig} - 1 - (\text{orgIdx} \bmod \text{dig})$$
    - Divide `number` by $10$ repeatedly `digIdx` times, then return `number % 10`.

## Complexity

### Time Complexity

$$
O(q \times \log_{10} k)
$$

For each of the $q$ queries, finding the digit group and extracting the digit takes at most $\approx 18$ iterations (since $k \le 10^{18}$).

### Space Complexity

$$
O(1)
$$

Only a few primitive variables are used per query beyond standard I/O buffers.

## Code Implementation (Java)

```java
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(br.readLine().trim());

        while (q-- > 0) {
            long k = Long.parseLong(br.readLine().trim());
            bw.write(String.valueOf(solve(k)));
            bw.newLine();
        }

        bw.flush();
    }

    private static long solve(long k) {
        if (k < 10) return k;

        int dig = 2;
        long mul = 10L;
        long start = 10;
        long end = 9 + 9 * mul * dig;

        while (end < k) {
            dig++;
            mul *= 10;
            start = end + 1;
            end += 9 * mul * dig;
        }

        long orgIdx = k - start;
        long number = mul + orgIdx / dig;
        long digIdx = dig - 1 - (orgIdx % dig);

        while (digIdx > 0) {
            digIdx--;
            number /= 10;
        }

        return number % 10;
    }
}
```

---

# ---------------------------- THANK YOU ----------------------------