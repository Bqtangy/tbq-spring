package com.study.code;


import java.security.Key;
import java.util.*;

/**
 *
 *
 * Created by Administrator on 2017/9/27.
 */
public class CaseInsensitiveKeyMap<V> extends AbstractMap<String,V> {

    private   static  final StringManager  sm = StringManager.getManager(CaseInsensitiveKeyMap.class);

    private final Map<Key,V>  map = new HashMap<Key, V>();

    @Override
    public V get(Object key){
        return map.get(Key.getInstance(key));
    }

    @Override
    public V put(String key, V value){
        Key caseInsensitiveKey = Key.getInstance(key);
        if(caseInsensitiveKey == null){
            throw  new NullPointerException(sm.getString("caseInsensitiveKeyMap.nullKey"));
        }
        return map.put(caseInsensitiveKey,value);
    }

    @Override
    public void  putAll(Map<? extends String,? extends V> m){
        super.putAll(m);
    }

    @Override
    public boolean containsKey(Object key){
        return  map.containsKey(Key.getInstance(key));
    }

    @Override
    public V remove(Object key){
        return map.remove(Key.getInstance(key));
    }

   /* @Override
    public Set<Entry<String,V>>  entrySet(){
        return  new EntrySet<String,V>(map.entrySet());
    }

    private static class EntrySet<V> extends  AbstractSet<Entry<String,V>>{


    }*/

    public Set<Entry<String, V>> entrySet() {
        return null;
    }
    private static class Key{

        private final String key;
        private final String lcKey;

        private Key(String key){
            this.key = key;
            this.lcKey = key.toLowerCase(Locale.ENGLISH);
        }

        public String getKey(){
            return key;
        }

        @Override
        public int hashCode(){
            return lcKey.hashCode();
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj){
                return true;
            }
            if(obj == null){
                return false;
            }
            if(getClass() != obj.getClass()){
                return false;
            }
            Key other= (Key)obj;
            return lcKey.equals(other.lcKey);
        }

        public static Key getInstance(Object o){
            if(o instanceof String){
                return new Key((String) o);
            }
            return  null;
        }









    }
}
