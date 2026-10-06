# Rotated Sorted Arrays and Binary Search
### How rotation breaks sortedness, and how to still search in O(log n) (with Java examples)

---

## 1. What "rotation" actually does to an array

A sorted array like:

```
[10, 20, 30, 40, 50, 60, 70]
```

rotated left by `k = 3` positions becomes:

```
[40, 50, 60, 70, 10, 20, 30]
```

**Rotation takes the first `k` elements and moves them to the end** (for a left rotation), keeping the relative order of every element the same. The array is no longer fully sorted — but it isn't random either. It's made of **exactly two sorted sub-arrays** placed back to back:

```
[40, 50, 60, 70] and [10, 20, 30]
     (sorted)             (sorted)
```

This is the single fact that everything else in this report builds on: **a rotated sorted array is always two consecutive sorted runs, and the second run's values are always smaller than the first run's values.**

The point where the second run starts — where `arr[i] < arr[i-1]` — is called the **pivot** or **break point**. In the example above, that's index `4` (value `10`), because `70 > 10`.

---

## 2. Why you can't just binary search normally

Standard binary search relies on one guarantee: *if `mid` isn't your target, you can tell which half to discard, because both halves are sorted relative to each other.* In a rotated array, `arr[mid]` being bigger or smaller than the target no longer tells you which side to go to — **unless you first figure out which of the two halves around `mid` is the sorted one.**

That's the entire trick for every problem in this family:

> **At any point in the array, at least one of the two halves (left of mid, or right of mid, inclusive of mid) is guaranteed to be sorted. Identify which one, then decide whether the target could be in that sorted half.**

---

## 3. Step 1 — Finding the Rotation Count / Pivot Index

**Contract:** `findPivot(arr)` returns the index of the smallest element — i.e., the index where the sorted order "breaks." The rotation count equals this index.

**Why linear scan is wasteful:** Checking every element is O(n) and throws away the fact that both halves are individually sorted. We can do it in O(log n) using a binary-search-style shrink.

**The core idea:** At every step, compare `arr[mid]` with `arr[high]`.
- If `arr[mid] > arr[high]`, the break point must be **somewhere to the right of mid** (the right half is "contaminated" by the larger left-run values), so move `low = mid + 1`.
- Otherwise, `arr[mid] <= arr[high]` means the segment from `mid` to `high` is already sorted, so the break point is **at or before mid** — move `high = mid`.
- Stop when `low == high`. That index is the pivot.

```java
public class FindRotation {
    // Contract: returns the index of the smallest element (= rotation count)
    // Assumes no duplicate values and array is a rotated-sorted array
    public static int findPivot(int[] arr) {
        int low = 0, high = arr.length - 1;

        // If array isn't rotated at all
        if (arr[low] <= arr[high]) {
            return 0;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                // break point is to the right of mid
                low = mid + 1;
            } else {
                // arr[mid] <= arr[high]: mid..high is sorted,
                // so the break point is mid itself or to its left
                high = mid;
            }
        }

        return low; // low == high == index of smallest element
    }

    public static void main(String[] args) {
        int[] arr = {40, 50, 60, 70, 10, 20, 30};
        int pivot = findPivot(arr);
        System.out.println("Rotation count / pivot index: " + pivot); // 4
        System.out.println("Smallest element: " + arr[pivot]);        // 10
    }
}
```

**Why compare with `arr[high]` and not `arr[low]`:** Comparing `mid` against `high` always gives an unambiguous signal regardless of which half `mid` lands in. Comparing against `low` can be ambiguous when `mid == low`. This is a detail people often get wrong when they first attempt this — always anchor the comparison against the boundary that lets you decide "is this half sorted or not" cleanly.

---

## 4. Step 2 — Searching for a Target Directly (Without Finding the Pivot First)

You *can* find the pivot, then binary search separately in the correct half — but the more elegant and commonly expected approach in interviews/exams is to search in **one pass**, deciding at each step which half is sorted and whether the target lies in it.

**Contract:** `search(arr, target)` returns the index of `target` in the rotated sorted array, or `-1` if not present.

**The decision tree at each step:**

1. Compute `mid`. If `arr[mid] == target`, done.
2. Determine which half is sorted:
   - If `arr[low] <= arr[mid]` → the **left half** (`low` to `mid`) is sorted.
   - Otherwise → the **right half** (`mid` to `high`) is sorted.
