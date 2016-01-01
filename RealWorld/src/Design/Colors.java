/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design;

import java.awt.Color;

/**
 *
 * @author Nathan Smith
 */
public enum Colors {

    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
// various colors in the pallete
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

    /**
     *
     */
        Pink(255, 175, 175),

    /**
     *
     */
    Green(159, 205, 20),

    /**
     *
     */
    Orange(213, 113, 13),

    /**
     *
     */
    Yellow(Color.yellow),

    /**
     *
     */
    Red(189, 67, 67),

    /**
     *
     */
    LightBlue(208, 223, 245),

    /**
     *
     */
    Blue(Color.blue),

    /**
     *
     */
    Black(0, 0, 0),

    /**
     *
     */
    White(255, 255, 255),

    /**
     *
     */
    Gray(Color.gray.getRed(), Color.gray.getGreen(), Color.gray.getBlue()),
    
    /**
     * 
     */
    BackgroundGray(233,236,241);

    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    // constructors
    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    /**
     * 
     * @param c 
     */
    Colors(Color c) {
        _myColor = c;
    }

    Colors(int r, int g, int b) {
        _myColor = new Color(r, g, b);
    }

    Colors(int r, int g, int b, int alpha) {
        _myColor = new Color(r, g, b, alpha);
    }

    Colors(float r, float g, float b, float alpha) {
        _myColor = new Color(r, g, b, alpha);
    }

  //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    // data
    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    private final Color _myColor;

  //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    // methods
    //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

    /**
     *
     * @param t
     * @return
     */
        public Color alpha(float t) {
        return new Color(_myColor.getRed(), _myColor.getGreen(), _myColor.getBlue(), (int) (t * 255f));
    }

    /**
     *
     * @param c
     * @param t
     * @return
     */
    public static Color alpha(Color c, float t) {
        return new Color(c.getRed(), c.getGreen(), c.getBlue(), (int) (t * 255f));
    }

    /**
     *
     * @return
     */
    public Color color() {
        return _myColor;
    }

    /**
     *
     * @param f
     * @return
     */
    public Color color(float f) {
        return alpha(f);
    }

        @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("r=")
                .append(_myColor.getRed())
                .append(", g=")
                .append(_myColor.getGreen())
                .append(", b=")
                .append(_myColor.getBlue())
                .append("\n");
        return sb.toString();
    }

    /**
     *
     * @return
     */
    public String toHexString() {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        sb.append(Integer.toHexString(_myColor.getRed()));
        sb.append(Integer.toHexString(_myColor.getGreen()));
        sb.append(Integer.toHexString(_myColor.getBlue()));
        return sb.toString();
    }

}
