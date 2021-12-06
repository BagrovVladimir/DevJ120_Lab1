
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class User{
    
    private int id;
    private String name;
    private boolean isAdmin;
    
    static ArrayList <User> users = new ArrayList<>();
    
    public User(){}

    public User(int id, String name, boolean isAdmin) throws UserException{ 
        setName(name);
        setIsAdmin(isAdmin);
        setId(id);
        users.add(this);
        System.out.println("id: "+id+" , name: "+name+" . Is Admin? "+isAdmin);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws UserException{
        for (User user : users) {
            if(id!=user.id) this.id = id;
            else throw new UserException("!");      
        }
    }    
    
    public String getName() {
        return name;
    }

    public void setName(String name) throws UserException {
        if (name != null && !name.trim().isEmpty()) {this.name=name;} 
        else throw new UserException("Name can not null or empty");    
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    

    @Override
    protected Object clone() throws CloneNotSupportedException  {
            if (name != null && !name.trim().isEmpty()){
                User user=null;
                try {
                    user = new User(new Random().nextInt(15),name, isAdmin);
                } catch (UserException ex) {
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
                return user;}            
            else throw new CloneNotSupportedException("Name is null or empty!!!!!");  
    }

    @Override
    public int hashCode() {
        int hash = 10;
        hash = 5 * hash + Objects.hashCode(getName());
        hash = 5 * hash + (isIsAdmin() ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        User user;
        if(obj instanceof User){
           user = (User) obj;
        } else return false;
        if (obj==null) return false;
        if(this== obj) return true;
        
        if (isIsAdmin() != user.isIsAdmin()) {
            return false;
        }
        if (!getName().equals(user.getName())) {
            return false;
        }
        return true;
    }
    
    /*public static void main(String[] args) {
        
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
    } */       
}
    

