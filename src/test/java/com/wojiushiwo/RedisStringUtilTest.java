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
		// ��׷�� key����
		Integer num = redisStringUtil.append("name", "�Ҿ�����");
		System.out.println("���ַ�����:" + num);
		Integer newNum = redisStringUtil.append("age", "11");
		System.out.println("���ַ�����:" + newNum);
	}

	@Test
	public void size() {
		Long length = redisStringUtil.len("name");
		System.out.println("�ܳ���:" + length);
	}

	@Test
	public void del() {
		redisStringUtil.del("name");
		String str = redisStringUtil.get("name");
		System.out.println("ɾ����ϣ�����ȡ�����ݣ�" + str);
	}
}
