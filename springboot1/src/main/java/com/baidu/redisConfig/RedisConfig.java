package com.baidu.redisConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource ( "classpath:config/redis.properties" )
public class RedisConfig {

    @Value( "${redis.host}" )
    private String host;

    @Value ( "${redis.port}" )
    private int port;


    @Bean
    public JedisPoolConfig jedisPoolConfig(){

        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig ();

        jedisPoolConfig.setMaxWaitMillis ( 1000 );

        jedisPoolConfig.setMaxTotal ( 100 );

        jedisPoolConfig.setMaxIdle ( 10 );

        return jedisPoolConfig;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig){

        JedisConnectionFactory jedisConnectionFactory=new JedisConnectionFactory (  );

        jedisConnectionFactory.setPoolConfig ( jedisPoolConfig );

        jedisConnectionFactory.setHostName ( host );


        jedisConnectionFactory.setPort ( port );

        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory){

        RedisTemplate redisTemplate=new RedisTemplate ();

        redisTemplate.setKeySerializer ( new StringRedisSerializer (  ) );
        redisTemplate.setValueSerializer ( new JdkSerializationRedisSerializer (  ) );

        redisTemplate.setHashKeySerializer ( new StringRedisSerializer (  ) );

        redisTemplate.setHashValueSerializer ( new JdkSerializationRedisSerializer (  ) );

        redisTemplate.setConnectionFactory ( jedisConnectionFactory );

        return redisTemplate;
    }

    @Bean
    public MyMessageListener myMessageListener(){
        return new MyMessageListener ();
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(JedisConnectionFactory jedisConnectionFactory,MyMessageListener myMessageListener){

        RedisMessageListenerContainer redisMessageListenerContainer=new RedisMessageListenerContainer ();

        redisMessageListenerContainer.setConnectionFactory ( jedisConnectionFactory );

        redisMessageListenerContainer.addMessageListener ( myMessageListener,new ChannelTopic ( "channel" ) );

        return redisMessageListenerContainer;
    }

}
