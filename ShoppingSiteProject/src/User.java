import java.util.ArrayList;

/**
 * User Class
 * @author Gökberk Altıparmak
 * @version v1.0 24.04.2021
 */

public class User
{
    // Properties
    private ArrayList<Item> itemList;
    private BankRegistration bankAccount;
    private UserRegistration userAccount;
    
    
    User( BankRegistration bank, UserRegistration user )
    {
        itemList = new ArrayList<>();
        this.bankAccount = bank;
        this.userAccount = user;
    }
    
    public BankRegistration getBank()
    {
        return bankAccount;
    }
    
    public UserRegistration getUser()
    {
        return userAccount;
    }
    
    public ArrayList<Item> getItemList()
    {
        return itemList;
    }
    
    public void addItem( Item item )
    {
        if ( item != null )
            itemList.add( item );
    }
    
    public void removeItem( Item item )
    {
        if ( item != null )
        {
            for ( int i = 0; i < itemList.size(); i++ )
            {
                if ( itemList.get( i ) == item )
                {
                    itemList.remove( item );
                }
            }
        }
    }
    
    public void clearList()
    {
        for ( int i = 0; i < itemList.size(); i++ )
        {
            itemList.remove( i );
        }
    }
    
    public int calculateTotal()
    {
        int total;
        total = 0;
        for ( int i = 0; i < itemList.size(); i++ )
        {
            total += itemList.get( i ).getPrize();
        }
        return total;
    }
}
