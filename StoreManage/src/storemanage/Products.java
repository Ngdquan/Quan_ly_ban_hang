/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemanage;

import java.util.*;
import java.io.*;



/**
 *
 * @author Duy Quan
 */
public class Products extends Product{
    ArrayList<Products> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void addProduct(){
        int k = 1;
        while(k != 0){
            System.out.println("----ADD PRODUCT----");
            System.out.println("What is type of product: ");
            System.out.println("1. FOODS ");
            System.out.println("2. DRINKS ");
            System.out.println("3. OTHERS ");
            System.out.println("0. CANCEL ");
            int a = Integer.parseInt(sc.nextLine());
            switch(a){
                case 1 : {
                 
                    Foods p = new Foods();
                    p.addProductMethod();
                    list.add(p);
                    break;
                }
                case 2 : {
                    
                    Drinks p = new Drinks();
                    p.addProductMethod();
                    list.add(p);
                    break;
                }
                case 3 : {
                    
                    Others p = new Others();
                    p.addProductMethod();
                    list.add(p);
                    break;
                }
                case 0 : k = 0;break;
            }
        }
    }
    
    public void deleteProduct(){
            System.out.println("----DELETE PRODUCT----\n");
            System.out.print("Input product code: ");
            String temp = sc.nextLine();
            for (Products obj : list) {
                if(obj.getCodeNum().equalsIgnoreCase(temp))
                    list.remove(obj);
            }
            System.out.println("----DELETE SUCCESSFUL!----\n");
        }
    
    
    public void findProduct(){
        System.out.println("----FIND PRODUCT----");
        System.out.print("Input product code or name: ");
        String temp = sc.nextLine();
        for( Products obj : list){
            if(obj.getCodeNum().compareToIgnoreCase(temp) == 0 || obj.getName().compareToIgnoreCase(temp) == 0 ){
                if(obj instanceof Foods){
                    Products t = new Foods();
                    t =  obj;
                    t.printProductMethod();
                }
                else if(obj instanceof Drinks){
                    Products t = new Drinks();
                    t = (Drinks) obj;
                    t.printProductMethod();
                }
                else{
                    Products t = new Others();
                    t = (Others) obj;
                    t.printProductMethod();
                }
                    
                System.out.println("----FIND SUCCESSFUL!----\n");
                break;
            }
        }
    }
    
    public void editInforMethod(){
        
    }
    
    public void editInfor(){
        int i;
        System.out.println("-----EDIT PRODUCT'S INFORMATION-----");
        System.out.println("Input product code or name: ");
        String temp = sc.nextLine();
        for( Products obj : list){
            if(obj.getCodeNum().compareToIgnoreCase(temp) == 0 || obj.getName().compareToIgnoreCase(temp) == 0 ){
                System.out.println("FIND SUCCESSFUL!");
                    if(obj instanceof Foods){
                        Products t = new Foods();
                        t = obj;
                        t.editInforMethod();
                    }
                    else if(obj instanceof Drinks){
                        Products t = new Drinks();
                        t = obj;
                        t.editInforMethod();
                    }
                    else{
                        Products t = new Others();
                        t = obj;
                        t.editInforMethod();
                    }
                    
                break;
            }
        }
    }
    
    
    public void sortByName(){
        Collections.sort(list,new SortByName());
        System.out.println("----Success!----");
    }
    
    public void sortByCode(){
        Collections.sort(list,new SortByCode());
        System.out.println("----Success!----");
    }
    
    public void sortByType(){
       Collections.sort(list,new SortByType());
       System.out.println("----Success!----");
    }
    
    @Override
    public String toString(){
      return getType()+","+getCodeNum()+","+getName()+","+getWeight()+","+getCost()+","+getdOM()+","+getExD()+","+getInStock();
    }
    
