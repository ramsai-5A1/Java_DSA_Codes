import java.util.*;
import java.io.*;

class Box {
    String name;
    int roll;
    Double cgpa;
    
    public Box(String name, int roll, Double cgpa) {
        this.name = name;
        this.roll = roll;
        this.cgpa = cgpa;
    }
}


class HelpComparing implements Comparator<Box> {
    
    @Override
    public int compare(Box a, Box b) {
        // The below part of code, sorts 2 objects basing on higher cgpa (Decending order of CGPA)
        // Incase if there is any tie, then it breaks the tie by sorting basing on roll num (Ascending order)
        int cgpaComparision = Double.compare(b.cgpa, a.cgpa);
        if (cgpaComparision != 0) {
            return cgpaComparision;
        }
        int rollNoComparision = Integer.compare(a.roll, b.roll);
        return rollNoComparision;
    }
}

class SortObjects {
    
    public static void printObjects(ArrayList<Box> list) {
        int n = list.size();
        for (int index = 0; index < n; index++) {
            Box obj = list.get(index);
            System.out.println("Name is: " + obj.name + ", Roll num is: " + obj.roll + ", CGPA is: " + obj.cgpa);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        String[] names = {"Kiran", "Sai", "Arun", "Kusuma", "Venky"};
        int[] rolls = {56, 23, 45, 10, 8};
        Double[] cgpas = {8.9, 5.6, 7.6, 7.6, 4.5};
        
        ArrayList<Box> list = new ArrayList<>();
        int n = names.length;
        for (int index = 0; index < n; index++) {
            Box obj = new Box(names[index], rolls[index], cgpas[index]);
            list.add(obj);
        }
        
        System.out.println("Before sorting");
        printObjects(list);
        
        Collections.sort(list, new HelpComparing());
        
        System.out.println("After sorting");
        printObjects(list);
    }
}