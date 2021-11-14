import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Main Frame to display different site pages
 * 
 * @author Gökberk Altıparmak, Zeynep Hanife Akgül, Osman Baktır, Berkan Karakuş
 * @version v1.0 24.04.2021
 */

public class MainFrame implements ActionListener {
    // Properties
    private JFrame frame;
    private Container cp;
    private User user;
    private JPanel comparePanel;
    private JPanel checkoutPanel;
    private JPanel userProfilePanel;
    private JPanel topPane;
    private JPanel centerPane;
    private JPanel booksPane;
    private JPanel booksName;
    private JPanel booksImage;
    private JPanel booksButton;
    private JPanel vehiclesPane;
    private JPanel vehiclesName;
    private JPanel vehiclesImage;
    private JPanel vehiclesButton;
    private JPanel devicesPane;
    private JPanel devicesName;
    private JPanel devicesImage;
    private JPanel devicesButton;
    private JPanel clothesPane;
    private JPanel clothesName;
    private JPanel clothesImage;
    private JPanel clothesButton;
    private JButton profileButton;
    private JButton checkoutButton;
    private JButton sellItemButton;
    private JButton book1;
    private JButton book2;
    private JButton book3;
    private JButton vehicle1;
    private JButton vehicle2;
    private JButton vehicle3;
    private JButton device1;
    private JButton device2;
    private JButton device3;
    private JButton clothe1;
    private JButton clothe2;
    private JButton clothe3;
    private ImageIcon exampleImage;
    private JTextField searchField;
    private final int MAX_ITEM_DISPLAYED = 3;
    final String cathegories[] = { "Books", "Technological Devices", "Vehicles", "Clothes", "Main Page" };
    private JComboBox cath;
    private JPanel searchPane = null;
    private final String TL = "TL";

    private int counter;
    private Book bookItem1;
    private Book bookItem2;
    private Vehicles veh1;
    private Vehicles veh2;
    private TechnologicalDevices dev1;
    private TechnologicalDevices dev2;
    private Clothes cloth1;
    private Clothes cloth2;
    private JButton compareBookButton1;
    private JButton compareBookButton2;
    private JButton compareBookButton3;
    private JButton compareClothesButton1;
    private JButton compareClothesButton2;
    private JButton compareClothesButton3;
    private JButton compareTechButton1;
    private JButton compareTechButton2;
    private JButton compareTechButton3;
    private JButton compareVehicleButton1;
    private JButton compareVehicleButton2;
    private JButton compareVehicleButton3;

