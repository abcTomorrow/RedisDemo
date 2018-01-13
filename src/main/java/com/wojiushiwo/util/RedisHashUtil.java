package com.wojiushiwo.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * hash 工具类
 * 
 * @author meng
 * 
 */
@Component
public class RedisHashUtil {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 添加元素 如果该键不存在 则添加该元素 如果该键值存在 则覆盖该键值对应的value
	 * 
	 * @param key
	 *            hash集合名称
	 * @param hashKey
	 *            键值
	 * @param value
	 *            数据
	 */
	public void add(String key, Object hashKey, Object value) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(hashKey, "hashKey不能为空");
		Assert.notNull(value, "value不能为空");
		stringRedisTemplate.opsForHash().put(key, hashKey, value);
	}

	/**
	 * 添加元素(若键值不存在,若键值存在 则什么都不做)
	 * 
	 * @param key
	 *            hash集合名称
	 * @param hashKey
	 *            键值
	 * @param value
	 *            数据
	 */
	public void addIfAbsent(String key, Object hashKey, Object value) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(hashKey, "hashKey不能为空");
		Assert.notNull(value, "value不能为空");
		stringRedisTemplate.opsForHash().putIfAbsent(key, hashKey, value);
	}

	/**
	 * 批量添加元素
	 * 
	 * @param key
	 *            hash集合名称
	 * @param map
	 *            待添加集合
	 */
	public void addAll(String key, Map<? extends Object, ? extends Object> map) {
		Assert.notNull(key, "key不能为空");
		Assert.notEmpty(map, "map不能为空");
		stringRedisTemplate.opsForHash().putAll(key, map);
	}

	/**
	 * 获取集合中某键值的数据
	 * 
	 * @param key
	 *            hash集合名称
	 * @param hashKey
	 *            键值
	 * @return value
	 */
	public Object get(String key, Object hashKey) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(hashKey, "hashKey不能为空");
		return stringRedisTemplate.opsForHash().get(key, hashKey);
	}

	/**
	 * 获取多个hashKey的value值
	 * 
	 * @param key
	 *            hash集合名称
	 * @param hashKeys
	 */
	public List<Object> multiGet(String key, Collection<Object> hashKeys) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(hashKeys, "hashKeys不能为空");
		return stringRedisTemplate.opsForHash().multiGet(key, hashKeys);
	}

	/**
	 * 判断集合中是否存在该hashKey
	 * 
	 * @param key
	 *            hash集合
	 * @param hashKey
	 * @return true 存在、false 不存在
	 */
	public Boolean isExists(String key, Object hashKey) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(hashKey, "hashKey不能为空");
		return stringRedisTemplate.opsForHash().hasKey(key, hashKey);
	}

	/**
	 * 获取集合中hashKey的集合
	 * 
	 * @param key
	 *            hash集合名称
	 * @return hashKey的集合
	 */
	public Set<Object> getKeys(String key) {
		Assert.notNull(key, "key不能为空");
		return stringRedisTemplate.opsForHash().keys(key);
	}

	/**
	 * 获取集合中value的集合
	 * 
	 * @param key
	 *            hash集合名称
	 * @return value的集合
	 */
	public List<Object> getValues(String key) {
		Assert.notNull(key, "key不能为空");
		return stringRedisTemplate.opsForHash().values(key);
	}

	/**
	 * 删除指定 hashKeys的数据
	 * 
	 * @param key
	 *            hash集合名称
	 * @param hashKeys
	 *            待删除hashKey集合
	 * @return
	 */
	public Long delete(String key, Object... hashKeys) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(hashKeys, "hashKeys不能为空");
		return stringRedisTemplate.opsForHash().delete(key, hashKeys);
	}

	/**
	 * 遍历hash集合
	 * 
	 * @param key
	 *            hash集合名称
	 * @return hash 键值对集合
	 */
	public Map<Object, Object> list(String key) {
		Assert.notNull(key, "key不能为空");
		return stringRedisTemplate.opsForHash().entries(key);
	}

	/**
	 * 获取集合中的元素个数
	 * 
	 * @param key
	 *            hash集合名称
	 * @return 元素个数
	 */
	public Long length(String key) {
		Assert.notNull(key, "key不能为空");
		return stringRedisTemplate.opsForHash().size(key);
	}

}
