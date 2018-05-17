package retrofit2.converter.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @author atomone
 * @date 2017/3/16
 * FastJsonResponseBodyConverter
 */
public class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Type type;

    public FastJsonResponseBodyConverter(Type type) {
        this.type = type;
    }

    /**
     * @param value ResponseBody
     * @return T
     * @throws IOException
     */
    @Override
    public T convert(ResponseBody value) throws IOException {
        Type stringType = new TypeReference<String>() {
        }.getType();
        String utf8Str = value.string();
        if (stringType == type) {
            return (T) utf8Str;
        } else {
            return JSON.parseObject(utf8Str, type);
        }
    }
}