    MainFrame(User user) {
        this.user = user;
        frame = new JFrame();
        frame.setTitle("Main Page");
        frame.setBounds(200, 10, 1200, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);

        checkoutPanel = new Checkout(user);
        userProfilePanel = new UserProfile(user);

        exampleImage = new ImageIcon("download.png");
        topPane = new JPanel();
        topPane.setLayout(new GridLayout(1, 0));
        topPane.setBorder(BorderFactory.createTitledBorder("Menu"));

        profileButton = new JButton("Profile");
        profileButton.addActionListener(this);
        checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(this);
        sellItemButton = new JButton("Sell Item");
        sellItemButton.addActionListener(this);
        searchField = new JTextField(15);

        topPane.add(new JLabel(user.getUser().getUserName()));
        topPane.add(profileButton);
        topPane.add(checkoutButton);
        // topPane.add( sellItemButton );
        topPane.add(new JLabel("Search: ", JLabel.RIGHT));
        topPane.add(searchField);
        cath = new JComboBox(cathegories);
        topPane.add(cath);
        searchField.addActionListener(this);

        // Adding books name
        booksName = new JPanel();
        booksName.setLayout(new GridLayout(1, 0));
        for (int i = 0; i < MAX_ITEM_DISPLAYED; i++) {
            String bN = DBConnection.getBookName().get(i);
            booksName.add(new JLabel(bN), SwingConstants.CENTER);
        }
        // booksName.add( new JLabel( "item name here" ), SwingConstants.CENTER );

        // Adding books image
        booksImage = new JPanel();
        booksImage.setLayout(new GridLayout(1, 0));
        // first books image
        JLabel b1Lab = new JLabel();
        // ImageIcon iM = DBConnection.getImageOfItem( "image", "image"); //only
        // displayed empty label (see DBConnection.getImageOfItem)
        // b1Lab.setIcon( iM);
        // booksImage.add( bLab);
        ImageIcon b1imageIcon = new ImageIcon("1984.jpg");
        Image b1image = b1imageIcon.getImage();
        Image b1newimg = b1image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        b1imageIcon = new ImageIcon(b1newimg);
        b1Lab.setIcon(b1imageIcon);
        b1Lab.setHorizontalAlignment(SwingConstants.CENTER);
        b1Lab.setVerticalAlignment(SwingConstants.CENTER);
        booksImage.add(b1Lab, SwingConstants.CENTER);
        // second books image
        JLabel b2Lab = new JLabel();
        ImageIcon b2imageIcon = new ImageIcon("blindness.jpeg");
        Image b2image = b2imageIcon.getImage();
        Image b2newimg = b2image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        b2imageIcon = new ImageIcon(b2newimg);
        b2Lab.setIcon(b2imageIcon);
        b2Lab.setHorizontalAlignment(SwingConstants.CENTER);
        b2Lab.setVerticalAlignment(SwingConstants.CENTER);
        booksImage.add(b2Lab, SwingConstants.CENTER);
        // third books image
        JLabel b3Lab = new JLabel();
        ImageIcon b3imageIcon = new ImageIcon("lord.jpg");
        Image b3image = b3imageIcon.getImage();
        Image b3newimg = b3image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        b3imageIcon = new ImageIcon(b3newimg);
        b3Lab.setIcon(b3imageIcon);
        b3Lab.setHorizontalAlignment(SwingConstants.CENTER);
        b3Lab.setVerticalAlignment(SwingConstants.CENTER);
        booksImage.add(b3Lab, SwingConstants.CENTER);
        // booksImage.add( new JLabel( exampleImage ) );

        // Adding books price
        String bP = DBConnection.getPriceOfBook(DBConnection.getBookName().get(2));
        book1 = new JButton(bP + " " + TL);
        String bP2 = DBConnection.getPriceOfBook(DBConnection.getBookName().get(1));
        book2 = new JButton(bP2 + " " + TL);
        String bP3 = DBConnection.getPriceOfBook(DBConnection.getBookName().get(0));
        book3 = new JButton(bP3 + " " + TL);
        // book3 = new JButton( "add price here" );

        book1.addActionListener(this);
        book2.addActionListener(this);
        book3.addActionListener(this);

        compareBookButton1 = new JButton("compare");
        compareBookButton2 = new JButton("compare");
        compareBookButton3 = new JButton("compare");
        compareBookButton1.addActionListener(this);
        compareBookButton2.addActionListener(this);
        compareBookButton3.addActionListener(this);

        booksButton = new JPanel();
        booksButton.setLayout(new GridLayout(1, 0));
        booksButton.add(compareBookButton3);
        booksButton.add(book1);
        booksButton.add(compareBookButton2);
        booksButton.add(book2);
        booksButton.add(compareBookButton1);
        booksButton.add(book3);

        booksPane = new JPanel();
        booksPane.setLayout(new BorderLayout());
        booksPane.add(booksName, BorderLayout.NORTH);
        booksPane.add(booksImage, BorderLayout.CENTER);
        booksPane.add(booksButton, BorderLayout.SOUTH);

        // Adding vehicles name
        vehiclesName = new JPanel();
        vehiclesName.setLayout(new GridLayout(1, 0));
        for (int i = 0; i < MAX_ITEM_DISPLAYED; i++) {
            String vN = DBConnection.getVehicleName().get(i);
            vehiclesName.add(new JLabel(vN), SwingConstants.CENTER);
        }
        // vehiclesName.add( new JLabel( "item name here" ), SwingConstants.CENTER );

        // Adding vehicles image
        vehiclesImage = new JPanel();
        vehiclesImage.setLayout(new GridLayout(1, 0));
        // first vehicles image
        JLabel v1Lab = new JLabel();
        ImageIcon v1imageIcon = new ImageIcon("tesla.jpeg");
        Image v1image = v1imageIcon.getImage();
        Image v1newimg = v1image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        v1imageIcon = new ImageIcon(v1newimg);
        v1Lab.setIcon(v1imageIcon);
        v1Lab.setHorizontalAlignment(SwingConstants.CENTER);
        v1Lab.setVerticalAlignment(SwingConstants.CENTER);
        vehiclesImage.add(v1Lab, SwingConstants.CENTER);
        // second vehicles image
        JLabel v2Lab = new JLabel();
        ImageIcon v2imageIcon = new ImageIcon("mini.jpeg");
        Image v2image = v2imageIcon.getImage();
        Image v2newimg = v2image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        v2imageIcon = new ImageIcon(v2newimg);
        v2Lab.setIcon(v2imageIcon);
        v2Lab.setHorizontalAlignment(SwingConstants.CENTER);
        v2Lab.setVerticalAlignment(SwingConstants.CENTER);
        vehiclesImage.add(v2Lab, SwingConstants.CENTER);
        // third vehicles image
        JLabel v3Lab = new JLabel();
        ImageIcon v3imageIcon = new ImageIcon("golf.jpeg");
        Image v3image = v3imageIcon.getImage();
        Image v3newimg = v3image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        v3imageIcon = new ImageIcon(v3newimg);
        v3Lab.setIcon(v3imageIcon);
        v3Lab.setHorizontalAlignment(SwingConstants.CENTER);
        v3Lab.setVerticalAlignment(SwingConstants.CENTER);
        vehiclesImage.add(v3Lab, SwingConstants.CENTER);
        // vehiclesImage.add( new JLabel( exampleImage ) );

        // Adding vehicles' price
        String vP = DBConnection.getPriceOfVehicle(DBConnection.getVehicleName().get(2));
        vehicle1 = new JButton(vP + " " + TL);
        String vP2 = DBConnection.getPriceOfVehicle(DBConnection.getVehicleName().get(1));
        vehicle2 = new JButton(vP2 + " " + TL);
        String vP3 = DBConnection.getPriceOfVehicle(DBConnection.getVehicleName().get(0));
        vehicle3 = new JButton(vP3 + " " + TL);
        // vehicle3 = new JButton( "add price here" );

        vehicle1.addActionListener(this);
        vehicle2.addActionListener(this);
        vehicle3.addActionListener(this);

        compareVehicleButton1 = new JButton("compare");
        compareVehicleButton2 = new JButton("compare");
        compareVehicleButton3 = new JButton("compare");
        compareVehicleButton1.addActionListener(this);
        compareVehicleButton2.addActionListener(this);
        compareVehicleButton3.addActionListener(this);

        vehiclesButton = new JPanel();
        vehiclesButton.setLayout(new GridLayout(1, 0));
        vehiclesButton.add(compareVehicleButton3);
        vehiclesButton.add(vehicle1);
        vehiclesButton.add(compareVehicleButton2);
        vehiclesButton.add(vehicle2);
        vehiclesButton.add(compareVehicleButton1);
        vehiclesButton.add(vehicle3);

        vehiclesPane = new JPanel();
        vehiclesPane.setLayout(new BorderLayout());
        vehiclesPane.add(vehiclesName, BorderLayout.NORTH);
        vehiclesPane.add(vehiclesImage, BorderLayout.CENTER);
        vehiclesPane.add(vehiclesButton, BorderLayout.SOUTH);

        // Adding devices name
        devicesName = new JPanel();
        devicesName.setLayout(new GridLayout(1, 0));
        for (int i = 0; i < MAX_ITEM_DISPLAYED; i++) {
            String dN = DBConnection.getTDeviceName().get(i);
            devicesName.add(new JLabel(dN), SwingConstants.CENTER);
        }
        // devicesName.add( new JLabel( "item name here" ), SwingConstants.CENTER );

        // Adding devices image
        devicesImage = new JPanel();
        devicesImage.setLayout(new GridLayout(1, 0));
        // first devices image
        JLabel d1Lab = new JLabel();
        ImageIcon d1imageIcon = new ImageIcon("nintendo.jpg");
        Image d1image = d1imageIcon.getImage();
        Image d1newimg = d1image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        d1imageIcon = new ImageIcon(d1newimg);
        d1Lab.setIcon(d1imageIcon);
        d1Lab.setHorizontalAlignment(SwingConstants.CENTER);
        d1Lab.setVerticalAlignment(SwingConstants.CENTER);
        devicesImage.add(d1Lab, SwingConstants.CENTER);
        // second devices image
        JLabel d2Lab = new JLabel();
        ImageIcon d2imageIcon = new ImageIcon("casio.jpeg");
        Image d2image = d2imageIcon.getImage();
        Image d2newimg = d2image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        d2imageIcon = new ImageIcon(d2newimg);
        d2Lab.setIcon(d2imageIcon);
        d2Lab.setHorizontalAlignment(SwingConstants.CENTER);
        d2Lab.setVerticalAlignment(SwingConstants.CENTER);
        devicesImage.add(d2Lab, SwingConstants.CENTER);
        // third devices image
        JLabel d3Lab = new JLabel();
        ImageIcon d3imageIcon = new ImageIcon("airpods.jpeg");
        Image d3image = d3imageIcon.getImage();
        Image d3newimg = d3image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        d3imageIcon = new ImageIcon(d3newimg);
        d3Lab.setIcon(d3imageIcon);
        d3Lab.setHorizontalAlignment(SwingConstants.CENTER);
        d3Lab.setVerticalAlignment(SwingConstants.CENTER);
        devicesImage.add(d3Lab, SwingConstants.CENTER);
        // devicesImage.add( new JLabel( exampleImage ) );

        // Adding devices' price
        String dP = DBConnection.getPriceOfTDevice(DBConnection.getTDeviceName().get(2));
        device1 = new JButton(dP + " " + TL);
        String dP2 = DBConnection.getPriceOfTDevice(DBConnection.getTDeviceName().get(1));
        device2 = new JButton(dP2 + " " + TL);
        String dP3 = DBConnection.getPriceOfTDevice(DBConnection.getTDeviceName().get(0));
        device3 = new JButton(dP3 + " " + TL);
        // device3 = new JButton( "add price here" );

        device1.addActionListener(this);
        device2.addActionListener(this);
        device3.addActionListener(this);

        compareTechButton1 = new JButton("compare");
        compareTechButton2 = new JButton("compare");
        compareTechButton3 = new JButton("compare");
        compareTechButton1.addActionListener(this);
        compareTechButton2.addActionListener(this);
        compareTechButton3.addActionListener(this);

        devicesButton = new JPanel();
        devicesButton.setLayout(new GridLayout(1, 0));
        devicesButton.add(compareTechButton3);
        devicesButton.add(device1);
        devicesButton.add(compareTechButton2);
        devicesButton.add(device2);
        devicesButton.add(compareTechButton1);
        devicesButton.add(device3);

        devicesPane = new JPanel();
        devicesPane.setLayout(new BorderLayout());
        devicesPane.add(devicesName, BorderLayout.NORTH);
        devicesPane.add(devicesImage, BorderLayout.CENTER);
        devicesPane.add(devicesButton, BorderLayout.SOUTH);

        // Adding clothes' name
        clothesName = new JPanel();
        clothesName.setLayout(new GridLayout(1, 0));
        for (int i = 0; i < MAX_ITEM_DISPLAYED; i++) {
            String cN = DBConnection.getClothName().get(i);
            clothesName.add(new JLabel(cN), SwingConstants.CENTER);
        }
        // clothesName.add( new JLabel( "item name here" ), SwingConstants.CENTER );

        // Adding clothes' image
        clothesImage = new JPanel();
        clothesImage.setLayout(new GridLayout(1, 0));
        // first clothes image
        JLabel c1Lab = new JLabel();
        ImageIcon c1imageIcon = new ImageIcon("dress.png");
        Image c1image = c1imageIcon.getImage();
        Image c1newimg = c1image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        c1imageIcon = new ImageIcon(c1newimg);
        c1Lab.setIcon(c1imageIcon);
        c1Lab.setHorizontalAlignment(SwingConstants.CENTER);
        c1Lab.setVerticalAlignment(SwingConstants.CENTER);
        clothesImage.add(c1Lab, SwingConstants.CENTER);
        // second clothes image
        JLabel c2Lab = new JLabel();
        ImageIcon c2imageIcon = new ImageIcon("under.jpg");
        Image c2image = c2imageIcon.getImage();
        Image c2newimg = c2image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        c2imageIcon = new ImageIcon(c2newimg);
        c2Lab.setIcon(c2imageIcon);
        c2Lab.setHorizontalAlignment(SwingConstants.CENTER);
        c2Lab.setVerticalAlignment(SwingConstants.CENTER);
        clothesImage.add(c2Lab, SwingConstants.CENTER);
        // third clothes image
        JLabel c3Lab = new JLabel();
        ImageIcon c3imageIcon = new ImageIcon("converse.jpg");
        Image c3image = c3imageIcon.getImage();
        Image c3newimg = c3image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
        c3imageIcon = new ImageIcon(c3newimg);
        c3Lab.setIcon(c3imageIcon);
        c3Lab.setHorizontalAlignment(SwingConstants.CENTER);
        c3Lab.setVerticalAlignment(SwingConstants.CENTER);
        clothesImage.add(c3Lab, SwingConstants.CENTER);
        // clothesImage.add( new JLabel( exampleImage ) );

        // Adding clothes' price
        String cP = DBConnection.getPriceOfCloth(DBConnection.getClothName().get(2));
        clothe1 = new JButton(cP + " " + TL);
        String cP2 = DBConnection.getPriceOfCloth(DBConnection.getClothName().get(1));
        clothe2 = new JButton(cP2 + " " + TL);
        String cP3 = DBConnection.getPriceOfCloth(DBConnection.getClothName().get(0));
        clothe3 = new JButton(cP3 + " " + TL);
        // clothe3 = new JButton( "add prize " );

        clothe1.addActionListener(this);
        clothe2.addActionListener(this);
        clothe3.addActionListener(this);

        compareClothesButton1 = new JButton("compare");
        compareClothesButton2 = new JButton("compare");
        compareClothesButton3 = new JButton("compare");
        compareClothesButton1.addActionListener(this);
        compareClothesButton2.addActionListener(this);
        compareClothesButton3.addActionListener(this);

        clothesButton = new JPanel();
        clothesButton.setLayout(new GridLayout(1, 0));
        clothesButton.add(compareClothesButton3);
        clothesButton.add(clothe1);
        clothesButton.add(compareClothesButton2);
        clothesButton.add(clothe2);
        clothesButton.add(compareClothesButton1);
        clothesButton.add(clothe3);

        clothesPane = new JPanel();
        clothesPane.setLayout(new BorderLayout());
        clothesPane.add(clothesName, BorderLayout.NORTH);
        clothesPane.add(clothesImage, BorderLayout.CENTER);
        clothesPane.add(clothesButton, BorderLayout.SOUTH);

        centerPane = new JPanel();
        centerPane.setLayout(new GridLayout(4, 1));
        centerPane.add(booksPane);
        centerPane.add(vehiclesPane);
        centerPane.add(devicesPane);
        centerPane.add(clothesPane);

        cp = frame.getContentPane();

        cp.add(topPane, BorderLayout.NORTH);
        cp.add(centerPane, BorderLayout.CENTER);
        frame.setVisible(true);

        bookItem1 = new Book(35, "New", 5, "black", "1984", "book", "novel", "1984", "George Orwell", "YKY");
        bookItem2 = new Book(40, "Second Hand", 1, "Blindness", "black", "book", "novel", "Blindness", "Jose Saramago",
                "Nadir Kitap");

        veh1 = new Vehicles(1380000, "Second Hand", 1, "black", "Tesla Model X", "Tesla", "P90D", 772);
        veh2 = new Vehicles(480000, "Second Hand", 1, "red", "Mini Cooper Electric", "Mini", "SE Signature", 184);

        dev1 = new TechnologicalDevices(3900, "Only used once", 1, "blue and gray joy-cons", "Nintendo Switch",
                "Nintendo", "console", "6.2-inch, 720p LCD screen", 1);
        dev2 = new TechnologicalDevices(290, "Second Hand", 1, "gray", "Casio Watch", "Casio", "watch", "33 * 82 mm",
                1);

        cloth1 = new Clothes(89, "second hand", 1, "blue", "Dress", "Bershka", "coton", 1);
        cloth2 = new Clothes(110, "New", 2, "black", "Sweatshirt", "Under Armour", "coton", 2);

        counter = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkoutButton) {
            cp.remove(centerPane);
            cp.add(checkoutPanel, BorderLayout.CENTER);
            frame.repaint();
            frame.revalidate();
        } else if (e.getSource() == profileButton) {
            cp.remove(centerPane);
            cp.add(userProfilePanel, BorderLayout.CENTER);
            frame.repaint();
            frame.revalidate();
        } else if (e.getSource() == book3) {
            Book booook1 = new Book(35, "New", 5, "", "1984", "", "", "", "George Orwell", "YKY");
            frame.setVisible(false);
            new ProductPage(booook1, user);
        } else if (e.getSource() == book2) {
            Book booook1 = new Book(20, "Second Hand", 1, "", "Blindness", "", "", "", "Jose Saramago", "Nadir Kitap");
            frame.setVisible(false);
            new ProductPage(booook1, user);

        } else if (e.getSource() == book1) {
            Book booook1 = new Book(40, "New", 3, "", "Lord Of The Flies", "", "", "", "William Golding",
                    "Penguin Books");
            frame.setVisible(false);
            new ProductPage(booook1, user);

        } else if (e.getSource() == vehicle3) {
            Vehicles vehiiicle1 = new Vehicles(1380000, "Second Hand", 1, "black", "Tesla Model X", "Tesla", "P90D",
                    772);
            frame.setVisible(false);
            new ProductPage(vehiiicle1, user);

        } else if (e.getSource() == vehicle2) {
            Vehicles vehiiicle1 = new Vehicles(480000, "Second Hand", 1, "red", "Mini Cooper Electric", "Mini",
                    "SE Signature", 184);
            frame.setVisible(false);
            new ProductPage(vehiiicle1, user);
        } else if (e.getSource() == vehicle1) {
            Vehicles vehiiicle1 = new Vehicles(250000, "Second Hand", 1, "blue", "Golf", "Volkswagen",
                    "1.6TDI BlueMotion Highline", 115);
            frame.setVisible(false);
            new ProductPage(vehiiicle1, user);
        } else if (e.getSource() == device3) {
            TechnologicalDevices deviiiiiiiice1 = new TechnologicalDevices(3900, "Only used once", 1,
                    "Blue and red joy-cons", "Nintendo Switch", "Nintendo", "console", "6.2-inch, 720p LCD screen", 1);
            frame.setVisible(false);
            new ProductPage(deviiiiiiiice1, user);

        } else if (e.getSource() == device2) {
            TechnologicalDevices deviiiiiiiice1 = new TechnologicalDevices(290, "Second Hand", 1, "gray", "Casio Watch",
                    "Casio", "watch", "33*82 mm", 1);
            frame.setVisible(false);
            new ProductPage(deviiiiiiiice1, user);
        } else if (e.getSource() == device1) {
            TechnologicalDevices deviiiiiiiice1 = new TechnologicalDevices(130, "New", 2, "white", "AirPods", "Apple",
                    "headphone", "TWS, 5.0 Bluetooth", 1);
            frame.setVisible(false);
            new ProductPage(deviiiiiiiice1, user);
        } else if (e.getSource() == clothe3) {
            Clothes cloothes1 = new Clothes(89, "Second Hand", 1, "Blue", "Dress", "Bershka", "Coton", 1);
            frame.setVisible(false);
            new ProductPage(cloothes1, user);
        } else if (e.getSource() == clothe2) {
            Clothes cloothes1 = new Clothes(110, "New", 2, "Black", "Dress", "Under Armour", "Coton", 2);
            frame.setVisible(false);
            new ProductPage(cloothes1, user);

        } else if (e.getSource() == clothe1) {
            Clothes cloothes1 = new Clothes(230, "Second Hand", 1, "Red", "Dress", "Converse", "Fabric", 8);
            frame.setVisible(false);
            new ProductPage(cloothes1, user);
        }

