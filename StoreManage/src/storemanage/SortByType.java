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
public class SortByType implements Comparator<Products>{
  @Override
  public int compare(Products o1, Products o2) {
  String type1 = o1.getType();
  String type2 = o2.getType();
  if(type2.compareToIgnoreCase(type1) < 0){
    return 1;
  }
  else if(type2.compareToIgnoreCase(type1) == 0){
    return 0;
  }
  else{
    return -1;
    }
  }
}
