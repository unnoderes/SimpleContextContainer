package io.unnode.core.support;

import cn.hutool.core.lang.Assert;
import io.unnode.core.Resource;
import io.unnode.core.ResourceLoader;

import java.net.MalformedURLException;
import java.net.URL;

public class DefaultResourceLoader implements ResourceLoader {

    @Override
    public Resource getResource(String location) {
        Assert.notNull(location,"目标目录为空");
        // 判断是否为ClassPath、URL以及文件
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }

    }
}
