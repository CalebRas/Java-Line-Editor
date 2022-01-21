/**
 * File: Paragraph.java
 * Author: Caleb Rasmussen
 * This file contains the implentation for the Paragraph class.
 */


import java.util.*;

/**
 * Paragraph hold lies of text associated with an index. 
 */
public class Paragraph {
    // Memeber Variables
    Map<Integer, String> paragraph = new HashMap<Integer, String>();

    /**
     * insert() inserts a line, made up of a index and string.
     */ 
    public void insert(int index, String line)
    {
        paragraph.put(index, line);
    }

    /**
     * remove() removes an index assciated with a given index.
     * @param index
     */
    public void remove(int index)
    {
        paragraph.remove(index);
    }
        
    /**
     * get() returns a line asscoiated with a given index.
     * @param index
     * @return
     */
    public String get(int index)
    {
        return paragraph.get(index);
    }

    /**
     * length() returns the number of lines in the Paragraph.
     * @return
     */
    public int length()
    {
        return paragraph.size();
    }
}
