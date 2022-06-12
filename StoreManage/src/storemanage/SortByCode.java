/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemanage;
import java.util.*;
/**
 *
 * @author Duy Quan
 */
public class SortByCode implements Comparator<Products> {
  @Override
  public int compare(Products o1, Products o2) {
  String code1 = o1.getCodeNum();
  String code2 = o2.getCodeNum();
  if(code2.compareToIgnoreCase(code1) < 0){
    return 1;
  }
  else if(code2.compareToIgnoreCase(code1) == 0){
    return 0;
  }
  else{
    return -1;
    }
  }
    
}
