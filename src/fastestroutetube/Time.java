/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestroutetube;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author micael
 */

public class Time {
    
    Date timeSelected = new Date();
    SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
    
    public Time(){
        
    }
    
    public Date createTime(String time){
        try {
            return parser.parse(time);
        } catch (ParseException ex) {
            Logger.getLogger("Invalid format");
        }
        return null;
    }
    
    public Date getTimeSelected(){
        return this.timeSelected;
    }
    
    public void setTimeSelected(String newTime){
        try {
            this.timeSelected = parser.parse(newTime);
        } catch (ParseException ex) {
            Logger.getLogger("Invalid format");
        }
    }
}
