/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pearson;

/**
 *
 * @author Nathan Smith
 */
public class ClassInfo {
    String name;
    int courseID;
    
    public ClassInfo(String name, int id)
    {
        this.name = name;
        this.courseID = id;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setID(int id)
    {
        this.courseID = id;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getID()
    {
        return this.courseID;
    }
}
