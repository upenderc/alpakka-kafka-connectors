package com.poc.kafka.streams;

import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;

public class KafkaConsumerStream {

	public static void main(String ...args) {
		final ActorSystem system = ActorSystem.create("kafka-consumer-stream");
		final ActorMaterializer materializer = ActorMaterializer.create(system);
		
	}
}
