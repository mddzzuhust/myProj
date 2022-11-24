

import java.util.*;

public class Twitter {
    private Map<Integer, Set<Integer>> followeeMap;

    private Map<Integer, List<Integer>> userTweetMap;

    private Map<Integer,Integer> tweetToIndex;

    private int index;

    public Twitter(){
        followeeMap = new HashMap<>();
        userTweetMap = new HashMap<>();
        tweetToIndex = new HashMap<>();
    }

    public void postTweet(int userId,int tweetId){
        if(!userTweetMap.containsKey(userId)){
            userTweetMap.put(userId,new ArrayList<>());
        }
        userTweetMap.get(userId).add(0,tweetId);
        tweetToIndex.put(tweetId,index++);
    }

    public List<Integer> getNewsFeed(int userId){
        List<Integer> result = new ArrayList<>();
        List<Integer> userList = new ArrayList<>();
        Set<Integer> followees = followeeMap.get(userId);
        if(null!=followees){
            userList.addAll(followees);
            if(!followees.contains(userId)){
                userList.add(userId);
            }
        }else {
            userList.add(userId);
        }

        int[] curs = new int[userList.size()];
        while (result.size()<10){
            int maxIndex = -1,max = Integer.MIN_VALUE;
            for (int i = 0; i < userList.size(); i++) {
                List<Integer> tweets = userTweetMap.get(userList.get(i));
                if(null!=tweets&&curs[i]<tweets.size()&&max<tweetToIndex.get(tweets.get(curs[i]))){
                    maxIndex = i;
                    max = tweetToIndex.get(tweets.get(curs[i]));
                }
            }
            if(maxIndex == -1){
                break;
            }
            result.add(userTweetMap.get(userList.get(maxIndex)).get(curs[maxIndex]++));
        }
        return result;
    }

    public void follow(int followerId,int followeeId){
        if(!followeeMap.containsKey(followerId)){
            followeeMap.put(followerId,new HashSet<>());
        }
        followeeMap.get(followerId).add(followeeId);
    }

    public void unfollow(int follwerId,int followeeId){
        if(followeeMap.containsKey(follwerId)){
            followeeMap.get(follwerId).remove(followeeId);
        }
    }
}
