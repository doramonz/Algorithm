function lengthOfLongestSubstring(s: string): number {
    let result: number = 0;
    const set: Set<string> = new Set<string>();

    let i: number = 0;
    let j: number = 0;

    while (j < s.length) {
        if (!set.has(s.charAt(j))) {
            set.add(s.charAt(j));
            j++;
            result = Math.max(result, set.size);
        } else {
            set.delete(s.charAt(i));
            i++;
        }
    }

    return result;
}

console.log(3 === lengthOfLongestSubstring("abcabcbb"));
console.log(1 === lengthOfLongestSubstring("bbbbb"));
console.log(3 === lengthOfLongestSubstring("pwwkew"));
console.log(0 === lengthOfLongestSubstring(""));