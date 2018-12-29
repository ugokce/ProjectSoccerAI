/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arhrs.movement.sccr.BetterAIPack;

import math.geom2d.Vector2D;
import java.util.Random;

/**
 *
 * @author Uğurcan
 */
public class VectorCalculator {
    
    public static double CalculateMagnitude(Vector2D first, Vector2D second)
    {
        
        return Math.sqrt((first.minus(second).x()*first.minus(second).x())+(first.minus(second).y()*first.minus(second).y()));
    
        
    }
    
}
