function convert(s: string, numRows: number): string {
    if (numRows === 1)
        return s;

    let result = "";

    for (let i = 0; i < numRows; i++) {
        let index = i;

        if (i === 0 || i === numRows - 1) {
            while (index < s.length) {
                result += s.charAt(index);
                index += 2 * (numRows - 1);
            }
        } else {
            while (index < s.length) {
                result += s.charAt(index);
                index += 2 * (numRows - i - 1);
                if (index < s.length) {
                    result += s.charAt(index);
                    index += 2 * i;
                }
            }
        }
    }

    return result;
};

console.log(convert("PAYPALISHIRING", 3)); // Output: "PAHNAPLSIIGYIR"