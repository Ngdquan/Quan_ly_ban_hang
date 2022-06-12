/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemanage;
import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
/**
 *
 * @author Duy Quan
 */
public class Payment extends Products {
    ArrayList<Products> queueList = new ArrayList<>();
    ArrayList<Payment> bill = new ArrayList<>();
    static float total = 0;
    private float subtotal = 0;

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getSubtotal() {
        return subtotal;
    }

    
    public void addToBill(){
        boolean boo = true;
        
        System.out.print("Input product code or name: ");
        String temp = sc.nextLine();
        for( Products obj : list){
            if(obj.getCodeNum().compareToIgnoreCase(temp) == 0 || obj.getName().compareToIgnoreCase(temp) == 0 ){
                obj.printTagCol();
                obj.printDetail();
                System.out.println("Add to bill? Y/n");
                String check = sc.nextLine();
                if(check.equalsIgnoreCase("Y")){
                    Products tmp = new Products();
                    //tao temp de lay object clone
                    tmp.setType(obj.getType());
                    tmp.setName(obj.getName());
                    tmp.setCodeNum(obj.getCodeNum());
                    tmp.setCost(obj.getCost());
                    tmp.setWeight(obj.getWeight());
                    tmp.setVolume(obj.getVolume());
                    tmp.setdOM(obj.getdOM());
                    tmp.setExD(obj.getExD());
                    System.out.println("Input quantity: ");
                    int q = Integer.parseInt(sc.nextLine());
                    int inst = obj.getInStock();
                    tmp.setInStock(q);
                    queueList.add(tmp);
                    obj.setInStock(inst-q);
                    //thay doi so luong inStock
                    
                }
                System.out.println("Continue? Y/n");
                String check2 = sc.nextLine();
                if(check2.equalsIgnoreCase("Y")){
                    addToBill();
                }
                else{
                    //them chuoi san pham vao hang doi
                    System.out.println("----Added!----");
                }
                boo = false;
                break;
            }
        }
        if(boo){
                System.out.println("----CANNOT FIND PRODUCT! PLEASE TRY AGAIN");
                addToBill();
            }
    }
    
    public void createBill(){
        bill.clear();
        queueList.clear();
        total = 0;
        addToBill();
        delDuplicated(queueList);
        for(Products obj : queueList){
            Payment pr = new Payment();
            pr.setType(obj.getType());
            pr.setName(obj.getName());
            pr.setCodeNum(obj.getCodeNum());
            pr.setCost(obj.getCost());
            pr.setWeight(obj.getWeight());
            pr.setVolume(obj.getVolume());
            pr.setdOM(obj.getdOM());
            pr.setExD(obj.getExD());
            pr.setInStock(obj.getInStock());
            bill.add(pr);
        }
        
        for(Payment obj : bill){
            //tinh tien tung san pham
            obj.setSubtotal(obj.getCost()*obj.getInStock());
            total += obj.getSubtotal();
            //tinh tong tien
        }
        saveToFile(list);
        System.out.println("----Created!-----");
    }
    
    @Override
    public void printDetail(){
        System.out.printf("%-10s%-10s%-10s\t%-10.2f%-7.2f%10s%15s%10d%10.2f\n",getType(),getCodeNum(),getName(),getWeight(),getCost(),getdOM(),getExD(),getInStock(),getSubtotal());
    }
    
    
    @Override
    public void printTagCol(){
        System.out.printf("%-10s%-10s%-10s\t%-10s%-7s%10s%15s%10s%10s\n","Type","P.Code","Name","Vol/Wei","Cost","DOM","ExD","Quantity","Prices");
    }
    
    public void printTotal(){
        System.out.printf("%-20s%20.2f\n","Total",total);
    }
    
    public void printBill(){
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String formatted = current.format(formatter);
        System.out.println(formatted);
        printTagCol();
        for(Payment obj : bill){
            obj.printDetail();
        }
        printTotal();
    }
    
    @Override
    public String toString(){
      String s = String.format("%-10s%-10s%-10s\t%-10.2f%-7.2f%10s%15s%10d%10.2f\n",getType(),getCodeNum(),getName(),getWeight(),getCost(),getdOM(),getExD(),getInStock(),getSubtotal());
      return s;
    }
    
    public void saveBillToPrint(){
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String formatted = current.format(formatter);
        String file_Url = "bill.txt";
        String tagCol = String.format("%-10s%-10s%-10s\t%-10s%-7s%10s%15s%10s%10s\n","Type","P.Code","Name","Vol/Wei","Cost","DOM","ExD","Quantity","Prices");
        String ptotal = String.format("%-20s%20.2f\n","Total",total);
        try{
            File f = new File(file_Url);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(formatted);
            pw.println(tagCol);
            for(Payment obj : bill){
                pw.println(obj.toString());
            }
            pw.println(ptotal);
            fw.close();
            pw.close();
        }catch(IOException e)
        {
            System.out.println("ERROR!!!" + e.getMessage());
        }
        System.out.println("----Saved!----");
    }
    
    @Override
    public void readFromFile(){
       String file_Url = "data.txt";
       File f = new File(file_Url);
       try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while((line = br.readLine()) != null){
                if(line.trim() == "") continue;
                Products tmp = new Products();
                String[] arr = line.split("[,]+");
                tmp.setType(arr[0]);
                tmp.setCodeNum(arr[1]);
                tmp.setName(arr[2]);
                tmp.setVolume(Float.parseFloat(arr[3]));
                tmp.setWeight(Float.parseFloat(arr[3]));
                tmp.setCost(Float.parseFloat(arr[4]));
                tmp.setdOM(arr[5]);
                tmp.setExD(arr[6]);
                tmp.setInStock(Integer.parseInt(arr[7]));
                list.add(tmp);
            }
            fr.close();
            br.close();
       }catch(IOException e){
           System.out.println("Cannot open file!");
       }
       System.out.println("----Read!----");
    }
}


