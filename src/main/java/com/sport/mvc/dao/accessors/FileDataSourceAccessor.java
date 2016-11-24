package com.sport.mvc.dao.accessors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public abstract class FileDataSourceAccessor {

    public BufferedReader load() throws FileNotFoundException{
        File file = new File(this.getDataSourceName());
        return new BufferedReader(new FileReader(file));
    }

    public abstract String getDataSourceName();
}
