package com.online_gaming_service.gaming_service_application.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration.JedisPoolingClientConfigurationBuilder;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.*;
import org.springframework.data.redis.connection.jedis.*;

@Configuration
@EnableCaching
public class JedisConfiguration {

//	@Value("${redis.host}")
//	private String host;
	
//	@Value("${redis.password}")
//	private String password;
	
//	@Value("${redis.port}")
//	private int port;
	
//	@Value("${redis.jedis.pool.max-total}")
//	private int maxTotal;
//	
//	@Value("${redis.jedis.pool.max-idle}")
//	private int maxIdle;
//	
//	@Value("${redis.jedis.pool.min-idle}")
//	private int minIdle;
//	
//	@Bean
//	public JedisClientConfiguration getJedisClientConfiguration() {
//		final JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jedisPoolingClientConfigurationBuilder = (JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
//		 GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig<>();
//		 
//	}
	
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		redisStandaloneConfiguration.setHostName("127.0.0.1");
		redisStandaloneConfiguration.setPort(6379);
		return new JedisConnectionFactory(redisStandaloneConfiguration);
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
//		redisTemplate.setKeySerializer(new StringRedisSerializer());
//		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//		redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
//		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.setEnableTransactionSupport(true);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}	
}
