function isPalindrome(x: number): boolean {
    if(x<0) return false;

    return x === Number(String(x).split("").reverse().join(""));
};

console.log(isPalindrome(121));  // true
console.log(isPalindrome(-121)); // false
console.log(isPalindrome(10));   // false