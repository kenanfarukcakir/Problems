package main

import (
	"fmt"
)

func searchPatternWithSlide(text, pattern string) []int {
	foundIndexes := []int{}

	lenT := len(text)
	lenP := len(pattern)

	if len(text) < len(pattern) {
		return foundIndexes
	}

	i := 0 // slide pointer

	for ; i <= lenT-lenP; i++ {
		found := true
		for j := 0; j < lenP; j++ {
			if text[i+j] != pattern[j] {
				found = false
				break
			}
		}

		if found {
			foundIndexes = append(foundIndexes, i)
		}
	}

	return foundIndexes

}

func main() {
	fmt.Println(searchPatternWithSlide("abababcabcdabeabc", "abc"))
}
