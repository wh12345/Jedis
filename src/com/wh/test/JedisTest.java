package com.wh.test;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {
	@Test
	public void test1() {
		Jedis jedis = new Jedis("192.168.1.9",6379);
		jedis.set("key1", "婷婷");
		System.out.println(jedis.get("key1"));
		jedis.close();
	}
	
	@Test
	public void testJedisPool() {
		JedisPool pool  = new JedisPool("192.168.1.9",6379);
		Jedis jedis  = pool.getResource();
		jedis.set("key2", "小王");
		System.out.println(jedis.get("key2"));
		jedis.close();
	}
}
