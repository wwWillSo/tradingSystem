package com.szw.trading.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration
@PropertySource(value = { "file:${user.dir}/config/application.properties", "file:${user.dir}/config/web.properties",
		"file:${user.dir}/config/persistence.properties", "file:${user.dir}/config/redis.properties" })
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment env;

	@Autowired
	private RedisTemplate redisTemplate;

	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}

	@Bean("redisTemplate")
	public RedisTemplate RedisTemplate() {

		RedisSerializer<String> redisSerializer = new StringRedisSerializer();// Long类型不可以会出现异常信息;
		redisTemplate.setKeySerializer(redisSerializer);
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);

		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
		redisTemplate.afterPropertiesSet();

		return redisTemplate;
	}

	@Bean
	public FilterRegistrationBean characterEncodingFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		;
		registration.setFilter(characterEncodingFilter);
		registration.addUrlPatterns("/*");
		return registration;
	}

	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		try {
			String clientRoot = env.getProperty("staticResourcesPath").endsWith("/") ? env.getProperty("staticResourcesPath")
					: env.getProperty("staticResourcesPath").concat("/");
			System.out.println("clientRoot: " + clientRoot);
			registry.addResourceHandler("/" + clientRoot + "**").addResourceLocations("file:" + clientRoot);

			registry.addResourceHandler("/plugins/**").addResourceLocations("classpath:/static/plugins/");
			registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
			registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
			registry.addResourceHandler("/build/**").addResourceLocations("classpath:/static/build/");
			registry.addResourceHandler("/images/**").addResourceLocations("file:" + env.getProperty("imagesStaticResourcesPath"));
			registry.addResourceHandler("/views/**").addResourceLocations("classpath:/views/");

			registry.addResourceHandler("/financeStaticResourcesPath/**").addResourceLocations("file:" + env.getProperty("financeStaticResourcesPath"));
			registry.addResourceHandler("/actionStaticResourcesPath/**").addResourceLocations("file:" + env.getProperty("actionStaticResourcesPath"));
			registry.addResourceHandler("/systemStaticResourcesPath/**").addResourceLocations("file:" + env.getProperty("systemStaticResourcesPath"));
			registry.addResourceHandler("/tradeStrategyStaticResourcesPath/**")
					.addResourceLocations("file:" + env.getProperty("tradeStrategyStaticResourcesPath"));
			registry.addResourceHandler("/productDetailStaticResourcesPath/**")
					.addResourceLocations("file:" + env.getProperty("productDetailStaticResourcesPath"));
			registry.addResourceHandler("/othersStaticResourcesPath/**").addResourceLocations("file:" + env.getProperty("othersStaticResourcesPath"));
			registry.addResourceHandler("/commom/file/**").addResourceLocations("file:" + env.getProperty("pathForUploadImage"));
			registry.addResourceHandler("/wx/**").addResourceLocations("file:" + env.getProperty("wxstaticResourcesPath"));

		} catch (Exception e) {

			System.out.println("staticResourcesPath is not in web.properties");
		}
	}
}
