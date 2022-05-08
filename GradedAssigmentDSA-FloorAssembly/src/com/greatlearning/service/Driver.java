package com.greatlearning.service;

import java.util.ArrayList;
import java.util.Scanner;
import com.greatlearning.model.FloorAssembly;

public class Driver {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("enter the total no of floors in the building:");
		int totalFloors = sc.nextInt();
		int[] floors = new int[totalFloors];
		int floorSize=0;
		for(int i=0;i<totalFloors;i++)
		{
			System.out.println("enter the floor size given on day : "+(i+1));
			floorSize = sc.nextInt();
			if(floorSize<=0) {
				System.err.println("Invalid size of the floor");
			}
			floors[i] = floorSize;
		}
		
		FloorAssembly floorAssembly = new FloorAssembly();
		floorAssembly.getAssembly(floors);
		
		sc.close();
	}

}
