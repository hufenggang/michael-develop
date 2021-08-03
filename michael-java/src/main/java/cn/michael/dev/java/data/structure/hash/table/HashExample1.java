package cn.michael.dev.java.data.structure.hash.table;

/**
 * Created by hufenggang on 2021/8/3.
 */
public class HashExample1 {

    public static int hash(String key, int tableSize) {
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            hashVal += key.charAt(i);
        }

        return hashVal % tableSize;
    }
}
