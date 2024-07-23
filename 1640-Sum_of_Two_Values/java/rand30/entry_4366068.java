/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package com.mycompany.usaco;
import java.io.*;
import java.util.*;
/**
 *
 * @author S.Zheng25
 */
public class entry_4366068 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter (new BufferedWriter (new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> nums = new ArrayList();
        
        for (int i = 0; i < n; i++){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        
        ArrayList<Integer> number = new ArrayList(nums);
        Collections.sort(nums);
        
        int left = 0; int right = n-1;
        String ans = "IMPOSSIBLE";
        while (left < right){
            if (nums.get(left) + nums.get(right) == target){
                
                ans = Integer.toString(number.indexOf(nums.get(left))+1) + " " + Integer.toString(number.lastIndexOf(nums.get(right))+1);
                break;
            }
            else if (nums.get(left) + nums.get(right) > target){
                right --;
            }
            else{
                left ++;
            }
        }
        pw.println(ans);
        pw.close();
        
//        int size = Integer.parseInt(st.nextToken());
//        int sum = Integer.parseInt(st.nextToken());
//        
//        HashMap<Integer, Integer> numbers = new HashMap();
//        ArrayList<Integer> numersArray = new ArrayList();
//        
//        st = new StringTokenizer(br.readLine());
//        for (int a = 0; a < size; a++){
//            int num = Integer.parseInt(st.nextToken());
//            numbers.putIfAbsent(num, 0);
//            numbers.replace(num, numbers.get(num)+1);
//            numersArray.add(num);
//        }
//        
//        int num1=0;
//        int num2=0;
//        boolean swit = true;
//        
//        for (int n: numbers.keySet()){
//            int desired = sum - n;
//            if (numbers.keySet().contains(desired)){
//                if (desired == n){
//                    if (!(numbers.get(n) > 1)){
//                        continue;
//                    }
//                }
//                num1 = n;
//                num2 = desired; 
//                swit = false;
//            }
//        }
//        
//        int ind1 = numersArray.indexOf(num1)+1;
//        int ind2 = numersArray.indexOf(num2)+1;
//        
//        if (num1 == num2){
//            ind2 = numersArray.lastIndexOf(num2)+1;
//        }
//        
//        if (swit){
//            pw.println("IMPOSSIBLE");
//        }
//        else{
//            pw.print(ind1);
//            pw.print(" ");
//            pw.print(ind2);
//        }
//        pw.close();
    }
}
