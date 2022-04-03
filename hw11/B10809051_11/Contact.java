package hw11;

import java.util.Date;

/**
 *
 * @author jenny
 */
public class Contact
{
    private String name;
    private Date birthday;
    private String phone;
    private String email;
    
    public Contact(String name, Date birthday, String phone, String email)
    {
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
    }
    
    public String getName()
    {
        return name;
    }
    
    public Date getBirthday()
    {
        return birthday;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public String getEmail()
    {
        return email;
    }
}
