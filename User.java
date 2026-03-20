import java.util.*;
public class User {
    public static Object id;
    int userId;
    String name;
    Map<Integer,Habit> habits;
    Map<String,String> journals;
    List<User> friends;
    List<User> friendReq;
    User(int userId, String name){
        this.userId = userId;
        this.name = name;
        friends = new ArrayList<>();
        friendReq = new ArrayList<>();
        habits = new HashMap<>();
        journals = new HashMap<>();

    }
    void addHabit(int habit_id,Habit h){
        habits.put(habit_id,h);
    }
    void addFriendReq(User f){
        friendReq.add(f);
    }
    
    
}
