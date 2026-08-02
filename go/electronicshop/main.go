package main

import (
	"bufio"
	"fmt"
	"io"
	"strings"
)

/*
 * Complete the getMoneySpent function below.
 */
func getMoneySpent(keyboards []int32, drives []int32, b int32) int32 {

	var max int32
	max = -1

	var pivot int32

	for i := 0; i < len(keyboards); i++ {
		for j := 0; j < len(drives); j++ {
			pivot = keyboards[i] + drives[j]
			if pivot <= b && pivot > max {
				max = pivot
			}
		}
	}

	return max
}

func main() {
	fmt.Println(getMoneySpent([]int32{4}, []int32{5}, 5))
}

func readLine(reader *bufio.Reader) string {
	str, _, err := reader.ReadLine()
	if err == io.EOF {
		return ""
	}

	return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
	if err != nil {
		panic(err)
	}
}
