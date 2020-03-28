package edu.usfca.dataflow;

public class Main {
  // Make sure you change USER_EMAIL below to your @dons email address.
  final private static String USER_EMAIL = "psong4@dons.usfca.edu";

  static String getUserEmail() {
    return USER_EMAIL;
  }

  // Fix these methods to return correct answers.
  static int getAnswerForQuestion1() {
    return 8;
  }

  static int getAnswerForQuestion2() {
    return 12;
  }

  static int getAnswerForQuestion3() {
    return 41;
  }

  static String getAnswerForQuestion4() {
    return "Friday";
  }

  static String getAnswerForQuestion5() {
    return "Search";
  }

  // main method is not used for this specific assignment.
  public static void main(String[] args) {
    System.out.println("hello, world!");
    for (String arg : args) {
      System.out.println("\t" + arg);
    }
  }
}
