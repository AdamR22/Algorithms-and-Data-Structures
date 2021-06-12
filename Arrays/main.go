/*
This file contains code demonstrating
static and dynamic arrays.
*/

package main

import (
	"fmt"
	"strconv"
)

func staticArrayDemo() {
	var array [8]int // Array of length 8
	var input int // User input

	fmt.Println("Enter array elements")

	for i:= 0; i < len(array); i++ {
		fmt.Scanf("%d", &input)
		array[i] = input
	}

	fmt.Print("Final Result: ")
	fmt.Print(array)
}

func dynamicArrayDemo() {
	const length = 8

	var array [length]int
	var input string

	fmt.Println("Enter dynamic array items. type ENTER to quit")
	for i:= 0; i < len(array); i++ {
		fmt.Scanf("%s", &input)
		if (input == "ENTER") {
			break
		}

		value, _ := strconv.Atoi(input)
		array[i] = value
	}
}

func main() {
	// staticArrayDemo()
	dynamicArrayDemo()
}