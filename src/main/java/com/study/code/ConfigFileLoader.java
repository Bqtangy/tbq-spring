package com.study.code;

import java.io.*;
import java.net.URI;
import java.net.URL;

/**
 * Created by Administrator on 2017/9/27.
 */
public class ConfigFileLoader {

    private static final StringManager  sm = StringManager.getManager(ConfigFileLoader.class);

    private static final File CATALINA_BASE_FILE;

    private static final URI CATALINA_BASE_URI;

    static {
        String catalinaBase = System.getProperty("catalina.base");
        if(catalinaBase != null){
            CATALINA_BASE_FILE = new File(catalinaBase);
            CATALINA_BASE_URI = CATALINA_BASE_FILE.toURI();
        }else{
            CATALINA_BASE_URI = null;
            CATALINA_BASE_FILE = null;
        }
    }

    private ConfigFileLoader(){

    }

    public static InputStream getInputStream(String location) throws IOException {

        File  f = new File(location);
        if(!f.isAbsolute()){
            f = new File(CATALINA_BASE_FILE,location);
        }
        if(f.isFile()){
            return new FileInputStream(f);
        }
        URI  uri;
        if(CATALINA_BASE_URI != null){
            uri = CATALINA_BASE_URI.resolve(location);
        }else{
            uri = URI.create(location);
        }

        try {
            URL url = uri.toURL();
            return url.openConnection().getInputStream();
        } catch (Exception e) {
            //(sm.getString("configFileLoader.cannotObtainURL",location),e);
            throw  new IOException();
        }
     }
    }
