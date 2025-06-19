package main

import (
	"fmt"
	"sort"
)

func countElements(nums []int) map[int]int {
	frecuency := make(map[int]int)

	for i := 0; i < len(nums); i++ {
		value, ok := frecuency[nums[i]]

		if ok {
			frecuency[nums[i]] = value + 1
		} else {
			frecuency[nums[i]] = 1
		}
	}
	return frecuency
}

type Pair struct {
	Value int
	Key   int
}

func getMajorOrdered(frecuency map[int]int, k int) []int {
	var ordered []int
	var pairs []Pair

	for k, v := range frecuency {
		pairs = append(pairs, Pair{Key: k, Value: v})
	}

	sort.Slice(pairs, func(i, j int) bool {
		return pairs[i].Value > pairs[j].Value
	})
	for i := 0; i < k; i++ {
		ordered = append(ordered, pairs[i].Key)
	}
	return ordered

}

func topKFrequent(nums []int, k int) []int {
	frecuency := countElements(nums)
	return getMajorOrdered(frecuency, k)
}

func main() {

	nums := []int{1, 1, 1, 1, 1, 2, 2, 2, 3, 3}
	fmt.Println(topKFrequent(nums, 2))

}
