package com.wojiushiwo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * string������
 * 
 * @author meng
 * 
 */
@Component
public class RedisStringUtil {
	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * ��������
	 * 
	 * @param key
	 *            ��
	 * @param value
	 *            ֵ
	 */
	public void add(String key, String value) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(value, "value����Ϊ��");
		redisTemplate.opsForValue().set(key, value);
	}

	/**
	 * ��ȡָ������ֵ
	 * 
	 * @param key
	 *            ��
	 * @return ����Ӧ��ֵ
	 */
	public String get(String key) {
		Assert.notNull(key, "key����Ϊ��");
		return redisTemplate.opsForValue().get(key);
	}

	/**
	 * ׷������ ���������� ���������
	 * 
	 * @param key
	 *            ��
	 * @param value
	 *            ֵ
	 * @return Ӱ�������
	 */
	public Integer append(String key, String value) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(value, "value����Ϊ��");
		return redisTemplate.opsForValue().append(key, value);
	}

	/**
	 * ɾ��ĳkey������
	 * 
	 * @param key
	 *            ��
	 */
	public void del(String key) {
		Assert.notNull(key, "key����Ϊ��");
		redisTemplate.delete(key);
	}

	/**
	 * ��ȡָ��key�����ݵĳ���
	 * 
	 * @param key
	 *            ��
	 * @return ���ݳ���
	 */
	public Long len(String key) {
		Assert.notNull(key, "key����Ϊ��");
		return redisTemplate.opsForValue().size(key);
	}
}
