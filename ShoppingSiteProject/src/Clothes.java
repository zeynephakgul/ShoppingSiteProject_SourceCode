
/**
 * Clothes cathegory.
 * @author Gökberk Altıparmak
 * @version v1.0 19.04.2021
 */

public class Clothes extends Item
{
    // Properties
    private String material;
    private int size;
    
    // Constructors
    Clothes( int prize, String condition, int quantity, String color, String name, String brand, String material, int size )
    {
        super( prize, condition, quantity, color, name, brand );
        this.material = material;
        this.size = size;
    }
    
    // Methods
    public String getMaterial()
    {
        return material;
    }
    
    public int getSize()
    {
        return size;
    }

	@Override
    public String compareForEachClass( Object other )
    {
        String comparison;
        Clothes clotheObject;
        comparison = " Not Comparable ";
        if ( this.getClass().equals( other.getClass() ) )
        {
            comparison = "";
            clotheObject = ( Clothes ) other;
            if ( this.getSize() > clotheObject.getSize() )
                comparison += this.getName() + " " + this.getSize() + " > " + clotheObject.getName() + " " + clotheObject.getSize() + "\n";
            else if ( this.getSize() < clotheObject.getSize() )
                comparison += this.getName() + " " + this.getSize() + " < " + clotheObject.getName() + " " + clotheObject.getSize() + "\n";
            return super.compare( clotheObject ) + comparison;
        }
        return comparison;
	}
}
