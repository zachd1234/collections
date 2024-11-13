/**
 * Creates a database of ShowCharacters using a linked list.
 *
 * @author Mr. Murphy
 * @version November 2024
 */
public class CharacterDatabase
{
    public static MyRobustLinkedList buildListDatabase() {
        MyRobustLinkedList<ShowCharacter> list = new MyRobustLinkedList<ShowCharacter>();
        list.add(new ShowCharacter("Fred", "Flintstone", "The Flintstones", "Alan Reed"));
        list.add(new ShowCharacter("Wilma", "Flintstone", "The Flintstones", "Jean Vander Pyl"));  
        list.add(new ShowCharacter("Barney", "Rubble", "The Flintstones", "Mel Blanc"));  
        list.add(new ShowCharacter("Betty", "Rubble", "The Flintstones", "Bea Benaderet"));  
        list.add(new ShowCharacter("Rachel", "Green", "Friends", "Jennifer Aniston"));  
        list.add(new ShowCharacter("Ross", "Geller", "Friends", "David Schwimmer"));  
        list.add(new ShowCharacter("Monica", "Geller", "Friends", "Courteney Cox"));  
        list.add(new ShowCharacter("Chandler", "Bing", "Friends", "Matthew Perry"));  
        list.add(new ShowCharacter("Joey", "Tribbiani", "Friends", "Matt LeBlanc"));  
        list.add(new ShowCharacter("Phoebe", "Buffay", "Friends", "Lisa Kudrow"));
        return list;
    }
}