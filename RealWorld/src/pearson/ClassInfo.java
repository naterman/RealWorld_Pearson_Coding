/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pearson;

import java.io.Serializable;

/**
 *
 * @author Nathan Smith
 */
public class ClassInfo implements Serializable {

    String name;
    int courseID;
    private static final long serialVersionUID = 3;

    /**
     *
     * @param name
     * @param id
     */
    public ClassInfo(String name, int id) {
        this.name = name;
        this.courseID = id;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param id
     */
    public void setID(int id) {
        this.courseID = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return
     */
    public int getID() {
        return this.courseID;
    }
}
