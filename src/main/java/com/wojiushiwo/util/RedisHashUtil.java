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
 * hash ������
 * 
 * @author meng
 * 
 */
@Component
public class RedisHashUtil {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * ���Ԫ�� ����ü������� ����Ӹ�Ԫ�� ����ü�ֵ���� �򸲸Ǹü�ֵ��Ӧ��value
	 * 
	 * @param key
	 *            hash��������
	 * @param hashKey
	 *            ��ֵ
	 * @param value
	 *            ����
	 */
	public void add(String key, Object hashKey, Object value) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(hashKey, "hashKey����Ϊ��");
		Assert.notNull(value, "value����Ϊ��");
		stringRedisTemplate.opsForHash().put(key, hashKey, value);
	}

	/**
	 * ���Ԫ��(����ֵ������,����ֵ���� ��ʲô������)
	 * 
	 * @param key
	 *            hash��������
	 * @param hashKey
	 *            ��ֵ
	 * @param value
	 *            ����
	 */
	public void addIfAbsent(String key, Object hashKey, Object value) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(hashKey, "hashKey����Ϊ��");
		Assert.notNull(value, "value����Ϊ��");
		stringRedisTemplate.opsForHash().putIfAbsent(key, hashKey, value);
	}

	/**
	 * �������Ԫ��
	 * 
	 * @param key
	 *            hash��������
	 * @param map
	 *            ����Ӽ���
	 */
	public void addAll(String key, Map<? extends Object, ? extends Object> map) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notEmpty(map, "map����Ϊ��");
		stringRedisTemplate.opsForHash().putAll(key, map);
	}

	/**
	 * ��ȡ������ĳ��ֵ������
	 * 
	 * @param key
	 *            hash��������
	 * @param hashKey
	 *            ��ֵ
	 * @return value
	 */
	public Object get(String key, Object hashKey) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(hashKey, "hashKey����Ϊ��");
		return stringRedisTemplate.opsForHash().get(key, hashKey);
	}

	/**
	 * ��ȡ���hashKey��valueֵ
	 * 
	 * @param key
	 *            hash��������
	 * @param hashKeys
	 */
	public List<Object> multiGet(String key, Collection<Object> hashKeys) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(hashKeys, "hashKeys����Ϊ��");
		return stringRedisTemplate.opsForHash().multiGet(key, hashKeys);
	}

	/**
	 * �жϼ������Ƿ���ڸ�hashKey
	 * 
	 * @param key
	 *            hash����
	 * @param hashKey
	 * @return true ���ڡ�false ������
	 */
	public Boolean isExists(String key, Object hashKey) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(hashKey, "hashKey����Ϊ��");
		return stringRedisTemplate.opsForHash().hasKey(key, hashKey);
	}

	/**
	 * ��ȡ������hashKey�ļ���
	 * 
	 * @param key
	 *            hash��������
	 * @return hashKey�ļ���
	 */
	public Set<Object> getKeys(String key) {
		Assert.notNull(key, "key����Ϊ��");
		return stringRedisTemplate.opsForHash().keys(key);
	}

	/**
	 * ��ȡ������value�ļ���
	 * 
	 * @param key
	 *            hash��������
	 * @return value�ļ���
	 */
	public List<Object> getValues(String key) {
		Assert.notNull(key, "key����Ϊ��");
		return stringRedisTemplate.opsForHash().values(key);
	}

	/**
	 * ɾ��ָ�� hashKeys������
	 * 
	 * @param key
	 *            hash��������
	 * @param hashKeys
	 *            ��ɾ��hashKey����
	 * @return
	 */
	public Long delete(String key, Object... hashKeys) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(hashKeys, "hashKeys����Ϊ��");
		return stringRedisTemplate.opsForHash().delete(key, hashKeys);
	}

	/**
	 * ����hash����
	 * 
	 * @param key
	 *            hash��������
	 * @return hash ��ֵ�Լ���
	 */
	public Map<Object, Object> list(String key) {
		Assert.notNull(key, "key����Ϊ��");
		return stringRedisTemplate.opsForHash().entries(key);
	}

	/**
	 * ��ȡ�����е�Ԫ�ظ���
	 * 
	 * @param key
	 *            hash��������
	 * @return Ԫ�ظ���
	 */
	public Long length(String key) {
		Assert.notNull(key, "key����Ϊ��");
		return stringRedisTemplate.opsForHash().size(key);
	}

}
