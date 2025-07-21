function uniqueOccurrences(arr: number[]): boolean {
    const map = new Map<number, number>();

    for(const num of arr){
        map.set(num, (map.get(num) ?? 0) + 1);
    }

    const temp: boolean[] = [];

    for(const [key, value] of map.entries()){
        if(temp[value])
            return false;
        temp[value] = true;
    }

    return true;
};