function convert(s: string, numRows: number): string {
    if (numRows === 1) return s;

    const result: string[] = [];

    for (let i = 0; i < numRows; i++) {
        for(let j = i; j < s.length; j += 2 * (numRows - 1)) {
            result.push(s.charAt(j));

            if(i != 0 && i != numRows - 1) {
                result.push(s.charAt(j + 2 * (numRows - i - 1)));
            }
        }
    }

    return result.join('');
};

console.log(convert("PAYPALISHIRING", 3)); // Output: "PAHNAPLSIIGYIR"