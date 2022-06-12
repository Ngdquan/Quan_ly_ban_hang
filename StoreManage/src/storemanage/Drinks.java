/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemanage;
import java.io.*;

/**
 *
 * @author Duy Quan
 */
public class Drinks extends Products implements Serializable{
    private String type = "DRINK";

    @Override
    public void setType(String type) {
        this.type = type;
    }
    private float volume = 0;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public float getVolume() {
        return volume;
    }

    @Override
    public void setVolume(float volume) {
        this.volume = volume;
    }
    
    public void addProductMethod(){
        System.out.print("Input product code: ");
        setCodeNum(sc.nextLine());
        System.out.print("Input product's name: ");
        setName(sc.nextLine());
        System.out.print("Input product's volume: ");
        setVolume(Float.parseFloat(sc.nextLine()));
        System.out.print("Input product's cost: ");
        setCost(Float.parseFloat(sc.nextLine()));
        System.out.print("Input date of manufacture: ");
        setdOM(sc.nextLine());
        System.out.print("Input expiry date: ");
        setExD(sc.nextLine());
        System.out.print("Input in stock: ");
        setInStock(Integer.parseInt(sc.nextLine()));
        System.out.println("----INPUT SUCCESSFUL!----\n");
    }
    
    @Override
    public void printProductMethod(){
        System.out.printf("%-10s%-10s%-10s\t%-10s%-7s%10s%15s%10s\n","Type","P.Code","Name","Volume","Cost","DOM","ExD","InStock");
        System.out.printf("%-10s%-10s%-10s\t%-10.2f%-7.2f%10s%15s%10d\n",getType(),getCodeNum(),getName(),getVolume(),getCost(),getdOM(),getExD(),getInStock());
    }
    
    @Override
    public void printDetail(){
        System.out.printf("%-10s%-10s%-10s\t%-10.2f%-7.2f%10s%15s%10d\n",getType(),getCodeNum(),getName(),getVolume(),getCost(),getdOM(),getExD(),getInStock());
    }
    
    @Override
    public void editInforMethod(){
       System.out.println("What information do you want to edit?");
       System.out.println("1. TYPE");
       System.out.println("2. PRODUCT CODE");
       System.out.println("3. NAME");
       System.out.println("4. VOLUME");
       System.out.println("5. COST");
       System.out.println("6. DOM");
       System.out.println("7. ExD");
       System.out.println("8. InStock");
       System.out.println("0. CANCEL");
       int a = Integer.parseInt(sc.nextLine());
       System.out.println("----EDIT INFORMATION----");
       switch(a){
           case 1 : {
                System.out.print("Input product's type: ");
                setType(sc.nextLine());
                System.out.println("----EDIT SUCCESSFUL!----\n");
                break;
           }
           case 2 : {
                System.out.print("Input product's code: ");
                setCodeNum(sc.nextLine());
                System.out.println("----EDIT SUCCESSFUL!----\n");
                break;
           }
           case 3 : {
                System.out.print("Input product's name: ");
                setName(sc.nextLine());
                System.out.println("----EDIT SUCCESSFUL!----\n");
                break;
           }
           case 4 : {
                System.out.print("Input product's volume: ");
                setVolume(Integer.parseInt(sc.nextLine()));
                System.out.println("----EDIT SUCCESSFUL!----\n");
                break;
           }
           case 5 : {
                System.out.print("Input product's cost: ");
                setCost(Float.parseFloat(sc.nextLine()));
                System.out.println("----EDIT SUCCESSFUL!----\n");
                break;
           }
           case 6 : {
                System.out.print("Input product's DOM: ");
                setdOM(sc.nextLine());
                System.out.println("----EDIT SUCCESSFUL!----\n");
                break;
           }
           case 7 : {
                System.out.print("Input product's ExD: ");
                setExD(sc.nextLine());
                System.out.println("----EDIT SUCCESSFUL!----\n");
                break;
           }
           case 8 : {
                System.out.print("Input in stock: ");
                setInStock(Integer.parseInt(sc.nextLine()));
                System.out.println("----EDIT SUCCESSFUL!----\n");
                break;
           }
           case 0 : {
               
                break;
           }
       }
       System.out.println("Do you want to continue editing? Y/N");
       String c = sc.nextLine();
       if(c.equalsIgnoreCase("Y"))
           editInforMethod();
   }
    @Override
    public String toString(){
        return String.format("%s,%s,%s,%.1f,%.1f,%s,%s,%d",getType(),getCodeNum(),getName(),getVolume(),getCost(),getdOM(),getExD(),getInStock());
    }
}
