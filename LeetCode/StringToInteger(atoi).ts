function myAtoi(s: string): number {
    const MAX = 2 ** 31 - 1;
    const MIN = -(2 ** 31);

    let index = 0;
    let num = 0;
    let isNegative = false;

    while (index < s.length && s[index] === ' ') {
        index++;
    }

    if (index < s.length && (s[index] === '-' || s[index] === '+')) {
        isNegative = s[index] === '-';
        index++;
    }

    while (index < s.length && s[index] >= '0' && s[index] <= '9') {
        num = num * 10 + (s[index].charCodeAt(0) - '0'.charCodeAt(0));
        index++;
    }

    if (isNegative) {
        num = -num;
    }

    return Math.max(Math.min(num, MAX), MIN);
};

console.log(myAtoi("  -042")); // 42