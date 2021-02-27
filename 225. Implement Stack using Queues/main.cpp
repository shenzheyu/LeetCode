#include <iostream>
#include <queue>

using namespace std;

class MyStack {
public:
    /** Initialize your data structure here. */
    MyStack() {

    }

    /** Push element x onto stack. */
    void push(int x) {
        // push element into q2
        q2.push(x);

        // pop all elements from q1 and push into q2
        while (q1.size() != 0) {
            q2.push(q1.front());
            q1.pop();
        }

        // exchange q1 and q2
        queue<int> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    int pop() {
        int x = q1.front();
        q1.pop();
        return x;
    }

    /** Get the top element. */
    int top() {
        return q1.front();
    }

    /** Returns whether the stack is empty. */
    bool empty() {
        return q1.empty();
    }

private:
    queue<int> q1;
    queue<int> q2;
};

int main() {
    MyStack* obj = new MyStack();
    obj->push(1);
    int param_2 = obj->pop();
    int param_3 = obj->top();
    bool param_4 = obj->empty();
    return 0;
}
