function reverse(x: number): number {
    let isNegative = x < 0;
    let result = 0;

    x *= isNegative ? -1 : 1;

    while(x > 0){
        result *= 10;
        result += x % 10;
        x = Math.floor(x / 10);
    }

    let pow = Math.pow(2, 31);

    if (result > pow - 1 || result < -pow) {
        return 0;
    }

    return result * (isNegative ? -1 : 1);
};

console.log(reverse(123)); // 321
console.log(reverse(-123)); // -321
console.log(reverse(120)); // 21