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
import com.alibaba.fastjson.TypeReference;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @author atomOne
 * @date 02/07/2017 18:23
 * <a href="https://github.com/atom-li">Follow me</a>
 */
public class FastJsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Type type;

    public FastJsonResponseBodyConverter(Type type) {
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        Type stringType = new TypeReference<String>() {
        }.getType();
        String utf8Str = value.string();
        try {
            if (stringType == type) {
                return (T) utf8Str;
            } else {
                return JSON.parseObject(utf8Str, type);
            }
        } finally {
            value.close();
        }
    }
}
