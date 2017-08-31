package com.poc.kafka.streams;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import akka.Done;

public class MessageConsumerService {
	private final AtomicLong offset = new AtomicLong();

	  public CompletionStage<Done> save(ConsumerRecord<byte[], String> record) {
	    System.out.println("DB.save: " + record.value());
	    offset.set(record.offset());
	    return CompletableFuture.completedFuture(Done.getInstance());
	  }

	  public CompletionStage<Long> loadOffset() {
	    return CompletableFuture.completedFuture(offset.get());
	  }

	  public CompletionStage<Done> update(String data) {
	    System.out.println("DB.update: " + data);
	    return CompletableFuture.completedFuture(Done.getInstance());
	  }
}