3. Once you know which half is sorted, check if `target` falls **within that sorted half's range**:
   - If yes, search that half (`normal binary search logic` applies there since it's sorted).
   - If no, the target must be in the *other* half — search there instead.

```java
public class SearchInRotatedArray {
    // Contract: returns index of target, or -1 if not found
    public static int search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            // Step 2: which half is sorted?
            if (arr[low] <= arr[mid]) {
                // Left half [low..mid] is sorted
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;   // target is in the sorted left half
                } else {
                    low = mid + 1;    // target must be in the right half
                }
            } else {
                // Right half [mid..high] is sorted
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;    // target is in the sorted right half
                } else {
                    high = mid - 1;   // target must be in the left half
                }
            }
        }

        return -1; // not found
    }

    public static void main(String[] args) {
        int[] arr = {40, 50, 60, 70, 10, 20, 30};
        System.out.println(search(arr, 20)); // 5
        System.out.println(search(arr, 45)); // -1
    }
}
```

**The detail people most often miss here:** the boundary checks in the range comparisons. `arr[low] <= target && target < arr[mid]` uses `<=` on one side and `<` on the other because `mid` was already checked for equality above — this avoids double-checking `arr[mid]` and prevents off-by-one errors when `target` equals a boundary value. Write these comparisons out carefully rather than guessing `<=` everywhere.

---

## 5. Step 3 — Handling Duplicates (The Trap Case)

Everything above assumes **all elements are distinct**. If duplicates are allowed, e.g.:

```
[3, 3, 3, 1, 2, 3]
```

then comparing `arr[low]`, `arr[mid]`, `arr[high]` can become **ambiguous** — you genuinely cannot tell which half is sorted when `arr[low] == arr[mid] == arr[high]`, because both halves *look* identical from that comparison alone.

**The fix:** when `arr[low] == arr[mid]` and you can't decide, **shrink the search space defensively** by moving `low` forward by one (or `high` back by one) instead of guessing. This sacrifices the O(log n) guarantee in the worst case (it degrades to O(n) when there are many duplicates), but it stays correct.

```java
public class SearchWithDuplicates {
    public static boolean search(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return true;
            }

            // Ambiguous case: can't tell which side is sorted
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }

            if (arr[low] <= arr[mid]) {
                // left half sorted
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // right half sorted
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 1, 2, 3};
        System.out.println(search(arr, 1)); // true
    }
}
```

**This is the single biggest gap in most students' understanding of this topic** — they memorize the distinct-elements solution and don't realize it silently breaks (or gives wrong answers / infinite loops) the moment duplicates are introduced. Always ask an interviewer/exam setter whether duplicates are allowed before committing to the simpler version.

---

## 6. Step 4 — Finding *How Many Times* the Array Was Rotated

This is really just Step 1 in disguise: **the rotation count equals the pivot index found in Section 3.** If the array was rotated `k` times to the left, then `arr[k]` is the smallest element, and that's exactly what `findPivot` returns.

```java
int rotationCount = FindRotation.findPivot(arr); // reuse Section 3's function
```

No new logic is needed — recognizing that "how many rotations" and "where does sortedness break" are the *same question asked two ways* is itself a useful insight, since problems often phrase it differently to make it look unfamiliar.

---

## 7. Summary Table — Which Technique to Use

| Question asked | What to compute | Section |
|---|---|---|
| "How many times was the array rotated?" | Pivot index (index of the minimum element) | §3 |
| "Where does the sorted order break?" | Same as above — pivot index | §3 |
| "Find the minimum element" | `arr[pivot]` | §3 |
| "Search for a target value" (no duplicates) | One-pass modified binary search | §4 |
| "Search for a target value" (duplicates allowed) | Same as above, with ambiguity handling | §5 |
| "Is the array rotated at all?" | Check `arr[0] <= arr[n-1]`; if true, it's effectively unrotated (or rotated by a full cycle) | §3 |

---

## 8. Checklist Before Submitting a Rotated-Array Binary Search Solution

1. **Did I identify which half is sorted at each step**, rather than trying to reason about the whole array at once?
2. **Am I comparing against the correct boundary** (`arr[low]` vs `arr[mid]`, or `arr[mid]` vs `arr[high]`) consistently, and not mixing conventions mid-function?
3. **Did I handle the target being exactly equal to a boundary value** (`arr[low]`, `arr[mid]`, or `arr[high]`) using consistent `<=` / `<` choices?
4. **Does my solution assume distinct elements?** If the problem allows duplicates, did I add the ambiguity-handling shrink step?
5. **Does my loop terminate?** In the duplicate-handling version specifically, verify `low++`/`high--` always eventually causes `low > high` and doesn't loop forever on adversarial input like all-equal arrays.
6. **Off-by-one check:** after narrowing to one half, did I correctly exclude `mid` where needed (`mid - 1` / `mid + 1`) to avoid re-examining an already-checked element?

---

## 9. Practice Ladder (in order of difficulty)

1. Find the minimum element in a rotated sorted array (no duplicates)
2. Find the minimum element in a rotated sorted array (with duplicates)
3. Search a target in a rotated sorted array (no duplicates)
4. Search a target in a rotated sorted array (with duplicates) — return true/false
5. Find how many times a rotated sorted array has been rotated
6. Search in a rotated sorted array that was also rotated an unknown number of times **and** has an unknown pivot direction (right-rotation instead of left)
7. Given two rotated sorted arrays, find if a target exists in either (combine the technique with a simple pre-check)

Work through these using the same discipline from the recursion guide: state the contract, identify what changes about the problem's structure at each step (rotation count → pivot → sorted-half identification → range check), and verify your boundary comparisons explicitly rather than guessing `<=` vs `<`.
