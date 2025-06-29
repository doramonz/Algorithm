function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
    let result: number = 0;
    const arr: number[] = [];

    let i: number = 0;
    let j: number = 0;

    while(i < nums1.length && j < nums2.length && arr.length <= (nums1.length + nums2.length) / 2){
        if(nums1[i] <= nums2[j]){
            arr.push(nums1[i++]);
        } else {
            arr.push(nums2[j++]);
        }
    }

    while(i < nums1.length && arr.length <= (nums1.length + nums2.length) / 2){
        arr.push(nums1[i++]);
    }

    while(j < nums2.length && arr.length <= (nums1.length + nums2.length) / 2){
        arr.push(nums2[j++]);
    }

    if((nums1.length + nums2.length) % 2 == 0){
        result = (arr.pop() + arr.pop())/2;
    }else{
        result = arr.pop();
    }

    return result;
};

const nums1: number[] = [1, 4, 5, 12, 16, 19, 21, 25, 27];
const nums2: number[] = [93, 101, 181, 283, 344, 411, 432, 489, 511, 554, 556];


console.log(findMedianSortedArrays(nums1, nums2));