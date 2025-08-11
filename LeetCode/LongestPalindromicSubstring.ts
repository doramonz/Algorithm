function longestPalindrome(s: string): string {
    let result = ""

    for(let i = 0;i<s.length;i++){
        let left = i;
        let right = i;

        while(s.charAt(left) === s.charAt(right) && left >= 0 && right < s.length){
            left--;
            right++;
        }

        if(right - left - 1 > result.length){
            result = s.substring(left + 1, right);
        }

        if(i + 1 < s.length && s.charAt(i) === s.charAt(i + 1)){
            left = i;
            right = i + 1;

            while(s.charAt(left) === s.charAt(right) && left >= 0 && right < s.length){
                left--;
                right++;
            }

            if(right - left - 1 > result.length){
                result = s.substring(left + 1, right);
            }
        }
    }

    return result;
};

console.log(longestPalindrome("babad")); // Output: "bab" or "aba"