package hw11;

/**
 *
 * @author jenny
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;


public class AddressBook {
    
    private Map < String, Contact > people = new HashMap < String , Contact > ();
    
    public static void main(String[] args) 
    {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        String input;
        
        do
        {
            showMenu();
            input = scanner.next();
            System.out.println();
            
            switch(input)
            {
                case "1" :
                    addressBook.addContact();
                    break;
                    
                case "2" :
                    addressBook.showContact();
                    break;
                    
                case "3" :
                    addressBook.editContact();
                    break;
                    
                case "4" :
                    addressBook.contactDelete();
                    break;
                    
                case "5" :
                    addressBook.importFile();
                    break;
                    
                case "6" :
                    addressBook.writeFile();
                    break;
                    
                case "7" :
                    addressBook.clearMap();
                    break;
                    
                case "0" :
                    break;
                    
                default:
                    System.out.println("Please enter a right number.");
                    break;
            }
        }while(!input.equals("0"));
        
        
    }
    
    // show menu
    public static void showMenu()
    {
        System.out.println("******** Address Book ********");
        System.out.println("1) Add a New Contact");
        System.out.println("2) Show Contact List");
        System.out.println("3) Edit the Contact");
        System.out.println("4) Delete the Contact");
        System.out.println("5) Import Contacts");
        System.out.println("6) Export Contacts");
        System.out.println("7) Clear Contact List");
        System.out.println("0) Exit");
        System.out.println("********************************");
        System.out.print("Please enter a number in [1,2,3,4,5,6,7,0]: ");
    }
    
    public void addContact()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Phone: ");
        String phone = scanner.next();
        System.out.print("E-mail: ");
        String email = scanner.next();
        System.out.print("Birthday (yyyy/mm/dd):");
        String birthdayString = scanner.next();
        
        //check format
        if(isValidFormat(name, birthdayString, phone, email))
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date birthday = null;
            
            try
            {
                birthday = sdf.parse(birthdayString);
                people.put(name , new Contact(name, birthday, phone, email));
                System.out.println("The contact has been added.");
                System.out.println();
                
                Set set = people.keySet();
                Object[] arr = set.toArray();
                Arrays.sort(arr);
            }
            catch(ParseException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public static boolean isValidFormat(String name, String birthdayString, String phone, String email)
    {
        boolean isValidFormat = true;
        
        if(!name.matches("^[a-zA-Z]+$"))
        {
            System.out.println("Invalid name format!");
            isValidFormat = false;
        }
        
        if(!phone.matches("^09[0-9]{2}-[0-9]{3}-[0-9]{3}$"))
        {
            System.out.println("Invalid phone format!");
            isValidFormat = false;
        }
        
        if(!email.matches("^[_a-z0-9-]+([.][ a-z0-9-]+)*@[a-z0-9-]+([.][ a-z0-9-]+)*$"))
        {
            System.out.println("Invalid e-mail format!");
            isValidFormat = false;
        }
        
        if(!birthdayString.matches("^((19|20)?[0-9]{2}/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01]))$"))
        {
            System.out.println("Invalid birthday format!");
            isValidFormat = false;
        }
        
        System.out.println();
        
        return isValidFormat;
    }
    
    public void showContact()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("Name\t  Birthday\tPhone\t  E-mail");
        System.out.println("---------------------------------------------------------");
        
        Set set=people.keySet();
        Object[] arr=set.toArray();
        Arrays.sort(arr);
        for(Object key:arr)
        {
            System.out.printf("%s\t%s\t%s\t%s\n",people.get(key).getName(),
                    sdf.format(people.get(key).getBirthday()),
                    people.get(key).getPhone(),
                    people.get(key).getEmail());
        }
        System.out.println();
    }
    
    public void editContact()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of contact that you want edit.");
        System.out.print("Name: ");
        String name = scanner.next();
        
        if(people.containsKey(name))
        {
            
            System.out.print("Phone: ");
            String phone = scanner.next();
            System.out.print("E-mail: ");
            String email = scanner.next();
            System.out.print("Birthday (yyyy/mm/dd):");
            String birthdayString = scanner.next();
            
            //check format
            if(isValidFormat(name, birthdayString, phone, email))
            {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Date birthday = null;
                
                try
                {
                    people.remove(name);
                    birthday = sdf.parse(birthdayString);
                    people.put(name , new Contact(name, birthday, phone, email));
                    System.out.println("The contact has been changed.");
                    System.out.println();
                
                    Set set = people.keySet();
                    Object[] arr = set.toArray();
                    Arrays.sort(arr);
                }
                catch(ParseException e)
                {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            System.out.println("Not found !");
            System.out.println();
        }
    }
    
    public void contactDelete()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of contact that you want delete.");
        System.out.print("Name: ");
        String name = scanner.next();
        
        if(people.containsKey(name))
        {
            people.remove(name);
            System.out.println("The contact has been deleted.");
        }
        else
        {
            System.out.println("Not found !");
        }
        
        System.out.println();
    }
    
    public void importFile()
    {
        int max = 0;
        String a[] = null;
        
        try
        {
            File file = new File("data.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String str;
            String line=null;
            StringBuilder data = new StringBuilder();
            
            while( (line = br.readLine()) != null)
            {
                data.append(line + "#");
            }
            
            br.close();
            fr.close();
            
            str=data.toString();
            a = str.split("#");
            max=a.length;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        try
        {
            String contact;
            for(int i = 0; i < max; i++)
            {
                contact = a[i];
                String[] c = contact.split("\\s+");
                
                for(int j = 0; j < (c.length); j++)
                {
                    String name;
                    String phone;
                    String email;
                    String birthdayString;
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                    Date birthday = null;
                    
                    name = c[0];
                    birthdayString = c[1];
                    phone = c[2];
                    email = c[3];
                    
                    birthday = sdf.parse(birthdayString);
                    people.put(name , new Contact(name, birthday, phone, email));
                }
            }
            
            System.out.println("The contact has been imported.\n");
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }
    }
    
    public void writeFile()
    {
        try
        {
            PrintWriter pw = new PrintWriter(new File("contacts.txt"));
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            pw.println("Name\t  Birthday\tPhone\t  E-mail");
            pw.println("---------------------------------------------------------");
            
            Set set=people.keySet();
            Object[] arr=set.toArray();
            Arrays.sort(arr);
            
            for(Object key:arr)
            {
                pw.printf("%s\t%s\t%s\t%s\n",people.get(key).getName(),
                    sdf.format(people.get(key).getBirthday()),
                    people.get(key).getPhone(),
                    people.get(key).getEmail());
            }
            
            pw.flush();
            pw.close();
            
            System.out.println("The contact list has been exported.\n");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void clearMap()
    {
        people.clear();
        System.out.println("The contact list is empty.");
        System.out.println();
    }
}
