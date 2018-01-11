/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fastestroutetube;

/**
 *
 * @author micael
 */
public enum LineName {
    Bakerloo("Bakerloo"),
    Victoria("Victoria"),
    Central("Central"),
    District("District"),
    HammersmithCity("Hammersmith & City"),
    Jubilee("Jubilee"),
    Metropolitan("Metropolitan"),
    Northern("Northern"),
    Piccadilly("Piccadilly"),
    Circle("Circle"),
    WaterlooCity("Waterloo & City"),
    Unknown("Unkown");

    private String name;

    LineName(String name) {
        this.name = name;
    }

    /*Returns the respective
        LineName object considering the string parsed
     */
    static LineName getLineName(String name) {
        for (LineName value : LineName.values()) {
            if (name.equalsIgnoreCase(value.toString())) {
                return value;
            }
        }
        return LineName.Unknown;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
