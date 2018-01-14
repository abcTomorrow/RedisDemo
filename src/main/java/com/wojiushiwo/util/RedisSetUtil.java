package com.wojiushiwo.util;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * set 工具类 set跟数学中的集合一样，具备无序性和唯一性，即同一个key的，value值不允许重复
 * 
 * @author meng
 * 
 */
@Component
public class RedisSetUtil {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 添加元素 如果该元素已存在 则不再添加
	 * 
	 * @param key
	 *            set集合名称
	 * @param values
	 *            元素集合
	 * @return 返回插入成功的个数
	 */
	public Long add(String key, String... values) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(values, "values不能为空");
		return stringRedisTemplate.opsForSet().add(key, values);
	}

	/**
	 * 判断该元素是否属于该集合
	 * 
	 * @param key
	 *            set集合名称
	 * @param setKey
	 *            键值
	 */
	public Boolean isExists(String key, Object setKey) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(setKey, "setKey不能为空");
		return stringRedisTemplate.opsForSet().isMember(key, setKey);
	}

	/**
	 * 遍历集合
	 * 
	 * @param key
	 *            set集合名称
	 * @return 元素集合
	 */
	public Set<String> list(String key) {
		Assert.notNull(key, "key不能为空");
		return stringRedisTemplate.opsForSet().members(key);
	}

	/**
	 * 将一集合中的元素 移到另一个集合中
	 * 
	 * @param key
	 *            set集合名称
	 * @param value
	 *            数据
	 * @param destKey
	 *            目标集合
	 * @return 是否移动成功
	 */
	public Boolean move(String key, String value, String destKey) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(value, "value不能为空");
		Assert.notNull(destKey, "destKey不能为空");
		return stringRedisTemplate.opsForSet().move(key, value, destKey);
	}

	/**
	 * 随机从集合中删除一个元素
	 * 
	 * @param key
	 *            set集合名称
	 * @return　删除集合的值
	 */
	public String pop(String key) {
		Assert.notNull(key, "key不能为空");
		return stringRedisTemplate.opsForSet().pop(key);
	}

	/**
	 * 随机取出一个元素
	 * 
	 * @param key
	 *            set集合
	 * @return 随机元素值
	 */
	public String randomMember(String key) {
		Assert.notNull(key, "key不能为空");
		return stringRedisTemplate.opsForSet().randomMember(key);
	}

	/**
	 * 随机取出多个元素
	 * 
	 * @param key
	 *            set集合名称
	 * @return 取出元素的集合
	 */
	public List<String> randomMembers(String key, Long count) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(count, "count不能为空");
		return stringRedisTemplate.opsForSet().randomMembers(key, count);
	}

	/**
	 * 删除集合中指定的元素
	 * 
	 * @param key
	 *            set集合名称
	 * @param values
	 *            待删除元素的集合
	 * @return 返回被删除元素的个数
	 */
	public Long remove(String key, Object... values) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(values, "values不能为空");
		return stringRedisTemplate.opsForSet().remove(key, values);
	}

	/**
	 * 求两个集合的交集
	 * 
	 * @param key
	 *            set集合名称
	 * @param otherKey
	 *            另一个set集合
	 * @return 交集的元素集合
	 */
	public Set<String> inter(String key, String otherKey) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(otherKey, "otherKey不能为空");
		return stringRedisTemplate.opsForSet().intersect(key, otherKey);
	}

	/**
	 * 求两个集合的并集
	 * 
	 * @param key
	 *            set集合名称
	 * @param otherKey
	 *            另一个set集合
	 * @return 并集的元素集合
	 */
	public Set<String> union(String key, String otherKey) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(otherKey, "otherKey不能为空");
		return stringRedisTemplate.opsForSet().union(key, otherKey);
	}

	/**
	 * 求两个集合的差集 
	 * 如a集合是1 2 3 4；
	 * b集合是3 4 5 6 则差集是a集合元素 取出a/b两个集合的交集 即差集是1 2
	 * 
	 * @param key
	 *            set集合名称
	 * @param otherKey
	 *            另一个set集合
	 * @return 差集的元素集合
	 */
	public Set<String> diff(String key, String otherKey) {
		Assert.notNull(key, "key不能为空");
		Assert.notNull(otherKey, "otherKey不能为空");
		return stringRedisTemplate.opsForSet().difference(key, otherKey);
	}

	/**
	 * 获取集合中的元素个数
	 * 
	 * @param key
	 *            set集合名称
	 * @return 元素个数
	 */
	public Long length(String key) {
		Assert.notNull(key, "key不能为空");
		return stringRedisTemplate.opsForSet().size(key);
	}

}
