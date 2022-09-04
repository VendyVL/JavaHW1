package Sem1;

import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;

public class T2 {
    static int solve(int start, int end, int summ, int mult) {                  /*Это метод который создаёт*/
        int[] ways = new int[end + 1];
        ways[start] = 1;

        for (int index = start + summ; index <= end; index++) {
            if (index % mult == 0) {
                ways[index] = ways[index - summ] + ways[index / mult];
            } 
            else {
                ways[index] = ways[index - summ];
            }
        }
        // System.out.println(print(ways,start));
        return ways[end];
        
    }

    static String print(int[] items, int start) {                                          /*Это метод который печатает он идёт в строку 16*/
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < items.length; i++) {

            sb.append(String.format("(%d)%d ", i, items[i]));
        }
        return sb.toString();
    }

    // static String printRev(ArrayList<String> items) { 
    //     for (int i = items.length; i == 0; i--) {
    //         System.out.println(items[i]);
    //     }
    // }

    static ArrayList<String> wway(int start, int end, int summ, int mult, int countways) {
        ArrayList<String> oneWay = new ArrayList<>();                               /*Количество операций зависит непонятно от чего, нужен пустой массив без заданной длины */

        while (start != end) {
            if (end % mult != 0) {
                end -= summ;
                oneWay.add("+" + String.valueOf(summ));

            } 
            else {
                end /= mult;
                oneWay.add("*" + String.valueOf(mult));
                // arrayList.addFirst("+" + String.valueOf(summ)); не работает
            }
        }
        System.out.print(oneWay);
        return oneWay;
    }

    public static void main(String[] args) {
        int start = 2;
        int end = 15;
        int summ = 1;
        int mult = 2;
        
        if (start > end)  System.out.println("нет решения");
        else if (solve(start, end, summ, mult) > 0){
            System.out.println("Возможных решений" + solve(start, end, summ, mult));
            wway(start, end, summ, mult, solve(start, end, summ, mult));
        }
        else{ System.out.println("нет решения"); }
        
    }
}
