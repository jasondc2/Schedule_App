/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jason.schedule_app;
import android.content.ClipData;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
/**
 *
 * @author whi08_000
 */
public class SAtest {

    /**className, assignmentName,assignmentType,date,time, assignmentPoints, overallPrio
     *
     */
    Queue<Item> createQueue() {
        Queue<Item> items = new PriorityQueue<Item>();
        items.add(new Item("CS 246", "Java", "Ponder", 233, "12/01/2016", 233, 66 ));
        items.add(new  Item("CS 246", "Java", "Ponder", 233, "12/06/2016", 233, 8 ));
        items.add(new  Item("CS 246", "Java", "Ponder", 233, "1/3/2017", 233, 1 ));
        items.add(new  Item("CS 246", "Java", "Ponder", 233, "2/01/2017", 233, 2 ));

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
        private String className;
        private int assignmentPoints;
        private int overallPriority;

        public Item(String assignmentType,String assignmentName, String date, int time, String className, int assingmentPoints,int overallPriority) {
            this.date = date;
            this.time = time;
            this.assignmentName=assignmentName;
            this.assignmentType=assignmentType;
            this.className=className;
            this.assignmentPoints=assingmentPoints;
            this.overallPriority=overallPriority;
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
            if (this.overallPriority != other.overallPriority) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 97 * hash + (this.date != null ? this.date.hashCode() : 0);
            hash = 97 * hash + this.overallPriority;
            return hash;
        }

        @Override
        public int compareTo(Item i) {
            if ((this.overallPriority == i.overallPriority) ){
                return this.date.compareTo(i.date) ;
                // return (this.assignmentName.compareTo(i.assignmentName));
            }

            return this.overallPriority - i.overallPriority;
        }

        @Override
        public String toString() {
            return String.format("%s: %s: %s : %s: %s: %d : %d",  className, assignmentName,assignmentType,date,time, assignmentPoints, overallPriority);
        }

    }
}


