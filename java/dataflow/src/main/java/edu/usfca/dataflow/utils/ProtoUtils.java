package edu.usfca.dataflow.utils;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;

/**
 * This class contains various utility methods that deal with Proto messages.
 */
public class ProtoUtils {
  /**
   * Returns the number of bytes required to encode a given proto message {@code msg}.
   * 
   * @throws IllegalArgumentException if msg is null.
   */
  static int getSerializedSize(Message msg) throws IllegalArgumentException {
    // TODO: Read the Javadoc/code of toByteArray() and getSerializedSize().
    if (msg == null) {
      throw new IllegalArgumentException();
    }
    return msg.getSerializedSize();
  }

  /**
   * Returns Json representation (in String with no insignificant whitespace(s)) of a given proto message {@code msg}.
   * 
   * @throws IllegalArgumentException if msg is null.
   * @throws InvalidProtocolBufferException if msg contains types that cannot be processed/printed.
   */
  static String getJsonFromMessage(Message msg) throws InvalidProtocolBufferException, IllegalArgumentException {
    // TODO: Read the Javadoc/code of JsonFormat class.
    if (msg == null) {
      throw new IllegalArgumentException();
    }
    return JsonFormat.printer().omittingInsignificantWhitespace().preservingProtoFieldNames().print(msg);
  }
}
