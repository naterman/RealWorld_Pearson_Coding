/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FireBase;

import java.util.LinkedList;

/**
 *
 * @author Nathan Smith
 */
public class FullAssignmentData {
    
    Assignment assignment;
    LinkedList<Question> questions = new LinkedList<>();
    LinkedList<Trigger> triggers = new LinkedList<>();
    
    public FullAssignmentData(Assignment a)
    {
        this.assignment = a;
    }
    
}
