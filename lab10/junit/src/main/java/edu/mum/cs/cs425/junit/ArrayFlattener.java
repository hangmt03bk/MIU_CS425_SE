package edu.mum.cs.cs425.junit;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

//@SpringBootApplication
@Service
public class ArrayFlattener{
	public int[] flattenArray(int[][] arr2d){
		if(arr2d == null) return null;
		
		return Arrays.stream(arr2d)
			.flatMapToInt(Arrays::stream)
			.toArray();
	}

	public static void main(String[] args) {
		SpringApplication.run(ArrayFlattener.class, args);
	}
/*
	@Override
	public void run(String... args) throws Exception {
		
		
	}
*/
}
