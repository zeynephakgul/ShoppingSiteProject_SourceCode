import java.util.ArrayList;

/**
 * Creates items.
 * @author Gökberk Altıparmak
 * @version v1.0 19.04.2021
 */

public abstract class Item
{
    // Properties
    private int prize;
    private String condition;
    private int quantity;
    private String color;
    private String name;
    private String brand;
    
    // Constructor
    Item( int prize, String condition, int quantity, String color, String name, String brand )
    {
        this.prize = prize;
        this.condition = condition;
        this.quantity = quantity;
        this.color = color;
        this.name = name;
        this.brand = brand;
    }
    
    // Methods
    
    /**
     * Gets prize of item.
     * @return prize.
     */
    public int getPrize()
    {
        return prize;
    }
    
    /**
     * Gets condition of item.
     * @return condition.
     */
    public String getCondition()
    {
        return condition;
    }
    
    /**
     * Gets quantity of item.
     * @return quantity.
     */
    public int getQuantity()
    {
        return quantity;
    }
    
    /**
     * Gets color of item.
     * @return color.
     */
    public String getColor()
    {
        return color;
    }
    
    /**
     * Gets name of item.
     * @return name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Gets brand of item.
     * @return brand.
     */
    public String getBrand()
    {
        return brand;
    }
    
    /**
     * Compares common properties of two products.
     * @param anyObject to compare.
     * @return result of comparison.
     */
    public String compare( Object anyObject )
    {
        Item itemObject;
        String comparison;
        comparison = "";
        if ( this.getClass().equals( anyObject.getClass() ) )
        {
            itemObject = ( Item ) anyObject;
            if ( this.getPrize() > itemObject.getPrize() )
                comparison += this.getPrize() + " > " + itemObject.getPrize() + "\n";
            else if (  this.getPrize() < itemObject.getPrize() )
                comparison += this.getPrize() + " < " + itemObject.getPrize() + "\n";
            
            if ( this.getQuantity() > itemObject.getQuantity() )
                comparison += this.getQuantity() + " > " + itemObject.getQuantity() + "\n";
            else if ( this.getQuantity() < itemObject.getQuantity() )
                comparison += this.getQuantity() + " < " + itemObject.getQuantity() + "\n";
        }
        return comparison;
    }
    
    /**
     * Compares specific properties of two products.
     * @param object to compare.
     * @return result of comparison.
     */
    public abstract String compareForEachClass( Object object );
}