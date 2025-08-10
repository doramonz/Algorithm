function longestCommonPrefix(strs: string[]): string {
    let max = strs[0].length;

    for (let i = 1; i < strs.length; i++) {
        if (strs[i].length < max) {
            max = strs[i].length;
        }

        for (let j = 0; j < strs[i].length && j < max; j++) {
            if (strs[i][j] !== strs[0][j]) {
                max = j;
                break;
            }
        }

        if (max === 0) {
            break;
        }
    }

    return strs[0].substring(0, max);
};

console.log(longestCommonPrefix(["flower", "flow", "flight"]));