import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;


public class HabitService {
    Scanner scan = new Scanner(System.in);

    Map<Integer, User> users = new HashMap<>();

   

    public void addUser(int user_id, String name) {
        if (users.containsKey(user_id)) {
            System.out.println("User already exists");
            return;
        }

        User user = new User(user_id, name);
        users.put(user_id, user);
        System.out.println("User added successfully");
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available");
            return;
        }

        for (User user : users.values()) {
            System.out.println("User Id: " + user.userId);
            System.out.println("Name: " + user.name);
            System.out.println("-----------------");
        }
    }

    public void deleteUser(int user_id) {
        if (!users.containsKey(user_id)) {
            System.out.println("User not found");
            return;
        }

        users.remove(user_id);
        System.out.println("User removed successfully");
    }

    

    public void addHabitToUser(int user_id, int habit_id, String habitName, int goal) {

        User user = users.get(user_id);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        if (user.habits.containsKey(habit_id)) {
            System.out.println("Habit already exists");
            return;
        }

        Habit habit = new Habit(habit_id, habitName, goal, 0, 0, false);
        user.addHabit(habit_id, habit);

        System.out.println("Habit added successfully");
    }

    public void displayUserHabits(int user_id) {
        User user = users.get(user_id);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        if (user.habits.isEmpty()) {
            System.out.println("No habits found");
            return;
        }

        for (Habit habit : user.habits.values()) {
            System.out.println("Habit Id: " + habit.habit_id);
            System.out.println("Habit Name: " + habit.habit_name);
            System.out.println("Goal: " + habit.goal);
            System.out.println("-----------------");
        }
    }

    

    public void updateProgress(int userId, int habitId, int value) {

        User user = users.get(userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        Habit habit = user.habits.get(habitId);
        if (habit == null) {
            System.out.println("Habit not found");
            return;
        }

        LocalDate today = LocalDate.now();

        if (habit.lastUpdatedDate == null) {
            habit.progress = value;
            habit.lastUpdatedDate = today;
        }

        else if (habit.lastUpdatedDate.equals(today)) {
            habit.progress += value;
        }

        else if (habit.lastUpdatedDate.plusDays(1).equals(today)) {

            if (habit.progress >= habit.goal) {
                habit.streak++;
            } else {
                habit.streak = 0;
            }

            habit.progress = value;
            habit.lastUpdatedDate = today;
        }

        else {
            habit.streak = 0;
            habit.progress = value;
            habit.lastUpdatedDate = today;
        }

        if (habit.progress >= habit.goal) {
            habit.progress = habit.goal;
            System.out.println("Goal completed for today!");
        }
    }

    public void displayProgress(int user_id, int habit_id) {

        User user = users.get(user_id);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        Habit habit = user.habits.get(habit_id);
        if (habit == null) {
            System.out.println("Habit not found");
            return;
        }

        System.out.println("Habit Name: " + habit.habit_name);
        System.out.println("Progress: " + habit.progress + "/" + habit.goal);
        System.out.println("Streak: " + habit.streak);
    }

   

    public void addJournal(int user_id, String date, String journal) {

        User user = users.get(user_id);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        user.journals.put(date, journal);
        System.out.println("Journal added");
    }

    public void displayJournal(int user_id) {

        User user = users.get(user_id);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        if (user.journals.isEmpty()) {
            System.out.println("No journal entries");
            return;
        }

        for (Map.Entry<String, String> entry : user.journals.entrySet()) {
            System.out.println("Date: " + entry.getKey());
            System.out.println("Journal: " + entry.getValue());
            System.out.println("-----------------");
        }
    }

    

    public void displayRewards(int user_id, int habit_id) {

        User user = users.get(user_id);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        Habit habit = user.habits.get(habit_id);
        if (habit == null) {
            System.out.println("Habit not found");
            return;
        }

        if (habit.progress == habit.goal) {
            habit.completion = true;
        }

        if (habit.completion) {
            System.out.println("Completion Badge earned!");
        }

        if (habit.streak < 3) {
            System.out.println("Silver Badge");
        } else if (habit.streak < 7) {
            System.out.println("Gold Badge");
        } else {
            System.out.println("Platinum Badge");
        }
    }
    void sendRequest(int user_id,int f_id){
        User user = users.get(user_id);
        // System.out.println("hello");
        if(user == null){
            System.out.println("User not found");
            return;
        }
        User reqFrnd = users.get(f_id);
        if(reqFrnd == null){
            System.out.println("User not found");
            return;
        }
        if(reqFrnd.friendReq.contains(user)){
            System.out.println("Request has been already sent");
            return;
        }
        reqFrnd.addFriendReq(user);
         System.out.println("Request has been sent to "+f_id);
       
    }
    // void displayfriendReq(int u_id){
    //      User user = users.get(u_id);
    //     if(user == null){
    //         System.out.println("User not found");
    //         return;
    //     }
    //     if(user.friendReq.isEmpty()){
    //         System.out.println("No friend Requests recieved");
    //         return;
    //     }
    //     // for(User us: user.friendReq){
    //     //     System.out.println(us.userId+"-"+us.name);
    //     // }
         
    // }
    void friendReqManage(int u_id){
    User user = users.get(u_id);

    if(user == null){
        System.out.println("User not found");
        return;
    }

   
    if(user.friendReq.isEmpty()){
        System.out.println("No friend requests");
        return;
    }

 
    System.out.println("Friend Requests:");
    for(User us : user.friendReq){
        System.out.println(us.userId + " - " + us.name);
    }

     
    System.out.print("Choose id to manage: ");
    int chooseId = scan.nextInt();
    scan.nextLine();  

     
    Iterator<User> it = user.friendReq.iterator();

    while(it.hasNext()){
        User u = it.next();

        if(u.userId == chooseId){
            System.out.println("Selected: " + u.name);

            System.out.println("1. Accept  2. Reject");
            int choice = scan.nextInt();
            scan.nextLine();  

            if(choice == 1){
               
                if(!user.friends.contains(u)){
                    user.friends.add(u);
                    u.friends.add(user);
                }
                it.remove(); 
                System.out.println("Friend added");
            } 
            else if(choice == 2){
                it.remove();  
                System.out.println(" Request rejected");
            } 
            else{
                System.out.println("Invalid choice");
            }

            return;
        }
    }

    System.out.println("No request found with given id");
}
void displayFriends(int u_id){
        User user = users.get(u_id);
        if(user == null){
            System.out.println("No user found");
            return;
        }
         if(user.friends.isEmpty()){
            System.out.println("No friends found");
         }
        for(User u : user.friends){
            System.out.println(u.name);
        }
        
    }
void addRemainder(int u_id,int h_id){
    User user = users.get(u_id);
    if(user == null){
        System.out.println("User not found");
        return;
    }
    Habit habit = user.habits.get(h_id);
    if(habit == null){
        System.out.println("Habit not found");
        return;
    }
    System.out.println("Enter date: ");
    String dat = scan.nextLine();
    LocalDate date = LocalDate.parse(dat);

    String tim = scan.nextLine();
    LocalTime time = LocalTime.parse(tim);

    System.out.println("Enter message to Remaind");
    String message = scan.nextLine();



    // Remainder remainder = new Remainder();
}

}