    public void saveToFile(ArrayList<Products> list){
        String file_Url = "data.txt";
        try{
            File f = new File(file_Url);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for(Products obj : list){
                pw.println(obj.toString());
            }
            fw.close();
            pw.close();
        }catch(IOException e)
        {
            System.out.println("ERROR!!!" + e.getMessage());
        }
        System.out.println("----Success!----");
    }
    
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
       castClass();
       System.out.println("----Success!----");
    }
    
    
    public void castClass(){
        ArrayList<Products> toRemove = new ArrayList<>();
        ArrayList<Products> toAdd = new ArrayList<>();
        for(Products obj : list){
            if(obj.getType().equalsIgnoreCase("DRINK")){
                Drinks tmp = new Drinks();
                tmp.setType(obj.getType());
                tmp.setCodeNum(obj.getCodeNum());
                tmp.setName(obj.getName());
                tmp.setVolume(obj.getVolume());
                tmp.setCost(obj.getCost());
                tmp.setdOM(obj.getdOM());
                tmp.setExD(obj.getExD()); 
                tmp.setInStock(obj.getInStock());
                toAdd.add(tmp);
                toRemove.add(obj);
                
            }
            else if(obj.getType().equalsIgnoreCase("FOOD")){
                Foods tmp = new Foods();
                tmp.setType(obj.getType());
                tmp.setCodeNum(obj.getCodeNum());
                tmp.setName(obj.getName());
                tmp.setWeight(obj.getWeight());
                tmp.setCost(obj.getCost());
                tmp.setdOM(obj.getdOM());
                tmp.setExD(obj.getExD());
                tmp.setInStock(obj.getInStock());
                toAdd.add(tmp);
                toRemove.add(obj);
            }
            else{
                Others tmp = new Others();
                tmp.setType(obj.getType());
                tmp.setCodeNum(obj.getCodeNum());
                tmp.setName(obj.getName());
                tmp.setWeight(obj.getWeight());
                tmp.setCost(obj.getCost());
                tmp.setdOM(obj.getdOM());
                tmp.setExD(obj.getExD()); 
                tmp.setInStock(obj.getInStock());
                toAdd.add(tmp);
                toRemove.add(obj);
            }
        }
        list.removeAll(toRemove);
        list.addAll(toAdd);
    }
    
    public void printProductMethod(){
        
    }
    
    
    
    public void printAll(){
        printTagCol();
        for(Products obj : list){
            obj.printDetail();
        }
    }
    
    public void printProducts(){
        System.out.println("-----PRINT PRODUCTS-----");
        System.out.println("Choose print method: ");
        System.out.println("1. All");
        System.out.println("2. Option");
        System.out.println("0. Cancel");
        int check = Integer.parseInt(sc.nextLine());
        switch(check){
            case 1 : {
                printAll(); break;
            }
            case 2 : {
                optPrint(); break;
            }
            case 0 : break;
        }
    }
    
    public void printDetail(){
        System.out.printf("%-10s%-10s%-10s\t%-10.2f%-7.2f%10s%15s%10d\n",getType(),getCodeNum(),getName(),getWeight(),getCost(),getdOM(),getExD(),getInStock());
    }
    
    public void printTagCol(){
        System.out.printf("%-10s%-10s%-10s\t%-10s%-7s%10s%15s%10s\n","Type","P.Code","Name","Vol/Wei","Cost","DOM","ExD","InStock");
    }
    
    public void optPrint(){
        System.out.println("-----OPT PRINT-----");
        System.out.println("Choose type of products: ");
        System.out.println("1. DRINKS");
        System.out.println("2. FOODS");
        System.out.println("3. OTHERS");
        System.out.println("0. CANCEL");
        System.out.println("CHOOSE: ");
        int check = Integer.parseInt(sc.nextLine());
        System.out.println("............................................");
        switch(check){
            case 1 : {
                printTagCol();
                for(Products obj : list){
                    if(obj instanceof Drinks)
                        obj.printDetail();
                    }
                break;
                }
            case 2 : {
                printTagCol();
                for(Products obj : list){
                    if(obj instanceof Foods)
                        obj.printDetail();                  
                    }
                break;
                }
            case 3 : {
                printTagCol();
                for(Products obj : list){
                    if(obj instanceof Others)
                        obj.printDetail();
                }
                break;
                }
            case 0 : break;
            }
        
    }
    
    public void delDuplicated(ArrayList<Products> list){
        for(int i = 0; i < list.size(); i++){
            for(int j = list.size()-1; j > i; j--){
                if(list.get(i).getCodeNum().equalsIgnoreCase(list.get(j).getCodeNum())){
                    list.get(i).setInStock(list.get(i).getInStock()+list.get(j).getInStock());
                    //thay doi so luong san pham trong danh sach
                    list.remove(j);
                }
            }
        }
    }
  
    
//    public void outputtest(){
//        for ( Products obj : list) {
//            System.out.println(obj.getClass());
//            System.out.println(obj.getType());
//            System.out.println(obj.getCodeNum());
//            System.out.println(obj.getName());
//            System.out.println(obj.getCost());
//        }
//    }
}
    
    

