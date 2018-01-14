package com.wojiushiwo.util;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * set ������ set����ѧ�еļ���һ�����߱������Ժ�Ψһ�ԣ���ͬһ��key�ģ�valueֵ�������ظ�
 * 
 * @author meng
 * 
 */
@Component
public class RedisSetUtil {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * ���Ԫ�� �����Ԫ���Ѵ��� �������
	 * 
	 * @param key
	 *            set��������
	 * @param values
	 *            Ԫ�ؼ���
	 * @return ���ز���ɹ��ĸ���
	 */
	public Long add(String key, String... values) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(values, "values����Ϊ��");
		return stringRedisTemplate.opsForSet().add(key, values);
	}

	/**
	 * �жϸ�Ԫ���Ƿ����ڸü���
	 * 
	 * @param key
	 *            set��������
	 * @param setKey
	 *            ��ֵ
	 */
	public Boolean isExists(String key, Object setKey) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(setKey, "setKey����Ϊ��");
		return stringRedisTemplate.opsForSet().isMember(key, setKey);
	}

	/**
	 * ��������
	 * 
	 * @param key
	 *            set��������
	 * @return Ԫ�ؼ���
	 */
	public Set<String> list(String key) {
		Assert.notNull(key, "key����Ϊ��");
		return stringRedisTemplate.opsForSet().members(key);
	}

	/**
	 * ��һ�����е�Ԫ�� �Ƶ���һ��������
	 * 
	 * @param key
	 *            set��������
	 * @param value
	 *            ����
	 * @param destKey
	 *            Ŀ�꼯��
	 * @return �Ƿ��ƶ��ɹ�
	 */
	public Boolean move(String key, String value, String destKey) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(value, "value����Ϊ��");
		Assert.notNull(destKey, "destKey����Ϊ��");
		return stringRedisTemplate.opsForSet().move(key, value, destKey);
	}

	/**
	 * ����Ӽ�����ɾ��һ��Ԫ��
	 * 
	 * @param key
	 *            set��������
	 * @return��ɾ�����ϵ�ֵ
	 */
	public String pop(String key) {
		Assert.notNull(key, "key����Ϊ��");
		return stringRedisTemplate.opsForSet().pop(key);
	}

	/**
	 * ���ȡ��һ��Ԫ��
	 * 
	 * @param key
	 *            set����
	 * @return ���Ԫ��ֵ
	 */
	public String randomMember(String key) {
		Assert.notNull(key, "key����Ϊ��");
		return stringRedisTemplate.opsForSet().randomMember(key);
	}

	/**
	 * ���ȡ�����Ԫ��
	 * 
	 * @param key
	 *            set��������
	 * @return ȡ��Ԫ�صļ���
	 */
	public List<String> randomMembers(String key, Long count) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(count, "count����Ϊ��");
		return stringRedisTemplate.opsForSet().randomMembers(key, count);
	}

	/**
	 * ɾ��������ָ����Ԫ��
	 * 
	 * @param key
	 *            set��������
	 * @param values
	 *            ��ɾ��Ԫ�صļ���
	 * @return ���ر�ɾ��Ԫ�صĸ���
	 */
	public Long remove(String key, Object... values) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(values, "values����Ϊ��");
		return stringRedisTemplate.opsForSet().remove(key, values);
	}

	/**
	 * ���������ϵĽ���
	 * 
	 * @param key
	 *            set��������
	 * @param otherKey
	 *            ��һ��set����
	 * @return ������Ԫ�ؼ���
	 */
	public Set<String> inter(String key, String otherKey) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(otherKey, "otherKey����Ϊ��");
		return stringRedisTemplate.opsForSet().intersect(key, otherKey);
	}

	/**
	 * ���������ϵĲ���
	 * 
	 * @param key
	 *            set��������
	 * @param otherKey
	 *            ��һ��set����
	 * @return ������Ԫ�ؼ���
	 */
	public Set<String> union(String key, String otherKey) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(otherKey, "otherKey����Ϊ��");
		return stringRedisTemplate.opsForSet().union(key, otherKey);
	}

	/**
	 * ���������ϵĲ 
	 * ��a������1 2 3 4��
	 * b������3 4 5 6 ����a����Ԫ�� ȡ��a/b�������ϵĽ��� �����1 2
	 * 
	 * @param key
	 *            set��������
	 * @param otherKey
	 *            ��һ��set����
	 * @return ���Ԫ�ؼ���
	 */
	public Set<String> diff(String key, String otherKey) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(otherKey, "otherKey����Ϊ��");
		return stringRedisTemplate.opsForSet().difference(key, otherKey);
	}

	/**
	 * ��ȡ�����е�Ԫ�ظ���
	 * 
	 * @param key
	 *            set��������
	 * @return Ԫ�ظ���
	 */
	public Long length(String key) {
		Assert.notNull(key, "key����Ϊ��");
		return stringRedisTemplate.opsForSet().size(key);
	}

}
