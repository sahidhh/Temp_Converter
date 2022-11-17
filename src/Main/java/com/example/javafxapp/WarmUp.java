package com.example.javafxapp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WarmUp {

	public static void main(String[] args) {

		int[] numbersArray = IntStream.rangeClosed(0,100).toArray();

		List<Integer> numberList = IntStream.rangeClosed(0,100).mapToObj(i -> new Integer(i)).collect(Collectors.toList());

		System.out.println(numberList);

	}

}