        else if (e.getSource() == compareBookButton1 || e.getSource() == compareBookButton2
                || e.getSource() == compareBookButton3) {
            counter++;
            if (e.getSource() == compareBookButton1 && counter == 1) {
                bookItem1 = new Book(35, "New", 5, "black", "1984", "book", "novel", "1984", "George Orwell", "YKY");
                compareBookButton1.setEnabled(false);
            } else if (e.getSource() == compareBookButton2 && counter == 1) {
                bookItem1 = new Book(40, "Second Hand", 1, "Blindness", "black", "book", "novel", "Blindness",
                        "Jose Saramago", "Nadir Kitap");
                compareBookButton2.setEnabled(false);
            } else if (e.getSource() == compareBookButton3 && counter == 1) {
                bookItem1 = new Book(40, "New", 3, "black", "Lord Of The Flies", "book", "novel", "Lord Of The Flies",
                        "William Golding", "Penguin Books");
                compareBookButton3.setEnabled(false);
            } else if (e.getSource() == compareBookButton1 && counter == 2) {
                counter = 0;
                compareBookButton2.setEnabled(true);
                compareBookButton3.setEnabled(true);
                bookItem2 = new Book(35, "New", 5, "black", "1984", "book", "novel", "1984", "George Orwell", "YKY");
                comparePanel = new CompareItem(bookItem1, bookItem2);
                cp.remove(centerPane);
                cp.add(comparePanel, BorderLayout.CENTER);
                frame.repaint();
                frame.revalidate();
            } else if (e.getSource() == compareBookButton2 && counter == 2) {
                counter = 0;
                compareBookButton1.setEnabled(true);
                compareBookButton3.setEnabled(true);
                bookItem2 = new Book(40, "Second Hand", 1, "Blindness", "black", "book", "novel", "Blindness",
                        "Jose Saramago", "Nadir Kitap");
                comparePanel = new CompareItem(bookItem1, bookItem2);
                cp.remove(centerPane);
                cp.add(comparePanel, BorderLayout.CENTER);
                frame.repaint();
                frame.revalidate();
            } else if (e.getSource() == compareBookButton3 && counter == 2) {
                counter = 0;
                compareBookButton1.setEnabled(true);
                compareBookButton2.setEnabled(true);
                bookItem2 = new Book(40, "New", 3, "black", "Lord Of The Flies", "book", "novel", "Lord Of The Flies",
                        "William Golding", "Penguin Books");
                comparePanel = new CompareItem(bookItem1, bookItem2);
                cp.remove(centerPane);
                cp.add(comparePanel, BorderLayout.CENTER);
                frame.repaint();
                frame.revalidate();
            }

        }

