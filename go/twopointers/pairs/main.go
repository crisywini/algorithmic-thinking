package main

import "fmt"

func arePairsToSumTheTarget(array []int, target int) bool {

	stopper := false
	i := 0
	j := len(array) - 1

	for !stopper {

		sum := array[i] + array[j]

		if sum == target {
			stopper = true
		}
		if sum > target {
			j--
		}
		if sum < target {
			i++
		}

		if j < 0 || i >= len(array) {
			return false
		}

	}
	return stopper
}

func main() {

	array := []int{1, 2, 3, 4, 5}

	fmt.Println(arePairsToSumTheTarget(array, 5))

}
