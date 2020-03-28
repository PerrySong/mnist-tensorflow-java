package edu.usfca.dataflow.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.google.protobuf.InvalidProtocolBufferException;

import edu.usfca.protobuf.Common.OsType;
import edu.usfca.protobuf.Common.UserId;

// NOTE: You should not modify this file, as the grading system will use this file as-is (and additional hidden tests)
// in order to grade your submission.
public class __TestProtoUtils {
  @Test
  public void testGetSerializedSize() {
    UserId.Builder uid = UserId.newBuilder().setOs(OsType.ANDROID).setUuid("be7a454e-dc38-438f-b574-df1f545980d7");
    assertEquals(40, ProtoUtils.getSerializedSize(uid.build()));

    uid.setOs(OsType.IOS);
    assertEquals(40, ProtoUtils.getSerializedSize(uid.build()));

    uid.setWebid("longer-than-be7a454e-dc38-438f-b574-df1f545980d7");
    assertEquals(52, ProtoUtils.getSerializedSize(uid.build()));

    uid.setWebid("much-shorter");
    assertEquals(16, ProtoUtils.getSerializedSize(uid.build()));
  }

  @Test
  public void testGetJsonFromMessage() {
    UserId.Builder uid = UserId.newBuilder().setOs(OsType.ANDROID).setUuid("be7a454e-dc38-438f-b574-df1f545980d7");

    try {
      assertEquals("{\"os\":\"ANDROID\",\"uuid\":\"be7a454e-dc38-438f-b574-df1f545980d7\"}",
          ProtoUtils.getJsonFromMessage(uid.build()));
    } catch (InvalidProtocolBufferException e) {
      e.printStackTrace();
      fail("InvalidProtocolBufferException was thrown (test case 1)");
    }

    uid.setOs(OsType.IOS);
    uid.clearUuid();
    uid.setWebid("web");

    try {
      assertEquals("{\"os\":\"IOS\",\"webid\":\"web\"}", ProtoUtils.getJsonFromMessage(uid.build()));
    } catch (InvalidProtocolBufferException e) {
      e.printStackTrace();
      fail("InvalidProtocolBufferException was thrown (test case 2)");
    }
  }
}