        else if (e.getSource() == compareVehicleButton1 || e.getSource() == compareVehicleButton2
                || e.getSource() == compareVehicleButton3) {
            counter++;
            if (e.getSource() == compareVehicleButton1 && counter == 1) {
                veh1 = new Vehicles(1380000, "Second Hand", 1, "black", "Tesla Model X", "Tesla", "P90D", 772);
                compareVehicleButton1.setEnabled(false);
            } else if (e.getSource() == compareVehicleButton2 && counter == 1) {
                veh1 = new Vehicles(480000, "Second Hand", 1, "red", "Mini Cooper Electric", "Mini", "SE Signature",
                        184);
                compareVehicleButton2.setEnabled(false);
            } else if (e.getSource() == compareVehicleButton3 && counter == 1) {
                veh2 = new Vehicles(250000, "Second Hand", 1, "blue", "Golf", "Volkwagen",
                        "1.6 TDI BlueMotion Highline", 115);
                compareVehicleButton3.setEnabled(false);
            } else if (e.getSource() == compareVehicleButton1 && counter == 2) {
                counter = 0;
                compareVehicleButton2.setEnabled(true);
                compareVehicleButton3.setEnabled(true);
                veh2 = new Vehicles(1380000, "Second Hand", 1, "black", "Tesla Model X", "Tesla", "P90D", 772);
                comparePanel = new CompareItem(veh1, veh2);
                cp.remove(centerPane);
                cp.add(comparePanel, BorderLayout.CENTER);
                frame.repaint();
                frame.revalidate();
            } else if (e.getSource() == compareVehicleButton2 && counter == 2) {
                counter = 0;
                compareVehicleButton1.setEnabled(true);
                compareVehicleButton3.setEnabled(true);
                veh2 = new Vehicles(480000, "Second Hand", 1, "red", "Mini Cooper Electric", "Mini", "SE Signature",
                        184);
                comparePanel = new CompareItem(veh1, veh2);
                cp.remove(centerPane);
                cp.add(comparePanel, BorderLayout.CENTER);
                frame.repaint();
                frame.revalidate();
            } else if (e.getSource() == compareVehicleButton3 && counter == 2) {
                counter = 0;
                compareVehicleButton1.setEnabled(true);
                compareVehicleButton2.setEnabled(true);
                veh2 = new Vehicles(250000, "Second Hand", 1, "blue", "Golf", "Volkwagen",
                        "1.6 TDI BlueMotion Highline", 115);
                comparePanel = new CompareItem(veh1, veh2);
                cp.remove(centerPane);
                cp.add(comparePanel, BorderLayout.CENTER);
                frame.repaint();
                frame.revalidate();
            }
        }

