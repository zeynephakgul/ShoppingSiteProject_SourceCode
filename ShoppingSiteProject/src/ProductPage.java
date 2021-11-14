import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 * Product Page Frame
 * @author Osman Baktır
 * @version v1.0 30.04.2021
 */
public class ProductPage{

    //Properties
    private User user;
    private JFrame frame;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel productImage;
    private JPanel productInfo;
    private JPanel bottomPanel;
    private JButton profileButton;
    private JButton checkoutButton;
    private JButton sellItemButton;
    private ImageIcon exampleImage;
    private JLabel property1;
    private JLabel property2;
    private JLabel property3;
    private JLabel property4;
    private JLabel property5;
    private JLabel property6;
    private JLabel property7;
    private JLabel productCategory;
    private JLabel property1info;
    private JLabel property2info;
    private JLabel property3info;
    private JLabel property4info;
    private JLabel property5info;
    private JLabel property6info;
    private JLabel property7info;
    private JButton buyButton;
    private JButton compareButton;
    private JLabel productCategoryInfo;

    

    //Constructor

    public ProductPage( Item item, User user){
        this.user = user;
        frame = new JFrame();
        frame.setTitle( "Product Page" );
        frame.setBounds( 500, 10, 1200, 1000 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setLayout( new BorderLayout() );
        frame.setResizable( false );


        exampleImage = new ImageIcon( "download.png" );
        topPanel = new JPanel();
        topPanel.setLayout( new GridLayout( 1, 0 ) );
        topPanel.setBorder( BorderFactory.createTitledBorder( "Menu" ) );

        buyButton = new JButton("Buy Product");
        buyButton.addActionListener( new ButtonListener( user, item ) );
        buyButton.setSize( 100, 20 );
        
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1 ,2));
        bottomPanel.add(buyButton);

        profileButton = new JButton( "Profile" );
        checkoutButton = new JButton( "Checkout" );
        sellItemButton = new JButton( "Sell Item" );

        //topPanel.add( new JLabel( "USERNAME HERE" ) );
        topPanel.add( profileButton );
        topPanel.add( checkoutButton );
        //topPanel.add( sellItemButton );

        if( item instanceof Book ){

            Book book;
            book = (Book) item;

            productImage = new JPanel();
            productImage.setLayout( new GridLayout( 1, 0 ) );
            String imageAdress = DBConnection.getImageAdressOfItem( "books", book.getName() );
            JLabel cLab = new JLabel();
            ImageIcon cImageIcon = new ImageIcon( imageAdress);
            Image cImage = cImageIcon.getImage();
            Image cNewimg = cImage.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); 
            cImageIcon = new ImageIcon( cNewimg);
            cLab.setIcon( cImageIcon);
            cLab.setHorizontalAlignment(SwingConstants.CENTER);
            cLab.setVerticalAlignment(SwingConstants.CENTER);
            productImage.add( cLab, SwingConstants.CENTER);

            productInfo = new JPanel();
            productInfo.setLayout(new GridLayout(8,2));
            productCategory = new JLabel("Category");
            productCategoryInfo = new JLabel("Book");

            property1 = new JLabel("Genre");
            property1info = new JLabel(  book.getGenre() );
            productInfo.add(property1);
            productInfo.add(property1info);
            
            property2 = new JLabel("Title");
            property2info = new JLabel( book.getName() );
            productInfo.add(property2);
            productInfo.add(property2info);

            property3 = new JLabel("Author's Name");
            property3info = new JLabel( book.getAuthorsName());
            productInfo.add(property3);
            productInfo.add(property3info);

            property4 = new JLabel("Condition");
            property4info = new JLabel( book.getCondition());
            productInfo.add(property4);
            productInfo.add(property4info);

            property5 = new JLabel("Publisher");
            property5info = new JLabel( book.getPublisher() );
            productInfo.add(property5);
            productInfo.add(property5info);

            property6 = new JLabel("Quantity");
            property6info = new JLabel(book.getQuantity() + "");
            productInfo.add(property6);
            productInfo.add(property6info);

