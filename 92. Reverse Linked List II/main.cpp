#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        // base case
        if (left == 1) {
            return reverseN(head, right);
        }

        // go ahead
        head->next = reverseBetween(head->next, left - 1, right - 1);

        return head;
    }

private:
    ListNode *successor = NULL;

    ListNode* reverseN(ListNode* head, int n) {
        // base case
        if (n == 1) {
            successor = head->next;
            return head;
        }

        // reverse n-1 node from head.next
        ListNode *last = reverseN(head->next, n - 1);

        // connect head.next to head
        head->next->next = head;

        // connect head to successor
        head->next = successor;

        return last;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
