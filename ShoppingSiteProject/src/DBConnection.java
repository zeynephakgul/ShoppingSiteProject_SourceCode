import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * This program connects to a database and inserts data using methods
 * @author Zeynep Hanife Akgül
 * @version v1.0 29.04.2021
 */


public class DBConnection 
{
    //Properties
    static Connection c = null;
    static Statement stmt = null;

    //Constructor
    DBConnection()
    {
        //try connect to DB
        try 
        {
            Class.forName( "org.sqlite.JDBC");
            //Write location of the database file datab.db to be connected
            c = DriverManager.getConnection( "jdbc:sqlite:C:\\Users\\zeyne\\OneDrive\\Belgeler\\cs102_project\\datab.db");
            System.out.println( "Connected to DB");
            //c.close();
        } catch ( Exception e) 
        {
            System.out.println( "Error: " + e.getMessage());
        }
    }

    //Methods
    /** 
     * Finds password of given username from the database
     * @param username
     * @return String password of given username
     * @author Zeynep Akgul
     */
    public static String getPasswordOfUsername( String username)
    {
        DBConnection db = new DBConnection();

        String password = "";

        try 
        {
            stmt = c.createStatement();

            ResultSet passwordRs = stmt.executeQuery( "SELECT password FROM users WHERE username = '"+username+"'");

            while( passwordRs.next())
            {
                password = passwordRs.getString( "password");
            }

        } catch( Exception e)
        {
            System.out.println( "Error: " + e);
        }

        return password;
    }

    
    /** 
     * Checks if the given password matches with given username's password on the database
     * @param username
     * @param password
     * @return Boolean true if password matches with given username's password on the database
     * @author Zeynep Akgul
     */
    public static Boolean checkPassword( String username, String password)
    {
        DBConnection db = new DBConnection();

        if( password.equals( getPasswordOfUsername( username)))
        {
            //JOptionPane.showMessageDialog( null, "login succesful");
            return true;
        }
        //else
        //JOptionPane.showMessageDialog( null, "wrong username or password");
        return false;
    }

    
    /** 
     * Finds the age of given username from the database
     * @param username of user to be searched
     * @return int age name of user
     * @author Zeynep Akgul
     */
    public static int getAgeOfUsername( String username)
    {
        int age = 0;

        DBConnection db = new DBConnection();

        try 
        {
            stmt = c.createStatement();

            ResultSet ageRs = stmt.executeQuery( "SELECT age FROM users WHERE username = '"+username+"'");

            while( ageRs.next())
            {
                age = ageRs.getInt( "age");
            }
            
        } catch( Exception e)
        {
            System.out.println( "Error: " + e);
        }

        return age;
    }

    
    /** 
     * Finds the email of given username from the database
     * @param username of user to be searched
     * @return String email of user
     * @author Zeynep Akgul
     */
    public static String getEmailOfUsername( String username)
    {
        String email = "";

        DBConnection db = new DBConnection();

        try 
        {
            stmt = c.createStatement();

            ResultSet emailRs = stmt.executeQuery( "SELECT email FROM users WHERE username = '"+username+"'");

            while( emailRs.next())
            {
                email = emailRs.getString( "email");
            }
            
        } catch( Exception e)
        {
            System.out.println( "Error: " + e);
        }

        return email;
    }

    
    /** 
     * Finds the actual name of given username from the database
     * @param username of user to be searched
     * @return String actual name of user
     * @author Zeynep Akgul
     */
    public static String getActualNameOfUsername( String username)
    {
        String actualName = "";

        DBConnection db = new DBConnection();

        try 
        {
            stmt = c.createStatement();

            ResultSet actualNameRs = stmt.executeQuery( "SELECT name FROM users WHERE username = '"+username+"'");

            while( actualNameRs.next())
            {
                actualName = actualNameRs.getString( "name");
            }

        } catch( Exception e)
        {
            System.out.println( "Error: " + e);
        }

        return actualName;
    }

