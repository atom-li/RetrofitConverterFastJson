/**
 * Copyright 2017 atomone
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package retrofit2.converter.fastjson;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * ================================================
 * Created by atomone on 02/06/2017 18:23
 * <a href="https://github.com/atom-li">Follow me</a>
 * ================================================
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

    @Override
    public RequestBody convert(T value) throws IOException {
        if (value instanceof String) {
            return RequestBody.create(MEDIA_TYPE_TEXT, (String) value);
        }
        return RequestBody.create(MEDIA_TYPE_JSON, JSON.toJSONBytes(value));
    }
}
