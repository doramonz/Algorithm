
class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val===undefined ? 0 : val)
        this.next = (next===undefined ? null : next)
    }
}

function addTwoNumbers(l1: ListNode | null, l2: ListNode | null): ListNode | null {
    let head: ListNode = new ListNode();
    let current: ListNode = head;
    let carry: number = 0;

    while(l1 !== null || l2 !== null || carry !== 0){
        let sum: number = (l1?.val ?? 0) + (l2?.val ?? 0) + carry;

        carry = Math.floor(sum / 10);

        current.next = new ListNode(sum % 10)
        current = current.next;

        if(l1 !== null) l1 = l1.next;
        if(l2 !== null) l2 = l2.next;
    }

    return head.next;
};

console.log(addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4)))));