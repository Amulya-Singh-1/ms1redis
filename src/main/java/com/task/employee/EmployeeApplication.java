package com.task.employee;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Bean
	public RedisCacheConfiguration cacheConfiguration() {
		return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(60)).disableCachingNullValues()
				.serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
	}

	@Bean
	public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
		return (builder) -> builder
				.withCacheConfiguration("itemCache",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(10)))
				.withCacheConfiguration("customerCache",
						RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(5)));
	}

	@Bean
//	@LoadBalanced

	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
