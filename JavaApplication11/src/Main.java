
public class Main {
    
    public static void main(String[] args) {
        

        try {
            System.out.println("origin user:");
            User origin = new User(34,"Petr", true);
            System.out.println("hashCode = " + origin.hashCode());
            
            
            System.out.println("copy user:");
            User copy = (User)origin.clone();
            System.out.println("hashCode = " + copy.hashCode());
            System.out.println("origin user and copy user are equals? "+origin.equals(copy));
           
            System.out.println("");
            
            System.out.println("Second user object:");
            User origin2 = new User(2,"Ivan", true);
            System.out.println("hashCode = " + origin2.hashCode());
            System.out.println("copy of second user:");
            User copy2 = (User)origin2.clone();
            
            System.out.println("");
            
            System.out.println("Third origin user:");
            User origin3 = new User(3,"Pavel", true);
            System.out.println("hashCode = " + origin3.hashCode());
            System.out.println("Second origin user and Third origin user are equals? "+origin2.equals(origin3));
            
            System.out.println("");
            
            System.out.println("Fourth origin user:");
            User origin4 = new User(3,"Vasilii", false);
            
        } catch (UserException ex) {
            System.out.println("New user's id is not uniq or Name is null or empty");
        }
         catch (CloneNotSupportedException ex) {
             System.out.println(ex.getMessage());
        
            }
  }
}
