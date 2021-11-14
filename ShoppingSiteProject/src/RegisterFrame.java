
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

/**
 * Register Frame
 * @author Gökberk Altıparmak, Osman Baktır, Berkan Karakuş(methods to check conditions), Zeynep Hanife Akgül(database connection)
 * @version v1.0 01.05.2021
 */

public class RegisterFrame
{
    private JFrame frame;
    private JPanel loginPanel;
    private JLabel login;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JLabel label;
    private JLabel label2;
    private JTextField userText;
    private JButton registerButton;
    private JPasswordField passwordText;
    private JButton loginButton;
    private Font newFont;
    private Font loginFont;
    private Font textFont;
    private JPanel regPanel;
    private JLabel title;
    private JLabel userName;
    private JTextField userNameText;
    private JLabel password;
    private JPasswordField passwordText1;
    private JLabel name;
    private JTextField nameText;
    private JLabel age;
    private JComboBox ageBox;
    private JLabel email;
    private JComboBox emailBox;
    private JTextField emailText;
    private JCheckBox terms;
    private JButton submitButton;
    private JButton resetButton;
    private JTextArea info;
    private JCheckBox checkPassword;
    private JLabel fail;
    private Font newFont1;
    
    private final String AGES[]
    = { "18", "19", "20", "21",
        "22", "23", "24", "25",
        "26", "27", "28", "29",
        "30", "31", "32", "33",
        "34", "33", "34", "35",
        "36", "37", "38", "39",
        "40", "41", "42", "43",
        "44", "45", "46", "47",
        "48", "49", "50", "51",
        "52", "53", "54", "55", };
    
    private final String EMAILS[]
    = { "@hotmail.com", "@gmail.com", "@icloud.com", "@g2mail.com" };
    private JPanel bankRegPanel;
    private JLabel tittle;
    private JLabel accountName;
    private JTextField accountNameText;
    private JLabel bankName;
    private JTextField bankNameText;
    private JLabel nameOnCard;
    private JTextField nameOnCardText;
    private JLabel cardNumber;
    private JTextField cardNumberBox;
    private JLabel accountNumber;
    private JTextField accountNumberText;
    private JCheckBox terms1;
    private JButton submitButton1;
    private JButton resetButton1;
    private JComboBox monthBox;
    private JComboBox yearBox;
    private JLabel expiryDate;
    private JLabel month;
    private JLabel year;
    private JLabel ccvCode;
    private JTextField ccvCodeText;
    private final String EXPIRY_MONTH[]
        = { "1", "2", "3", "4",
            "5", "6", "7", "8",
            "9", "10", "11", "12",};
        
    private final String EXPIRY_YEAR[]
        = { "21", "22", "23", "24", "25","26","27","28","29","30","31" };

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pat = null; 
    
