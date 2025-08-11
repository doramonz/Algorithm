function lengthOfLongestSubstring(s: string): number {
    let max = 0;

    let left = 0;
    let right = 0;

    const set = new Set<string>;

    while (right < s.length) {
        if (!set.has(s[right])) {
            set.add(s[right]);

            max = Math.max(max, set.size);
            right++;
        } else {
            set.delete(s[left]);
            left++;
        }
    }

    return max;
}

console.log(lengthOfLongestSubstring("abcabcbb")); // Output: 3
console.log(lengthOfLongestSubstring("bbbbb"));    // Output: 1
console.log(lengthOfLongestSubstring("pwwkew"));   // Output: 3