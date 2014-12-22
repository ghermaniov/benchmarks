package main

import "fmt"
import "math"
import "time"

func main() {
	start := time.Now()
		
	var a [1000000000]float64
	
	for i := 0; i < 1000000000; i++ {
		a[i] = math.Log(float64(i + 1));
	}
	
	elapsed := time.Since(start)
    fmt.Printf("Execution took %s", elapsed)
    
}