    /** 
     * Finds all users present in the database and prints their properties
     * @author Zeynep Akgul
     */
    public static void listUsers()
    {
        DBConnection db = new DBConnection();

        try 
        {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM users");

            while( rs.next())
            {
                String name = rs.getString( "name");
                String username = rs.getString( "username");
                String password = rs.getString( "password");
                String email = rs.getString( "email");
                String city = rs.getString( "city");
                int zipCode = rs.getInt( "zipcode");
                int age = rs.getInt( "age");

                System.out.println( "\nName: " + name + "\nUsername: " + username + "\nAge: " + age 
                                    + "\nCity: " + city + "\nemail: " + email + "\nZipcode: " + zipCode);
            }

        } catch ( Exception e) 
        {
            System.out.println( "Error: " + e.getMessage());
        }
    }

    
    /** 
     * Finds all book names present in the database
     * @return ArrayList<String> name of books
     * @author Zeynep Akgul
     */
    public static ArrayList<String> getBookName()
    {
        DBConnection db = new DBConnection();

        ArrayList<String> bookNames = new ArrayList<String>();

        try 
        {
            stmt = c.createStatement();

            //getting book names
            ResultSet bookRs = stmt.executeQuery( "SELECT * FROM books");
            while( bookRs.next())
            {
                bookNames.add( bookRs.getString( "name"));
            }

            System.out.println( bookNames);
        } catch ( Exception e) 
        {
            System.out.println( "Error: " + e.getMessage());
        }

        return bookNames;
    }

    
    /** 
     * Finds all cloth names present in the database
     * @return ArrayList<String> name of clothes
     * @author Zeynep Akgul
     */
    public static ArrayList<String> getClothName()
    {
        DBConnection db = new DBConnection();

        ArrayList<String> clothNames = new ArrayList<String>();

        try 
        {
            stmt = c.createStatement();

            //getting cloth names
            ResultSet clothRs = stmt.executeQuery( "SELECT * FROM clothes");
            while( clothRs.next())
            {
                clothNames.add( clothRs.getString( "name"));
            }

            System.out.println( clothNames);
        } catch ( Exception e) 
        {
            System.out.println( "Error: " + e.getMessage());
        }

        return clothNames;
    }


    
    /** 
     * Finds all technological device names present in the database
     * @return ArrayList<String> name of technological devices
     * @author Zeynep Akgul
     */
    public static ArrayList<String> getTDeviceName()
    {
        DBConnection db = new DBConnection();

        ArrayList<String> deviceNames = new ArrayList<String>();

        try 
        {
            stmt = c.createStatement();

            //getting technological device names
            ResultSet deviceRs = stmt.executeQuery( "SELECT * FROM technological_devices");
            while( deviceRs.next())
            {
                deviceNames.add( deviceRs.getString( "name"));
            }

            System.out.println( deviceNames);
        } catch ( Exception e) 
        {
            System.out.println( "Error: " + e.getMessage());
        }

        return deviceNames;
    }


    
    /** 
     * Finds all vehicle names present in the database
     * @return ArrayList<String> name of vehicles
     * @author Zeynep Akgul
     */
    public static ArrayList<String> getVehicleName()
    {
        DBConnection db = new DBConnection();

        ArrayList<String> vehicleNames = new ArrayList<String>();

        try 
        {
            stmt = c.createStatement();

            //getting vehicle names
            ResultSet vehicleRs = stmt.executeQuery( "SELECT * FROM vehicles");
            while( vehicleRs.next())
            {
                vehicleNames.add( vehicleRs.getString( "name"));
            }

            System.out.println( vehicleNames);
        } catch ( Exception e) 
        {
            System.out.println( "Error: " + e.getMessage());
        }

        return vehicleNames;
    }


    
    /** 
     * Finds all item names present in the database
     * @return ArrayList<String> of all item names
     * @author Zeynep Akgul
     */
    public static ArrayList<String> getAllItemNames()
    {
        DBConnection db = new DBConnection();

        ArrayList<String> itemNames = new ArrayList<String>();
        
        try 
        {
            stmt = c.createStatement();

            //getting book names
            ResultSet bookRs = stmt.executeQuery( "SELECT * FROM books");
            while( bookRs.next())
            {
                itemNames.add( bookRs.getString( "name"));
            }

            //getting cloth names
            ResultSet clothRs = stmt.executeQuery( "SELECT * FROM clothes");
            while( clothRs.next())
            {
                itemNames.add( clothRs.getString( "name"));
            }

            //getting technological devices names
            ResultSet tDeviceRs = stmt.executeQuery( "SELECT * FROM technological_devices");
            while( tDeviceRs.next())
            {
                itemNames.add( tDeviceRs.getString( "name"));
            }

            //getting vehicles names
            ResultSet vehiclesRs = stmt.executeQuery( "SELECT * FROM vehicles");
            while( vehiclesRs.next())
            {
                itemNames.add( vehiclesRs.getString( "name"));
            }

            System.out.println( itemNames);

        } catch ( Exception e) 
        {
            System.out.println( "Error: " + e.getMessage());
        }

        return itemNames;
    }

    
    /** 
     * Finds price of given vehicle from the database
     * @param vehicleName
     * @return String price of vehicle
     * @author Zeynep Akgul
     */
    public static String getPriceOfVehicle( String vehicleName)
    {
        String vPrice = "";

        DBConnection db = new DBConnection();

        try 
        {
            stmt = c.createStatement();

            ResultSet priceRs = stmt.executeQuery( "SELECT price FROM vehicles WHERE name = '"+vehicleName+"'");

            while( priceRs.next())
            {
                vPrice = priceRs.getString( "price");
            }

        } catch( Exception e)
        {
            System.out.println( "Error: " + e);
        }

        return vPrice;
    }

    
    /** 
     * Finds price of given cloth from the database
     * @param clothName
     * @return String price of cloth
     * @author Zeynep Akgul
     */
    public static String getPriceOfCloth( String clothName)
    {
        String cPrice = "";

        DBConnection db = new DBConnection();

        try 
        {
            stmt = c.createStatement();

            ResultSet priceRs = stmt.executeQuery( "SELECT price FROM clothes WHERE name = '"+clothName+"'");

            while( priceRs.next())
            {
                cPrice = priceRs.getString( "price");
            }
            
        } catch( Exception e)
        {
            System.out.println( "Error: " + e);
        }

        return cPrice;
    }

    
    /** 
     * Finds price of given technological device from the database
     * @param deviceName
     * @return String price of technological device
     * @author Zeynep Akgul
     */
    public static String getPriceOfTDevice( String deviceName)
    {
        String tPrice = "";

        DBConnection db = new DBConnection();

        try 
        {
            stmt = c.createStatement();

            ResultSet priceRs = stmt.executeQuery( "SELECT price FROM technological_devices WHERE name = '"+deviceName+"'");

            while( priceRs.next())
            {
                tPrice = priceRs.getString( "price");
            }
            
        } catch( Exception e)
        {
            System.out.println( "Error: " + e);
        }

        return tPrice;
    }

    
    /** 
     * Finds price of given book from the database
     * @param bookName
     * @return String price of book
     * @author Zeynep Akgul
     */
    public static String getPriceOfBook( String bookName)
    {
        String bPrice = "";

        DBConnection db = new DBConnection();

        try 
        {
            stmt = c.createStatement();

            ResultSet priceRs = stmt.executeQuery( "SELECT price FROM books WHERE name = '"+bookName+"'");

            if( priceRs.next())
            {
                bPrice = priceRs.getString( "price");
            }

        } catch( Exception e)
        {
            System.out.println( "Error: " + e);
        }
        return bPrice;
    }

    
    /** 
     * Finds image of given item name from given cathegory from database and returns it 
     * @param cathegory of item
     * @param name of item
     * @return ImageIcon of item
     * @author Zeynep Akgul
     */
    public static ImageIcon getImageOfItem( String cathegory, String name)
    {
        DBConnection db = new DBConnection();

        ImageIcon image = null;
        //im.getScaledInstance(bLab.getWidth(), bLab.getHeight(), Image.SCALE_SMOOTH);

        try 
        {
            stmt = c.createStatement();

            ResultSet imageRs = stmt.executeQuery( "SELECT image FROM image WHERE name = 'a'");

            while( imageRs.next())
            {
                //byte[] img = imageRs.getBytes( "image");
                image = (ImageIcon) imageRs.getBlob( "image");
            }
        } catch( Exception e)
        {
            System.out.println( "Error image: " + e);
        }
        return image;
    }

    
    /** 
     * Finds adress of given item name from given cathegory from database and returns it
     * @param cathegory of item
     * @param name of item
     * @return String image adress
     * @author Zeynep Akgul
     */
    public static String getImageAdressOfItem( String cathegory, String name)
    {
        String adress = "";

        DBConnection db = new DBConnection();

        try 
        {
            stmt = c.createStatement();

            ResultSet adressRs = stmt.executeQuery( "SELECT image FROM '"+cathegory+"' WHERE name = '"+name+"'");

            if( adressRs.next())
            {
                adress = adressRs.getString( "image");
            }

        } catch( Exception e)
        {
            System.out.println( "Error: " + e);
        }

        return adress;
    }

    
    /** 
     * returns name and price of given book item
     * @param searchedBookname
     * @return ArrayList<String> of name at index 0, price at index 1
     * @author Zeynep Akgul
     */
    public static ArrayList<String> searchBook( String searchedBookname)
    {
        ArrayList<String> properties = new ArrayList<String>();

        String name = "";
        String price = "";

        try
        {
            ResultSet rs = stmt.executeQuery( "SELECT * FROM books WHERE name = '"+searchedBookname+"'");

            while( rs.next())
            {
                name  = rs.getString( "name");
                price = "" + rs.getInt( "price");
            }

            properties.add( name);
            properties.add( price);

        } catch( Exception e)
        {
            //error
        }
        return properties;
    }

    
    /** 
     * returns name and price of given technological device item
     * @param searchedDevicename
     * @return ArrayList<String> of name at index 0, price at index 1
     * @author Zeynep Akgul
     */
    public static ArrayList<String> searchDevice( String searchedDevicename)
    {
        ArrayList<String> properties = new ArrayList<String>();

        String name = "";
        String price = "";

        try
        {
            ResultSet rs = stmt.executeQuery( "SELECT * FROM technological_devices WHERE name = '"+searchedDevicename+"'");

            while( rs.next())
            {
                name  = rs.getString( "name");
                price = "" + rs.getInt( "price");
            }

            properties.add( name);
            properties.add( price);

        } catch( Exception e)
        {
            //error
        }
        return properties;
    }

    
    /** 
     * returns name and price of given vehicle item
     * @param searchedVehiclename
     * @return ArrayList<String> of name at index 0, price at index 1
     * @author Zeynep Akgul
     */
    public static ArrayList<String> searchVehicle( String searchedVehiclename)
    {
        ArrayList<String> properties = new ArrayList<String>();

        String name = "";
        String price = "";

        try
        {
            ResultSet rs = stmt.executeQuery( "SELECT * FROM vehicles WHERE name = '"+searchedVehiclename+"'");

            while( rs.next())
            {
                name  = rs.getString( "name");
                price = "" + rs.getInt( "price");
            }

            properties.add( name);
            properties.add( price);

        } catch( Exception e)
        {
            //error
        }
        return properties;
    }

    
    /** 
     * returns name and price of given cloth item
     * @param searchedClothname
     * @return ArrayList<String> of name at index 0, price at index 1
     * @author Zeynep Akgul
     */
    public static ArrayList<String> searchCloth( String searchedClothname)
    {
        ArrayList<String> properties = new ArrayList<String>();

        String name = "";
        String price = "";

        try
        {
            ResultSet rs = stmt.executeQuery( "SELECT * FROM clothes WHERE name = '"+searchedClothname+"'");

            while( rs.next())
            {
                name  = rs.getString( "name");
                price = "" + rs.getInt( "price");
            }

            properties.add( name);
            properties.add( price);

        } catch( Exception e)
        {
            //error
        }
        return properties;
    }

