package onboarding;

import onboarding.problem7.Problem7Exception;
import onboarding.problem7.Problem7ExceptionType;

import java.util.*;

import static onboarding.problem7.Problem7Constant.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = getFriends(user, friends);
        Map<String, Integer> scores = getFriendsOfFriends(userFriends, friends, user);
        scores = give1Point(scores, visitors, userFriends);
        return getTop5(scores);
    }

    public static List<String> getFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();
        for (List<String> friend : friends) {
            if (friend.get(0).equals(user)) {
                userFriends.add(friend.get(1));
            }
            if (friend.get(1).equals(user)) {
                userFriends.add(friend.get(0));
            }
        }
        return userFriends;
    }

    public static Map<String, Integer> getFriendsOfFriends(List<String> userFriends, List<List<String>> friends, String user) {
        Map<String, Integer> scores = new HashMap<>();
        for (String userFriend : userFriends) {
            List<String> friendsOfFriends = getFriends(userFriend, friends);
            for (String friendsOfFriend : friendsOfFriends) {
                if (friendsOfFriend.equals(user)) continue;
                scores = give10Points(scores, friendsOfFriend);
            }
        }
        return scores;
    }

    public static Map<String, Integer> give10Points(Map<String, Integer> scores, String friendsOfFriend) {
        Integer value = scores.get(friendsOfFriend);
        if (value == null) {
            scores.put(friendsOfFriend, 10);
        }
        if (value != null) {
            scores.put(friendsOfFriend, value + 10);
        }
        return scores;
    }

    public static Map<String, Integer> give1Point(Map<String, Integer> scores, List<String> visitors, List<String> userFriends) {
        for (String visitor : visitors) {
            if (userFriends.contains(visitor)) continue;
            Integer value = scores.get(visitor);
            if (value == null) {
                scores.put(visitor, 1);
            }
            if (value != null) {
                scores.put(visitor, value + 1);
            }
        }
        return scores;
    }

    public static List<String> getTop5(Map<String, Integer> scores) {
        List<Map.Entry<String, Integer>> sortedMap = getSortedMap(scores);
        List<String> top5 = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedMap) {
            if (entry.getValue() > 0) {
                top5.add(entry.getKey());
                if (top5.size() >= 5) {
                    break;
                }
            }
        }
        return top5;
    }

    public static List<Map.Entry<String, Integer>> getSortedMap(Map<String, Integer> scores) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(scores.entrySet());
        list.sort((o1, o2) -> {
            int comparison = o2.getValue().compareTo(o1.getValue());
            if (comparison == 0) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return comparison;
        });
        return list;
    }

}