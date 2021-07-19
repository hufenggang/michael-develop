package cn.michael.develop.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by hufenggang on 2021/6/28.
 */
public class RedisJava {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.70.21.22");
        jedis.auth("Cly9hQ4rfqdSwgY0");
        System.out.println(jedis.ping());
    }
}
