/**
 * Vehicle cathegory.
 * @author Gökberk Altıparmak
 * @version v1.0 19.04.2021
 */

public class Vehicles extends Item
{
    // Properties
    private int horsePower;
    private String model;
    
    // Constructors
    Vehicles( int prize, String condition, int quantity, String color, String name, String brand, String model, int horsePower )
    {
        super( prize, condition, quantity, color, name, brand );
        this.horsePower = horsePower;
        this.model = model;
    }
    
    // Methods
    public int getHorsePower()
    {
        return horsePower;
    }
    
    public String getModel()
    {
        return model;
    }

	@Override
    public String compareForEachClass( Object other )
    {
        String comparison;
        Vehicles vehicleObject;
        comparison = " Not Comparable ";
        if ( this.getClass().equals( other.getClass() ) )
        {
            comparison = "";
            vehicleObject = ( Vehicles ) other;
            if ( this.getHorsePower() > vehicleObject.getHorsePower() )
                comparison += this.getName() + " " + this.getHorsePower() + " > " + vehicleObject.getName() + " " + vehicleObject.getHorsePower() + "\n";
            else if ( this.getHorsePower() < vehicleObject.getHorsePower() )
                comparison += this.getName() + " " + this.getHorsePower() + " < " + vehicleObject.getName() + " " + vehicleObject.getHorsePower() + "\n";
            return super.compare( vehicleObject ) + comparison;
        }
        return comparison;
	}
}
