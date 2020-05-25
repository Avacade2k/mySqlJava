
public class myBean {  
    private static String username;
	private static String password;  
	private String userlist;
      
    public static String getUsername() {  
        return username;  
    }  
    public void setName(String username) {  
        this.username = username;  
    }  
    public void setPassword(String password) {  
        this.password = password;  
    }
    public static String getPassword() {  
        return password;  
    }
    public String getUserlist(){
    	userlist = SQLcon.userbase.toString();
    	return userlist;
    }
    
}  
