function increasingTriplet(nums: number[]): boolean {
    let first = Infinity
    let second = Infinity

    for (const num of nums) {
        if (num < first) {
            first = num;
        } else if (num < second && num > first) {
            second = num;
        } else if (num > second) {
            return true;
        }
    }

    return false;
};