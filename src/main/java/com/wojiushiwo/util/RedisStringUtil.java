package com.wojiushiwo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * string工具类
 * 
 * @author meng
 * 
 */
@Component
public class RedisStringUtil {
	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * 插入数据
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	public void add(String key, String value) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(value, "value不能为空");
		redisTemplate.opsForValue().set(key, value);
	}

	/**
	 * 获取指定键的值
	 * 
	 * @param key
	 *            键
	 * @return 键对应的值
	 */
	public String get(String key) {
		Assert.notNull(key, "key不能为空");
		return redisTemplate.opsForValue().get(key);
	}

	/**
	 * 追加数据 若键不存在 则插入数据
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * @return 影响的条数
	 */
	public Integer append(String key, String value) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(value, "value不能为空");
		return redisTemplate.opsForValue().append(key, value);
	}

	/**
	 * 删除某key的数据
	 * 
	 * @param key
	 *            键
	 */
	public void del(String key) {
		Assert.notNull(key, "key不能为空");
		redisTemplate.delete(key);
	}

	/**
	 * 获取指定key的数据的长度
	 * 
	 * @param key
	 *            键
	 * @return 数据长度
	 */
	public Long len(String key) {
		Assert.notNull(key, "key不能为空");
		return redisTemplate.opsForValue().size(key);
	}
}
