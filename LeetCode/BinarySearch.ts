function search(nums: number[], target: number): number {
    let left = 0;
    let right = nums.length - 1;
    let result = -1;

    while(left<=right){
        let mid = Math.floor((left+right)/2);

        if(nums[mid] == target){
            result = mid;
            break;
        } else if(nums[mid] > target){
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return result;
};