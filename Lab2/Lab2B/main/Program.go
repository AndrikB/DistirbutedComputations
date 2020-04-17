package main

import (
	"fmt"
	"math/rand"
	"time"
)

type StolenProperty struct {
	index int
	price int
}

var queue1 []StolenProperty
var queue2 []StolenProperty

var r = rand.New(rand.NewSource(time.Now().UnixNano()))

func Ivanov() {
	i := 0
	for ; ; {
		stolenProperty := StolenProperty{i, 0}
		n := r.Intn(3000) + 1000
		time.Sleep(time.Duration(n) * time.Millisecond)
		stolenProperty.price = r.Intn(50)
		fmt.Println("Ivanov: steal ", stolenProperty)
		queue1 = append(queue1, stolenProperty)
		i = i + 1
	}
}

func Pertov() {
	for ; ; {
		if len(queue1) == 0 {
			time.Sleep(10 * time.Millisecond)
			continue
		}
		stolenProperty := queue1[0] // First element
		queue1 = queue1[1:]         // Dequeue

		n := r.Intn(3000) + 2000
		time.Sleep(time.Duration(n) * time.Millisecond)

		fmt.Println("\t\t\t\t\t\tPetrov: transport ",stolenProperty)
		queue2 = append(queue2, stolenProperty)

	}
}

func Necheporchuk() {
	var sum = 0
	for ; ; {
		if len(queue2) == 0 {
			time.Sleep(10 * time.Millisecond)
			continue
		}
		stolenProperty := queue2[0] // First element
		queue2 = queue2[1:]         // Dequeue

		n := r.Intn(1000) + 500
		time.Sleep(time.Duration(n) * time.Millisecond)

		sum = sum + stolenProperty.price
		fmt.Println("\t\t\t\t\t\t\t\t\t\t\t\tNecheporchuk: calculated ", stolenProperty, "total price: ", sum)
	}
}

func main() {
	var input = make(chan int)
	go Ivanov()
	go Pertov()
	Necheporchuk()

	fmt.Println(<-input)
}
