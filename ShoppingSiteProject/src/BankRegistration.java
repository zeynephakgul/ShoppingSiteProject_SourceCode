/**
 * Bank Registiration Frame
 * @author Gökberk Altıparmak, Berkan Karakuş
 * @version v1.0 24.04.2021
 */

public class BankRegistration
{
    // Properties
    private String accountName;
    private String bankName;
    private String cardName;
    private String cardNumber;
    private int accountNumber;
    private String day;
    private String month;
    private String year;
    private int cvc;
    
    BankRegistration( String accountName, String bankName, String cardName, String cardNumber, int accountNumber, String day, String month, String year, int cvc )
    {
        this.accountName = accountName;
        this.bankName = bankName;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.day = day;
        this.month = month;
        this.year = year;
        this.cvc = cvc;
    }
    public String getAccountName()
    {
        return accountName;
    }
    public String getBankName()
    {
        return bankName;
    }
    public String getCardName()
    {
        return cardName;
    }
    public String getCardNumber()
    {
        return cardNumber;
    }
    public int getAccountNumber()
    {
        return accountNumber;
    }
    public String getDay()
    {
        return day;
    }
    public String getMonth()
    {
        return month;
    }
    public String getYear()
    {
        return year;
    }
    public int getCVC()
    {
        return cvc;
    }
}
