/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author dell
 */
public class Earphone {
    private String earphoneID,type,frequency,sensitive,impedance,meterial,earphone_ProductID,size,battery,connection_distance,wire_length;

    public Earphone() {
    }

    public Earphone(String earphoneID, String type, String frequency, String sensitive, String impedance, String meterial, String earphone_ProductID, String size, String battery, String connection_distance, String wire_length) {
        this.earphoneID = earphoneID;
        this.type = type;
        this.frequency = frequency;
        this.sensitive = sensitive;
        this.impedance = impedance;
        this.meterial = meterial;
        this.earphone_ProductID = earphone_ProductID;
        this.size = size;
        this.battery = battery;
        this.connection_distance = connection_distance;
        this.wire_length = wire_length;
    }

    public String getEarphoneID() {
        return earphoneID;
    }

    public void setEarphoneID(String earphoneID) {
        this.earphoneID = earphoneID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getSensitive() {
        return sensitive;
    }

    public void setSensitive(String sensitive) {
        this.sensitive = sensitive;
    }

    public String getImpedance() {
        return impedance;
    }

    public void setImpedance(String impedance) {
        this.impedance = impedance;
    }

    public String getMeterial() {
        return meterial;
    }

    public void setMeterial(String meterial) {
        this.meterial = meterial;
    }

    public String getEarphone_ProductID() {
        return earphone_ProductID;
    }

    public void setEarphone_ProductID(String earphone_ProductID) {
        this.earphone_ProductID = earphone_ProductID;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getConnection_distance() {
        return connection_distance;
    }

    public void setConnection_distance(String connection_distance) {
        this.connection_distance = connection_distance;
    }

    public String getWire_length() {
        return wire_length;
    }

    public void setWire_length(String wire_length) {
        this.wire_length = wire_length;
    }





}