        else if (e.getSource() == compareTechButton1 || e.getSource() == compareTechButton2
                || e.getSource() == compareTechButton3) {
            counter++;
            if (e.getSource() == compareTechButton1 && counter == 1) {
                dev1 = new TechnologicalDevices(3900, "Only used once", 1, "blue and gray joy-cons", "Nintendo Switch",
                        "Nintendo", "console", "6.2-inch, 720p LCD screen", 1);
                compareTechButton1.setEnabled(false);
            } else if (e.getSource() == compareTechButton2 && counter == 1) {
                dev1 = new TechnologicalDevices(290, "Second Hand", 1, "gray", "Casio Watch", "Casio", "watch",
                        "33 * 82 mm", 1);
                compareTechButton2.setEnabled(false);
            } else if (e.getSource() == compareTechButton3 && counter == 1) {
                dev1 = new TechnologicalDevices(1300, "New", 1, "white", "AirPods", "Apple", "head phone",
                        "TWS, 5.0 bluetooth", 1);
                compareTechButton3.setEnabled(false);
            } else if (e.getSource() == compareTechButton1 && counter == 2) {
                counter = 0;
                compareTechButton2.setEnabled(true);
                compareTechButton3.setEnabled(true);
                dev2 = new TechnologicalDevices(3900, "Only used once", 1, "blue and gray joy-cons", "Nintendo Switch",
                        "Nintendo", "console", "6.2-inch, 720p LCD screen", 1);
                comparePanel = new CompareItem(dev1, dev2);
                cp.remove(centerPane);
                cp.add(comparePanel, BorderLayout.CENTER);
                frame.repaint();
                frame.revalidate();
            } else if (e.getSource() == compareTechButton2 && counter == 2) {
                counter = 0;
                compareTechButton1.setEnabled(true);
                compareTechButton3.setEnabled(true);
                dev2 = new TechnologicalDevices(290, "Second Hand", 1, "gray", "Casio Watch", "Casio", "watch",
                        "33 * 82 mm", 1);
                comparePanel = new CompareItem(dev1, dev2);
                cp.remove(centerPane);
                cp.add(comparePanel, BorderLayout.CENTER);
                frame.repaint();
                frame.revalidate();
            } else if (e.getSource() == compareTechButton3 && counter == 2) {
                counter = 0;
                compareTechButton1.setEnabled(true);
                compareTechButton2.setEnabled(true);
                dev2 = new TechnologicalDevices(1300, "New", 1, "white", "AirPods", "Apple", "head phone",
                        "TWS, 5.0 bluetooth", 1);
                comparePanel = new CompareItem(dev1, dev2);
                cp.remove(centerPane);
                cp.add(comparePanel, BorderLayout.CENTER);
                frame.repaint();
                frame.revalidate();
            }
        }

