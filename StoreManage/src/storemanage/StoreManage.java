/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemanage;
import java.util.*;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author Duy Quan
 */
public class StoreManage{

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Products a = new Products();
        Payment b = new Payment();
        Scanner sc = new Scanner(System.in);
        int n = 1;
        while(n != 0){
            System.out.println(">>>>>>> STORE MANAGEMENT APP <<<<<<<");
            System.out.println("1. PRODUCT MANAGEMENT");
            System.out.println("2. PAYMENT MANAGEMENT");
            System.out.println("0. EXIT");
            System.out.println("CHOOSE: ");           
            int de = Integer.parseInt(sc.nextLine());
            System.out.println("............................................");
            switch(de){
                case 1 : {
                   int n1 = 0;
                   while(n1 == 0){
                    System.out.println(">>>>>>> PRODUCT MANAGEMENT <<<<<<<");
                    System.out.println("1. ADD PRODUCT");
                    System.out.println("2. DELETE PRODUCT");
                    System.out.println("3. FIND PRODUCT");
                    System.out.println("4. EDIT PRODUCT");
                    System.out.println("5. SHOW PRODUCT");
                    System.out.println("6. PUSH PRODUCT'S LIST");
                    System.out.println("0. RETURN");
                    System.out.println("CHOOSE: ");
                    int c = Integer.parseInt(sc.nextLine());
                    System.out.println("............................................");
                    switch(c){
                        case 1 :  { 
                            a.addProduct();
                            a.delDuplicated(a.list);
                            a.saveToFile(a.list);
                            break;
                        }
                        case 2 : {
                            a.list.clear();
                            a.readFromFile();
                            a.deleteProduct();
                            a.saveToFile(a.list);
                            break;
                        }
                        case 3 : {
                            a.list.clear();
                            a.readFromFile();
                            a.findProduct();
                            break;
                        }
                        case 4 : {
                            a.list.clear();
                            a.readFromFile();
                            a.editInfor();
                            a.saveToFile(a.list);
                            break;
                        }
                        case 5 : {
                            a.list.clear();
                            a.readFromFile();
                            System.out.println("Do you want to sort before show? Y/n");
                            String str = sc.nextLine();
                            if(str.equalsIgnoreCase("Y")){
                                System.out.println("1. SORT BY NAME");
                                System.out.println("2. SORT BY CODE");
                                System.out.println("3. SORT BY TYPE");
                                System.out.println("0. RETURN");
                                System.out.println("CHOOSE: ");
                                int c1 = Integer.parseInt(sc.nextLine());
                                System.out.println("............................................");
                                switch(c1){
                                    case 1 : {
                                        a.sortByName();
                                        a.printProducts();
                                        break;
                                    }
                                    case 2 : {
                                        a.sortByCode();
                                        a.printProducts();
                                        break;
                                    }
                                    case 3 : {
                                        a.sortByType();
                                        a.printProducts();
                                        break;
                                    }
                                    case 0 : {
                                        break;
                                    }
                                }
                            }
                            else {
                                a.printProducts();
                            }
                            break;
                        }
                        case 6 : {
                            a.list.clear();
                            a.readFromFile();
                            a.delDuplicated(a.list);
                            a.saveToFile(a.list);
                            break;
                        }
                        case 0 : {
                            n1 = 1;
                            break;
                        }
                    }
                   }
                   break;
                }
                case 2 : {
                    int n2 = 0;
                    while(n2 == 0){
                    System.out.println(">>>>>>> PAYMENT MANAGEMENT <<<<<<<");
                    System.out.println("1. CREATE A NEW BILL");
                    System.out.println("2. SHOW BILL");
                    System.out.println("3. DOWNLOAD BILL");
                    System.out.println("0. RETURN");
                    System.out.println("CHOOSE: ");
                    int c2 = Integer.parseInt(sc.nextLine());
                    System.out.println("............................................");
                    switch(c2){
                        case 1 : {
                            b.readFromFile();
                            b.createBill();
                            b.list.clear();
                            a.list.clear();
                            a.readFromFile();
                            break;
                        }
                        case 2 : {
                            b.printBill();
                            break;
                        }
                        case 3 : {
                            b.saveBillToPrint();
                            break;
                        }
                        case 0 : {
                            n2 = 1;
                            break;
                        }
                      }
                    }
                   break;
                }
                case 0 : {
                    System.out.println("CLOSING PROGRAM.....3");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("CLOSING PROGRAM.....2");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("CLOSING PROGRAM.....1");
                    TimeUnit.SECONDS.sleep(1);
                    System.exit(0);
                    break;
                }
            }
        }
    }
    
}
