package com.wojiushiwo.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * list工具类 list类似于双向链表 因此其头尾均可插入数据 取出数据
 * 
 * @author meng
 * 
 */
@Component
public class RedisListUtil {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 头插入
	 * 
	 * @param key
	 *            集合的名称
	 * @param value
	 *            值
	 */
	public void addAtLeft(String key, String value) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(value, "value不能为空");
		// 会返回添加元素后 集合的长度
		stringRedisTemplate.opsForList().leftPush(key, value);
	}

	/**
	 * 头插入 一次插入多个数据
	 * 
	 * @param key
	 *            集合的名称
	 * @param values
	 *            数据集合值
	 */
	public void addAllAtLeft(String key, String... values) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(values, "values不能为空");
		// 会返回添加元素后 集合的长度
		stringRedisTemplate.opsForList().leftPushAll(key, values);
	}

	/**
	 * 尾插入
	 * 
	 * @param key
	 *            集合的名称
	 * @param value
	 *            值
	 */
	public void addAtRight(String key, String value) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(value, "value不能为空");
		// 会返回添加元素后 集合的长度
		stringRedisTemplate.opsForList().rightPush(key, value);
	}

	/**
	 * 尾插入 一次插入多个数据
	 * 
	 * @param key
	 *            集合的名称
	 * @param value
	 *            数据集合
	 */
	public void addAllAtRight(String key, String... values) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(values, "values不能为空");
		// 会返回添加元素后 集合的长度
		stringRedisTemplate.opsForList().rightPushAll(key, values);
	}

	/**
	 * 从头取出一个数据 (删除该头元素数据 并返回 集合长度减少1)
	 * 
	 * @param key
	 *            集合名称
	 * @return 链表头数据
	 */
	public String getAtLeft(String key) {
		Assert.notNull(key, "key不能为空");
		return stringRedisTemplate.opsForList().leftPop(key);
	}

	/**
	 * 从头取出一个数据 (删除该头元素数据 并返回 集合长度减少1)
	 * 
	 * @param key
	 *            集合名称
	 * @param time
	 *            等待时间
	 * @param timeUnit
	 *            时间单位
	 * @return 链表头数据
	 */
	public String getAtLeft(String key, long time, TimeUnit timeUnit) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(time, "time不能为空");
		Assert.notNull(timeUnit, "timeUnit不能为空");
		return stringRedisTemplate.opsForList().leftPop(key, time, timeUnit);
	}

	/**
	 * 从尾取出一个数据 (删除该尾元素数据 并返回 集合长度减少1)
	 * 
	 * @param key
	 *            集合名称
	 * @return 链表头数据
	 */
	public String getAtRight(String key) {
		Assert.notNull(key, "key不能为空");
		return stringRedisTemplate.opsForList().rightPop(key);
	}

	/**
	 * 从尾取出一个数据 (删除该尾元素数据 并返回 集合长度减少1)
	 * 
	 * @param key
	 *            集合名称
	 * @param time
	 *            等待时间
	 * @param timeUnit
	 *            时间单位
	 * @return 链表头数据
	 */
	public String getAtRight(String key, long time, TimeUnit timeUnit) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(time, "time不能为空");
		Assert.notNull(timeUnit, "timeUnit不能为空");
		return stringRedisTemplate.opsForList().rightPop(key, time, timeUnit);
	}

	/**
	 * 设置集合中某指定索引的值
	 * 
	 * @param key
	 *            集合名称
	 * @param index
	 *            索引值
	 * @param value
	 *            待设置值
	 */
	public void set(String key, int index, String value) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(index, "index不能为空");
		Assert.notNull(value, "value不能为空");
		stringRedisTemplate.opsForList().set(key, index, value);
	}

	/**
	 * 获取集合中指定索引的数据
	 * 
	 * @param key
	 *            集合名称
	 * @param index
	 *            索引值
	 * @return 索引位置的数据
	 */
	public String index(String key, int index) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(index, "index不能为空");
		return stringRedisTemplate.opsForList().index(key, index);
	}

	/**
	 * 遍历 指定长度的集合
	 * 
	 * @param key
	 *            集合名称
	 * @param start
	 *            索引开始
	 * @param end
	 *            索引结束
	 * @return List 集合
	 */
	public List<String> list(String key, int start, int end) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(start, "start不能为空");
		Assert.notNull(end, "end不能为空");
		return stringRedisTemplate.opsForList().range(key, start, end);
	}

	/**
	 * 获取集合长度
	 * 
	 * @param key
	 *            集合名称
	 * @return 集合长度
	 */
	public Long length(String key) {
		Assert.notNull(key, "key不能为空");
		return stringRedisTemplate.opsForList().size(key);
	}
}
