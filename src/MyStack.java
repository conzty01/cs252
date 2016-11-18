/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author conzty01
 */

import java.util.ArrayList;

public class MyStack<T> {
    private ArrayList<T> lst;
    public MyStack() {
        lst = new ArrayList();
    }
    public void push(T o) {
        lst.add(o);
    }
    public T pop() {
        return lst.remove(lst.size()-1);
    }
    public boolean isEmpty() {
        return (lst.size() == 0);
    }
    public int stackLen() {
        return lst.size();
    }
    @Override
    public String toString() {
        String str = "";
        
        for(int i = 0; i >= lst.size(); i++) {
            str += lst.get(i).toString() + "\n";
        }
        return str;
    }

}
