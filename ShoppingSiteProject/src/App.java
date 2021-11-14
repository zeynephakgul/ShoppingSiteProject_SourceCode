/**
 * Tester class
 * @author Gökberk Altıparmak
 * @version v1.0 24.04.2021
 */

public class App {
    public static void main(String[] args) throws Exception {
        BankRegistration bank = new BankRegistration( "aslı", "", "", "", 0, "", "", "", 0 );
        UserRegistration user = new UserRegistration( 1, "aslı", "", "", "", 0);
        User aUser = new User( bank, user );
        System.out.println( aUser.getBank().getAccountName() );
    }
}
