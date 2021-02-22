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
    ListNode* reverseKGroup(ListNode* head, int k) {
        if (head == NULL) {
            return head;
        }

        ListNode *a = head;
        ListNode *b = a;
        for (int i = 0; i < k; i++) {
            if (b == NULL) {
                return head;
            }
            b = b->next;
        }

        // reverse k elements in [a,b)
        ListNode *newHead = reverse(a, b);

        // reverse remaining elements recursively and connect results
        a->next = reverseKGroup(b, k);

        return newHead;
    }

private:
    ListNode* reverse(ListNode* a, ListNode* b) {
        ListNode *pre = NULL, *cur = a, *next;
        while(cur != b) {
            next = cur->next;
            cur->next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
};

int main() {
    ListNode *head = new ListNode(5, NULL);
    head = new ListNode(4, head);
    head = new ListNode(3, head);
    head = new ListNode(2, head);
    head = new ListNode(1, head);
    head = Solution().reverseKGroup(head, 2);
    return 0;
}
