/**
 * User Registeration
 * @author Gökberk Altıparmak, Berkan Karakuş
 * @version v1.0 24.04.2021
 */

public class UserRegistration
{
    // Properties
    private int userID; // 1 den başlayıp user sayısına göre değişecek.
    private String userName;
    private String email;
    private String password;
    private String name;
    private int age;
    
    UserRegistration( int userID ,String userName, String email, String password, String name, int age)
    {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
    }
    
    public int getUserID()
    {
        return userID;
    }
    public String getUserName()
    {
        return userName;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPassword()
    {
        return password;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    
}
