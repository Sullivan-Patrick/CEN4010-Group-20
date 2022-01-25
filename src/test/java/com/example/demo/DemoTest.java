package com.example.demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DemoTest {

  Demo demo = new Demo();

  @Before
  public void setUp() {
    System.out.println("Tests beginning");
  }

  @Test
  public void shouldBeADemo() {
    for(int i = 0; i < 10000; i++)
    System.out.println("Test entered");
    assertThat(demo, is(instanceOf(Demo.class)));
  }
}
