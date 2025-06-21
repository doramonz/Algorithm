function twoSum(nums: number[], target: number): number[] {
    const map = new Map<number, number>();
    let result

    nums.forEach((value, index) => {
        const complement = target - value;
        
        if (map.has(complement) && map.get(complement) !== index) {
            result = [index, (map.get(complement) as number)];
        }

        map.set(value, index);
    });

    return result
}