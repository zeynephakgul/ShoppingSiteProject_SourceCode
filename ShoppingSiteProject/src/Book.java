/**
 * Book cathegory.
 * @author Gökberk Altıparmak
 * @version v1.0 19.04.2021
 */

public class Book extends Item
{
    // Properties
    private String genre;
    private String title;
    private String authorsName;
    private String publisher;
    
    // Constructors
    Book( int prize, String condition, int quantity, String color, String name, String brand, String genre, String title, String authorsName, String publisher )
    {
        super( prize, condition, quantity, color, name, brand );
        this.genre = genre;
        this.title = title;
        this.authorsName = authorsName;
        this.publisher = publisher;
    }
    
    public String getGenre()
    {
        return genre;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getAuthorsName()
    {
        return authorsName;
    }
    
    public String getPublisher()
    {
        return publisher;
    }

	@Override
    public String compareForEachClass( Object object )
    {
        return super.toString();
	}
}
