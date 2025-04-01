package io.unnode.core.support;

import io.unnode.core.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSystemResource implements Resource {

    final File file;
    final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }
    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }


    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public final String getPath() {
        return this.path;
    }
}
