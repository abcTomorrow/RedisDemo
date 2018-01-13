package com.wojiushiwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wojiushiwo.util.RedisHashUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/resources")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class RedisHashUtilTest {
	@Autowired
	private RedisHashUtil redisHashUtil;
	private static final String HASH_NAME = "myHash";

	@Test
	public void add() {
		redisHashUtil.add(HASH_NAME, "name", "wojiushiwo");
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("age", "25");
		map.put("hello", "redis");
		redisHashUtil.addAll(HASH_NAME, map);
		redisHashUtil.addIfAbsent(HASH_NAME, "name", "new");
	}

	@Test
	public void get() {
		String str = (String) redisHashUtil.get(HASH_NAME, "name");
		System.out.println(str);
		// 获取keys
		Set<Object> keys = redisHashUtil.getKeys(HASH_NAME);
		for (Object obj : keys) {
			System.out.println("键值:" + obj);
		}
		// 获取value
		List<Object> values = redisHashUtil.getValues(HASH_NAME);
		for (Object obj : values) {
			System.out.println("value值:" + obj);
		}
	}

	@Test
	public void multiGet() {
		List<Object> hashKeys = new ArrayList<Object>();
		hashKeys.add("name");
		hashKeys.add("age");
		hashKeys.add("hello");
		List<Object> multiGet = redisHashUtil.multiGet(HASH_NAME, hashKeys);
		if (multiGet != null) {
			for (Object obj : multiGet) {
				System.out.print(obj + " ");
			}
		}
	}

	@Test
	public void list() {
		Map<Object, Object> map = redisHashUtil.list(HASH_NAME);
		if (map != null) {
			for (Entry<Object, Object> datas : map.entrySet()) {
				System.out.print(datas.getKey() + ":" + datas.getValue() + " ");
			}
		}
	}

	@Test
	public void size() {
		Long length = redisHashUtil.length(HASH_NAME);
		System.out.println("总长度:" + length);
	}

	@Test
	public void del() {
		Object[] hashKeys = { "name" };
		Long deleteNum = redisHashUtil.delete(HASH_NAME, hashKeys);
		System.out.println("删除元素的个数:" + deleteNum);
	}
}
