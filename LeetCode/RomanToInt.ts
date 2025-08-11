const romanToIntMap: Record<string, number> = {
    'I': 1,
    'V': 5,
    'X': 10,
    'L': 50,
    'C': 100,
    'D': 500,
    'M': 1000
};

function romanToInt(s: string): number {
    let result = 0;

    for(let i = 0; i<s.length; i++) {
        if (i + 1 < s.length && romanToIntMap[s[i]] < romanToIntMap[s[i + 1]]) {
            result -= romanToIntMap[s[i]];
        } else {
            result += romanToIntMap[s[i]];
        }
    }

    return result;
};

console.log(romanToInt("III")); // Output: 3
console.log(romanToInt("IV"));  // Output: 4
console.log(romanToInt("IX"));  // Output: 9
console.log(romanToInt("LVIII")); // Output: 58
console.log(romanToInt("MCMXCIV")); // Output: 1994