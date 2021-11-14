/**
 * Technological devices cathegory.
 * @author Gökberk Altıparmak
 * @version v1.0 19.04.2021
 */

public class TechnologicalDevices extends Item
{
    // Properteis 
    private String electronicType;
    private String hardWareDetails;
    private int size;
    
    // Constructor
    TechnologicalDevices( int prize, String condition, int quantity, String color, String name, String brand, String electronicType, String hardWareDetails, int size )
    {
        super( prize, condition, quantity, color, name, brand );
        this.electronicType = electronicType;
        this.hardWareDetails = hardWareDetails;
        this.size = size;
    }
    
    // Methods
    public String getElectronicType()
    {
        return electronicType;
    }
    
    public String getHardWareDetails()
    {
        return hardWareDetails;
    }
    
    public int getSize()
    {
        return size;
    }

	@Override
    public String compareForEachClass( Object other )
    {
        String comparison;
        TechnologicalDevices techObject;
        comparison = " Not Comparable ";
        if ( this.getClass().equals( other.getClass() ) )
        {
            comparison = "";
            techObject = ( TechnologicalDevices ) other;
            if ( this.getSize() > techObject.getSize() )
                comparison += this.getName() + " " + this.getSize() + " > " + techObject.getName() + " " + techObject.getSize() + "\n";
            else if ( this.getSize() < techObject.getSize() )
                comparison += this.getName() + " " + this.getSize() + " < " + techObject.getName() + " " + techObject.getSize() + "\n";
            return super.compare( techObject ) + comparison;
        }
        return comparison;
	}
}
