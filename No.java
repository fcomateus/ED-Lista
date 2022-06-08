/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arvorebinariagenerica;

/**
 *
 * @author fmfr
 */
import java.util.*;

class No { 

  Object Dado;
  No esq;
  No dir;

  public No() {
    Dado = null;
    esq = null;
    dir = null;
  }

   public No(Object x) {
     Dado = x;
     esq = null;
     dir = null;
 }

}