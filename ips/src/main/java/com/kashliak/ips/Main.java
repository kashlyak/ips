package com.kashliak.ips;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.BitSet;

public class Main {

    public static void main(String[] args) {
        BitSet[][][] bitSet = new BitSet[256][256][256];
        for (BitSet[][] bitSets : bitSet) {
            for (BitSet[] set : bitSets) {
                for (int i = 0; i < set.length; i++) {
                    set[i] = new BitSet(256);
                }
            }
        }
        long counter = 0;
        long startProgram = System.currentTimeMillis();
        try (BufferedReader reader = new BufferedReader(new FileReader(
                "Add the path to the file"
                ), 8 * 1024 * 1024)) {
            String ipAsString;
            while ((ipAsString = reader.readLine()) != null) {
                String[] split = ipAsString.split("\\.");
                int firstOctet = Integer.parseInt(split[0]);
                int secondOctet = Integer.parseInt(split[1]);
                int thirdOctet = Integer.parseInt(split[2]);
                BitSet currentBitSet = bitSet[firstOctet][secondOctet][thirdOctet];
                currentBitSet.set(Integer.parseInt(split[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long startCalculation = System.currentTimeMillis();
        System.out.println("Sort finished in " + (startCalculation - startProgram)/1000);
        for (BitSet[][] ip : bitSet) {
            for (BitSet[] bitSets : ip) {
                for (BitSet bs : bitSets) {
                    counter += bs.cardinality();
                }
            }
        }
        System.out.println("Unique ips: " + counter);
        System.out.println("The whole flow took " + (System.currentTimeMillis() - startProgram)/1000);
    }
}


