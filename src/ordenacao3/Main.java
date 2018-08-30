/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenacao3;

import java.util.Arrays;

/**
 *
 * @author Felipe
 */
public class Main {

    
    public static void main(String[] args) {

        int[] randomico = randomizeArray();
        
        System.out.print("Counting Sort: Array randomico => ");
        System.out.println(Arrays.toString(new CountingSort(randomico).sort()));
        
        randomico = randomizeArray();
        
        System.out.print("Heap Sort: Array randomico => ");
        System.out.println(Arrays.toString(new HeapSort(randomico).sort()));
    }
    
    static int[] randomizeArray(){
        int[] array = new int[30];
        for (int i = 0; i < 30; ++i){
            array[i] = (int)(Math.random()*100 + 1);
        }
        return array;
    }
}

