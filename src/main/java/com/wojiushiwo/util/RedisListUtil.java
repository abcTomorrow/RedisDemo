package com.wojiushiwo.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * list������ list������˫������ �����ͷβ���ɲ������� ȡ������
 * 
 * @author meng
 * 
 */
@Component
public class RedisListUtil {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * ͷ����
	 * 
	 * @param key
	 *            ���ϵ�����
	 * @param value
	 *            ֵ
	 */
	public void addAtLeft(String key, String value) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(value, "value����Ϊ��");
		// �᷵�����Ԫ�غ� ���ϵĳ���
		stringRedisTemplate.opsForList().leftPush(key, value);
	}

	/**
	 * ͷ���� һ�β���������
	 * 
	 * @param key
	 *            ���ϵ�����
	 * @param values
	 *            ���ݼ���ֵ
	 */
	public void addAllAtLeft(String key, String... values) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(values, "values����Ϊ��");
		// �᷵�����Ԫ�غ� ���ϵĳ���
		stringRedisTemplate.opsForList().leftPushAll(key, values);
	}

	/**
	 * β����
	 * 
	 * @param key
	 *            ���ϵ�����
	 * @param value
	 *            ֵ
	 */
	public void addAtRight(String key, String value) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(value, "value����Ϊ��");
		// �᷵�����Ԫ�غ� ���ϵĳ���
		stringRedisTemplate.opsForList().rightPush(key, value);
	}

	/**
	 * β���� һ�β���������
	 * 
	 * @param key
	 *            ���ϵ�����
	 * @param value
	 *            ���ݼ���
	 */
	public void addAllAtRight(String key, String... values) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(values, "values����Ϊ��");
		// �᷵�����Ԫ�غ� ���ϵĳ���
		stringRedisTemplate.opsForList().rightPushAll(key, values);
	}

	/**
	 * ��ͷȡ��һ������ (ɾ����ͷԪ������ ������ ���ϳ��ȼ���1)
	 * 
	 * @param key
	 *            ��������
	 * @return ����ͷ����
	 */
	public String getAtLeft(String key) {
		Assert.notNull(key, "key����Ϊ��");
		return stringRedisTemplate.opsForList().leftPop(key);
	}

	/**
	 * ��ͷȡ��һ������ (ɾ����ͷԪ������ ������ ���ϳ��ȼ���1)
	 * 
	 * @param key
	 *            ��������
	 * @param time
	 *            �ȴ�ʱ��
	 * @param timeUnit
	 *            ʱ�䵥λ
	 * @return ����ͷ����
	 */
	public String getAtLeft(String key, long time, TimeUnit timeUnit) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(time, "time����Ϊ��");
		Assert.notNull(timeUnit, "timeUnit����Ϊ��");
		return stringRedisTemplate.opsForList().leftPop(key, time, timeUnit);
	}

	/**
	 * ��βȡ��һ������ (ɾ����βԪ������ ������ ���ϳ��ȼ���1)
	 * 
	 * @param key
	 *            ��������
	 * @return ����ͷ����
	 */
	public String getAtRight(String key) {
		Assert.notNull(key, "key����Ϊ��");
		return stringRedisTemplate.opsForList().rightPop(key);
	}

	/**
	 * ��βȡ��һ������ (ɾ����βԪ������ ������ ���ϳ��ȼ���1)
	 * 
	 * @param key
	 *            ��������
	 * @param time
	 *            �ȴ�ʱ��
	 * @param timeUnit
	 *            ʱ�䵥λ
	 * @return ����ͷ����
	 */
	public String getAtRight(String key, long time, TimeUnit timeUnit) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(time, "time����Ϊ��");
		Assert.notNull(timeUnit, "timeUnit����Ϊ��");
		return stringRedisTemplate.opsForList().rightPop(key, time, timeUnit);
	}

	/**
	 * ���ü�����ĳָ��������ֵ
	 * 
	 * @param key
	 *            ��������
	 * @param index
	 *            ����ֵ
	 * @param value
	 *            ������ֵ
	 */
	public void set(String key, int index, String value) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(index, "index����Ϊ��");
		Assert.notNull(value, "value����Ϊ��");
		stringRedisTemplate.opsForList().set(key, index, value);
	}

	/**
	 * ��ȡ������ָ������������
	 * 
	 * @param key
	 *            ��������
	 * @param index
	 *            ����ֵ
	 * @return ����λ�õ�����
	 */
	public String index(String key, int index) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(index, "index����Ϊ��");
		return stringRedisTemplate.opsForList().index(key, index);
	}

	/**
	 * ���� ָ�����ȵļ���
	 * 
	 * @param key
	 *            ��������
	 * @param start
	 *            ������ʼ
	 * @param end
	 *            ��������
	 * @return List ����
	 */
	public List<String> list(String key, int start, int end) {
		Assert.notNull(key, "key����Ϊ��");
		Assert.notNull(start, "start����Ϊ��");
		Assert.notNull(end, "end����Ϊ��");
		return stringRedisTemplate.opsForList().range(key, start, end);
	}

	/**
	 * ��ȡ���ϳ���
	 * 
	 * @param key
	 *            ��������
	 * @return ���ϳ���
	 */
	public Long length(String key) {
		Assert.notNull(key, "key����Ϊ��");
		return stringRedisTemplate.opsForList().size(key);
	}
}
