package ru.stqa.javacourse.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by kostoa on 5/12/2017.
 */
public class PrimesTests {

  @Test
  public void testPrimes() {
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test
  public void testNotPrimes() {
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }

  @Test(enabled = false)
  public void testPrimesLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }

  @Test(enabled = false)
  public void testPrimesWhile() {
    Assert.assertTrue(Primes.isPrimeWhile(Integer.MAX_VALUE));
  }

  @Test(enabled = false)
  public void testNotPrimesWhile() {
    Assert.assertFalse(Primes.isPrimeWhile(Integer.MAX_VALUE - 2));
  }
}
