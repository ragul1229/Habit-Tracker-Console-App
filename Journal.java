public class Journal {
    int journal_id;
    String message;
    User user;
    Journal(int journal_id,String message,User user){
        this.journal_id = journal_id;
        this.message = message;
        this.user = user;

    }
    
}
