#include <iostream>
#include <queue>

using namespace std;

class MedianFinder {
private:
    priority_queue<int, vector<int>, greater<>> small;
    priority_queue<int, vector<int>, less<>> large;

public:
    /** initialize your data structure here. */
    MedianFinder() = default;

    void addNum(int num) {
        if (small.size() >= large.size()) {
            small.push(num);
            large.push(small.top());
            small.pop();
        } else {
            large.push(num);
            small.push(large.top());
            large.pop();
        }
    }

    double findMedian() {
        if (small.size() > large.size()) {
            return small.top();
        }
        if (small.size() < large.size()) {
            return large.top();
        }
        return (double)(small.top() + large.top()) / 2;
    }
};

int main() {
    MedianFinder* obj = new MedianFinder();
    obj->addNum(1);
    double param_2 = obj->findMedian();
    return 0;
}
