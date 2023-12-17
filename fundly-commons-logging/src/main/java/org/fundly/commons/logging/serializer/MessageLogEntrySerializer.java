package org.fundly.commons.logging.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import org.fundly.commons.logging.model.MessageLogEntry;

public class MessageLogEntrySerializer extends JsonSerializer<MessageLogEntry> {
  @Override
  public void serialize(MessageLogEntry messageLogEntry,
                        JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
      throws IOException {
    System.out.println("checking json generator" + jsonGenerator.getCurrentValue().toString());
  }
}