        else if (e.getSource() == compareClothesButton1 || e.getSource() == compareClothesButton2
                || e.getSource() == compareClothesButton3) {
            counter++;
            if (e.getSource() == compareClothesButton1 && counter == 1) {
                cloth1 = new Clothes(89, "second hand", 1, "blue", "Dress", "Bershka", "coton", 1);
                compareClothesButton1.setEnabled(false);
            } else if (e.getSource() == compareClothesButton2 && counter == 1) {
                cloth1 = new Clothes(110, "New", 2, "black", "Sweatshirt", "Under Armour", "coton", 2);
                compareClothesButton2.setEnabled(false);
            } else if (e.getSource() == compareClothesButton3 && counter == 1) {
                cloth1 = new Clothes(230, "Second Hand", 1, "red", "Sneakers", "Converse", "fabric", 8);
                compareClothesButton3.setEnabled(false);
            } else if (e.getSource() == compareClothesButton1 && counter == 2) {
                counter = 0;
                compareClothesButton2.setEnabled(true);
                compareClothesButton3.setEnabled(true);
                cloth2 = new Clothes(89, "second hand", 1, "blue", "Dress", "Bershka", "coton", 1);
                comparePanel = new CompareItem(cloth1, cloth2);
                cp.remove(centerPane);
                cp.add(comparePanel, BorderLayout.CENTER);
                frame.repaint();
                frame.revalidate();
            } else if (e.getSource() == compareClothesButton2 && counter == 2) {
                counter = 0;
                compareClothesButton1.setEnabled(true);
                compareClothesButton3.setEnabled(true);
                cloth2 = new Clothes(110, "New", 2, "black", "Sweatshirt", "Under Armour", "coton", 2);
                comparePanel = new CompareItem(cloth1, cloth2);
                cp.remove(centerPane);
                cp.add(comparePanel, BorderLayout.CENTER);
                frame.repaint();
                frame.revalidate();
            } else if (e.getSource() == compareClothesButton3 && counter == 2) {
                counter = 0;
                compareClothesButton1.setEnabled(true);
                compareClothesButton2.setEnabled(true);
                cloth2 = new Clothes(230, "Second Hand", 1, "red", "Sneakers", "Converse", "fabric", 8);
                comparePanel = new CompareItem(cloth1, cloth2);
                cp.remove(centerPane);
                cp.add(comparePanel, BorderLayout.CENTER);
                frame.repaint();
                frame.revalidate();
            }
        }