    /** 
     * Closes all connections to made to database
     * @author Zeynep Akgul
     */
    public void closeConnections()
    {
        try 
        {
            c.close();
        } catch (Exception e) 
        {
            //error
        }
    }
    
    /** 
     * executes given String to find representation in SQLite language
     * @param query to be executed
     * @author Zeynep Akgul
     */
    public void executeQuery( String query)
    {
        try 
        {
            stmt = c.createStatement();
            stmt.executeQuery( query);
        } catch (Exception e) 
        {
            //error
        }
    }

    //main method to test the DBConnection class
    public static void main(String[] args)
    {
        DBConnection db = new DBConnection();

        //String query = "DELETE FROM users WHERE username = 'Zeynep'";

        //db.executeQuery( query);

        listUsers();
        System.out.println( "\n");
        getAllItemNames();
        System.out.println( "\n");
        getBookName();
        System.out.println( "\n");
        getClothName();
        System.out.println( "\n");
        getTDeviceName();
        System.out.println( "\n");
        getVehicleName();
        System.out.println( "\n");

        System.out.println( getPasswordOfUsername( "Zeynep"));
        System.out.println( getPasswordOfUsername( "Azra_"));

        System.out.println( checkPassword( "Zeynep", "Zeynep123"));
        System.out.println( checkPassword( "Azra_", "ABC12345"));
        System.out.println( checkPassword( "Azra", "ABC12345"));

        System.out.println( searchBook( "1984"));

        System.out.println( getImageAdressOfItem( "books", "1984"));

        db.closeConnections();
    }
}