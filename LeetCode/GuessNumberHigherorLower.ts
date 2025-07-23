/** 
 * Forward declaration of guess API.
 * @param {number} num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * var guess = function(num) {}
 */

 const guessNum = 10;

 function guess(num: number): number {
    return num === guessNum ? 0 : (num < guessNum ? 1 : -1);
 }

function guessNumber(n: number): number {
    let m = 0;

    while(m <= n){
        let mid = Math.floor((m + n) / 2);

        const val = guess(mid);

        if(val === 0) {
            return mid;
        } else if(val === -1) {
            n = mid - 1;
        } else {
            m = mid + 1;
        }
    }

    return 0;
};