        else if (e.getSource() == searchField) {
            String searchedItem = searchField.getText();

            Container cp;
            cp = frame.getContentPane();
            if (searchPane != null) {
                cp.remove(searchPane);
            }
            searchPane = new JPanel();

            if (cath.getSelectedIndex() == 0) {
                // books cathegory
                if (DBConnection.searchBook(searchedItem).get(0).equals(searchedItem)) {

                    JPanel booksSearchPane = new JPanel();

                    searchPane.setLayout(new GridLayout(4, 1));
                    booksSearchPane.setLayout(new BorderLayout());

                    String imageAdress = DBConnection.getImageAdressOfItem("books", searchedItem);

                    JPanel bN = new JPanel();
                    bN.add(new JLabel(DBConnection.searchBook(searchedItem).get(0)));

                    JPanel bB = new JPanel();
                    bB.add(new JLabel(DBConnection.searchBook(searchedItem).get(1) + " " + TL));

                    JPanel bI = new JPanel();
                    JLabel bLab = new JLabel();
                    ImageIcon bImageIcon = new ImageIcon(imageAdress);
                    Image bImage = bImageIcon.getImage();
                    Image bNewimg = bImage.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
                    bImageIcon = new ImageIcon(bNewimg);
                    bLab.setIcon(bImageIcon);
                    bLab.setHorizontalAlignment(SwingConstants.CENTER);
                    bLab.setVerticalAlignment(SwingConstants.CENTER);
                    bI.add(bLab, SwingConstants.CENTER);

                    booksSearchPane.add(bN, BorderLayout.NORTH);
                    booksSearchPane.add(bI, BorderLayout.CENTER);
                    booksSearchPane.add(bB, BorderLayout.SOUTH);

                    searchPane.add(booksSearchPane);
                    centerPane.setVisible(false);
                    searchPane.setVisible(true);

                    cp.add(searchPane, BorderLayout.CENTER);
                    cp.setVisible(false);
                    cp.setVisible(true);
                }
                // else if( searchedItem.equalsIgnoreCase( "all"))
                // {
                // Show all
                // }
                else {
                    JOptionPane.showMessageDialog(null, "No Such Book!");
                }
            }
            if (cath.getSelectedIndex() == 1) {
                // Technological Devices cathegory
                if (DBConnection.searchDevice(searchedItem).get(0).equals(searchedItem)) {
                    JPanel deviceSearchPane = new JPanel();

                    searchPane.setLayout(new GridLayout(4, 1));
                    deviceSearchPane.setLayout(new BorderLayout());

                    String imageAdress = DBConnection.getImageAdressOfItem("technological_devices", searchedItem);

                    JPanel dN = new JPanel();
                    dN.add(new JLabel(DBConnection.searchDevice(searchedItem).get(0)));

                    JPanel dB = new JPanel();
                    dB.add(new JLabel(DBConnection.searchDevice(searchedItem).get(1) + " " + TL));

                    JPanel dI = new JPanel();
                    JLabel dLab = new JLabel();
                    ImageIcon dImageIcon = new ImageIcon(imageAdress);
                    Image dImage = dImageIcon.getImage();
                    Image dNewimg = dImage.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
                    dImageIcon = new ImageIcon(dNewimg);
                    dLab.setIcon(dImageIcon);
                    dLab.setHorizontalAlignment(SwingConstants.CENTER);
                    dLab.setVerticalAlignment(SwingConstants.CENTER);
                    // bLab.setPreferredSize( new Dimension( 120,120));
                    dI.add(dLab, SwingConstants.CENTER);

                    deviceSearchPane.add(dN, BorderLayout.NORTH);
                    deviceSearchPane.add(dI, BorderLayout.CENTER);
                    deviceSearchPane.add(dB, BorderLayout.SOUTH);

                    if (searchPane != null) {
                        searchPane.removeAll();
                    }
                    searchPane.add(deviceSearchPane);
                    centerPane.setVisible(false);
                    searchPane.setVisible(true);

                    cp.add(searchPane, BorderLayout.CENTER);
                    cp.setVisible(false);
                    cp.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No Such Technological Device!");
                }
            } else if (cath.getSelectedIndex() == 2) {
                // Vehicles cathegory
                if (DBConnection.searchVehicle(searchedItem).get(0).equals(searchedItem)) {
                    JPanel vehicleSearchPane = new JPanel();

                    searchPane.setLayout(new GridLayout(4, 1));
                    vehicleSearchPane.setLayout(new BorderLayout());

                    String imageAdress = DBConnection.getImageAdressOfItem("vehicles", searchedItem);

                    JPanel vN = new JPanel();
                    vN.add(new JLabel(DBConnection.searchVehicle(searchedItem).get(0)));

                    JPanel vB = new JPanel();
                    vB.add(new JLabel(DBConnection.searchVehicle(searchedItem).get(1) + " " + TL));

                    JPanel vI = new JPanel();
                    JLabel vLab = new JLabel();
                    ImageIcon vImageIcon = new ImageIcon(imageAdress);
                    Image vImage = vImageIcon.getImage();
                    Image vNewimg = vImage.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
                    vImageIcon = new ImageIcon(vNewimg);
                    vLab.setIcon(vImageIcon);
                    vLab.setHorizontalAlignment(SwingConstants.CENTER);
                    vLab.setVerticalAlignment(SwingConstants.CENTER);
                    // bLab.setPreferredSize( new Dimension( 120,120));
                    vI.add(vLab, SwingConstants.CENTER);

                    vehicleSearchPane.add(vN, BorderLayout.NORTH);
                    vehicleSearchPane.add(vI, BorderLayout.CENTER);
                    vehicleSearchPane.add(vB, BorderLayout.SOUTH);

                    if (searchPane != null) {
                        searchPane.removeAll();
                    }
                    searchPane.add(vehicleSearchPane);
                    centerPane.setVisible(false);
                    searchPane.setVisible(true);

                    cp.add(searchPane, BorderLayout.CENTER);
                    cp.setVisible(false);
                    cp.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No Such Vehicle!");
                }
            } else if (cath.getSelectedIndex() == 3) {
                // Clothes cathegory
                if (DBConnection.searchCloth(searchedItem).get(0).equals(searchedItem)) {
                    JPanel clothesSearchPane = new JPanel();

                    searchPane.setLayout(new GridLayout(4, 1));
                    clothesSearchPane.setLayout(new BorderLayout());

                    String imageAdress = DBConnection.getImageAdressOfItem("clothes", searchedItem);

                    JPanel cN = new JPanel();
                    cN.add(new JLabel(DBConnection.searchCloth(searchedItem).get(0)));

                    JPanel cB = new JPanel();
                    cB.add(new JLabel(DBConnection.searchCloth(searchedItem).get(1) + " " + TL));

                    JPanel cI = new JPanel();
                    JLabel cLab = new JLabel();
                    ImageIcon cImageIcon = new ImageIcon(imageAdress);
                    Image cImage = cImageIcon.getImage();
                    Image cNewimg = cImage.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
                    cImageIcon = new ImageIcon(cNewimg);
                    cLab.setIcon(cImageIcon);
                    cLab.setHorizontalAlignment(SwingConstants.CENTER);
                    cLab.setVerticalAlignment(SwingConstants.CENTER);
                    // bLab.setPreferredSize( new Dimension( 120,120));
                    cI.add(cLab, SwingConstants.CENTER);

                    clothesSearchPane.add(cN, BorderLayout.NORTH);
                    clothesSearchPane.add(cI, BorderLayout.CENTER);
                    clothesSearchPane.add(cB, BorderLayout.SOUTH);

                    if (searchPane != null) {
                        searchPane.removeAll();
                    }
                    searchPane.add(clothesSearchPane);
                    centerPane.setVisible(false);
                    searchPane.setVisible(true);

                    cp.add(searchPane, BorderLayout.CENTER);
                    cp.setVisible(false);
                    cp.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No Such Cloth!");
                }
            }
            if (cath.getSelectedIndex() == 4) {
                // Main page
                searchPane.setVisible(false);
                centerPane.remove(searchPane);
                centerPane.setVisible(true);
            }
        }

    }

    class Checkout extends JPanel {
        private JButton buyButton;
        private int total;

        Checkout(User user) {
            this.setLayout(new GridLayout(user.getItemList().size() + 1, 2));
            for (int i = 0; i < user.getItemList().size(); i++) {
                this.add(new JLabel(user.getItemList().get(i).getName()));
                this.add(new JLabel(String.valueOf(user.getItemList().get(i).getPrize())));
            }

            total = user.calculateTotal();
            this.add(new JLabel("Total: " + total));

            buyButton = new JButton("Buy Items");
            this.add(buyButton);
            buyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    user.clearList();
                    cp.remove(checkoutPanel);
                    cp.add(centerPane, BorderLayout.CENTER);
                    frame.repaint();
                    frame.revalidate();
                }
            });
        }
    }

    class UserProfile extends JPanel {
        private JButton button;

        UserProfile(User user) {
            this.setLayout(new GridLayout(0, 1));
            // this.add( new JLabel( "UserID: " + user.getUser().getUserID() ) );
            this.add(new JLabel("Username: " + user.getUser().getUserName()));
            this.add(new JLabel("Email: " + user.getUser().getEmail()));
            this.add(new JLabel("Name: " + user.getUser().getName()));
            this.add(new JLabel("Age: " + String.valueOf(user.getUser().getAge())));
            button = new JButton("Main Page");
            this.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cp.remove(userProfilePanel);
                    cp.add(centerPane, BorderLayout.CENTER);
                    frame.repaint();
                    frame.revalidate();
                }
            });
        }
    }

    class CompareItem extends JPanel {
        private JLabel warningMessage;
        private JTextField nameTextField1;
        private JTextField priceTextField1;
        private JTextField conditionTextField1;
        private JTextField quantityTextField1;
        private JTextField nameTextField2;
        private JTextField priceTextField2;
        private JTextField conditionTextField2;
        private JTextField quantityTextField2;
        private JButton mainButton;
        private Font newFont;

        CompareItem(Item item1, Item item2) {
            newFont = new Font("Serif", Font.PLAIN, 30);
            if (!(item1.getClass().equals(item2.getClass()))) {
                setLayout(new GridLayout(0, 1));

                warningMessage = new JLabel("Items need to be chosen from same cathegory for comparing");
                warningMessage.setFont(newFont);
                warningMessage.setSize(500, 25);
                add(warningMessage);
            } else {
                setLayout(new GridLayout(0, 4, 5, 5));

                if (item1 instanceof Book) {
                    JTextField authorTextField1;
                    JTextField authorTextField2;
                    JTextField genreTextField1;
                    JTextField genreTextField2;
                    JTextField publisherTextField1;
                    JTextField publisherTextField2;

                    Book book1 = (Book) item1;
                    Book book2 = (Book) item2;

                    nameTextField1 = new JTextField(20);
                    nameTextField2 = new JTextField(20);
                    nameTextField1.setText(book1.getTitle());
                    nameTextField2.setText(book2.getTitle());

                    authorTextField1 = new JTextField(20);
                    authorTextField2 = new JTextField(20);
                    authorTextField1.setText(book1.getAuthorsName());
                    authorTextField2.setText(book2.getAuthorsName());

                    genreTextField1 = new JTextField(20);
                    genreTextField2 = new JTextField(20);
                    genreTextField1.setText(book1.getGenre());
                    genreTextField2.setText(book2.getGenre());

                    publisherTextField1 = new JTextField(20);
                    publisherTextField2 = new JTextField(20);
                    publisherTextField1.setText(book1.getPublisher());
                    publisherTextField2.setText(book2.getPublisher());

                    add(new JLabel("Name: "));
                    add(nameTextField1);
                    add(new JLabel("Name: "));
                    add(nameTextField2);
                    add(new JLabel("Author: "));
                    add(authorTextField1);
                    add(new JLabel("Author: "));
                    add(authorTextField2);
                    add(new JLabel("Genre: "));
                    add(genreTextField1);
                    add(new JLabel("Genre: "));
                    add(genreTextField2);
                    add(new JLabel("Publisher: "));
                    add(publisherTextField1);
                    add(new JLabel("Publisher: "));
                    add(publisherTextField2);
                }

                else if (item1 instanceof Clothes) {
                    JTextField name1;
                    JTextField name2;
                    JTextField material1;
                    JTextField material2;
                    JTextField size1;
                    JTextField size2;

                    Clothes clothe1 = (Clothes) item1;
                    Clothes clothe2 = (Clothes) item2;

                    name1 = new JTextField(20);
                    name2 = new JTextField(20);
                    name1.setText(clothe1.getName());
                    name2.setText(clothe2.getName());

                    material1 = new JTextField(20);
                    material2 = new JTextField(20);
                    material1.setText(clothe1.getMaterial());
                    material2.setText(clothe2.getMaterial());

                    size1 = new JTextField(20);
                    size2 = new JTextField(20);
                    size1.setText("" + clothe1.getSize());
                    size2.setText("" + clothe2.getSize());

                    add(new JLabel("Clothe: "));
                    add(name1);
                    add(new JLabel("Clothe"));
                    add(name2);
                    add(new JLabel("Material: "));
                    add(material1);
                    add(new JLabel("Material: "));
                    add(material2);
                    add(new JLabel("Size: "));
                    add(size1);
                    add(new JLabel("Size: "));
                    add(size2);
                }

                else if (item1 instanceof TechnologicalDevices) {
                    JTextField name1;
                    JTextField name2;
                    JTextField deviceType1;
                    JTextField deviceType2;
                    JTextField hardware1;
                    JTextField hardware2;
                    JTextField size1;
                    JTextField size2;

                    TechnologicalDevices dev1 = (TechnologicalDevices) item1;
                    TechnologicalDevices dev2 = (TechnologicalDevices) item2;

                    name1 = new JTextField(20);
                    name2 = new JTextField(20);
                    name1.setText(dev1.getName());
                    name2.setText(dev2.getName());

                    deviceType1 = new JTextField(20);
                    deviceType2 = new JTextField(20);
                    deviceType1.setText(dev1.getElectronicType());
                    deviceType2.setText(dev2.getElectronicType());

                    hardware1 = new JTextField(20);
                    hardware2 = new JTextField(20);
                    hardware1.setText(dev1.getHardWareDetails());
                    hardware2.setText(dev2.getHardWareDetails());

                    size1 = new JTextField(20);
                    size2 = new JTextField(20);
                    size1.setText("" + dev1.getSize());
                    size2.setText("" + dev2.getSize());

                    add(new JLabel("Device Name: "));
                    add(name1);
                    add(new JLabel("Device Name: "));
                    add(name2);
                    add(new JLabel("Device Type: "));
                    add(deviceType1);
                    add(new JLabel("Device Type: "));
                    add(deviceType2);
                    add(new JLabel("Hardware: "));
                    add(hardware1);
                    add(new JLabel("Hardware: "));
                    add(hardware2);
                    add(new JLabel("Size: "));
                    add(size1);
                    add(new JLabel("Size: "));
                    add(size2);
                }

                else {
                    JTextField name1;
                    JTextField name2;
                    JTextField horse1;
                    JTextField horse2;
                    JTextField model1;
                    JTextField model2;

                    Vehicles veh1 = (Vehicles) item1;
                    Vehicles veh2 = (Vehicles) item2;

                    name1 = new JTextField(20);
                    name2 = new JTextField(20);
                    name1.setText(veh1.getName());
                    name2.setText(veh2.getName());

                    horse1 = new JTextField(20);
                    horse2 = new JTextField(20);
                    horse1.setText("" + veh1.getHorsePower());
                    horse2.setText("" + veh2.getHorsePower());

                    model1 = new JTextField(20);
                    model2 = new JTextField(20);
                    model1.setText(veh1.getModel());
                    model2.setText(veh2.getModel());

                    add(new JLabel("Vehicle Name: "));
                    add(name1);
                    add(new JLabel("Vehicle Name: "));
                    add(name2);
                    add(new JLabel("Horse Power: "));
                    add(horse1);
                    add(new JLabel("Horse Power: "));
                    add(horse2);
                    add(new JLabel("Model: "));
                    add(model1);
                    add(new JLabel("Model: "));
                    add(model2);
                }

                quantityTextField1 = new JTextField(20);
                quantityTextField2 = new JTextField(20);
                quantityTextField1.setText("" + item1.getQuantity());
                quantityTextField2.setText("" + item2.getQuantity());

                priceTextField1 = new JTextField(20);
                priceTextField2 = new JTextField(20);
                priceTextField1.setText("" + item1.getPrize());
                priceTextField2.setText("" + item2.getPrize());

                conditionTextField1 = new JTextField(20);
                conditionTextField2 = new JTextField(20);
                conditionTextField1.setText(item1.getCondition());
                conditionTextField2.setText(item2.getCondition());

                add(new JLabel("Quantity: "));
                add(quantityTextField1);
                add(new JLabel("Quantity: "));
                add(quantityTextField2);
                add(new JLabel("Price: "));
                add(priceTextField1);
                add(new JLabel("Price: "));
                add(priceTextField2);
                add(new JLabel("Condition: "));
                add(conditionTextField1);
                add(new JLabel("Condition: "));
                add(conditionTextField2);
            }

            mainButton = new JButton("Main Page");
            this.add(mainButton);
            mainButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cp.remove(comparePanel);
                    cp.add(centerPane, BorderLayout.CENTER);
                    frame.repaint();
                    frame.revalidate();
                }
            });
        }
    }
}