#include <iostream>
#include <vector>
#include <unordered_set>
#include <unordered_map>
#include <queue>

using namespace std;

class Tweet {
private:
    int id;
    int time;

public:
    Tweet *next;

    Tweet(int id, int time) {
        this->id = id;
        this->time = time;
        this->next = nullptr;
    }

    int getTime() {
        return this->time;
    }

    int getId() {
        return this->id;
    }

};

struct cmp{
    bool operator()(Tweet *a, Tweet *b){
        return (b->getTime() - a->getTime()) > 0;
    }
};

class User {
private:
    int id;

public:
    unordered_set<int> *followed;
    Tweet *head;

    User(int userId) {
        this->followed = new unordered_set<int>();
        this->id = userId;
        this->head = nullptr;
        // follow self
        follow(this->id);
    }

    void follow(int userId) {
        this->followed->insert(userId);
    }

    void unfollow(int userId) {
        // cant unfollow self
        if (userId != this->id) {
            this->followed->erase(userId);
        }
    }

    void post(int tweetId, int &timestamp) {
        Tweet *tweet = new Tweet(tweetId, timestamp);
        timestamp++;
        // insert tweet in time order
        tweet->next = this->head;
        this->head = tweet;
    }
};

class Twitter {
private:
    int timestamp;
    unordered_map<int, User*> *userMap;

public:
    /** Initialize your data structure here. */
    Twitter() {
        timestamp = 0;
        userMap = new unordered_map<int, User*>();
    }

    /** Compose a new tweet. */
    void postTweet(int userId, int tweetId) {
        if (!this->userMap->count(userId)) {
            this->userMap->insert(pair<int, User*>(userId, new User(userId)));
        }
        this->userMap->at(userId)->post(tweetId, this->timestamp);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    vector<int> getNewsFeed(int userId) {
        auto *res = new vector<int>();
        if (!this->userMap->count(userId)) {
            return *res;
        }

        unordered_set<int> *users = this->userMap->at(userId)->followed;

        auto *pq = new priority_queue<Tweet*, vector<Tweet*>, cmp>();

        for (auto user : *users) {
            Tweet *tweet = this->userMap->at(user)->head;
            if (tweet == nullptr) {
                continue;
            }
            pq->push(tweet);
        }

        while (!pq->empty()) {
            if (res->size() == 10) {
                break;
            }
            Tweet *tweet = pq->top();
            pq->pop();
            res->push_back(tweet->getId());
            if (tweet->next != nullptr) {
                pq->push(tweet->next);
            }
        }

        return *res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    void follow(int followerId, int followeeId) {
        if (!this->userMap->count(followerId)) {
            this->userMap->insert(pair<int, User*>(followerId, new User(followerId)));
        }
        if (!this->userMap->count(followeeId)) {
            this->userMap->insert(pair<int, User*>(followeeId, new User(followeeId)));
        }
        this->userMap->at(followerId)->follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    void unfollow(int followerId, int followeeId) {
        if (!this->userMap->count(followerId)) {
            this->userMap->insert(pair<int, User*>(followerId, new User(followerId)));
        }
        if (!this->userMap->count(followeeId)) {
            this->userMap->insert(pair<int, User*>(followeeId, new User(followeeId)));
        }
        this->userMap->at(followerId)->unfollow(followeeId);
    }
};

int main() {
    Twitter twitter;

    // User 1 posts a new tweet (id = 5).
    twitter.postTweet(1, 5);

    // User 1's news feed should return a list with 1 tweet id -> [5].
    twitter.getNewsFeed(1);

    // User 1 follows user 2.
    twitter.follow(1, 2);

    // User 2 posts a new tweet (id = 6).
    twitter.postTweet(2, 6);

    // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
    // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
    twitter.getNewsFeed(1);

    // User 1 unfollows user 2.
    twitter.unfollow(1, 2);

    // User 1's news feed should return a list with 1 tweet id -> [5],
    // since user 1 is no longer following user 2.
    twitter.getNewsFeed(1);

    return 0;
}
