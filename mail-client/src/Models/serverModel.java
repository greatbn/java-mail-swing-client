/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

/**
 *
 * @author SaPhi
 */
public class serverModel {
    private String hostname;
    private int port;
    public serverModel(){
        
    }
    public serverModel(String hostname, int port){
        this.hostname = hostname;
        this.port = port;
    }
    public void setHostname(String hostname){
        this.hostname = hostname;
    }
    public void setPort (int port){
        this.port = port;
    }
    public String getHostname(){
        return hostname;
    }
    public int getPort(){
        return port;
    }
}
