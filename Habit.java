import java.util.*;
class Habit {
    int habit_id;
    String habit_name;
    int goal;
    int progress;
    int streak;
    boolean completion;
     Map<Integer,Remainder> remainders;

    java.time.LocalDate lastUpdatedDate;

    Habit(int habit_id, String habit_name, int goal, int progress, int streak, boolean completion) {
        this.habit_id = habit_id;
        this.habit_name = habit_name;
        this.goal = goal;
        this.progress = progress;
        this.streak = streak;
        this.completion = completion;
        this.lastUpdatedDate = null;
        remainders = new HashMap<>();
    }
    void addRemainder(int habit_id,Remainder r){
        remainders.put(habit_id,r);
        
    }

}