/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntities;

/**
 *
 * @author Ricardo
 */
public abstract class Entity {
    
    public int id;
    
    public int getId(){
        return id;
    }
    
    //SETS
     public void setId(int n){
         this.id = n;
    }
}
