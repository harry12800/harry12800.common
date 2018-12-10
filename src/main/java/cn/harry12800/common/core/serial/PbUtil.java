package cn.harry12800.common.core.serial;


import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * protobuf 工具类
 *
 * @author ww
 */
public class PbUtil {
    public static <T> byte[] encode(T obj) {
        Class<?> cls = obj.getClass();
        Schema<?> schema = getSchema(cls);
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        byte[] data = ProtobufIOUtil.toByteArray(obj, (Schema<T>) schema, buffer);
        return data;
    }

    public static <T> T decode(byte[] data, Class<T> t) {
        try {
            T object = t.newInstance();
            Schema<?> schema = getSchema(t);
            ProtobufIOUtil.mergeFrom(data, object, (Schema<T>) schema);
            return object;
        } catch (Exception e) {
            return null;
        }
    }

    private static Schema<?> getSchema(Class<?> cls) {
        Schema<?> schema = map.get(cls);
        if (schema == null) {
            synchronized (PbUtil.class) {
                if (schema == null) {
                    schema = RuntimeSchema.getSchema(cls);
                    map.put(cls, schema);
                }
            }
        }
        return schema;
    }

    static Map<Class<?>, Schema<?>> map = new ConcurrentHashMap<>();
}
