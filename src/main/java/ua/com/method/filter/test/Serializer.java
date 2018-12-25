//package ua.com.method.filter.test;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.SerializerProvider;
//import com.fasterxml.jackson.databind.ser.std.StdSerializer;
//import ua.com.method.filter.Condition;
//
//import java.io.IOException;
//
//public class Serializer extends StdSerializer<Condition> {
//
//    public Serializer() {
//        this(null);
//    }
//
//    protected Serializer(Class<Condition> t) {
//        super(t);
//    }
//
//
//    @Override
//    public void serialize(Condition condition, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//        jsonGenerator.writeStartObject();
//        jsonGenerator.writeStringField("regionLot", condition.conditionRegionLot.regionLot);
////        jsonGenerator.writeStringField("itemName", value.itemName);
////        jsonGenerator.writeNumberField("owner", value.owner.id);
//        jsonGenerator.writeEndObject();
//    }
//}
