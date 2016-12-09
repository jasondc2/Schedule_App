/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jason.schedule_app;
import android.content.ClipData;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
/**
 *
 * @author whi08_000
 */
public class SAtest {
    String value;

    /**
     *
     */
    Queue<Item> createQueue(Set<String> val) {
        Iterator it = val.iterator();

        //while(it.hasNext()) {
                //value = (String) it.next();
       // }
            Queue<Item> items = new PriorityQueue<Item>();
            items.add(new Item("Nov 15, 2016", "Essay", "Ponder", 900));
            items.add(new Item("Nov 15, 2016", "Essay", "Ponder", 88800));
            items.add(new Item("Nov 15, 2016", "Essay", "Ponder", 200));
            items.add(new Item("Nov 15, 2016", "Essay", "Ponder", 700));
            //items.add(new Item("Nov 15, 2016", value, "Ponder", 700));
            while(it.hasNext()) {
                value = (String) it.next();
                items.add(new Item("Nov 15, 2016", value, "Ponder", 700));
            }


        //   System.out.println("Order of items in PriorityQueue");
        // System.out.println(items);

        //  System.out.println("Element consumed from head of the PriorityQueue : " + items.poll());
        //   System.out.println(items);

        // System.out.println("Element consumed from head of the PriorityQueue : " + items.poll());
        //  System.out.println(items);

        //  System.out.println("Element consumed from head of the PriorityQueue : " + items.poll());
        //  System.out.println(items);

        //items.add(null); // null elements not allowed in PriorityQueue - NullPointerException
        //   String[] strArray = {"foo", "foo", "bar"};
//Set<String> mySet = new HashSet<>(Arrays.asList(strArray));
//System.out.println(mySet);
        return items;
    }

    public static class Item implements Comparable<Item> {

        //private String name;
        // private int price;

        private String date;
        private int time;
        private String assignmentName;
        private  String assignmentType;

        public Item(String assignmentType,String assignmentName, String date, int time) {
            this.date = date;
            this.time = time;
            this.assignmentName=assignmentName;
            this.assignmentType=assignmentType;
        }

        public String getAssignmentName() {
            return assignmentName;
        }

        public String getAssignmentType() {
            return assignmentType;
        }

        public String getDate() {
            return date;
        }

        public int getTime() {
            return time;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Item other = (Item) obj;
            if ((this.date == null) ? (other.date != null) : !this.date.equals(other.date)) {
                return false;
            }
            if ((this.assignmentName == null) ? (other.assignmentName != null) : !this.assignmentName.equals(other.assignmentName)) {
                return false;
            }
            if ((this.assignmentType == null) ? (other.assignmentType != null) : !this.assignmentType.equals(other.assignmentType)) {
                return false;
            }
            if (this.time != other.time) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 97 * hash + (this.date != null ? this.date.hashCode() : 0);
            hash = 97 * hash + this.time;
            return hash;
        }

        @Override
        public int compareTo(Item i) {
            if ((this.time == i.time) ){
                return this.date.compareTo(i.date) ;
                // return (this.assignmentName.compareTo(i.assignmentName));
            }

            return this.time - i.time;
        }

        @Override
        public String toString() {
            return String.format("%s: %s: %s: %d", assignmentName,assignmentType,date,time);
        }

    }
}



