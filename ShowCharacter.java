//345678901234567890123456789012345678901234567890123456789012345678901234567890012345678901234567890

/**
 * Represents a character in a show.
 *
 * @author Mr. Murphy
 * @version November 2024
 */
public class ShowCharacter implements Comparable<ShowCharacter>  {
    private String firstName;
    private String lastName;
    private String showTitle;
    private String actorName;
    
    /**
     * Constructs a ShowCharacter.
     * 
     * @param firstName character's first name
     * @param lastName character's last name
     * @param showTitle title of the show
     * @param actorName actor that played the character
     */
    public ShowCharacter(String firstName, String lastName, String showTitle, String actorName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.showTitle = showTitle;
        this.actorName = actorName;
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else {
            if (this.firstName.equals(((ShowCharacter) other).firstName) && 
                this.lastName.equals(((ShowCharacter) other).lastName)) {
                return true;            
            } else {
                return false;
            }
        }
    }
    
    /**
     * Returns a value <0 if this is less than other; returns zero if this is equal to other; 
     * returns a value >0 if this is greater than other comparing last name then first anem
     * 
     * @param ShowCharacter Object
     * @return Returns a value <0 if this is less than other; returns zero if this is equal to other; 
     * returns a value >0 if this is greater than other
     * @throws 
     */
    public int compareTo(ShowCharacter other) {
        //compare last name if tie. compare first name 
        if(other == null) {
            throw new NullPointerException();
        } else {
             if(this.lastName.compareTo(other.lastName) == 0) {
                return this.firstName.compareTo(other.firstName);
            } else { 
                return this.lastName.compareTo(other.lastName);
            }
        }  
    }
    
    /**
     * Return key associated with ShowCharacter object.
     * 
     * @return firstName~lastName String of key
     */
    public String getKey() {
        return firstName + "~" + lastName;
    }
    
    /**
     * Returns a string representing a ShowCharacter.
     * 
     * @return string representing a ShowCharacter
     */
    public String toString() {
        return firstName + " " + lastName + " in " + showTitle + ", played by " + actorName;
    }
}