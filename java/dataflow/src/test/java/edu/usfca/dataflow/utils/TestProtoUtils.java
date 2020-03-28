package edu.usfca.dataflow.utils;

import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;

import edu.usfca.protobuf.Common.OsType;

import static org.junit.Assert.*;


// NOTE: If your IDE complains about the protobuf imports above,
// run `gradle test` under <your repo>/java directory to generate Java files from proto files.
// Then, reload your IDE or follow the instructions from your gradle plugin (for intelliJ or Eclipse).

public class TestProtoUtils {
  // TODO: To add your own unit tests.

  @Test
  public void testDummy() {
    // Feel free to remove this dummy unit test.
    OsType testVariable = OsType.ANDROID;
    assertEquals(OsType.ANDROID, testVariable);
    assertNotEquals(OsType.IOS, testVariable);
  }

  @Test(expected = IllegalArgumentException.class)
  public void __sharable_test_003() {
    try {
      ProtoUtils.getJsonFromMessage(null);
    } catch (InvalidProtocolBufferException e) {
      fail();
    }
  }
}
