package com.poc.kafka.streams;

import java.util.Arrays;
import java.util.concurrent.CompletionStage;

import akka.Done;
import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.RunnableGraph;
import akka.stream.javadsl.Source;
import akka.stream.javadsl.Sink;


public class QuickStreamDemo {

	public static void main(String ...args) {
		final ActorSystem system = ActorSystem.create();
		final ActorMaterializer materializer = ActorMaterializer.create(system);
        Source<String,NotUsed> source = Source.from(Arrays.asList("apple","strawberry","kiwi"));
        Flow<String, String, NotUsed> flow=Flow.<String>create().map(s->s.toUpperCase());
        Sink<String,CompletionStage<Done>> sink=Sink.foreach(s->System.out.println(s));
        RunnableGraph<NotUsed> runnable = source.via(flow).to(sink);
        runnable.run(materializer);
        
        
        
	}
}
