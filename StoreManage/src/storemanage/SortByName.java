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
public class SortByName implements Comparator<Products> {
  @Override
  public int compare(Products o1, Products o2) {
  String name1 = o1.getName();
  String name2 = o2.getName();
  if(name2.compareToIgnoreCase(name1) < 0){
    return 1;
  }
  else if(name2.compareToIgnoreCase(name1) == 0){
    return 0;
  }
  else{
    return -1;
    }
  }
}
