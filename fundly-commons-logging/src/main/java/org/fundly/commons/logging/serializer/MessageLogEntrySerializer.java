package org.fundly.commons.logging.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import org.fundly.commons.logging.model.MessageLogEntry;

public class MessageLogEntrySerializer extends JsonSerializer<MessageLogEntry> {
  @Override
  public void serialize(MessageLogEntry messageLogEntry,
                        JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
      throws IOException {
    jsonGenerator.writeStartObject();
    jsonGenerator.writeStringField("message", messageLogEntry.getMessage());
    jsonGenerator.writeEndObject();
  }
}
