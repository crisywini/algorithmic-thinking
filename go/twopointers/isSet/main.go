package main

import "fmt"

func isSet(array []int) bool {

	for i, j := 0, 1; i < len(array) && j < len(array); i, j = i+1, j+1 {
		if array[i] == array[j] {
			return false
		}
	}
	return true

}

func main() {

	array := []int{1}
	fmt.Println(isSet(array))

}
