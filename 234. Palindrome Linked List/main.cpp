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
    bool isPalindrome(ListNode* head) {
        // use slow and fast pointers find the mid of linklist
        ListNode *slow = head, *fast = head;

        while (fast != NULL && fast->next != NULL) {
            slow = slow->next;
            fast = fast->next->next;
        }
        // slow points to the mid

        // if fast != NULL, length of linklist is odd, slow moves one step
        if (fast != NULL) {
            slow = slow->next;
        }

        // reverse the linklist after slow
        ListNode *left = head;
        ListNode *right = reverse(slow);

        // compare the palindrome
        while (right != NULL) {
            if (left->val != right->val) {
                return false;
            }
            left = left->next;
            right = right->next;
        }

        return true;
    }

private:
    ListNode *reverse(ListNode* head) {
        ListNode *pre = NULL, *cur = head, *next;
        while (cur != NULL) {
            next = cur->next;
            cur->next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
