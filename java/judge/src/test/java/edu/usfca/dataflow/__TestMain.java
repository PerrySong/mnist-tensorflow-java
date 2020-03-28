package edu.usfca.dataflow;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

// NOTE: You should not modify this file, as the grading system will use this file as-is (and additional hidden tests)
// in order to grade your submission.
public class __TestMain {
  @Test
  public void testGetUserToken() {
    assertNotEquals("", Main.getUserEmail());
  }

  @Test
  public void testAnswers() {
    assertNotEquals(0, Main.getAnswerForQuestion1());
    assertNotEquals(0, Main.getAnswerForQuestion2());
    assertNotEquals(0, Main.getAnswerForQuestion3());
    assertNotEquals("", Main.getAnswerForQuestion4());
    assertNotEquals("", Main.getAnswerForQuestion5());
  }
}
