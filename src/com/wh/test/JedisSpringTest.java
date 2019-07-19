package com.wh.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisSpringTest {
	private ApplicationContext applicationContext;
	@Before
	public void setup()throws Exception{
		applicationContext = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
	}
	@Test
	public void test() {
		JedisPool pool = (JedisPool) applicationContext.getBean("jedisPool");
		Jedis jedis  = pool.getResource();
		jedis.del("key2");
		System.out.println(jedis.get("key2"));
		jedis.close();
		pool.close();
	}

}
