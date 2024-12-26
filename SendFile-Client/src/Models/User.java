package Models;


import java.io.Serializable;
import java.util.List;




public class User implements Serializable {
    private String userName;
    private String Password;    
    
    public User() {
    }
    
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public User(String userName, String Password) {
        this.userName = userName;
        this.Password = Password;
    }
    
    @Override
    public String toString() {
        return userName + "-" + Password;
    }
    public boolean checkUserName(List<User> users, User user)
    {
       for(int i = 0; i < users.size(); i++) {
           if(user.getUserName().equals(users.get(i).getUserName())){
               return true;
           }
       }
       return false;
    }
    
    public boolean checkUser(List<User> users, User user)
    {
       for(int i = 0; i < users.size(); i++) {
           if(user.getUserName().equals(users.get(i).getUserName()) && user.getPassword().equals(users.get(i).getPassword())){
               return true;
           }
       }
       return false;
    }
}
