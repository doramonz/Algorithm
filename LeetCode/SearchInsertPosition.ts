function searchInsert(nums: number[], target: number): number {
    let left = 0, right = nums.length;

    while(left < right) {
        let mid = Math.floor((left + right) / 2);

        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return left;
};

// Example usage:
console.log(searchInsert([1, 3, 4, 6], 5));