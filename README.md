# PrimeNumberService

Problem statment :

# Outline

Write a RESTful service which calculates and returns all the prime numbers up to and including a number provided.

# Example

The REST call would look something like http://your.host.com/primes/10 and should return JSON content:

{

  "Initial":  10,

  "Primes": [2,3,5,7]

}

What is Prime Number ?
A whole number greater than 1 that cannot be exactly divided by any whole number other than itself and 1 (e.g. 2, 3, 5, 7, 11).
"prime numbers are very useful in cryptography"

Example :
The prime numbers from 1 to 100 are: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97. Why is 1 not a prime number? 1 is not a prime number because it has only one factor, namely 1. Prime numbers need to have exactly two factors.

Implemented Algorithm - Sieve of Eratosthenes algorithm 

This implementation uses the Sieve of Eratosthenes algorithm to generate all prime numbers up to the given input n. The generatePrimes method takes an integer n as input and returns an ArrayList<Integer> containing all prime numbers up to n.
The isComposite array is used to mark all composite numbers in the range [2, n]. Initially, all elements of isComposite are false, indicating that all numbers are assumed to be prime. Starting from the first prime number, 2, the method marks all multiples of 2 as composite by setting their corresponding elements in isComposite to true. It then moves on to the next unmarked prime number, 3, and marks all its multiples as composite. This process continues until all prime numbers up to n have been found.
Note that this implementation is not very efficient for very large values of n, as it stores all prime numbers in an ArrayList. For larger values of n, it may be more appropriate to use a different algorithm, such as the Sieve of Atkin or the Miller-Rabin primality test.

The Sieve of Eratosthenes is an algorithm for finding all prime numbers up to a given limit by iteratively marking the multiples of each prime, starting with 2, and then proceeding to the next unmarked number until all multiples of primes less than or equal to the square root of the limit have been marked.

here's the pseudocode for the Sieve of Eratosthenes algorithm to generate prime numbers up to a given number n, and a Java implementation:

Pseudocode:

Create a boolean array "isPrime[1...n]" and initialize all entries it to true.
Iterate from i=2 to ii<=n:
a. If isPrime[i] is true, then iterate from j=i2 to j<=n, incrementing j by i:
i. Set isPrime[j] to false
Print all prime numbers from 2 to n where isPrime[i] is true.


Implement using Spring Boot Framework with Spring MVC framework supported 
This project is "Ready to test", to test make sure server is running in your local port
This project written in Java 8

This project built in Maven to build, test and run.

This project having strong unit and integration tests.

This project running in that the service hosted in tomat and spring boot server.

Please find the following screenshot examples where I ran this projet in my local port 8080 as I've tested unit and integration test cases as well as tested in Postman

GET : http://localhost:8080/primes/10
<img width="1015" alt="Screenshot 2023-03-22 at 05 33 40" src="https://user-images.githubusercontent.com/16776911/226811638-34c09d4d-9029-4daa-84f7-4f0339f6a104.png">

GET : http://localhost:8080/primes/1
<img width="1015" alt="Screenshot 2023-03-22 at 05 34 18" src="https://user-images.githubusercontent.com/16776911/226811738-65aa0d69-6a3e-44ea-8792-a2d6f2e5c699.png">

GET : http://localhost:8080/primes/0
<img width="1015" alt="Screenshot 2023-03-22 at 05 35 22" src="https://user-images.githubusercontent.com/16776911/226811881-e8d6f6fc-7380-4cf4-9c72-34a5a15e9c68.png">


GET : http://localhost:8080/primes/100
<img width="1015" alt="Screenshot 2023-03-22 at 05 35 46" src="https://user-images.githubusercontent.com/16776911/226812003-8304e3a5-9a59-4d57-a2e3-643f9cb2609a.png">


GET : http://localhost:8080/primes/-45
<img width="1015" alt="Screenshot 2023-03-22 at 05 36 36" src="https://user-images.githubusercontent.com/16776911/226812065-b7543398-1752-432d-955e-5c28dea18700.png">


Please use your local port (example : 8080) to run this project in your local machine .
Project built in maven. 

