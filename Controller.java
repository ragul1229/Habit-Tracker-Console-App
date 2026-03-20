import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Controller {
      Scanner scan = new Scanner(System.in);
       HabitService hs = new HabitService();
      public void start(){
         while (true) {
            try{
            System.out.println("\n===== HABIT TRACKER MENU =====");
            System.out.println("1. Add User");
            System.out.println("2. Display Users");
            System.out.println("3. Delete User");
            System.out.println("4. Add Habit");
            System.out.println("5. Display User Habits");
            System.out.println("6. Update Progress");
            System.out.println("7. Display Progress");
            System.out.println("8. Add Journal");
            System.out.println("9. Display Journal");
            System.out.println("10. Display Rewards");
            System.out.println("11. Friend Request");
            System.out.println("12. Friend Request Manage");
            System.out.println("13. Display Friends");
            System.out.println("14. Add a Remainder Friends");
            // System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scan.nextInt();
            scan.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter user id: ");
                    int uid = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Enter name: ");
                    String name = scan.nextLine();

                    hs.addUser(uid, name);
                    break;

                case 2:
                    hs.displayUsers();
                    break;

                case 3:
                    System.out.print("Enter user id to delete: ");
                    int delId = scan.nextInt();
                    hs.deleteUser(delId);
                    break;

                case 4:
                    System.out.print("Enter user id: ");
                    int uId = scan.nextInt();

                    System.out.print("Enter habit id: ");
                    int hId = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Enter habit name: ");
                    String habitName = scan.nextLine();

                    System.out.print("Enter goal (days): ");
                    int goal = scan.nextInt();

                    hs.addHabitToUser(uId, hId, habitName, goal);
                    break;

                case 5:
                    System.out.print("Enter user id: ");
                    int userId = scan.nextInt();
                    hs.displayUserHabits(userId);
                    break;

                case 6:
                    System.out.print("Enter user id: ");
                    int u = scan.nextInt();

                    System.out.print("Enter habit id: ");
                    int h = scan.nextInt();

                    System.out.print("Enter progress value: ");
                    int val = scan.nextInt();

                    hs.updateProgress(u, h, val);
                    break;

                case 7:
                    System.out.print("Enter user id: ");
                    int du = scan.nextInt();

                    System.out.print("Enter habit id: ");
                    int dh = scan.nextInt();

                    hs.displayProgress(du, dh);
                    break;

                case 8:
                    System.out.print("Enter user id: ");
                    int ju = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Enter date: ");
                    String date = scan.nextLine();

                    System.out.print("Enter journal: ");
                    String journal = scan.nextLine();

                    hs.addJournal(ju, date, journal);
                    break;

                case 9:
                    System.out.print("Enter user id: ");
                    int dj = scan.nextInt();
                    hs.displayJournal(dj);
                    break;

                case 10:
                    System.out.print("Enter user id: ");
                    int ru = scan.nextInt();

                    System.out.print("Enter habit id: ");
                    int rh = scan.nextInt();

                    hs.displayRewards(ru, rh);
                        break;
                    case 11:
                        System.out.print("Enter user id: ");
                        int u_id = scan.nextInt();
                        scan.nextLine();

                        System.out.println("Give request to");
                        //  hs.displayfriendReq(u_id);
                        int f_id = scan.nextInt();
                        scan.nextLine();
                        hs.sendRequest(u_id,f_id);
                       
                        break;
                case 12:
                     
 
                
                System.out.print("Enter user id: ");
                    int u_iid = scan.nextInt();
                    scan.nextLine();
                    

                    // hs.displayfriendReq(u_iid);    
                    // System.out.println("Choose Id to manage");
                    hs.friendReqManage(u_iid);
                    break;
                case 13:
                    System.out.println("Enter user id: ");
                    int uu_id = scan.nextInt();
                    scan.nextLine();
                    hs.displayFriends(uu_id);
                    break;
                case 14:
                    System.out.println("Enter user id: ");
                    int uu__iid = scan.nextInt();
                    scan.nextLine();
                    int habit_id= scan.nextInt();
                    scan.nextInt();
                    hs.addRemainder(uu__iid,habit_id);





                case 0:
                    System.out.println("Exiting... 👋");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
            
        }
       catch (InputMismatchException e){
    System.out.println("⚠️ Please enter only numbers!");
    scan.nextLine();
}
        }
      }
}
