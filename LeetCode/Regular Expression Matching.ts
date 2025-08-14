function isMatch(s: string, p: string): boolean {
    const n = s.length;
    const m = p.length;

    const dp: boolean[][] = Array.from({ length: n + 1 }, () => Array(m + 1).fill(false));

    dp[0][0] = true;

    for (let j = 1; j <= m; j++) {
        if (p[j - 1] === '*') {
            dp[0][j] = dp[0][j - 2];
        }
    }

    for (let i = 1; i <= n; i++) {
        for (let j = 1; j <= m; j++) {
            if (p[j - 1] === '*') {
                dp[i][j] = dp[i][j - 2] || ((p[j - 2] === '.' || p[j - 2] === s[i - 1]) && dp[i - 1][j]);
            } else {
                dp[i][j] = dp[i - 1][j - 1] && (p[j - 1] === '.' || p[j - 1] === s[i - 1]);
            }
        }
    }

    return dp[n][m];
}

console.log(isMatch("aaaaa", "a*a"));
console.log(isMatch("mississippi", "mis*is*p*."));