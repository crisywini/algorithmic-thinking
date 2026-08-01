package main

import (
	"bufio"
	"fmt"
	"io"
	"strings"
)

type Pair struct {
	First  int
	Second int
}

/*
 * Complete the 'dayOfProgrammer' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts INTEGER year as parameter.


 The transition from the Julian to Gregorian calendar system occurred in 1918, when the next day after January 31st was February 14th.
  This means that in 1918, February 14th was the 32nd day of the year in Russia.
*/

func dayOfProgrammer(year int32) string {
	// Write your code here

	monthsLeapYear := []Pair{{First: 1, Second: 31}, {First: 2, Second: 29}, {First: 3, Second: 31}, {First: 4, Second: 30}, {First: 5, Second: 31}, {First: 6, Second: 30}, {First: 7, Second: 31}, {First: 8, Second: 31}, {First: 9, Second: 30}, {First: 10, Second: 31}, {First: 11, Second: 30}, {First: 12, Second: 31}}

	months := []Pair{{First: 1, Second: 31}, {First: 2, Second: 28}, {First: 3, Second: 31}, {First: 4, Second: 30}, {First: 5, Second: 31}, {First: 6, Second: 30}, {First: 7, Second: 31}, {First: 8, Second: 31}, {First: 9, Second: 30}, {First: 10, Second: 31}, {First: 11, Second: 30}, {First: 12, Second: 31}}

	months1918 := []Pair{{First: 1, Second: 31}, {First: 2, Second: 15}, {First: 3, Second: 31}, {First: 4, Second: 30}, {First: 5, Second: 31}, {First: 6, Second: 30}, {First: 7, Second: 31}, {First: 8, Second: 31}, {First: 9, Second: 30}, {First: 10, Second: 31}, {First: 11, Second: 30}, {First: 12, Second: 31}}

	dayOfTheProgrammer := 256
	var monthExpected int
	var yearExpected int32
	var dayExpected int
	if year >= 1700 && year <= 1917 {
		//Julian Calendar for Russia
		if year%4 == 0 {
			// Leap Year
			pivot := 0
			for i := 0; i < len(monthsLeapYear); i++ {
				pivot = pivot + monthsLeapYear[i].Second
				if pivot == dayOfTheProgrammer {
					monthExpected = monthsLeapYear[i].First
					dayExpected = monthsLeapYear[i].Second
					yearExpected = year
					break
				} else if pivot > dayOfTheProgrammer {

					lastPivot := pivot - monthsLeapYear[i].Second
					daysToSum := dayOfTheProgrammer - lastPivot

					dayExpected = daysToSum
					monthExpected = monthsLeapYear[i].First
					yearExpected = year
					break
				}
			}
		} else {
			pivot := 0
			for i := 0; i < len(months); i++ {
				pivot = pivot + months[i].Second
				if pivot == dayOfTheProgrammer {
					monthExpected = months[i].First
					dayExpected = months[i].Second
					yearExpected = year
					break
				} else if pivot > dayOfTheProgrammer {

					lastPivot := pivot - months[i].Second
					daysToSum := dayOfTheProgrammer - lastPivot

					dayExpected = daysToSum
					monthExpected = months[i].First
					yearExpected = year
					break
				}
			}
		}
	} else if year == 1918 {
		pivot := 0
		for i := 0; i < len(months1918); i++ {
			pivot = pivot + months1918[i].Second
			if pivot == dayOfTheProgrammer {
				monthExpected = months1918[i].First
				dayExpected = months1918[i].Second
				yearExpected = year
				break
			} else if pivot > dayOfTheProgrammer {

				lastPivot := pivot - months1918[i].Second
				daysToSum := dayOfTheProgrammer - lastPivot

				dayExpected = daysToSum
				monthExpected = months1918[i].First
				yearExpected = year
				break
			}
		}
	} else {
		if year%400 == 0 || (year%100 != 0 && year%4 == 0) {
			pivot := 0
			for i := 0; i < len(monthsLeapYear); i++ {
				pivot = pivot + monthsLeapYear[i].Second
				if pivot == dayOfTheProgrammer {
					monthExpected = monthsLeapYear[i].First
					dayExpected = monthsLeapYear[i].Second
					yearExpected = year
					break
				} else if pivot > dayOfTheProgrammer {

					lastPivot := pivot - monthsLeapYear[i].Second
					daysToSum := dayOfTheProgrammer - lastPivot

					dayExpected = daysToSum
					monthExpected = monthsLeapYear[i].First
					yearExpected = year
					break
				}
			}
		} else {
			pivot := 0
			for i := 0; i < len(months); i++ {
				pivot = pivot + months[i].Second
				if pivot == dayOfTheProgrammer {
					monthExpected = months[i].First
					dayExpected = months[i].Second
					yearExpected = year
					break
				} else if pivot > dayOfTheProgrammer {

					lastPivot := pivot - months[i].Second
					daysToSum := dayOfTheProgrammer - lastPivot

					dayExpected = daysToSum
					monthExpected = months[i].First
					yearExpected = year
					break
				}
			}
		}
	}

	return fmt.Sprintf("%02d.%02d.%d", dayExpected, monthExpected, yearExpected)
}

func main() {
	fmt.Println(dayOfProgrammer(2016))
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
