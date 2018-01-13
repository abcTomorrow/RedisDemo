package com.wojiushiwo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wojiushiwo.util.RedisListUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/resources")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class RedisListUtilTest {
	@Autowired
	private RedisListUtil redisListUtil;
	private static final String LIST_NAME = "myList";

	@Test
	public void add() {
		redisListUtil.addAtLeft(LIST_NAME, "a");
		redisListUtil.addAtRight(LIST_NAME, "b");
	}

	@Test
	public void addAll() {
		String[] leftValues = { "1", "2", "3" };
		redisListUtil.addAllAtLeft(LIST_NAME, leftValues);
		String[] rightValues = { "4", "5", "6" };
		redisListUtil.addAllAtRight(LIST_NAME, rightValues);
	}

	@Test
	public void get() {
		String str = redisListUtil.index(LIST_NAME, 0);
		System.out.println(str);
	}

	@Test
	public void set() {
		redisListUtil.set(LIST_NAME, 0, "set");
	}

	@Test
	public void list() {
		List<String> list = redisListUtil.list(LIST_NAME, 0, -1);
		if (list != null) {
			for (String str : list) {
				System.out.print(str + " ");
			}
		}
	}

	@Test
	public void size() {
		Long length = redisListUtil.length(LIST_NAME);
		System.out.println("总长度:" + length);
	}

	@Test
	public void del() {
		String leftStr = redisListUtil.getAtLeft(LIST_NAME);
		System.out.println("从头部位取得数据：" + leftStr);
		String rightStr = redisListUtil.getAtRight(LIST_NAME);
		System.out.println("从尾部位取得数据：" + rightStr);
	}
}
