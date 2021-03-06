package cn.harry12800.common.core.serial;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.redisson.client.codec.BaseCodec;
import org.redisson.client.codec.Codec;
import org.redisson.client.codec.StringCodec;
import org.redisson.client.handler.State;
import org.redisson.client.protocol.Decoder;
import org.redisson.client.protocol.Encoder;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * protobuf存储解析
 *
 * @param <T>
 * @author ww
 */
public class ProtoBufCodec<T> extends BaseCodec {
    private static final Map<Class<?>, ProtoBufCodec> map = new ConcurrentHashMap<>();
    private Class<T> type;

    private ProtoBufCodec(Class<T> t) {
        this.type = t;
    }

    public static <T> ProtoBufCodec instance(Class<T> t) {
        ProtoBufCodec codec = map.get(t);
        if (codec == null) {
            synchronized (ProtoBufCodec.class) {
                codec = map.get(t);
                if (codec == null) {
                    codec = new ProtoBufCodec<T>(t);
                    map.put(t, codec);
                }
            }
        }
        return codec;
    }

    private final Encoder encoder = new Encoder() {
        @Override
        public ByteBuf encode(Object in) throws IOException {
            byte[] data = PbUtil.encode(in);
            ByteBuf byteBuf = Unpooled.buffer(data.length);
            byteBuf.writeBytes(data);
            return byteBuf;
        }
    };

    private final Decoder<Object> decoder = new Decoder<Object>() {
        @Override
        public Object decode(ByteBuf buf, State state) {
            byte[] data = new byte[buf.readableBytes()];
            buf.readBytes(data);
            T t = PbUtil.decode(data, type);
            return t;
        }
    };

    @Override
    public Decoder<Object> getMapValueDecoder() {
        return decoder;
    }

    @Override
    public Encoder getMapValueEncoder() {
        return encoder;
    }

    @Override
    public Decoder<Object> getMapKeyDecoder() {
        return StringCodec.INSTANCE.getMapKeyDecoder();
    }

    @Override
    public Encoder getMapKeyEncoder() {
        return StringCodec.INSTANCE.getMapKeyEncoder();
    }

    @Override
    public Decoder<Object> getValueDecoder() {
        return decoder;
    }

    @Override
    public Encoder getValueEncoder() {
        return encoder;
    }
}
