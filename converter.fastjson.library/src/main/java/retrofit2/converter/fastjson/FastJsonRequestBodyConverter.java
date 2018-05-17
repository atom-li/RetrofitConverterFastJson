package retrofit2.converter.fastjson;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 *
 * @author atomone
 * @date 2017/3/16
 * FastJsonRequestBodyConverter
 */
public class FastJsonRequestBodyConverter<T> implements Converter<T, RequestBody> {

    /**
     * 请求数据是字符串类型
     */
    private static final MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/plain; charset=UTF-8");
    /**
     * 请求数据是json类型
     */
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=UTF-8");

    /**
     * @param value T
     * @return json
     * @throws IOException
     */
    @Override
    public RequestBody convert(T value) throws IOException {
        if (value instanceof String) {
            return RequestBody.create(MEDIA_TYPE_TEXT, (String) value);
        }
        return RequestBody.create(MEDIA_TYPE_JSON, JSON.toJSONBytes(value));
    }
}
