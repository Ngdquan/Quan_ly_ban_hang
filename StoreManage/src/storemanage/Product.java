/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemanage;

/**
 *
 * @author Duy Quan
 */
public class Product {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    private String codeNum;
    private String name;
    private float cost;
    private float weight;
    private String dOM;
    private String exD;
    private float volume;
    private int inStock;

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public int getInStock() {
        return inStock;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }
    
    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    public void setdOM(String dOM) {
        this.dOM = dOM;
    }

    public void setExD(String exD) {
        this.exD = exD;
    }

    public String getdOM() {
        return dOM;
    }

    public String getExD() {
        return exD;
    }

    public void setCodeNum(String codeNum) {
        this.codeNum = codeNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getCodeNum() {
        return codeNum;
    }

    public String getName() {
        return name;
    }

    public float getCost() {
        return cost;
    }
    
}
