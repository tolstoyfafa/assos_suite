package com.motus.assosuite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import de.bwaldvogel.mongo.MongoServer;
import de.bwaldvogel.mongo.backend.memory.MemoryBackend;

/**
 * Configuration class for mongo repositories, it provide an in-memory server
 * closed after repositories tests execution
 * 
 * @author fbordjah
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = { "com.motus.assosuite.repository" })
public class MongoConfigTests {

	@Bean
	public MongoTemplate mongoTemplate(MongoClient mongoClient) {
		return new MongoTemplate(mongoDbFactory(mongoClient));
	}

	@Bean
	public MongoDbFactory mongoDbFactory(MongoClient mongoClient) {
		return new SimpleMongoDbFactory(mongoClient, "test");
	}

	@Bean(destroyMethod = "shutdown")
	public MongoServer mongoServer() {
		MongoServer mongoServer = new MongoServer(new MemoryBackend());
		mongoServer.bind();
		return mongoServer;
	}

	@Bean(destroyMethod = "close")
	public MongoClient mongoClient(MongoServer mongoServer) {
		return new MongoClient(new ServerAddress(mongoServer.getLocalAddress()));
	}
}
