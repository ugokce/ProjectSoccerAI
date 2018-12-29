package arhrs.util;

import org.lwjgl.Sys;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by dindar.oz on 9/29/2017.
 */
public class RandomUtils {
    static Random rng = new SecureRandom(new byte[]{(byte) System.currentTimeMillis()});

    public static double randomBinomial()
    {
        return  -1 + rng.nextDouble()*2; //rng.nextDouble()-rng.nextDouble();
    }

    public static double nextDouble() {
        return rng.nextDouble();
    }

    public static int nextInt(int size) {


        return rng.nextInt(size);
    }

    public static long[] nextLongArray(int length) {
        long arr[] = new long[length];
        for (int i = 0; i <length; i++) {
            arr[i] = rng.nextLong();
        }
        return arr;
    }
}