    public RegisterFrame()
    {
        //Connecting to databse
        try 
        {

            Class.forName( "org.sqlite.JDBC");
            //Write location of the database file datab.db to be connected
            con = DriverManager.getConnection( "jdbc:sqlite:C:\\Users\\zeyne\\OneDrive\\Belgeler\\cs102_project\\datab.db");
            System.out.println( "Connected to DB");
        } catch ( Exception e) 
        {
            System.out.println( "Error: " + e.getMessage());
        }

        // Login Page
        frame = new JFrame();
        frame.setTitle( "User Registration" );
        frame.setBounds( 300, 90, 900, 600 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setResizable( false );
        
        loginPanel = new JPanel();
        loginPanel.setLayout( null );
        
        newFont = new Font( "Serif", Font.PLAIN, 24 );
        loginFont = new Font( "Serif", Font.BOLD, 40 );
        textFont = new Font ( "Arial", Font.PLAIN, 15 );
        
        login = new JLabel( "Login Page" );
        login.setFont( loginFont );
        login.setBounds( 400, 10, 300, 100 );
        
        userLabel = new JLabel( "Username " );
        userLabel.setFont( newFont );
        userLabel.setBounds( 250, 100, 200, 100 );
        
        userText = new JTextField( 20 );
        userText.setBounds( 370, 130, 200, 40 );
        userText.setFont( textFont );
        userText.setBackground( Color.WHITE );
        
        passwordLabel = new JLabel( "Password " );
        passwordLabel.setFont( newFont );
        passwordLabel.setBounds( 250, 170, 200, 100 );
        
        passwordText = new JPasswordField( 20 );
        passwordText.setBounds( 370, 200, 200, 40 );
        passwordText.setFont( textFont );
        passwordText.setBackground( Color.WHITE );
        
        loginButton = new JButton( "Login" );
        loginButton.setBounds( 430, 270, 100, 25 );
        loginButton.addActionListener( new MyActionListener1() );
        
        registerButton = new JButton( "Register" );
        registerButton.setBounds( 430, 400, 100, 25 );
        registerButton.addActionListener( new MyActionListener1() );
        
        label = new JLabel( "Don't have account yet?" );
        label.setFont( newFont );
        label.setBounds( 350, 330, 300, 50 );
        
        label2 = new JLabel( "Register to open it =>" );
        label2.setBounds( 300, 386, 170, 50 );
        
        loginPanel.add( userText );
        loginPanel.add( login );
        loginPanel.add( userLabel );
        loginPanel.add( passwordLabel );
        loginPanel.add( passwordText );
        loginPanel.add( loginButton );
        loginPanel.add( registerButton );
        loginPanel.add( label );
        loginPanel.add( label2 );
        
        
        
        // Userreg Page
        regPanel = new JPanel();
        regPanel.setLayout( null );
        
        newFont1 = new Font( "Arial", Font.PLAIN, 20 );
  
        title = new JLabel( "Registration" );
        title.setFont( newFont1 );
        title.setSize( 300, 30 );
        title.setLocation( 300, 30 );
        regPanel.add( title );
  
        userName = new JLabel( "Username" );
        userName.setFont( newFont1 );
        userName.setSize( 100, 25 );
        userName.setLocation( 100, 100 );
        regPanel.add( userName );
  
        userNameText = new JTextField();
        userNameText.setFont( newFont1 );
        userNameText.setSize( 190, 25 );
        userNameText.setLocation( 200, 100 );
        regPanel.add( userNameText );
  
        password = new JLabel( "Password" );
        password.setFont( newFont1 );
        password.setSize( 100, 25 );
        password.setLocation( 100, 150 );
        regPanel.add( password );
  
        passwordText1 = new JPasswordField();
        passwordText1.setFont( newFont1 );
        passwordText1.setSize( 150, 25 );
        passwordText1.setLocation( 200, 150 );
        regPanel.add( passwordText1 );
  
        name = new JLabel( "Name" );
        name.setFont( newFont1 );
        name.setSize( 100, 25 );
        name.setLocation( 100, 200 );
        regPanel.add( name );
        
        nameText = new JTextField();
        nameText.setFont( newFont1 );
        nameText.setSize( 150, 25 );
        nameText.setLocation( 200, 200 );
        regPanel.add( nameText );
  
        age = new JLabel( "Age" );
        age.setFont( newFont1 );
        age.setSize( 100, 25 );
        age.setLocation( 100, 250 );
        regPanel.add( age );
  
        ageBox = new JComboBox( AGES );
        ageBox.setFont( newFont1 );
        ageBox.setSize( 100, 25 );
        ageBox.setLocation( 200, 250 );
        regPanel.add( ageBox );
  
        email = new JLabel( "Email" );
        email.setFont( newFont1 );
        email.setSize( 100, 20 );
        email.setLocation( 100, 300 );
        regPanel.add( email );
        
        emailText = new JTextField();
        emailText.setFont( newFont1 );
        emailText.setSize( 150, 25 );
        emailText.setLocation( 200, 300 );
        regPanel.add( emailText );
        
        emailBox = new JComboBox( EMAILS );
        emailBox.setFont( newFont );
        emailBox.setSize( 150, 25 );
        emailBox.setLocation( 350, 300 );
        regPanel.add( emailBox );
  
        terms = new JCheckBox( "Accept Terms And Conditions" );
        terms.setFont( newFont1 );
        terms.setSize( 300, 20 );
        terms.setLocation( 150, 350 );
        terms.addActionListener( new MyActionListener2() );
        regPanel.add( terms );
  
        submitButton = new JButton( "Submit" );
        submitButton.setFont( newFont1 );
        submitButton.setSize( 100, 20 );
        submitButton.setLocation( 150, 390 );
        submitButton.addActionListener( new MyActionListener2() );
        submitButton.setEnabled( false );
        regPanel.add( submitButton );
  
        resetButton = new JButton( "Reset" );
        resetButton.setFont( newFont1 );
        resetButton.setSize( 100, 20 );
        resetButton.setLocation( 270, 390 );
        resetButton.addActionListener( new MyActionListener2() ) ;
        regPanel.add( resetButton );
  
        info = new JTextArea();
        info.setFont( new Font( "Arial", Font.PLAIN, 15 ) );
        info.setSize( 310, 140 );
        info.setLocation( 520, 250 );
        info.setEditable( false );
        regPanel.add( info );
        
        info.setText( "Requirements To Register" + "\n" + "User name and password must be [6,12]" + "\n" + "characters long" + "\n" + "User name and password can't start with '0'"
                      + "\n" + "Password must include at least 1 capital letter" + "\n" + "and 1 digit" + "\n" + "Example: G2m1234" );
                      
        
        checkPassword = new JCheckBox( "Check Requirements" );
        checkPassword.setFont( newFont1 );
        checkPassword.setSize( 250, 20 );
        checkPassword.setLocation( 540, 400 );
        checkPassword.addActionListener( new MyActionListener2() );
        regPanel.add( checkPassword );
                      
        fail = new JLabel( "" );
        fail.setFont( newFont1 );
        fail.setSize( 400, 25 );
        fail.setLocation( 510, 420 );
        regPanel.add( fail ); 
        
        
        
        // Bankreg Page
        bankRegPanel = new JPanel();
        bankRegPanel.setLayout( null );
  
        tittle = new JLabel( "Bank Registration" );
        tittle.setFont( newFont1 );
        tittle.setSize( 300, 30 );
        tittle.setLocation( 300, 30 );
        bankRegPanel.add( tittle );
  
        accountName = new JLabel( "Account Name" );
        accountName.setFont( newFont1 );
        accountName.setSize( 200, 25 );
        accountName.setLocation( 100, 100 );
        bankRegPanel.add( accountName );
  
        accountNameText = new JTextField();
        accountNameText.setFont( newFont1 );
        accountNameText.setSize( 190, 25 );
        accountNameText.setLocation( 300, 100 );
        bankRegPanel.add( accountNameText );
  
        bankName = new JLabel( "Bank Name" );
        bankName.setFont( newFont1 );
        bankName.setSize( 200, 25 );
        bankName.setLocation( 100, 150 );
        bankRegPanel.add( bankName );
  
        bankNameText = new JTextField();
        bankNameText.setFont( newFont1 );
        bankNameText.setSize( 150, 25 );
        bankNameText.setLocation( 300, 150 );
        bankRegPanel.add( bankNameText );
  
        nameOnCard = new JLabel( "Name on Card" );
        nameOnCard.setFont( newFont );
        nameOnCard.setSize( 200, 25 );
        nameOnCard.setLocation( 100, 200 );
        bankRegPanel.add( nameOnCard );
        
        nameOnCardText = new JTextField();
        nameOnCardText.setFont( newFont );
        nameOnCardText.setSize( 150, 25 );
        nameOnCardText.setLocation( 300, 200 );
        bankRegPanel.add( nameOnCardText );
  
        cardNumber = new JLabel( "Card Number" );
        cardNumber.setFont( newFont );
        cardNumber.setSize( 200, 25 );
        cardNumber.setLocation( 100, 250 );
        bankRegPanel.add( cardNumber );
  
        cardNumberBox = new JTextField();
        cardNumberBox.setFont( newFont );
        cardNumberBox.setSize( 100, 25 );
        cardNumberBox.setLocation( 300, 250 );
        bankRegPanel.add( cardNumberBox );
  
        accountNumber = new JLabel( "Account Number" );
        accountNumber.setFont( newFont );
        accountNumber.setSize( 200, 20 );
        accountNumber.setLocation( 100, 300 );
        bankRegPanel.add( accountNumber );
        
        accountNumberText = new JTextField();
        accountNumberText.setFont( newFont );
        accountNumberText.setSize( 150, 25 );
        accountNumberText.setLocation( 300, 300 );
        bankRegPanel.add( accountNumberText );
        
        expiryDate = new JLabel( "Expiry Date");
        expiryDate.setFont(newFont);
        expiryDate.setSize(200 , 25);
        expiryDate.setLocation( 100,350 );
        bankRegPanel.add(expiryDate);

        monthBox = new JComboBox(EXPIRY_MONTH);
        monthBox.setFont(newFont);
        monthBox.setSize( 100, 25 );
        monthBox.setLocation(300,350);
        bankRegPanel.add(monthBox);

        yearBox = new JComboBox(EXPIRY_YEAR);
        yearBox.setFont(newFont);
        yearBox.setSize( 100, 25);
        yearBox.setLocation(420, 350);
        bankRegPanel.add(yearBox);

        month = new JLabel( "Month" );
        month.setFont(newFont);
        month.setSize(100,25);
        month.setLocation(300, 375);
        bankRegPanel.add(month);

        year = new JLabel( "Year");
        year.setFont(newFont);
        year.setSize(100,25);
        year.setLocation(420,375);
        bankRegPanel.add(year);

        ccvCode = new JLabel("CCV code");
        ccvCode.setFont(newFont);
        ccvCode.setSize(200,25);
        ccvCode.setLocation(100,400);
        bankRegPanel.add(ccvCode);

        ccvCodeText = new JTextField();
        ccvCodeText.setFont(newFont);
        ccvCodeText.setSize(150,25);
        ccvCodeText.setLocation(300, 400);
        bankRegPanel.add(ccvCodeText);

        terms1 = new JCheckBox( "Accept Terms And Conditions" );
        terms1.setFont( newFont );
        terms1.setSize( 300, 20 );
        terms1.setLocation( 150, 450 );
        terms1.addActionListener( new MyActionListener3() );
        bankRegPanel.add( terms1 );
  
        submitButton1 = new JButton( "Submit" );
        submitButton1.setFont( newFont );
        submitButton1.setSize( 100, 20 );
        submitButton1.setLocation( 150, 500 );
        submitButton1.addActionListener( new MyActionListener3() );
        submitButton1.setEnabled( true );
        bankRegPanel.add( submitButton1 );
  
        resetButton1 = new JButton( "Reset" );
        resetButton1.setFont( newFont );
        resetButton1.setSize( 100, 20 );
        resetButton1.setLocation( 270, 500 );
        resetButton1.addActionListener( new MyActionListener3() ) ;
        bankRegPanel.add( resetButton1 );
  
        frame.add( loginPanel );
        frame.setVisible( true );
    }
    
    class MyActionListener1 implements ActionListener
    {
		@Override
        public void actionPerformed( ActionEvent e )
        {
            String username = userText.getText();
            String password = passwordText.getText();

            if ( e.getSource() == loginButton )
            {
                if( DBConnection.checkPassword( username, password))
                {
                    JOptionPane.showMessageDialog( null, "login succesful");

                    String email = DBConnection.getEmailOfUsername( username);
                    String actualName = DBConnection.getActualNameOfUsername( username);
                    int age = DBConnection.getAgeOfUsername( username);

                    BankRegistration bankReg = new BankRegistration( " ", " ", " ", " ", 1, " ", " ", " ", 1);
                    UserRegistration userReg = new UserRegistration( 1, username, email, password, actualName, age);
                    
                    User user = new User( bankReg, userReg);
                    
                    frame.setVisible( false );
                    new MainFrame( user);
                }
                else
                {
                    JOptionPane.showMessageDialog( null, "wrong username or password");
                }
                
            }
            else if ( e.getSource() == registerButton )
            {
                frame.remove( loginPanel );
                frame.add( regPanel );
                frame.repaint();
                frame.revalidate();
            }
		}
    }
    
    class MyActionListener2 implements ActionListener
    {
        @Override
        public void actionPerformed( ActionEvent e )
        {
            if ( checkPassword.isSelected() )
            {
                if ( terms.isSelected() )
                {
                    if ( isPasswordOk( passwordText1.getText() ) && isUserNameOk( userNameText.getText() ) )
                    {
                        submitButton.setEnabled( true );
                        fail.setText( "Ready To Register" );
                    }
                    else
                    {
                        fail.setText( "Password or Username Is Not Suitable" );
                        checkPassword.setSelected( false );
                    }
                }
                else
                {
                    fail.setText( "Accept Our Policy Please" );
                    checkPassword.setSelected( false );
                }
            }
            else
            {
                submitButton.setEnabled( false );
            }
        
            if ( e.getSource() == resetButton )
            {
                String empty;
                empty = "";
                userNameText.setText(empty);
                passwordText.setText(empty);
                nameText.setText(empty);
                fail.setText(empty);
                terms.setSelected( false );
                checkPassword.setSelected( false );
                ageBox.setSelectedIndex(0);
            }
        
            else if ( e.getSource() == submitButton )
            {
                frame.remove( regPanel );
                frame.add( bankRegPanel );
                frame.repaint();
                frame.revalidate();

                try 
                {
    
                    String query = "INSERT INTO users VALUES(?, ?, ?, ?, ?)";
    
                    pat = con.prepareStatement( query);
                    pat.setString( 1, userNameText.getText());
                    pat.setString( 2, passwordText1.getText());
                    pat.setString( 3, nameText.getText());
    
                    int i = ((int) ageBox.getSelectedIndex()) + 18;
                    pat.setInt( 4, i);
                    
                    pat.setString( 5, emailText.getText() + emailBox.getSelectedItem());
                    pat.execute();
                    JOptionPane.showMessageDialog( null, "saved");
    
                }
                catch(Exception er)
                {
                    JOptionPane.showMessageDialog( null, er);
                }
            }
        }
    }

    class MyActionListener3 implements ActionListener
    {
		@Override
        public void actionPerformed( ActionEvent e )
        {
            if ( e.getSource() == resetButton1 )
            {
                String empty;
                empty = "";
                accountNameText.setText( empty );
                bankNameText.setText( empty );
                nameOnCardText.setText( empty );
                terms1.setSelected( false );
                monthBox.setSelectedIndex( 0 );
                yearBox.setSelectedIndex( 0 );
            }
            
            else if ( e.getSource() == submitButton1 )
            {
                // Set user reg info
                int userID = 1;
                String userN;
                String userE;
                String userP;
                String userNa;
                int userA;
                userN = userNameText.getText();
                userE = emailText.getText();
                userP = passwordText.getText();
                userNa = nameText.getText();
                userA = Integer.valueOf( (String) ageBox.getSelectedItem().toString() );
                
                UserRegistration userReg;
                userReg = new UserRegistration( userID, userN, userE, userP, userNa, userA );
                BankRegistration bankReg;
                bankReg = new BankRegistration( "", "", "", "", 1, "", "", "", 1 );
                User user;
                user = new User( bankReg, userReg );
                
                frame.setVisible( false );
                new MainFrame( user );
            }
		}
    }
    
    public static void main( String[] args )
    {
        new RegisterFrame();
    }
    
    public boolean hasUpperCase( String password )
    {
        for ( int i = 0; i < password.length(); i++ )
        {
            if ( Character.isUpperCase( password.charAt( i ) ) )
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasDigit( String password )
    {
        for ( int i = 0; i < password.length(); i++ )
        {
            if ( Character.isDigit( password.charAt( i ) ) )
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean isLengthOk( String input )
    {
        if ( input.length() <= 12 && input.length() >= 6 )
        {
            return true;
        }
        return false;
    }
    
    public boolean isStartWithZero( String input )
    {
        if ( input.charAt( 0 ) == '0' )
        {
            return true;
        }
        return false;
    }
    
    public boolean isPasswordOk( String password )
    {
        if ( password != null && password != "" )
        {
            if ( isLengthOk( password ) && !isStartWithZero( password ) )
            {
                if ( hasUpperCase( password ) && hasDigit( password )  )
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isUserNameOk( String userName )
    {
        if ( userName != null && userName != "" )
        {
            if ( isLengthOk( userName ) && !isStartWithZero( userName ) )
            {
                return true;
            }
        }
        return false;
    }
    
}

        
   



