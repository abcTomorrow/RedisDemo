package com.wojiushiwo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wojiushiwo.util.RedisStringUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/resources")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class RedisStringUtilTest {
	@Autowired
	private RedisStringUtil redisStringUtil;

	@Test
	public void add() {
		redisStringUtil.add("name", "wojiushiwo");
	}

	@Test
	public void get() {
		String str = redisStringUtil.get("name");
		System.out.println(str);
	}

	@Test
	public void append() {
		// 会追加 key存在
		Integer num = redisStringUtil.append("name", "我就是我");
		System.out.println("总字符个数:" + num);
		Integer newNum = redisStringUtil.append("age", "11");
		System.out.println("总字符个数:" + newNum);
	}

	@Test
	public void size() {
		Long length = redisStringUtil.len("name");
		System.out.println("总长度:" + length);
	}

	@Test
	public void del() {
		redisStringUtil.del("name");
		String str = redisStringUtil.get("name");
		System.out.println("删除完毕，测试取得数据：" + str);
	}
}
