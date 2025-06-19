package main

import "fmt"

func spiralOrder(matrix [][]int) []int {

	limit := len(matrix)
	vector := make([]int, len(matrix)*len(matrix[0]))
	it := 0
	i := 0
	j := 0
	aux := 0
	fmt.Println(len(vector))

	for start := 0; start < limit; start++ {
		for j = 0; j < limit; j++ {
			if i%2 == 0 {
				vector[it] = matrix[i][j]
			} else {
				vector[it] = matrix[j][i]
			}
			it++
		}
		if i%2 == 0 {
			i = limit
		} else {
			i = aux
			aux++
		}
		limit--
	}
	return vector

}

func main() {
	matrix := [][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}

	fmt.Println(spiralOrder(matrix))
}
