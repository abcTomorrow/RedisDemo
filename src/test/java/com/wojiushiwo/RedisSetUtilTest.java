package com.wojiushiwo;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wojiushiwo.util.RedisSetUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/resources")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class RedisSetUtilTest {
	@Autowired
	private RedisSetUtil redisSetUtil;
	private static final String SET_NAME = "mySet";
	private static final String DEST_SET_NAME = "mySet2";

	@Test
	public void add() {
		String[] values = { "1", "2", "3", "4", "5", "6" };
		redisSetUtil.add(SET_NAME, values);
		String[] values2 = { "4", "5", "7" };
		redisSetUtil.add(DEST_SET_NAME, values2);
	}

	@Test
	public void get() {
		// 随机取出一个元素
		String str = redisSetUtil.randomMember(SET_NAME);
		System.out.println(str);
	}

	@Test
	public void remove() {
		// 随机删除一个元素
		String deleteValue = redisSetUtil.pop(SET_NAME);
		System.out.println(deleteValue);
	}

	@Test
	public void list() {
		Set<String> set = redisSetUtil.list(SET_NAME);
		if (set != null) {
			for (String str : set) {
				System.out.print(str + " ");
			}
		}
	}

	@Test
	public void size() {
		Long length = redisSetUtil.length(SET_NAME);
		System.out.println("总长度:" + length);
	}

	@Test
	public void del() {
		Object[] values = { "1", "3" };
		Long remove = redisSetUtil.remove(SET_NAME, values);
		System.out.println("删除成功元素的个数:" + remove);
	}

	@Test
	public void move() {
		Boolean isSuccess = redisSetUtil.move(SET_NAME, "2", DEST_SET_NAME);
		System.out.println("是否移动成功:" + isSuccess);
	}

	@Test
	public void inter() {
		Set<String> inter = redisSetUtil.inter(SET_NAME, DEST_SET_NAME);
		if (inter != null) {
			for (String str : inter) {
				System.out.println("交集中的元素是:" + str + " ");
			}
		}
	}

	@Test
	public void union() {
		Set<String> union = redisSetUtil.union(SET_NAME, DEST_SET_NAME);
		if (union != null) {
			for (String str : union) {
				System.out.println("并集中的元素是:" + str + " ");
			}
		}
	}

	@Test
	public void diff() {
		Set<String> diff = redisSetUtil.diff(SET_NAME, DEST_SET_NAME);
		if (diff != null) {
			for (String str : diff) {
				System.out.print("差集中的元素是:" + str + " ");
			}
		}
	}
}