            property7 = new JLabel("Price");
            property7info = new JLabel(book.getPrize() + "");
            productInfo.add(property7);
            productInfo.add(property7info);

            centerPanel = new JPanel();
            centerPanel.setLayout( new GridLayout(2,0));
            centerPanel.add(productImage);
            centerPanel.add(productInfo);
        }
        else if( item instanceof Vehicles ){

            Vehicles vehicle;
            vehicle = ( Vehicles ) item;
            productImage = new JPanel();
            productImage.setLayout( new GridLayout( 1, 0 ) );
            String imageAdress = DBConnection.getImageAdressOfItem( "vehicles", vehicle.getName() );
            JLabel cLab = new JLabel();
            ImageIcon cImageIcon = new ImageIcon( imageAdress);
            Image cImage = cImageIcon.getImage();
            Image cNewimg = cImage.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); 
            cImageIcon = new ImageIcon( cNewimg);
            cLab.setIcon( cImageIcon);
            cLab.setHorizontalAlignment(SwingConstants.CENTER);
            cLab.setVerticalAlignment(SwingConstants.CENTER);
            productImage.add( cLab, SwingConstants.CENTER);

            productInfo = new JPanel();
            productInfo.setLayout(new GridLayout(8,2));
            productCategory = new JLabel("Category");
            productCategoryInfo = new JLabel("Vehicles");

            property1 = new JLabel("Brand");
            property1info = new JLabel( vehicle.getBrand() );
            productInfo.add(property1);
            productInfo.add(property1info);
            
            property2 = new JLabel("Color");
            property2info = new JLabel( vehicle.getColor() );
            productInfo.add(property2);
            productInfo.add(property2info);

            property3 = new JLabel("Horsepower");
            property3info = new JLabel( vehicle.getHorsePower() + "");
            productInfo.add(property3);
            productInfo.add(property3info);

            property4 = new JLabel("Condition");
            property4info = new JLabel( vehicle.getCondition());
            productInfo.add(property4);
            productInfo.add(property4info);

            property5 = new JLabel("Model");
            property5info = new JLabel( vehicle.getModel() );
            productInfo.add(property5);
            productInfo.add(property5info);

            property6 = new JLabel("Quantity");
            property6info = new JLabel(vehicle.getQuantity() + "");
            productInfo.add(property6);
            productInfo.add(property6info);

            property7 = new JLabel("Price");
            property7info = new JLabel(vehicle.getPrize() + "");
            productInfo.add(property7);
            productInfo.add(property7info);

            centerPanel = new JPanel();
            centerPanel.setLayout( new GridLayout(2,0));
            centerPanel.add(productImage);
            centerPanel.add(productInfo);

        }
        else if( item instanceof Clothes){
            
            Clothes clothe;
            clothe = (Clothes) item;
            productImage = new JPanel();
            productImage.setLayout( new GridLayout( 1, 0 ) );
            String imageAdress = DBConnection.getImageAdressOfItem( "clothes", clothe.getName() );
            JLabel cLab = new JLabel();
            ImageIcon cImageIcon = new ImageIcon( imageAdress);
            Image cImage = cImageIcon.getImage();
            Image cNewimg = cImage.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); 
            cImageIcon = new ImageIcon( cNewimg);
            cLab.setIcon( cImageIcon);
            cLab.setHorizontalAlignment(SwingConstants.CENTER);
            cLab.setVerticalAlignment(SwingConstants.CENTER);
            productImage.add( cLab, SwingConstants.CENTER);

            productInfo = new JPanel();
            productInfo.setLayout(new GridLayout(8,2));
            productCategory = new JLabel("Category");
            productCategoryInfo = new JLabel("Clothes");

            property1 = new JLabel("Brand");
            property1info = new JLabel( clothe.getBrand() );
            productInfo.add(property1);
            productInfo.add(property1info);
            
            property2 = new JLabel("Color");
            property2info = new JLabel( clothe.getColor() );
            productInfo.add(property2);
            productInfo.add(property2info);

            property3 = new JLabel("Size");
            property3info = new JLabel( String.valueOf(clothe.getSize()));
            productInfo.add(property3);
            productInfo.add(property3info);

            property4 = new JLabel("Condition");
            property4info = new JLabel( clothe.getCondition());
            productInfo.add(property4);
            productInfo.add(property4info);

            property5 = new JLabel("Material");
            property5info = new JLabel( clothe.getMaterial() );
            productInfo.add(property5);
            productInfo.add(property5info);

            property6 = new JLabel("Quantity");
            property6info = new JLabel(clothe.getQuantity() + "");
            productInfo.add(property6);
            productInfo.add(property6info);

            property7 = new JLabel("Price");
            property7info = new JLabel(clothe.getPrize() + "");
            productInfo.add(property7);
            productInfo.add(property7info);

            centerPanel = new JPanel();
            centerPanel.setLayout( new GridLayout(2,0));
            centerPanel.add(productImage);
            centerPanel.add(productInfo);

        }
        else if( item instanceof TechnologicalDevices){
            
            TechnologicalDevices device;
            device = (TechnologicalDevices) item;
            productImage = new JPanel();
            productImage.setLayout( new GridLayout( 1, 0 ) );
            String imageAdress = DBConnection.getImageAdressOfItem( "technological_devices", device.getName() );
            JLabel cLab = new JLabel();
            ImageIcon cImageIcon = new ImageIcon( imageAdress);
            Image cImage = cImageIcon.getImage();
            Image cNewimg = cImage.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); 
            cImageIcon = new ImageIcon( cNewimg);
            cLab.setIcon( cImageIcon);
            cLab.setHorizontalAlignment(SwingConstants.CENTER);
            cLab.setVerticalAlignment(SwingConstants.CENTER);
            productImage.add( cLab, SwingConstants.CENTER);

            productInfo = new JPanel();
            productInfo.setLayout(new GridLayout(8,2));
            productCategory = new JLabel("Category");
            productCategoryInfo = new JLabel("Technological Devices");

            property1 = new JLabel("Brand");
            property1info = new JLabel( (device.getBrand() ));
            productInfo.add(property1);
            productInfo.add(property1info);
            
            property2 = new JLabel("Electronic Type");
            property2info = new JLabel( (device.getElectronicType()) );
            productInfo.add(property2);
            productInfo.add(property2info);

            property3 = new JLabel("Size");
            property3info = new JLabel( String.valueOf(device.getSize()));
            productInfo.add(property3);
            productInfo.add(property3info);

            property4 = new JLabel("Condition");
            property4info = new JLabel( (device.getCondition()));
            productInfo.add(property4);
            productInfo.add(property4info);

            property5 = new JLabel("Hardware Details");
            property5info = new JLabel( (device.getHardWareDetails() ));
            productInfo.add(property5);
            productInfo.add(property5info);

            property6 = new JLabel("Quantity");
            property6info = new JLabel(device.getQuantity() + "");
            productInfo.add(property6);
            productInfo.add(property6info);

            property7 = new JLabel("Price");
            property7info = new JLabel(device.getPrize() + "");
            productInfo.add(property7);
            productInfo.add(property7info);

            centerPanel = new JPanel();
            centerPanel.setLayout( new GridLayout(2,0));
            centerPanel.add(productImage);
            centerPanel.add(productInfo);
        }
        Container cp;
        cp = frame.getContentPane();
        
        cp.add( topPanel, BorderLayout.NORTH );
        cp.add(centerPanel, BorderLayout.CENTER);
        cp.add(bottomPanel, BorderLayout.SOUTH);
        frame.setVisible( true );

    
    }

    class ButtonListener implements ActionListener{

        private User user12;
        private Item item12;
        public ButtonListener(User user, Item item){
            user12 = user;
            item12 = item;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == buyButton){
                user12.addItem(item12);
                frame.setVisible( false );
                new MainFrame( user );
            }
        }
    }

}
