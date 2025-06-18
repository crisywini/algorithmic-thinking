package main

import (
	"fmt"
	"sort"
)

func areIntervalsCollide(interval, nextInterval Pair) bool {

	minLimitInterval := interval.Left
	maxLimitInterval := interval.Right

	minLimitNextInterval := nextInterval.Left
	maxLimitNextInterval := nextInterval.Right

	isNextInInterval := (minLimitNextInterval >= minLimitInterval && minLimitNextInterval <= maxLimitInterval) || (maxLimitNextInterval >= minLimitInterval && minLimitNextInterval <= maxLimitInterval)

	isIntervalInNext := (minLimitInterval >= minLimitNextInterval && minLimitInterval <= maxLimitNextInterval) || (maxLimitInterval >= minLimitNextInterval && maxLimitInterval <= maxLimitNextInterval)

	return isNextInInterval || isIntervalInNext
}

func createNewInterval(interval, nextInterval Pair) []int {
	minLimitInterval := interval.Left
	maxLimitInterval := interval.Right

	minLimitNextInterval := nextInterval.Left
	maxLimitNextInterval := nextInterval.Right

	min := 0
	max := 0

	if minLimitInterval <= minLimitNextInterval {
		min = minLimitInterval
	} else {
		min = minLimitNextInterval
	}

	if maxLimitInterval >= maxLimitNextInterval {
		max = maxLimitInterval
	} else {
		max = maxLimitNextInterval
	}

	return []int{min, max}

}
func merge(intervals [][]int) [][]int {

	if len(intervals) == 1 {
		return intervals
	}

	var pairs []Pair

	for i := 0; i < len(intervals); i++ {
		pairs = append(pairs, Pair{Left: intervals[i][0], Right: intervals[i][1]})
	}

	sort.Slice(pairs, func(i, j int) bool {
		return pairs[i].Left < pairs[j].Left
	})

	var output [][]int

	interval := pairs[0]
	for i := 1; i < len(pairs); i++ {
		nextInterval := pairs[i]
		intervalsCollide := areIntervalsCollide(interval, nextInterval)

		if intervalsCollide {
			newInterval := createNewInterval(interval, nextInterval)
			interval = Pair{Left: newInterval[0], Right: newInterval[1]}
		} else {
			output = append(output, []int{interval.Left, interval.Right})
			interval = pairs[i]
		}
	}
	output = append(output, []int{interval.Left, interval.Right})

	return output
}

type Pair struct {
	Left  int
	Right int
}

func main() {
	intervals := [][]int{{1, 4}, {0, 2}, {3, 5}}

	fmt.Println(merge(intervals))
}
