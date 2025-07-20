function nextGreatestLetter(letters: string[], target: string): string {
    let left = 0, right = letters.length - 1;

    if(letters[letters.length - 1] <= target){
        return letters[0];
    }

    while(left < right){
        let mid = Math.floor((left + right) / 2);

        if(letters[mid] <= target){
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return letters[left];
};