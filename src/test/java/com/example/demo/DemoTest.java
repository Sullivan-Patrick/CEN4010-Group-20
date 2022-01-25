package com.example.demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DemoTest {

  Demo demo = new Demo();

  @BeforeEach
  public void setUp() {
    System.out.println("Tests beginning");
  }

  @Test
  public void shouldBeADemo() {
    assertThat(demo, is(instanceOf(Demo.class)));
  }
}
